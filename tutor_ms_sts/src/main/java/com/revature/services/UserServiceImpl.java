package com.revature.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.beans.AccountType;
import com.revature.beans.Course;
import com.revature.beans.Schedule;
import com.revature.beans.Session;
import com.revature.beans.User;
import com.revature.repositories.ScheduleRepo;
import com.revature.repositories.SessionRepo;
import com.revature.repositories.UserRepo;

@Service
@Qualifier("UserService")
public class UserServiceImpl implements UserService {

    private static final Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepo ur;

    @Autowired
    SessionRepo sessR;

    @Autowired
    ScheduleRepo schedR;
    
    @Autowired
    AccountTypeService ats;
    
    @Autowired
    CourseService cs;

    @Override
    public User addUser(User u) {
        return ur.save(u);
    }

    @Override
    public User getUser(int id) {
        Optional<User> opU = ur.findById(id);
        if (opU.isPresent()) {
            return opU.get();
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) ur.findAll();
    }

    @Override
    public User updateUser(User change) {
        if (ur.existsById(change.getId())) {
            return ur.save(change);
        } else {
            return null;
        }
    }

	@Override
	public List<User> getUsersbyCourse(Course course) {
		return ur.findByCoursesToTutor(course);
	}

    @Override
    public boolean deleteUser(int id) {
        try {
            ur.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            log.warn(e);
            return false;
        }
    }

    @Override
    public List<User> getUsersByAccountType(AccountType at) {
        return ur.findByAccountType(at);
    }

	@Override
	public User loginUser(String username, String password) {
		return ur.findBySchoolEmailAndPassword(username, password);
	}

    @Override
    public List<Session> getFutureSessionsForUser(int userId) {
        List<Session> allSessions = (List<Session>) sessR.findAll();
        List<Session> userSessions = new ArrayList<>();
        for (Session session : allSessions) {
            int sId = session.getStudent().getId();
            int tId = session.getTutor().getId();
            if (sId == userId || tId == userId) {
                userSessions.add(session);
            }
        }
        return userSessions;
    }

    @Override
    public Schedule addScheduleToApprove(int userId, Schedule s) {
        User user;
        if (ur.findById(userId).isPresent()) {
            user = ur.findById(userId).get();
        } else {
            return null;
        }

        if (user.getSchedule() != null) {
            schedR.delete(user.getSchedule());
        }

        Date dateTime = new Date();
        long currentTime = dateTime.getTime();

        s.setPendingApprovalSince(currentTime);
        user.setSchedule(s);
        ur.save(user);

        return schedR.save(s);
    }

    @Override
    public List<User> getUsersWithSchedulesToApprove(int mId) {
        if (!ur.findById(mId).isPresent()
                || ur.findById(mId).get().getAccountType().getId() != 1) {
            return null;
        }
        List<User> allUsers = getAllUsers();
        List<User> usersPendingApproval = new ArrayList<>();
        for (User user : allUsers) {
            if (user.getSchedule() != null
                    && user.getSchedule().getPendingApprovalSince() != null) {
                usersPendingApproval.add(user);
            }
        }
        return usersPendingApproval;
    }

    @Override
    public List<User> searchUser(Integer accountTypeId, String courseType) {
        
        AccountType accountType;
        Course course;
        
        accountType = ats.getAccountType(accountTypeId);
        course = cs.getCourses(courseType);

        if (course != null) {
            return getUsersbyCourse(course);
        } else if (accountType != null) {
            return getUsersByAccountType(accountType);
        } else {
            return new ArrayList<User>();
        }
    }

}

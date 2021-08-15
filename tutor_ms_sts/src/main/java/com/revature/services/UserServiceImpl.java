package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.beans.AccountType;
import com.revature.beans.Session;
import com.revature.beans.User;
import com.revature.repositories.SessionRepo;
import com.revature.repositories.UserRepo;


@Service
@Qualifier("UserService")
public class UserServiceImpl implements UserService {

    private static final Logger log = Logger
            .getLogger(UserServiceImpl.class);
    
	@Autowired
	UserRepo ur;
	
	@Autowired
	SessionRepo sessR;

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

}

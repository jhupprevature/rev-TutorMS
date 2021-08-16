package com.revature.services;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.AccountType;
import com.revature.beans.Schedule;
import com.revature.beans.Session;
import com.revature.beans.User;

@SpringBootTest(classes = com.revature.app.TutorMsStsApplication.class)
@Transactional
public class UserServiceTests {

    @Autowired
    public UserService us;

    @Autowired
    public AccountTypeService ats;

    @Autowired
    public ScheduleService ss;

    @Test
    void addUserTest() {
        AccountType studentType = ats.getAccountType(3);
        User newUser = new User("Bob", "McGee", "bmcgee", "Af2io!jfA3",
                "229-531-5483", studentType, null);
        newUser = us.addUser(newUser);
        assertNotEquals(0, newUser.getId());
    }

    @Test
    void getAllUsersTest() {
        List<User> allUsers = us.getAllUsers();
        assertFalse(allUsers.isEmpty());
    }

    @Test
    void getUserTest() {
        AccountType tutorManagerType = ats.getAccountType(1);
        Schedule schedule1 = ss.getSchedule(1);
        User expectedUser = new User(1, "Archibold", "Moorhouse", "amoorhouse0",
                "AvF4qVJ", "455-764-2236", tutorManagerType, schedule1);
        User actualUser = us.getUser(1);
        assertEquals(expectedUser.toString(), actualUser.toString());
        User notAUser = us.getUser(100);
        assertNull(notAUser);
    }

    @Test
    void updateUserTest() {
        User user = us.getUser(2);
        String userToUpdateString = user.toString();
        int userToUpdateId = user.getId();
        user.setLastName("Brown");
        user = us.updateUser(user);
        assertEquals(userToUpdateId, user.getId());
        assertNotEquals(userToUpdateString, user.toString());
        User fakeUser = new User(100, null, null, null, null, null, null, null);
        assertNull(us.updateUser(fakeUser));
    }

    @Test
    void deleteUserTest() {
        boolean uDeleted = us.deleteUser(3);
        assertTrue(uDeleted);
        assertThrows(EmptyResultDataAccessException.class, () -> {
            us.deleteUser(100);
        });
    }

    @Test
    void getUsersByAccountTypeTest() {
        AccountType tutor = ats.getAccountType(2);
        List<User> tutors = us.getUsersByAccountType(tutor);
        assertFalse(tutors.isEmpty());
    }

    @Test
    void loginUserTest() {
        User actual = us.loginUser("mspringall5", "NAnFQOzvR");
        assertEquals(
                "User [id=6, firstName=Meade, lastName=Springall, schoolEmail=mspringall5, password=NAnFQOzvR, phoneNumber=851-422-5573, accountType=AccountType [id=2, type=Tutor], schedule=Schedule [id=7, sundayStart=null, sundayEnd=null, mondayStart=19:00, mondayEnd=23:00, tuesdayStart=15:00, tuesdayEnd=19:00, wednesdayStart=19:00, wednesdayEnd=23:00, thursdayStart=15:00, thursdayEnd=19:00, fridayStart=19:00, fridayEnd=23:00, saturdayStart=null, saturdayEnd=null, pendingApprovalSince=null]]",
                actual.toString());
        User fake = us.loginUser("", "");
        assertNull(fake);
    }

    @Test
    void getSessionsInOrderForUserTest() {
        List<Session> sessions = us.getSessionsInOrderForUser(5);
        assertFalse(sessions.isEmpty());
        assertTrue(
                sessions.get(0).getStartTime() > sessions.get(1).getStartTime()
                        && sessions.get(1).getStartTime() > sessions.get(2)
                                .getStartTime());
        List<Session> noSessions = us.getSessionsInOrderForUser(1);
        assertTrue(noSessions.isEmpty());
    }

    @Test
    void addScheduleToApproveTest() {
        int newTutorId = 16;
        Schedule newTutorSched = new Schedule(null, null, "19:00", "23:00",
                "19:00", "23:00", "19:00", "23:00", "19:00", "23:00", "19:00",
                "23:00", null, null, 1628187125123L);
        newTutorSched = us.addScheduleToApprove(newTutorId, newTutorSched);
        assertNotNull(newTutorSched);

        int tutorWithSchedId = 6;
        Schedule tutorOldSched = us.getUser(6).getSchedule();
        Schedule tutorWithSchedSched = new Schedule(null, null, "19:00",
                "23:00", "19:00", "23:00", "19:00", "23:00", "19:00", "23:00",
                "19:00", "23:00", null, null, 1628187125123L);
        tutorWithSchedSched = us.addScheduleToApprove(tutorWithSchedId,
                tutorWithSchedSched);
        assertNull(ss.getSchedule(tutorOldSched.getId()));
        assertNotEquals(tutorOldSched.toString(),
                tutorWithSchedSched.toString());

        int fakeTutorId = 100;
        Schedule newSched = new Schedule(null, null, "19:00", "23:00", "19:00",
                "23:00", "19:00", "23:00", "19:00", "23:00", "19:00", "23:00",
                null, null, 1628187125123L);
        newSched = us.addScheduleToApprove(fakeTutorId, newSched);
        assertNull(newSched);
    }

    @Test
    void getUsersWithSchedulesToApproveTest() {
        List<User> usersToApprove = us.getUsersWithSchedulesToApprove(1);
        assertFalse(usersToApprove.isEmpty());
        assertNotNull(
                usersToApprove.get(0).getSchedule().getPendingApprovalSince());
    }
    
    @Test
    void searchForUsersTest() {
        assertTrue(us.searchForUsers(null, null).isEmpty());
        assertNotNull(us.searchForUsers(2, null));
        assertNotNull(us.searchForUsers(null, "Precalculus"));
    }

}

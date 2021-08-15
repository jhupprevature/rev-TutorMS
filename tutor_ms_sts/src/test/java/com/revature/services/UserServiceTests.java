package com.revature.services;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.AccountType;
import com.revature.beans.Schedule;
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
    void getFutureSessionsForUserTest() {
        User user = us.getUser(1);
        
    }
    
}

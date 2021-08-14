package com.revature.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
public class UserRepoTests {

    @Autowired
    public UserRepo ur;

    @Autowired
    public AccountTypeRepo atr;

    @Autowired
    public ScheduleRepo sr;

    @Test
    void addUser() {
        AccountType studentType = atr.findById(3).get();
        User newUser = new User("Bob", "McGee", "bmcgee", "Af2io!jfA3",
                "229-531-5483", studentType, null);
        newUser = ur.save(newUser);
        assertNotEquals(0, newUser.getId());
    }

    @Test
    void getAllUsers() {
        List<User> allUsers = (List<User>) ur.findAll();
        assertFalse(allUsers.isEmpty());
    }

    @Test
    void getUserById() {
        AccountType tutorManagerType = atr.findById(1).get();
        Schedule schedule1 = sr.findById(1).get();
        User expectedUser = new User(1, "Archibold", "Moorhouse", "amoorhouse0",
                "AvF4qVJ", "455-764-2236", tutorManagerType, schedule1);
        User actualUser = ur.findById(1).get();
        assertEquals(expectedUser.toString(), actualUser.toString());
    }

    @Test
    void updateUser() {
        User user = ur.findById(2).get();
        String userToUpdateString = user.toString();
        int userToUpdateId = user.getId();

        user.setLastName("Brown");

        user = ur.save(user);

        assertEquals(userToUpdateId, user.getId());
        assertNotEquals(userToUpdateString, user.toString());
    }

    @Test
    void deleteUser() {
        User user = ur.findById(3).get();
        ur.delete(user);
        assertFalse(ur.findById(3).isPresent());
    }

    @Test
    void findByAccountTypeTest() {
        AccountType tutorType = atr.findById(2).get();
        List<User> tutors = ur.findByAccountType(tutorType);
        System.out.println(tutors);
        assertFalse(tutors.isEmpty());
    }

    @Test
    void findBySchoolEmailAndPasswordTest() {
        AccountType student = atr.findById(3).get();
        User expectedTina = new User(8, "Tina", "Dymick", "tdymick7",
                "bqm4f4", "560-285-5415", student, null);
        String schoolEmail = "tdymick7";
        String password = "bqm4f4";
        User actualTina = ur.findBySchoolEmailAndPassword(schoolEmail, password);
        assertEquals(expectedTina.toString(), actualTina.toString());
    }

}

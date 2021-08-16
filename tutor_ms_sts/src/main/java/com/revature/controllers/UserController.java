package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Schedule;
import com.revature.beans.Session;
import com.revature.beans.User;
import com.revature.services.AccountTypeService;
import com.revature.services.CourseService;
import com.revature.services.UserService;

@RestController
public class UserController {

    @Autowired
    UserService us;

    @Autowired
    AccountTypeService ats;

    @Autowired
    CourseService cs;

    @CrossOrigin
    @GetMapping(value = "/users", produces = "application/json")
    public List<User> getAllUser() {
        return us.getAllUsers();
    }

    @CrossOrigin
    @GetMapping("users/{id}")
    public User getUser(@PathVariable("id") String id) {
        return us.getUser(Integer.parseInt(id));
    }

    @CrossOrigin
    @GetMapping("users/search")
    public List<User> searchUser(
            @RequestParam(required = false) Integer accountTypeId,
            @RequestParam(required = false) String courseType) {
        return us.searchForUsers(accountTypeId, courseType);
    }

    @CrossOrigin
    @PostMapping(value = "/users", consumes = "application/json",
            produces = "application/json")
    public User addUser(@RequestBody User u) {
        return us.addUser(u);
    }

    @CrossOrigin
    @PutMapping(value = "/users/{id}", consumes = "application/json",
            produces = "application/json")
    public User updateUser(@PathVariable int id, @RequestBody User change) {
        change.setId(id);
        return us.updateUser(change);
    } 

    @CrossOrigin
    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return us.deleteUser(id);
    }

    @CrossOrigin
    @PostMapping(value = "/login", consumes = "application/json",
            produces = "application/json")
    public User loginUser(@RequestBody User u) {
        return us.loginUser(u.getSchoolEmail(), u.getPassword());
    }

    @CrossOrigin
    @GetMapping("/users/{id}/sessions")
    public List<Session> getSessionsForUser(@PathVariable String id) {
        Integer intId = Integer.parseInt(id);
        return us.getSessionsInOrderForUser(intId);
    }

    @CrossOrigin
    @PostMapping(value = "/users/{id}/schedules", produces = "application/json")
    public Schedule addScheduleToApprove(@PathVariable int id,
            @RequestBody Schedule s) {
        return us.addScheduleToApprove(id, s);
    }

    @CrossOrigin
    @GetMapping("/users/{managerId}/users_with_schedules_to_approve")
    public List<User> getUsersWithSchedulesToApprove(
            @PathVariable String managerId) {
        Integer intId = Integer.parseInt(managerId);
        return us.getUsersWithSchedulesToApprove(intId);
    }

}

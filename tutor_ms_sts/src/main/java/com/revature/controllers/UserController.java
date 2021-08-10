package com.revature.controllers;

import java.util.ArrayList;
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

import com.revature.beans.User;
import com.revature.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService us;

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
	public List<User> searchUser(@RequestParam(required = false) String name,
			@RequestParam(required = false) int accountTypeId) {
		if (accountTypeId > 0 && name != null) {
			return us.getUserbyFirstNameAndAccountTypeId(name, accountTypeId);
		} else if (name != null) {
			return us.getUserbyName(name);
		} else if (accountTypeId > 0) {
			return us.getUserbyAccountTypeId(accountTypeId);
		} else {
			return new ArrayList<User>();
		}
	}

	@CrossOrigin
	@PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
	public User addUser(@RequestBody User u) {
		return us.addUser(u);
	}

	@CrossOrigin
	@PutMapping(value = "/users/{id}", consumes = "application/json", produces = "application/json")
	public User updateUser(@PathVariable int id, @RequestBody User change) {
		change.setId(id);
		return us.updateUser(change);
	}

	@CrossOrigin
	@DeleteMapping("/users/{id}")
	public boolean deleteUser(@PathVariable int id) {
		return us.deleteUser(id);
	}

}
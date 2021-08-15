package com.revature.services;

import java.util.List;

import com.revature.beans.AccountType;
import com.revature.beans.Course;
import com.revature.beans.User;

public interface UserService {

	public User addUser(User u);

	public User getUser(int id);

	public List<User> getAllUsers();

	public User updateUser(User change);

	public boolean deleteUser(int id);

	public List<User> getUserbyCourse(Course course);

	public User loginUser(String username, String password);

	public List<User> getUserByAccountType(AccountType id);

}

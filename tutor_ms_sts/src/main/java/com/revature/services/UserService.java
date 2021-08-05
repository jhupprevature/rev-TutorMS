package com.revature.services;

import java.util.List;

import com.revature.beans.User;

public interface UserService {

	public User addUser(User u);

	public User getUser(int id);

	public List<User> getAllUsers();

	public User updateUser(User change);

	public boolean deleteUser(int id);

	public List<User> getUser(String name, String email);

	public List<User> getUser(String name);

	public List<User> getActorByEmail(String email);
}

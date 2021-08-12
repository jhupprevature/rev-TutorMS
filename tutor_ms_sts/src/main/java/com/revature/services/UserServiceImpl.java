package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.AccountType;
import com.revature.beans.User;
import com.revature.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo ur;

	@Override
	public User addUser(User u) {
		return ur.save(u);
	}

	@Override
	public User getUser(int id) {
		return ur.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) ur.findAll();
	}

	@Override
	public User updateUser(User change) {
		return ur.save(change);
	}

	@Override
	public boolean deleteUser(int id) {
		try {
			ur.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<User> getUserbyFirstNameAndAccountTypeId(String name, int accountTypeId) {
		return ur.findByFirstNameAndAccountTypeId(name, accountTypeId);
	}

	@Override
	public List<User> getUserbyName(String name) {
		return ur.findByFirstName(name);
	}

	@Override
	public AccountType getUserAccountType(User u) {
		return u.getAccountType();
	}

	@Override
	public User loginUser(String username, String password) {
		
		return ur.findBySchoolEmailAndPassword(username, password);
	}

}

package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	List<User> findByFirstName(String name);

	List<User> findByFirstNameAndAccountTypeId(String name, AccountType accountTypeId);

	List<User> findByAccountType(AccountType at);
}

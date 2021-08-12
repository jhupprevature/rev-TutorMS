package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.beans.AccountType;
import com.revature.repositories.AccountTypeRepo;

@Service
@Qualifier("AccountTypeService")
public class AccountTypeServiceImpl implements AccountTypeService {

	@Autowired
	AccountTypeRepo atr;

	@Override
	public AccountType addAccountTypes(AccountType at) {
		return atr.save(at);
	}

	@Override
	public AccountType getAccountTypes(int id) {
		return atr.findById(id).get();
	}

	@Override
	public List<AccountType> getAllAccountTypes() {
		return (List<AccountType>) atr.findAll();
	}

	@Override
	public AccountType updateAccountTypes(AccountType change) {
		return atr.save(change);
	}

	@Override
	public boolean deleteAccountTypes(int id) {
		try {
			atr.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}

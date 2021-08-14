package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.beans.AccountType;
import com.revature.repositories.AccountTypeRepo;

@Service
@Qualifier("AccountTypeService")
public class AccountTypeServiceImpl implements AccountTypeService {

    private static final Logger log = Logger
            .getLogger(AccountTypeServiceImpl.class);
    
	@Autowired
	AccountTypeRepo atr;

	@Override
	public AccountType addAccountType(AccountType at) {
		return atr.save(at);
	}

	@Override
	public AccountType getAccountType(int id) {
		return atr.findById(id).get();
	}

	@Override
	public List<AccountType> getAllAccountTypes() {
		return (List<AccountType>) atr.findAll();
	}

	@Override
	public AccountType updateAccountType(AccountType change) {
		return atr.save(change);
	}

	@Override
	public boolean deleteAccountType(int id) {
		try {
			atr.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			log.warn(e);
			return false;
		}
	}

}

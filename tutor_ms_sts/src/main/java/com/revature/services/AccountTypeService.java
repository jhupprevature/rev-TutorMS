package com.revature.services;

import java.util.List;

import com.revature.beans.AccountType;

public interface AccountTypeService {

	public AccountType addAccountType(AccountType at);

	public AccountType getAccountType(int id);

	public List<AccountType> getAllAccountTypes();

	public AccountType updateAccountType(AccountType change);

	public boolean deleteAccountType(int id);

}

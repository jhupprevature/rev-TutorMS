package com.revature.services;

import java.util.List;

import com.revature.beans.AccountType;

public interface AccountTypeService {

	public AccountType addAccountTypes(AccountType at);

	public AccountType getAccountTypes(int id);

	public List<AccountType> getAllAccountTypes();

	public AccountType updateAccountTypes(AccountType change);

	public boolean deleteAccountTypes(int id);

}

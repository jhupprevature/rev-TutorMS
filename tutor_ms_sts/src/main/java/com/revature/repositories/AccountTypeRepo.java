package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.AccountType;

@Repository
public interface AccountTypeRepo extends CrudRepository<AccountType, Integer> {
    
}

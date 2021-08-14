package com.revature.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.AccountType;

@SpringBootTest(classes = com.revature.app.TutorMsStsApplication.class)
@Transactional
public class AccountTypeRepoTests {
    
    @Autowired
    public AccountTypeRepo atr;

    @Test
    void addAccountType() {
        AccountType parent = new AccountType("Parent");
        parent = atr.save(parent);
        assertNotEquals(0, parent.getId());
    }

    @Test
    void getAllAccountTypes() {
        List<AccountType> allAccountTypes = (List<AccountType>) atr.findAll();
        assertFalse(allAccountTypes.isEmpty());
    }

    @Test
    void getAccountTypeById() {
        AccountType expectedAccountType = new AccountType(1, "Tutor Manager");
        AccountType actualAccountType = atr.findById(1).get();
        assertEquals(expectedAccountType.toString(), actualAccountType.toString());
    }

    @Test
    void updateAccountType() {
        AccountType accountType = atr.findById(2).get();
        String accountTypeToUpdateString = accountType.toString();
        int accountTypeToUpdateId = accountType.getId();

        accountType.setType("Person");
        
        accountType = atr.save(accountType);

        assertEquals(accountTypeToUpdateId, accountType.getId());
        assertNotEquals(accountTypeToUpdateString, accountType.toString());
    }

//    @Test
//    void deleteAccountType() {
//        AccountType accountType = atr.findById(3).get();
//        atr.delete(accountType);
//        assertFalse(atr.findById(3).isPresent());
//    }
    
    @Test
    void deleteAccountTypeById() {
        atr.deleteById(3);
        assertFalse(atr.findById(3).isPresent());
    }
    
}

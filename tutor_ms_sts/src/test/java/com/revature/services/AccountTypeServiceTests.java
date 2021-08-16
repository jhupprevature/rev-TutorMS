package com.revature.services;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.AccountType;

@SpringBootTest(classes = com.revature.app.TutorMsStsApplication.class)
@Transactional
public class AccountTypeServiceTests {
    
    @Autowired
    public AccountTypeService ats;
    
    @Test
    void addAccountTypeTest() {
        AccountType parent = new AccountType("Parent");
        parent = ats.addAccountType(parent);
        assertNotEquals(0, parent.getId());
    }
    
    @Test
    void getAllAccountTypesTest() {
        List<AccountType> allAccountTypes = ats.getAllAccountTypes();
        assertFalse(allAccountTypes.isEmpty());
    }
    
    @Test
    void getAccountTypeTest() {
        AccountType expectedType = new AccountType(1, "Tutor Manager");
        AccountType actualType = ats.getAccountType(1);
        assertEquals(expectedType.toString(), actualType.toString());
        AccountType notAnAccountType = ats.getAccountType(20);
        assertNull(notAnAccountType);
    }
    
    @Test
    void updateAccountTypeTest() {
        AccountType accountType = ats.getAccountType(2);
        String atToUpdateString = accountType.toString();
        int atToUpdateId = 2;
        accountType.setType("Person");
        accountType = ats.updateAccountType(accountType);
        assertEquals(atToUpdateId, accountType.getId());
        assertNotEquals(atToUpdateString, accountType.toString());
        AccountType fakeAt = new AccountType();
        assertNull(ats.updateAccountType(fakeAt));
    }
    
    @Test
    void deleteAccountTypeTest() {
        boolean atDeleted = ats.deleteAccountType(3);
        assertTrue(atDeleted);
        assertThrows(EmptyResultDataAccessException.class, () -> {
            ats.deleteAccountType(100);
        });
    }
    
}

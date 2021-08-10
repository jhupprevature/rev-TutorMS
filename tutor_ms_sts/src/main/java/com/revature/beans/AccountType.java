package com.revature.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account_types")
public class AccountType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    
    private String type;
    
    @OneToMany(mappedBy = "accountType")
    private Set<User> usersWithType;

    public AccountType() {
        super();
    }

    public AccountType(int id, String type) {
        super();
        this.id = id;
        this.type = type;
    }

    public AccountType(String type) {
        super();
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<User> getUsersWithType() {
        return usersWithType;
    }

    public void setUsersWithType(Set<User> usersWithType) {
        this.usersWithType = usersWithType;
    }

    @Override
    public String toString() {
        return "AccountType [id=" + id + ", type=" + type + "]";
    }
    
}

package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	@PrimaryKeyJoinColumn
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "school_email")
	private String schoolEmail;

	private String password;

	@Column(name = "phone_number")
	private String phoneNumber;

	@ManyToOne
	@JoinColumn(name = "account_type_id", insertable = false, updatable = false)
	private AccountType accountType;

	public User() {
		super();
	}

	public User(int id, String firstName, String lastName, String schoolEmail, String password, String phoneNumber,
			AccountType accountType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.schoolEmail = schoolEmail;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.accountType = accountType;
	}

	public User(String firstName, String lastName, String schoolEmail, String password, String phoneNumber,
			AccountType accountType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.schoolEmail = schoolEmail;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.accountType = accountType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSchoolEmail() {
		return schoolEmail;
	}

	public void setSchoolEmail(String schoolEmail) {
		this.schoolEmail = schoolEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", schoolEmail=" + schoolEmail
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", accountType=" + accountType + "]";
	}

}

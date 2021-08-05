package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_id", updatable = false)
	private int id;
	private String firstName;
	private String lastName;
	private String schoolEmail;
	private String password;
	private String phoneNumber;
	private int accountTypeId;
	private int managerId;

	public User() {
		super();
	}

	public User(int id, String firstName, String lastName, String schoolEmail, String password, String phoneNumber,
			int accountTypeId, int managerId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.schoolEmail = schoolEmail;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.accountTypeId = accountTypeId;
		this.managerId = managerId;
	}

	public User(String firstName, String lastName, String schoolEmail, String password, String phoneNumber,
			int accountTypeId, int managerId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.schoolEmail = schoolEmail;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.accountTypeId = accountTypeId;
		this.managerId = managerId;
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

	public int getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", schoolEmail=" + schoolEmail
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", accountTypeId=" + accountTypeId
				+ ", managerId=" + managerId + "]";
	}

}

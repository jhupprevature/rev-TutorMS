package com.revature.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
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
    @JoinColumn(name = "account_type_id", insertable=false, updatable=false)
    private AccountType accountType;

    @OneToOne(targetEntity = Schedule.class)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tutors_courses",
            joinColumns = { @JoinColumn(name = "tutor_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") })
    private Set<Course> coursesToTutor;

    public User() {
        super();
    }

    public User(int id, String firstName, String lastName, String schoolEmail,
            String password, String phoneNumber, AccountType accountType, Schedule schedule) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolEmail = schoolEmail;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
        this.schedule = schedule;
    }

    public User(String firstName, String lastName, String schoolEmail,
            String password, String phoneNumber, AccountType accountType, Schedule schedule) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolEmail = schoolEmail;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
        this.schedule = schedule;
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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Set<Course> getCoursesToTutor() {
        return coursesToTutor;
    }

    public void setCoursesToTutor(Set<Course> coursesToTutor) {
        this.coursesToTutor = coursesToTutor;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", schoolEmail=" + schoolEmail + ", password="
                + password + ", phoneNumber=" + phoneNumber + ", accountType="
                + accountType + ", schedule=" + schedule + "]";
    }

}

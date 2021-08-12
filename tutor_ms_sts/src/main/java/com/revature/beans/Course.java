package com.revature.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private int id;

	private String name;

	private String subject;

	private int level;

	private int hours;

	@JsonIgnore
	@OneToMany(mappedBy = "course")
	@Transient
	private Set<Session> sessions;

	@JsonIgnore
	@ManyToMany(mappedBy = "coursesToTutor")
	@Transient
	private Set<User> users;

	public Course() {
		super();
	}

	public Course(int id, String name, String subject, int level, int hours) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.level = level;
		this.hours = hours;
	}

	public Course(String name, String subject, int level, int hours) {
		super();
		this.name = name;
		this.subject = subject;
		this.level = level;
		this.hours = hours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", subject=" + subject + ", level=" + level + ", hours=" + hours
				+ "]";
	}

}

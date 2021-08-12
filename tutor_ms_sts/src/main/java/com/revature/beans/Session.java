package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sessions")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name = "tutor_id")
	private User tutor;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private User student;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@Column(name = "start_time")
	private long startTime;

	@Column(name = "end_time")
	private long endTime;

	@Column(name = "student_notes")
	private String studentNotes;

	@Column(name = "tutor_notes")
	private String tutorNotes;

	public Session() {
		super();
	}

	public Session(int id, User tutor, User student, Course course, long startTime, long endTime, String studentNotes,
			String tutorNotes) {
		super();
		this.id = id;
		this.tutor = tutor;
		this.student = student;
		this.course = course;
		this.startTime = startTime;
		this.endTime = endTime;
		this.studentNotes = studentNotes;
		this.tutorNotes = tutorNotes;
	}

	public Session(User tutor, User student, Course course, long startTime, long endTime, String studentNotes,
			String tutorNotes) {
		super();
		this.tutor = tutor;
		this.student = student;
		this.course = course;
		this.startTime = startTime;
		this.endTime = endTime;
		this.studentNotes = studentNotes;
		this.tutorNotes = tutorNotes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getTutor() {
		return tutor;
	}

	public void setTutor(User tutor) {
		this.tutor = tutor;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public String getStudentNotes() {
		return studentNotes;
	}

	public void setStudentNotes(String studentNotes) {
		this.studentNotes = studentNotes;
	}

	public String getTutorNotes() {
		return tutorNotes;
	}

	public void setTutorNotes(String tutorNotes) {
		this.tutorNotes = tutorNotes;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", tutor=" + tutor + ", student=" + student + ", course=" + course + ", startTime="
				+ startTime + ", endTime=" + endTime + ", studentNotes=" + studentNotes + ", tutorNotes=" + tutorNotes
				+ "]";
	}
}
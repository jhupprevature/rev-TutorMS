package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "date_events")
public class DateEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "date_id", updatable = false)
	private int id;
	private String title;
	private String start;

	public DateEvent() {
		super();
	}

	public DateEvent(int id, String title, String start) {
		super();
		this.id = id;
		this.title = title;
		this.start = start;
	}

	public DateEvent(String title, String start) {
		super();
		this.title = title;
		this.start = start;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "DateEvent [id=" + id + ", title=" + title + ", start=" + start + "]";
	}

}

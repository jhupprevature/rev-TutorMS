package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "date_events")
public class DateEvents {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "date_id", updatable = false)
	private int id;
	private String title;
	private String date;

	public DateEvents() {
		super();
	}

	public DateEvents(int id, String title, String date) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
	}

	public DateEvents(String title, String date) {
		super();
		this.title = title;
		this.date = date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "DateEvents [id=" + id + ", title=" + title + ", date=" + date + "]";
	}

}

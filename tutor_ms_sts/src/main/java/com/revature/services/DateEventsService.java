package com.revature.services;

import java.util.List;

import com.revature.beans.DateEvent;

public interface DateEventsService {

	public DateEvent addDateEvents(DateEvent de);

	public DateEvent getDateEvents(int id);

	public List<DateEvent> getAllDateEvents();

	public DateEvent updateDateEvents(DateEvent change);

	public boolean deleteDateEvents(int id);

}

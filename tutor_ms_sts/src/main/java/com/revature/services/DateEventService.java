package com.revature.services;

import java.util.List;

import com.revature.beans.DateEvent;

public interface DateEventService {

	public DateEvent addDateEvent(DateEvent de);

	public DateEvent getDateEvent(int id);

	public List<DateEvent> getAllDateEvents();

	public DateEvent updateDateEvent(DateEvent change);

	public boolean deleteDateEvent(int id);

}

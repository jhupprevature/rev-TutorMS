package com.revature.services;

import java.util.List;

import com.revature.beans.DateEvents;

public interface DateEventsService {

	public DateEvents addDateEvents(DateEvents de);

	public DateEvents getDateEvents(int id);

	public List<DateEvents> getAllDateEvents();

	public DateEvents updateDateEvents(DateEvents change);

	public boolean deleteDateEvents(int id);

}

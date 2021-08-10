package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.DateEvents;
import com.revature.repositories.DateEventsRepo;

@Service
public class DateEventsServiceImpl implements DateEventsService {

	@Autowired
	DateEventsRepo der;

	@Override
	public DateEvents addDateEvents(DateEvents de) {
		return der.save(de);
	}

	@Override
	public DateEvents getDateEvents(int id) {
		return der.findById(id).get();
	}

	@Override
	public List<DateEvents> getAllDateEvents() {
		return (List<DateEvents>) der.findAll();
	}

	@Override
	public DateEvents updateDateEvents(DateEvents change) {
		return der.save(change);
	}

	@Override
	public boolean deleteDateEvents(int id) {
		try {
			der.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}

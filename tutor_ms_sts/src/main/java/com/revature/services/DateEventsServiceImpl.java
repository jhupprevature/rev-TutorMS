package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.DateEvent;
import com.revature.repositories.DateEventsRepo;

@Service
public class DateEventsServiceImpl implements DateEventsService {

	@Autowired
	DateEventsRepo der;

	@Override
	public DateEvent addDateEvents(DateEvent de) {
		return der.save(de);
	}

	@Override
	public DateEvent getDateEvents(int id) {
		return der.findById(id).get();
	}

	@Override
	public List<DateEvent> getAllDateEvents() {
		return (List<DateEvent>) der.findAll();
	}

	@Override
	public DateEvent updateDateEvents(DateEvent change) {
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

package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.DateEvent;
import com.revature.repositories.DateEventRepo;

@Service
public class DateEventServiceImpl implements DateEventService {

	@Autowired
	DateEventRepo der;

	@Override
	public DateEvent addDateEvent(DateEvent de) {
		return der.save(de);
	}

	@Override
	public DateEvent getDateEvent(int id) {
		return der.findById(id).get();
	}

	@Override
	public List<DateEvent> getAllDateEvents() {
		return (List<DateEvent>) der.findAll();
	}

	@Override
	public DateEvent updateDateEvent(DateEvent change) {
		return der.save(change);
	}

	@Override
	public boolean deleteDateEvent(int id) {

		try {
			der.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}

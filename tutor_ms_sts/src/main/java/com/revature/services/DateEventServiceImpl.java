package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.beans.DateEvent;
import com.revature.repositories.DateEventRepo;

@Service
@Qualifier("DateEventService")
public class DateEventServiceImpl implements DateEventService {

    private static final Logger log = Logger
            .getLogger(DateEventServiceImpl.class);
    
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
			log.warn(e);
			return false;
		}
	}

}

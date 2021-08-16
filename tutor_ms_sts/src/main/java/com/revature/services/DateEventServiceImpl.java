package com.revature.services;

import java.util.List;
import java.util.Optional;

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
        Optional<DateEvent> opDe = der.findById(id);
        if (opDe.isPresent()) {
            return opDe.get();
        } else {
            return null;
        }
    }

    @Override
    public List<DateEvent> getAllDateEvents() {
        return (List<DateEvent>) der.findAll();
    }

    @Override
    public DateEvent updateDateEvent(DateEvent change) {
        if (der.existsById(change.getId())) {
            return der.save(change);
        } else {
            return null;
        }
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

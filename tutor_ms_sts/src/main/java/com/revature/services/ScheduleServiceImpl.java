package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.beans.Schedule;
import com.revature.repositories.ScheduleRepo;

@Service
@Qualifier("ScheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    private static final Logger log = Logger
            .getLogger(ScheduleServiceImpl.class);
    
    @Autowired
    ScheduleRepo sr;
    
    @Override
    public Schedule addSchedule(Schedule s) {
        return sr.save(s);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return (List<Schedule>) sr.findAll();
    }

    @Override
    public Schedule getSchedule(int id) {
        return sr.findById(id).get();
    }

    @Override
    public Schedule updateSchedule(Schedule change) {
        return sr.save(change);
    }

    @Override
    public boolean deleteSchedule(int id) {
        try {
            sr.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            log.warn(e);
            return false;
        }
    }
    
}
package com.revature.repositories;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Schedule;

@SpringBootTest(classes = com.revature.app.TutorMsStsApplication.class)
@Transactional
public class ScheduleRepoTests {
    
    @Autowired
    public ScheduleRepo sr;
    
    @Test
    void addSchedule() {
        Date dateTime = new Date();
        long currentTime = dateTime.getTime();
        
        Schedule theoSchedule = new Schedule(null, null, "08:00", "12:00", "08:00", "12:00", "08:00", "12:00", "08:00", "12:00", "08:00", "12:00", null, null, currentTime);
        
        theoSchedule = sr.save(theoSchedule);
        
        System.out.println("theoSchedule ID: " + theoSchedule.getId());
        assertNotEquals(0, theoSchedule.getId());
    }
    
    @Test
    void getAllSchedules() {
        List<Schedule> allSchedules = (List<Schedule>) sr.findAll();
        System.out.println(allSchedules);
        assertFalse(allSchedules.isEmpty());
    }
    
}

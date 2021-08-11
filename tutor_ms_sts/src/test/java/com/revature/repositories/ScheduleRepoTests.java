package com.revature.repositories;

import java.util.Date;

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
        Schedule theoSchedule = new Schedule(16, null, null, "08:00", "12:00", "08:00", "12:00", "08:00", "12:00", "08:00", "12:00", "08:00", "12:00", null, null, currentTime);
    }
    
}

package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Schedule;

@SpringBootTest(classes = com.revature.app.TutorMsStsApplication.class)
@Transactional
public class ScheduleServiceTests {
    
    @Autowired
    public ScheduleService ss;
    
    @Test
    void addScheduleTest() {
        Date dateTime = new Date();
        Long currentTime = dateTime.getTime();
        Schedule theoSchedule = new Schedule(null, null, "08:00", "12:00",
                "08:00", "12:00", "08:00", "12:00", "08:00", "12:00", "08:00",
                "12:00", null, null, currentTime);
        theoSchedule = ss.addSchedule(theoSchedule);
        assertNotEquals(0, theoSchedule.getId());
    }

    @Test
    void getAllSchedulesTest() {
        List<Schedule> allSchedules = ss.getAllSchedules();
        assertFalse(allSchedules.isEmpty());
    }

    @Test
    void getScheduleTest() {
        Schedule expectedSchedule = new Schedule(1, null, null, "07:00",
                "15:00", "07:00", "15:00", "07:00", "15:00", "07:00", "15:00",
                "07:00", "15:00", null, null, null);
        Schedule actualSchedule = ss.getSchedule(1);
        assertEquals(expectedSchedule.toString(), actualSchedule.toString());
    }

    @Test
    void updateScheduleTest() {
        Schedule schedule = ss.getSchedule(2);
        String scheduleToUpdateString = schedule.toString();
        int scheduleToUpdateId = schedule.getId();

        schedule.setMondayStart("10:00");
        schedule.setMondayEnd("14:00");

        schedule = ss.updateSchedule(schedule);

        assertEquals(scheduleToUpdateId, schedule.getId());
        assertNotEquals(scheduleToUpdateString, schedule.toString());
    }

    @Test
    void deleteScheduleTest() {
        boolean sDeleted = ss.deleteSchedule(3);
        assertTrue(sDeleted);
    }
    
}

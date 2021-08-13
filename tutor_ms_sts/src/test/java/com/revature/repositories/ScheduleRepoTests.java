package com.revature.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        Long currentTime = dateTime.getTime();

        Schedule theoSchedule = new Schedule(null, null, "08:00", "12:00",
                "08:00", "12:00", "08:00", "12:00", "08:00", "12:00", "08:00",
                "12:00", null, null, currentTime);

        theoSchedule = sr.save(theoSchedule);

        System.out.println("theoSchedule id: " + theoSchedule.getId());
        assertNotEquals(0, theoSchedule.getId());
    }

    @Test
    void getAllSchedules() {
        List<Schedule> allSchedules = (List<Schedule>) sr.findAll();
        System.out.println(allSchedules);
        assertFalse(allSchedules.isEmpty());
    }

    @Test
    void getScheduleById() {
        Schedule expectedSchedule = new Schedule(1, null, null, "07:00",
                "15:00", "07:00", "15:00", "07:00", "15:00", "07:00", "15:00",
                "07:00", "15:00", null, null, null);
        Schedule actualSchedule = sr.findById(1).get();
        assertEquals(expectedSchedule.toString(), actualSchedule.toString());
    }

    @Test
    void updateSchedule() {
        Schedule schedule = sr.findById(2).get();
        String scheduleToUpdateString = schedule.toString();
        int scheduleToUpdateId = schedule.getId();

        schedule.setMondayStart("10:00");
        schedule.setMondayEnd("14:00");

        schedule = sr.save(schedule);

        assertEquals(scheduleToUpdateId, schedule.getId());
        assertNotEquals(scheduleToUpdateString, schedule.toString());
    }

    @Test
    void deleteSchedule() {
        Schedule schedule = sr.findById(3).get();
        sr.delete(schedule);
        assertFalse(sr.findById(3).isPresent());
    }

}

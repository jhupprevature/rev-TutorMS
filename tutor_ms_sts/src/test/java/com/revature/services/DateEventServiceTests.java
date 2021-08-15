package com.revature.services;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.DateEvent;

@SpringBootTest(classes = com.revature.app.TutorMsStsApplication.class)
@Transactional
public class DateEventServiceTests {
    
    @Autowired
    public DateEventService des;
    
    @Test
    void addDateEventTest() {
        DateEvent dateEvent = new DateEvent("Eat Pie", "2021/08/14");
        dateEvent = des.addDateEvent(dateEvent);
        assertNotEquals(0, dateEvent.getId());
    }
    
    @Test
    void getAllDateEventsTest() {
        List<DateEvent> allDateEvents = des.getAllDateEvents();
        assertFalse(allDateEvents.isEmpty());
    }
    
    @Test
    void getDateEventTest() {
        DateEvent expected = new DateEvent(1, "pancake making", "2021-08-08");
        DateEvent actual = des.getDateEvent(1);
        assertEquals(expected.toString(), actual.toString());
        DateEvent notADateEvent = des.getDateEvent(100);
        assertNull(notADateEvent);
    }
    
    @Test
    void updateDateEventTest() {
        DateEvent dateEvent = des.getDateEvent(2);
        String deToUpdateString = dateEvent.toString();
        int deToUpdateId = 2;
        dateEvent.setTitle("Eat Pie");
        dateEvent = des.updateDateEvent(dateEvent);
        assertEquals(deToUpdateId, dateEvent.getId());
        assertNotEquals(deToUpdateString, dateEvent.toString());
        DateEvent fakeDe = new DateEvent();
        assertNull(des.updateDateEvent(fakeDe));
    }
    
    @Test
    void deleteDateEventTest() {
        boolean deDeleted = des.deleteDateEvent(3);
        assertTrue(deDeleted);
    }
    
}

package com.revature.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.DateEvent;

@SpringBootTest(classes = com.revature.app.TutorMsStsApplication.class)
@Transactional
public class DateEventRepoTests {
    
    @Autowired
    public DateEventRepo der;
    
    @Test
    void addDateEvent() {
        DateEvent newDateEvent = new DateEvent("Eat Pie", "2021-08-13", "Turquoise");
        newDateEvent = der.save(newDateEvent);
        assertNotEquals(0, newDateEvent.getId());
    }
    
    @Test
    void getAllDateEvents() {
        List<DateEvent> allDateEvents = (List<DateEvent>) der.findAll();
        assertFalse(allDateEvents.isEmpty());
    }
    
    @Test
    void getDateEventById() {
        String expectedString = "DateEvent [id=1, title=pancake making, start=2021-08-08]";
        DateEvent actualDateEvent = der.findById(1).get();
        assertEquals(expectedString, actualDateEvent.toString());
    }
    
    @Test
    void updateDateEvent() {
        DateEvent dateEvent = der.findById(2).get();
        String dateEventToUpdateString = dateEvent.toString();
        int dateEventToUpdateId = dateEvent.getId();
        
        dateEvent.setTitle("Eat Pie");
        
        dateEvent = der.save(dateEvent);
        
        assertEquals(dateEventToUpdateId, dateEvent.getId());
        assertNotEquals(dateEventToUpdateString, dateEvent.toString());
    }
    
//    @Test
//    void deleteDateEvent() {
//        DateEvent dateEvent = der.findById(3).get();
//        der.delete(dateEvent);
//        assertFalse(der.findById(3).isPresent());
//    }

   @Test
   void deleteDateEventById() {
       der.deleteById(3);
       assertFalse(der.findById(3).isPresent());
   }
    
}

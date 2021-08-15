package com.revature.repositories;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Course;
import com.revature.beans.Session;
import com.revature.beans.User;

@SpringBootTest(classes = com.revature.app.TutorMsStsApplication.class)
@Transactional
public class SessionRepoTests {

    @Autowired
    public SessionRepo sr;

    @Autowired
    public UserRepo ur;

    @Autowired
    public CourseRepo cr;

    @Test
    void addSession() {
        User tutorAddie = ur.findById(4).get();
        User studentTina = ur.findById(8).get();
        Course courseComp2 = cr.findById(2).get();
        long aug13At1PmEst = 1628874000000L;
        long aug13At2PmEst = 1628877600000L;
        String tutorNotes = "Unfortunately, Tina showed little effort"
                + " in correcting her writing.";
        String studentNotes = "this was lame";
        Session writingSession = new Session(tutorAddie, studentTina,
                courseComp2, aug13At1PmEst, aug13At2PmEst, tutorNotes,
                studentNotes);
        sr.save(writingSession);
        assertNotEquals(0, writingSession.getId());
    }

    @Test
    void getAllSessions() {
        List<Session> allSessions = (List<Session>) sr.findAll();
        assertFalse(allSessions.isEmpty());
    }

    @Test
    void getSessionById() {
        User tutor = ur.findById(3).get();
        User student = ur.findById(8).get();
        Course course = cr.findById(16).get();
        Session expectedSession = new Session(1, tutor, student, course,
                1612890000000L, 1612893600000L,
                "Tutored in STEM Physics 1. Kid did good.",
                "Law is the best tutor!");
        Session actualSession = sr.findById(1).get();
        assertEquals(expectedSession.toString(), actualSession.toString());
    }
    
    @Test
    void updateSession() {
        Session session = sr.findById(2).get();
        String sessionToUpdateString = session.toString();
        int sessionToUpdateId = session.getId();
        
        session.setStudentNotes("I actually had fun.");
        
        session = sr.save(session);
        
        assertEquals(sessionToUpdateId, session.getId());
        assertNotEquals(sessionToUpdateString, session.toString());
    }
    
    @Test
    void deleteSessionById() {
        sr.deleteById(3);
        assertFalse(sr.findById(3).isPresent());
    }
    
    @Test
    void findAllByOrderByStartTimeDesc() {
        assertNull(sr.findAllByOrderByStartTimeDesc());
    }

}

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

import com.revature.beans.Course;
import com.revature.beans.Session;
import com.revature.beans.User;

@SpringBootTest(classes = com.revature.app.TutorMsStsApplication.class)
@Transactional
public class SessionServiceTests {
    
    @Autowired
    public SessionService ss;
    
    @Autowired
    public UserService us;
    
    @Autowired
    public CourseService cs;
    
    @Test
    void addSessionTest() {
        User tutor = us.getUser(4);
        User student = us.getUser(8);
        Course course = cs.getCourse(2);
        long aug13At1PmEst = 1628874000000L;
        long aug13At2PmEst = 1628877600000L;
        String tutorNotes = "Unfortunately, Tina showed little effort"
                + " in correcting her writing.";
        String studentNotes = "this was lame";
        Session writingSession = new Session(0, tutor, student,
                course, aug13At1PmEst, aug13At2PmEst, tutorNotes,
                studentNotes);
        writingSession = ss.addSession(writingSession);
        assertNotEquals(0, writingSession.getId());
    }
    
    @Test
    void getAllSessionsTest() {
        List<Session> allSessions = ss.getAllSessions();
        assertFalse(allSessions.isEmpty());
    }
    
    @Test
    void getSessionTest() {
        User tutor = us.getUser(3);
        User student = us.getUser(8);
        Course course = cs.getCourse(16);
        Session expectedSession = new Session(1, tutor, student, course,
                1612890000000L, 1612893600000L,
                "Tutored in STEM Physics 1. Kid did good.",
                "Law is the best tutor!");
        Session actualSession = ss.getSession(1);
        assertEquals(expectedSession.toString(), actualSession.toString());
        Session notASession = ss.getSession(100);
        assertNull(notASession);
    }
    
    @Test
    void updateSessionTest() {
        Session session = ss.getSession(2);
        String sToUpdateString = session.toString();
        int sToUpdateId = 2;
        session.setStudentNotes("Enjoyable.");
        session = ss.updateSession(session);
        assertEquals(sToUpdateId, session.getId());
        assertNotEquals(sToUpdateString, session.toString());
        Session notASess = new Session();
        assertNull(ss.updateSession(notASess));
    }
    
    @Test
    void deleteSessionTest() {
        boolean sDeleted = ss.deleteSession(3);
        assertTrue(sDeleted);
    }
    
}

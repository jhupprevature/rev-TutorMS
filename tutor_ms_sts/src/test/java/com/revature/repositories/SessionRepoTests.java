package com.revature.repositories;

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
        Session writingSession = new Session(tutorAddie, studentTina, courseComp2,
                aug13At1PmEst, aug13At2PmEst, tutorNotes, studentNotes);
    }
    
}

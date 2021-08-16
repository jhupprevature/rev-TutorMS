package com.revature.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.beans.Analytic;
import com.revature.beans.Course;
import com.revature.beans.JsonRequestSession;
import com.revature.beans.Session;
import com.revature.beans.StringAndNumber;
import com.revature.beans.User;
import com.revature.repositories.SessionRepo;

@Service
@Qualifier("SessionService")
public class SessionServiceImpl implements SessionService {

    private static final Logger log = Logger
            .getLogger(SessionServiceImpl.class);

    @Autowired
    SessionRepo sr;

    @Autowired
    UserService us;

    @Autowired
    CourseService cs;

    @Override
    public Session addSession(JsonRequestSession jrs) {
        User tutor = us.getUser(jrs.getTutorId());
        User student = us.getUser(jrs.getStudentId());
        Course course = cs.getCourse(jrs.getCourseId());

        long startTime = jrs.getStartTime();
        long endTime = jrs.getEndTime();
        String tutorNotes = jrs.getTutorNotes();
        String studentNotes = jrs.getStudentNotes();

        Session session = new Session(tutor, student, course, startTime,
                endTime, tutorNotes, studentNotes);
        return sr.save(session);
    }

    @Override
    public Session getSession(int id) {
        Optional<Session> opS = sr.findById(id);
        if (opS.isPresent()) {
            return opS.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Session> getAllSessions() {
        return (List<Session>) sr.findAll();
    }

    @Override
    public Session updateSession(Session change) {
        if (sr.existsById(change.getId())) {
            return sr.save(change);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteSession(int id) {
        try {
            sr.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            log.warn(e);
            return false;
        }
    }

    @Override
    public Analytic getAnalytic() {

        List<Session> allSessions = getAllSessions();

        Map<String, Integer> tutorSessMap = new HashMap<>();
        Map<String, Integer> studentSessMap = new HashMap<>();
        Map<String, Integer> courseSessMap = new HashMap<>();

        for (Session session : allSessions) {

            String tutorString = session.getTutor().getFirstName() + " "
                    + session.getTutor().getLastName();
            if (tutorSessMap.containsKey(tutorString)) {
                int tutorValue = tutorSessMap.get(tutorString) + 1;
                tutorSessMap.put(tutorString, tutorValue);
            } else {
                tutorSessMap.put(tutorString, 1);
            }

            String studentString = session.getStudent().getFirstName() + " "
                    + session.getStudent().getLastName();
            if (studentSessMap.containsKey(studentString)) {
                int studentValue = studentSessMap.get(studentString) + 1;
                studentSessMap.put(studentString, studentValue);
            } else {
                studentSessMap.put(studentString, 1);
            }

            String courseString = session.getCourse().getName();
            if (courseSessMap.containsKey(courseString)) {
                int courseValue = courseSessMap.get(courseString) + 1;
                courseSessMap.put(courseString, courseValue);
            } else {
                courseSessMap.put(courseString, 1);
            }

        }

        ArrayList<StringAndNumber> tutorCounts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : tutorSessMap.entrySet()) {
            StringAndNumber san = new StringAndNumber(entry.getKey(),
                    entry.getValue());
            tutorCounts.add(san);
        }
        ArrayList<StringAndNumber> studentCounts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : studentSessMap.entrySet()) {
            StringAndNumber san = new StringAndNumber(entry.getKey(),
                    entry.getValue());
            studentCounts.add(san);
        }
        ArrayList<StringAndNumber> courseCounts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : courseSessMap.entrySet()) {
            StringAndNumber san = new StringAndNumber(entry.getKey(),
                    entry.getValue());
            courseCounts.add(san);
        }
        
        Collections.sort(tutorCounts, new SortArrayOfStringAndNumber());
        Collections.sort(studentCounts, new SortArrayOfStringAndNumber());
        Collections.sort(courseCounts, new SortArrayOfStringAndNumber());
        
        Analytic analytic = new Analytic(tutorCounts, studentCounts, courseCounts);
        return analytic;
    }

}

package com.revature.beans;

import java.util.List;

public class Analytic {
    
    private List<StringAndNumber> tutorSessions;
    private List<StringAndNumber> studentSessions;
    private List<StringAndNumber> courseSessions;
    
    public Analytic(List<StringAndNumber> tutorSessions,
            List<StringAndNumber> studentSessions,
            List<StringAndNumber> courseSessions) {
        super();
        this.tutorSessions = tutorSessions;
        this.studentSessions = studentSessions;
        this.courseSessions = courseSessions;
    }
    
    
    
}

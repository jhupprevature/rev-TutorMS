package com.revature.beans;

import java.util.List;

public class Analytic {
    
    private List<StringAndNumber> tutorCounts;
    private List<StringAndNumber> studentCounts;
    private List<StringAndNumber> courseCounts;
    
    public Analytic(List<StringAndNumber> tutorCounts,
            List<StringAndNumber> studentCounts,
            List<StringAndNumber> courseCounts) {
        super();
        this.tutorCounts = tutorCounts;
        this.studentCounts = studentCounts;
        this.courseCounts = courseCounts;
    }

    public List<StringAndNumber> getTutorCounts() {
        return tutorCounts;
    }

    public void setTutorCounts(List<StringAndNumber> tutorCounts) {
        this.tutorCounts = tutorCounts;
    }

    public List<StringAndNumber> getStudentCounts() {
        return studentCounts;
    }

    public void setStudentCounts(List<StringAndNumber> studentCounts) {
        this.studentCounts = studentCounts;
    }

    public List<StringAndNumber> getCourseCounts() {
        return courseCounts;
    }

    public void setCourseCounts(List<StringAndNumber> courseCounts) {
        this.courseCounts = courseCounts;
    }

    @Override
    public String toString() {
        return "Analytic [tutorCounts=" + tutorCounts + ", studentCounts="
                + studentCounts + ", courseCounts=" + courseCounts + "]";
    }
    
}

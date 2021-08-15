package com.revature.beans;

public class JsonRequestSession {
    
    private int tutorId;
    private int studentId;
    private int courseId;
    private long startTime;
    private long endTime;
    private String tutorNotes;
    private String studentNotes;
    
    public JsonRequestSession(int tutorId, int studentId, int courseId,
            long startTime, long endTime, String tutorNotes,
            String studentNotes) {
        super();
        this.tutorId = tutorId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tutorNotes = tutorNotes;
        this.studentNotes = studentNotes;
    }

    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getTutorNotes() {
        return tutorNotes;
    }

    public void setTutorNotes(String tutorNotes) {
        this.tutorNotes = tutorNotes;
    }

    public String getStudentNotes() {
        return studentNotes;
    }

    public void setStudentNotes(String studentNotes) {
        this.studentNotes = studentNotes;
    }

    @Override
    public String toString() {
        return "JsonRequestSession [tutorId=" + tutorId + ", studentId="
                + studentId + ", courseId=" + courseId + ", startTime="
                + startTime + ", endTime=" + endTime + ", tutorNotes="
                + tutorNotes + ", studentNotes=" + studentNotes + "]";
    }
    
    
    
}

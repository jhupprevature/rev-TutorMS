package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "schedules")
public class Schedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    
    @Column(name = "sunday_start")
    private String sundayStart;

    @Column(name = "sunday_end")
    private String sundayEnd;
    
    @Column(name = "monday_start")
    private String mondayStart;
    
    @Column(name = "monday_end")
    private String mondayEnd;
    
    @Column(name = "tuesday_start")
    private String tuesdayStart;

    @Column(name = "tuesday_end")
    private String tuesdayEnd;
    
    @Column(name = "wednesday_start")
    private String wednesdayStart;

    @Column(name = "wednesday_end")
    private String wednesdayEnd;
    
    @Column(name = "thursday_start")
    private String thursdayStart;

    @Column(name = "thursday_end")
    private String thursdayEnd;
    
    @Column(name = "friday_start")
    private String fridayStart;

    @Column(name = "friday_end")
    private String fridayEnd;
    
    @Column(name = "saturday_start")
    private String saturdayStart;

    @Column(name = "saturday_end")
    private String saturdayEnd;
    
    @Column(name = "pending_approval_since", nullable = true)
    private Long pendingApprovalSince;
    
//    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
//    @Transient
//    private User user;

    public Schedule() {
        super();
    }

    public Schedule(int id, String sundayStart, String sundayEnd,
            String mondayStart, String mondayEnd, String tuesdayStart,
            String tuesdayEnd, String wednesdayStart,
            String wednesdayEnd, String thursdayStart,
            String thursdayEnd, String fridayStart, String fridayEnd,
            String saturdayStart, String saturdayEnd,
            Long pendingApprovalSince) {
        super();
        this.id = id;
        this.sundayStart = sundayStart;
        this.sundayEnd = sundayEnd;
        this.mondayStart = mondayStart;
        this.mondayEnd = mondayEnd;
        this.tuesdayStart = tuesdayStart;
        this.tuesdayEnd = tuesdayEnd;
        this.wednesdayStart = wednesdayStart;
        this.wednesdayEnd = wednesdayEnd;
        this.thursdayStart = thursdayStart;
        this.thursdayEnd = thursdayEnd;
        this.fridayStart = fridayStart;
        this.fridayEnd = fridayEnd;
        this.saturdayStart = saturdayStart;
        this.saturdayEnd = saturdayEnd;
        this.pendingApprovalSince = pendingApprovalSince;
    }

    public Schedule(String sundayStart, String sundayEnd,
            String mondayStart, String mondayEnd, String tuesdayStart,
            String tuesdayEnd, String wednesdayStart,
            String wednesdayEnd, String thursdayStart,
            String thursdayEnd, String fridayStart, String fridayEnd,
            String saturdayStart, String saturdayEnd,
            Long pendingApprovalSince) {
        super();
        this.sundayStart = sundayStart;
        this.sundayEnd = sundayEnd;
        this.mondayStart = mondayStart;
        this.mondayEnd = mondayEnd;
        this.tuesdayStart = tuesdayStart;
        this.tuesdayEnd = tuesdayEnd;
        this.wednesdayStart = wednesdayStart;
        this.wednesdayEnd = wednesdayEnd;
        this.thursdayStart = thursdayStart;
        this.thursdayEnd = thursdayEnd;
        this.fridayStart = fridayStart;
        this.fridayEnd = fridayEnd;
        this.saturdayStart = saturdayStart;
        this.saturdayEnd = saturdayEnd;
        this.pendingApprovalSince = pendingApprovalSince;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSundayStart() {
        return sundayStart;
    }

    public void setSundayStart(String sundayStart) {
        this.sundayStart = sundayStart;
    }

    public String getSundayEnd() {
        return sundayEnd;
    }

    public void setSundayEnd(String sundayEnd) {
        this.sundayEnd = sundayEnd;
    }

    public String getMondayStart() {
        return mondayStart;
    }

    public void setMondayStart(String mondayStart) {
        this.mondayStart = mondayStart;
    }

    public String getMondayEnd() {
        return mondayEnd;
    }

    public void setMondayEnd(String mondayEnd) {
        this.mondayEnd = mondayEnd;
    }

    public String getTuesdayStart() {
        return tuesdayStart;
    }

    public void setTuesdayStart(String tuesdayStart) {
        this.tuesdayStart = tuesdayStart;
    }

    public String getTuesdayEnd() {
        return tuesdayEnd;
    }

    public void setTuesdayEnd(String tuesdayEnd) {
        this.tuesdayEnd = tuesdayEnd;
    }

    public String getWednesdayStart() {
        return wednesdayStart;
    }

    public void setWednesdayStart(String wednesdayStart) {
        this.wednesdayStart = wednesdayStart;
    }

    public String getWednesdayEnd() {
        return wednesdayEnd;
    }

    public void setWednesdayEnd(String wednesdayEnd) {
        this.wednesdayEnd = wednesdayEnd;
    }

    public String getThursdayStart() {
        return thursdayStart;
    }

    public void setThursdayStart(String thursdayStart) {
        this.thursdayStart = thursdayStart;
    }

    public String getThursdayEnd() {
        return thursdayEnd;
    }

    public void setThursdayEnd(String thursdayEnd) {
        this.thursdayEnd = thursdayEnd;
    }

    public String getFridayStart() {
        return fridayStart;
    }

    public void setFridayStart(String fridayStart) {
        this.fridayStart = fridayStart;
    }

    public String getFridayEnd() {
        return fridayEnd;
    }

    public void setFridayEnd(String fridayEnd) {
        this.fridayEnd = fridayEnd;
    }

    public String getSaturdayStart() {
        return saturdayStart;
    }

    public void setSaturdayStart(String saturdayStart) {
        this.saturdayStart = saturdayStart;
    }

    public String getSaturdayEnd() {
        return saturdayEnd;
    }

    public void setSaturdayEnd(String saturdayEnd) {
        this.saturdayEnd = saturdayEnd;
    }

    public Long getPendingApprovalSince() {
        return pendingApprovalSince;
    }

    public void setPendingApprovalSince(Long pendingApprovalSince) {
        this.pendingApprovalSince = pendingApprovalSince;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "Schedule [id=" + id + ", sundayStart=" + sundayStart
                + ", sundayEnd=" + sundayEnd + ", mondayStart=" + mondayStart
                + ", mondayEnd=" + mondayEnd + ", tuesdayStart=" + tuesdayStart
                + ", tuesdayEnd=" + tuesdayEnd + ", wednesdayStart="
                + wednesdayStart + ", wednesdayEnd=" + wednesdayEnd
                + ", thursdayStart=" + thursdayStart + ", thursdayEnd="
                + thursdayEnd + ", fridayStart=" + fridayStart + ", fridayEnd="
                + fridayEnd + ", saturdayStart=" + saturdayStart
                + ", saturdayEnd=" + saturdayEnd + ", pendingApprovalSince="
                + pendingApprovalSince + "]";
    }
    
}

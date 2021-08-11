package com.revature.beans;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule {
    
    @Id
    @Column(name = "tutor_id", updatable = false)
    private int id;
    
    @Column(name = "sunday_start")
    private LocalTime sundayStart;

    @Column(name = "sunday_end")
    private LocalTime sundayEnd;
    
    @Column(name = "monday_start")
    private LocalTime mondayStart;
    
    @Column(name = "monday_end")
    private LocalTime mondayEnd;
    
    @Column(name = "tuesday_start")
    private LocalTime tuesdayStart;

    @Column(name = "tuesday_end")
    private LocalTime tuesdayEnd;
    
    @Column(name = "wednesday_start")
    private LocalTime wednesdayStart;

    @Column(name = "wednesday_end")
    private LocalTime wednesdayEnd;
    
    @Column(name = "thursday_start")
    private LocalTime thursdayStart;

    @Column(name = "thursday_end")
    private LocalTime thursdayEnd;
    
    @Column(name = "friday_start")
    private LocalTime fridayStart;

    @Column(name = "friday_end")
    private LocalTime fridayEnd;
    
    @Column(name = "saturday_start")
    private LocalTime saturdayStart;

    @Column(name = "saturday_end")
    private LocalTime saturdayEnd;
    
    @Column(name = "pending_approval_since")
    private long pendingApprovalSince;
    
    @OneToOne(targetEntity = User.class)
    private User user;

    public Schedule() {
        super();
    }

    public Schedule(int id, LocalTime sundayStart, LocalTime sundayEnd,
            LocalTime mondayStart, LocalTime mondayEnd, LocalTime tuesdayStart,
            LocalTime tuesdayEnd, LocalTime wednesdayStart,
            LocalTime wednesdayEnd, LocalTime thursdayStart,
            LocalTime thursdayEnd, LocalTime fridayStart, LocalTime fridayEnd,
            LocalTime saturdayStart, LocalTime saturdayEnd,
            long pendingApprovalSince) {
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

    public Schedule(LocalTime sundayStart, LocalTime sundayEnd,
            LocalTime mondayStart, LocalTime mondayEnd, LocalTime tuesdayStart,
            LocalTime tuesdayEnd, LocalTime wednesdayStart,
            LocalTime wednesdayEnd, LocalTime thursdayStart,
            LocalTime thursdayEnd, LocalTime fridayStart, LocalTime fridayEnd,
            LocalTime saturdayStart, LocalTime saturdayEnd,
            long pendingApprovalSince) {
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

    public LocalTime getSundayStart() {
        return sundayStart;
    }

    public void setSundayStart(LocalTime sundayStart) {
        this.sundayStart = sundayStart;
    }

    public LocalTime getSundayEnd() {
        return sundayEnd;
    }

    public void setSundayEnd(LocalTime sundayEnd) {
        this.sundayEnd = sundayEnd;
    }

    public LocalTime getMondayStart() {
        return mondayStart;
    }

    public void setMondayStart(LocalTime mondayStart) {
        this.mondayStart = mondayStart;
    }

    public LocalTime getMondayEnd() {
        return mondayEnd;
    }

    public void setMondayEnd(LocalTime mondayEnd) {
        this.mondayEnd = mondayEnd;
    }

    public LocalTime getTuesdayStart() {
        return tuesdayStart;
    }

    public void setTuesdayStart(LocalTime tuesdayStart) {
        this.tuesdayStart = tuesdayStart;
    }

    public LocalTime getTuesdayEnd() {
        return tuesdayEnd;
    }

    public void setTuesdayEnd(LocalTime tuesdayEnd) {
        this.tuesdayEnd = tuesdayEnd;
    }

    public LocalTime getWednesdayStart() {
        return wednesdayStart;
    }

    public void setWednesdayStart(LocalTime wednesdayStart) {
        this.wednesdayStart = wednesdayStart;
    }

    public LocalTime getWednesdayEnd() {
        return wednesdayEnd;
    }

    public void setWednesdayEnd(LocalTime wednesdayEnd) {
        this.wednesdayEnd = wednesdayEnd;
    }

    public LocalTime getThursdayStart() {
        return thursdayStart;
    }

    public void setThursdayStart(LocalTime thursdayStart) {
        this.thursdayStart = thursdayStart;
    }

    public LocalTime getThursdayEnd() {
        return thursdayEnd;
    }

    public void setThursdayEnd(LocalTime thursdayEnd) {
        this.thursdayEnd = thursdayEnd;
    }

    public LocalTime getFridayStart() {
        return fridayStart;
    }

    public void setFridayStart(LocalTime fridayStart) {
        this.fridayStart = fridayStart;
    }

    public LocalTime getFridayEnd() {
        return fridayEnd;
    }

    public void setFridayEnd(LocalTime fridayEnd) {
        this.fridayEnd = fridayEnd;
    }

    public LocalTime getSaturdayStart() {
        return saturdayStart;
    }

    public void setSaturdayStart(LocalTime saturdayStart) {
        this.saturdayStart = saturdayStart;
    }

    public LocalTime getSaturdayEnd() {
        return saturdayEnd;
    }

    public void setSaturdayEnd(LocalTime saturdayEnd) {
        this.saturdayEnd = saturdayEnd;
    }

    public long getPendingApprovalSince() {
        return pendingApprovalSince;
    }

    public void setPendingApprovalSince(long pendingApprovalSince) {
        this.pendingApprovalSince = pendingApprovalSince;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

package com.revature.services;

import java.util.List;

import com.revature.beans.Schedule;

public interface ScheduleService {

    public Schedule addSchedule(Schedule s);

    public List<Schedule> getAllSchedules();
    
    public Schedule getSchedule(int id);

    public Schedule updateSchedule(Schedule change);

    public boolean deleteSchedule(int id);

}

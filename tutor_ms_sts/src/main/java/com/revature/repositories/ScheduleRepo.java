package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Schedule;

@Repository
public interface ScheduleRepo extends CrudRepository<Schedule, Integer> {
    
}

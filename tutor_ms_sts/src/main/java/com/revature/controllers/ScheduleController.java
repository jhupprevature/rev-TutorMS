package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Schedule;
import com.revature.services.ScheduleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ScheduleController {
    
    @Autowired
    ScheduleService ss;
    
    @CrossOrigin
    @PostMapping(value = "/schedules", produces = "application/json")
    public Schedule addScheduleToApprove(@RequestBody Schedule s) {
        return addScheduleToApprove;
    }
    
}

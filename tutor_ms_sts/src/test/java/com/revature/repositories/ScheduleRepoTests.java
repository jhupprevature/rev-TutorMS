package com.revature.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = com.revature.app.TutorMsStsApplication.class)
@Transactional
public class ScheduleRepoTests {
    
    @Autowired
    public ScheduleRepo sr;
    
    
}

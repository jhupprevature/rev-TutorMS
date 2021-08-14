package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.beans.Course;
import com.revature.repositories.CourseRepo;

@Service
@Qualifier("CourseService")
public class CourseServiceImpl implements CourseService {

    private static final Logger log = Logger
            .getLogger(CourseServiceImpl.class);
    
    @Autowired
    CourseRepo cr;
    
    @Override
    public Course addCourse(Course course) {
        return cr.save(course);
    }

    @Override
    public Course getCourse(int id) {
        return cr.findById(id).get();
    }

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) cr.findAll();
    }

    @Override
    public Course updateCourse(Course change) {
        return cr.save(change);
    }

    @Override
    public boolean deleteCourse(int id) {
        try {
            cr.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            log.warn(e);
            return false;
        }
    }
    
}

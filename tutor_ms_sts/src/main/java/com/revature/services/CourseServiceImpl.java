package com.revature.services;

import java.util.List;
import java.util.Optional;

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
	public Course getCourse(String name) {
		return cr.findByName(name);
	}
    
    @Override
    public Course getCourse(int id) {
        Optional<Course> opC = cr.findById(id);
        if (opC.isPresent()) {
            return opC.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) cr.findAll();
    }

    @Override
    public Course updateCourse(Course change) {
        if (cr.existsById(change.getId())) {
            return cr.save(change);
        } else {
            return null;
        }
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

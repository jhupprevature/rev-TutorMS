package com.revature.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Course;

@SpringBootTest(classes = com.revature.app.TutorMsStsApplication.class)
@Transactional
public class CourseRepoTests {
    
    @Autowired
    public CourseRepo cr;
    
    @Test
    void addCourse() {
        Course newCourse = new Course("Introduction to Biology: The Evolution and Diversity of Life", "BIOL", 1010, 3);
        newCourse = cr.save(newCourse);
        System.out.println("newCourse id: " + newCourse.getId());
        assertNotEquals(0, newCourse.getId());
    }
    
    @Test
    void getAllCourses() {
        List<Course> allCourses = (List<Course>) cr.findAll();
        System.out.println(allCourses);
        assertFalse(allCourses.isEmpty());
    }
    
    @Test
    void getCourseById() {
        Course expectedCourse = new Course(1, "Composition I", "ENGL", 1101, 3);
        Course actualCourse = cr.findById(1).get();
        assertEquals(expectedCourse.toString(), actualCourse.toString());
    }
    
    @Test
    void updateCourse() {
        Course course = cr.findById(2).get();
        String courseToUpdateString = course.toString();
        int courseToUpdateId = course.getId();
        
        course.setName("Poetry");
        course.setLevel(1105);
        
        course = cr.save(course);
        
        assertEquals(courseToUpdateId, course.getId());
        assertNotEquals(courseToUpdateString, course.toString());
    }
    
    @Test
    void deleteCourse() {
        Course course = cr.findById(3).get();
        cr.delete(course);
        assertFalse(cr.findById(3).isPresent());
    }
    
}

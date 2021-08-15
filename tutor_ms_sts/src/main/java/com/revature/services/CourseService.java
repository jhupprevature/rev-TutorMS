package com.revature.services;

import java.util.List;

import com.revature.beans.Course;

public interface CourseService {
    
    public Course addCourse(Course course);

    public Course getCourse(int id);

    public Course getCourse(String courseType);

    public List<Course> getAllCourses();

    public Course updateCourse(Course change);

    public boolean deleteCourse(int id);
    
}

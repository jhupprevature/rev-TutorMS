package com.revature.services;

import java.util.List;

import com.revature.beans.Course;

public interface CourseService {

	public Course addCourses(Course at);

	public Course getCourses(String courseType);

	public List<Course> getAllCourses();

	public Course updateCourses(Course change);

	public boolean deleteCourses(int id);
}

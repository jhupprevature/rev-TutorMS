package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.beans.Course;
import com.revature.repositories.CourseRepo;

@Service
@Qualifier("CourseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepo cr;

	@Override
	public Course addCourses(Course at) {
		return cr.save(at);
	}

	@Override
	public Course getCourses(String name) {
		return cr.findByName(name);
	}

	@Override
	public List<Course> getAllCourses() {
		return (List<Course>) cr.findAll();
	}

	@Override
	public Course updateCourses(Course change) {
		return cr.save(change);
	}

	@Override
	public boolean deleteCourses(int id) {
		try {
			cr.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}
}

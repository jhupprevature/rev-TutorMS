package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Course;
import com.revature.services.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

	@Autowired
	CourseService cs;

	@CrossOrigin
	@GetMapping(value = "/courses", produces = "application/json")
	public List<Course> getAllCourses() {
		return cs.getAllCourses();
	}

	@CrossOrigin
	@GetMapping("courses/{id}")
	public Course getCourse(@PathVariable("id") String id) {
		return cs.getCourses(id);
	}

	@CrossOrigin
	@PostMapping(value = "/courses", consumes = "application/json", produces = "application/json")
	public Course addCourse(@RequestBody Course de) {
		return cs.addCourses(de);
	}

	@CrossOrigin
	@PutMapping(value = "/courses/{id}", consumes = "application/json", produces = "application/json")
	public Course updateCourse(@PathVariable int id, @RequestBody Course change) {
		change.setId(id);
		return cs.updateCourses(change);
	}

	@CrossOrigin
	@DeleteMapping("courses/{id}")
	public boolean deleteCourse(@PathVariable("id") String id) {
		return cs.deleteCourses(Integer.parseInt(id));
	}
}

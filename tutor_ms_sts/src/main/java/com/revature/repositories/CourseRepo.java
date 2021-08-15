package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course, Integer> {

	Course findByName(String name);
}

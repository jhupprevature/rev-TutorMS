package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Course;

@SpringBootTest(classes = com.revature.app.TutorMsStsApplication.class)
@Transactional
public class CourseServiceTests {

    @Autowired
    public CourseService cs;

    @Test
    void addCourseTest() {
        Course newCourse = new Course(
                "Introduction to Biology: The Evolution and Diversity of Life",
                "BIOL", 1010, 3);
        newCourse = cs.addCourse(newCourse);
        assertNotEquals(0, newCourse.getId());
    }

    @Test
    void getAllCoursesTest() {
        List<Course> allCourses = cs.getAllCourses();
        assertFalse(allCourses.isEmpty());
    }

    @Test
    void getCourseTest() {
        Course expectedCourse = new Course(1, "Composition I", "ENGL", 1101, 3);
        Course actualCourse = cs.getCourse(1);
        assertEquals(expectedCourse.toString(), actualCourse.toString());
    }

    @Test
    void updateCourseTest() {
        Course course = cs.getCourse(2);
        String courseToUpdateString = course.toString();
        int courseToUpdateId = course.getId();

        course.setName("Poetry");
        course.setLevel(1105);

        course = cs.updateCourse(course);

        assertEquals(courseToUpdateId, course.getId());
        assertNotEquals(courseToUpdateString, course.toString());
    }

    @Test
    void deleteCourseTest() {
        boolean cDeleted = cs.deleteCourse(3);
        assertTrue(cDeleted);
    }

}

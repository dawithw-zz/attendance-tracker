package io.github.dawithw.attendancetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.dawithw.attendancetracker.domain.Course;
import io.github.dawithw.attendancetracker.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired CourseRepository courseRepository;
    
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }
}
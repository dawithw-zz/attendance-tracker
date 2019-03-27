package io.github.dawithw.attendancetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.dawithw.attendancetracker.domain.CourseOffering;
import io.github.dawithw.attendancetracker.repository.CourseOfferingRepository;

@Service
public class CourseOfferingService {

    @Autowired CourseOfferingRepository courseOfferingRepository;

    public void saveCourseOffering(CourseOffering course) {
        courseOfferingRepository.save(course);
    }

    public List<CourseOffering> getAllCourseOfferings() {
        List<CourseOffering> offerings = new ArrayList<>();
        courseOfferingRepository.findAll().forEach(offerings::add);
        return offerings;
    }
}
package io.github.dawithw.attendancetracker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class CourseOffering {
    @Id 
    @GeneratedValue 
    private int id;

    @ManyToOne
    private Course course;


    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return this.course;
    }

    public String toString() {
        String courseDetails = "Course Offering: " + course;
        return courseDetails;
    }
}
package io.github.dawithw.attendancetracker.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Student extends Person {

    @ManyToMany(fetch=FetchType.LAZY)
    private Set<CourseOffering> coursesAttended;

    public void attend(CourseOffering course) {
        if(coursesAttended == null)
            this.coursesAttended = new HashSet<>();
        this.coursesAttended.add(course);
    }

    public void setCoursesAttended (Set<CourseOffering> coursesAttended) {
        this.coursesAttended = coursesAttended;
    }

    public Set<CourseOffering> getCoursesAttended () {
        return this.coursesAttended;
    }
}
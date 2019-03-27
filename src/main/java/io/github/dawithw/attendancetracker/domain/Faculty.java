package io.github.dawithw.attendancetracker.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Faculty extends Person {

    @OneToMany
    private Set<CourseOffering> coursesTaught;

    public void teach(CourseOffering course) {
        if (coursesTaught == null)
            this.coursesTaught = new HashSet<>();
        this.coursesTaught.add(course);
    }

    public void setCoursesTaught(Set<CourseOffering> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    public Set<CourseOffering> getCoursesTaught() {
        return this.coursesTaught;
    }
}
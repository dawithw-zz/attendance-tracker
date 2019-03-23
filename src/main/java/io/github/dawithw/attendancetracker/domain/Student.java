package io.github.dawithw.attendancetracker.domain;

import javax.persistence.Entity;

@Entity
public class Student extends Person {

    @Override
    public String toString() {
        return "Student:" + 
                "\t" + super.getFirstName() + 
                "\t" + super.getLastName() + 
                "\t" + super.getEmail();
    }
}
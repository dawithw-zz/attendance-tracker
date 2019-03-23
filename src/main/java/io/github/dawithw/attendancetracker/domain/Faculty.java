package io.github.dawithw.attendancetracker.domain;

import javax.persistence.Entity;

@Entity
public class Faculty extends Person {

    @Override
    public String toString() {
        return "Faculty:" + 
                "\t" + super.getFirstName() + 
                "\t" + super.getLastName() + 
                "\t" + super.getEmail();
    }
}
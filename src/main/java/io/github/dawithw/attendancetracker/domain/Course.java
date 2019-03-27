package io.github.dawithw.attendancetracker.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
    @Id 
    private String code;
    private String name;
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public String toString() {
        return "Course: " + code + " " + name;
    }
}
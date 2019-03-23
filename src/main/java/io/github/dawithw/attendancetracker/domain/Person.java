package io.github.dawithw.attendancetracker.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
    
    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    } 

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "Person:" + 
                "\t" + firstName +
                "\t" + lastName +
                "\t" + email;
    }
}
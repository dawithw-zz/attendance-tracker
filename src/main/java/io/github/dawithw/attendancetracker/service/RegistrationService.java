package io.github.dawithw.attendancetracker.service;

import org.springframework.stereotype.Service;

import io.github.dawithw.attendancetracker.domain.CourseOffering;
import io.github.dawithw.attendancetracker.domain.Faculty;
import io.github.dawithw.attendancetracker.domain.Student;

@Service
public class RegistrationService {

    public void enrollStudentInCourse(Student student, CourseOffering courseOffering) {
        //courseOffering.addStudent(student);
        student.attend(courseOffering);
    }

    public void assignTeacherForCourse(Faculty faculty, CourseOffering courseOffering) {
        faculty.teach(courseOffering);
        //courseOffering.setTeacher(faculty);
    }

}
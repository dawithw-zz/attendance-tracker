package io.github.dawithw.attendancetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.dawithw.attendancetracker.domain.Student;
import io.github.dawithw.attendancetracker.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired StudentRepository studentRepository;

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }
}
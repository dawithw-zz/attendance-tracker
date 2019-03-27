package io.github.dawithw.attendancetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.dawithw.attendancetracker.domain.Faculty;
import io.github.dawithw.attendancetracker.repository.FacultyRepository;

@Service
public class FacultyService {

    @Autowired FacultyRepository facultyRepository;

    public void save(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public List<Faculty> getAll() {
        List<Faculty> faculties = new ArrayList<>();
        facultyRepository.findAll().forEach(faculties::add);
        return faculties;
    }
}
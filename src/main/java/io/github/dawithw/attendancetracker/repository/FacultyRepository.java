package io.github.dawithw.attendancetracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.dawithw.attendancetracker.domain.Faculty;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, String> {
    
}
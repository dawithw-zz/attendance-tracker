package io.github.dawithw.attendancetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.dawithw.attendancetracker.domain.Person;
import io.github.dawithw.attendancetracker.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired PersonRepository personRepository;

    public void save(Person person) {
        personRepository.save(person);
    }

    public List<Person> getAll() {
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(people::add);
        return people;
    }
}
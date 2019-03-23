package io.github.dawithw.attendancetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.dawithw.attendancetracker.domain.Course;
import io.github.dawithw.attendancetracker.domain.CourseOffering;
import io.github.dawithw.attendancetracker.domain.Faculty;
import io.github.dawithw.attendancetracker.domain.Person;
import io.github.dawithw.attendancetracker.domain.Student;
import io.github.dawithw.attendancetracker.service.PersonService;


@Controller
public class MainController {

    @Autowired PersonService personService;
    
    @GetMapping(value="/")
    public String getMethodName(Model model) {
        Person p = new Person();
        p.setId("12345");
        p.setFirstName("Dawit");
        p.setLastName("Habte");
        p.setEmail("dawithw@gmail.com");

        Faculty faculty = new Faculty();
        faculty.setId("105200");
        faculty.setFirstName("Tina");
        faculty.setLastName("Xing");
        faculty.setEmail("rxing@mum.edu");

        Student student = new Student();
        student.setId("986654");
        student.setFirstName("Festus");
        student.setLastName("Iipito");
        student.setEmail("fiipito@mum.edu");

        //model.addAttribute("person", p);
        personService.save(p);
        personService.save(faculty);
        personService.save(student);
        model.addAttribute("people", personService.getAll());
        return "home";
    }
    
}
package io.github.dawithw.attendancetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.dawithw.attendancetracker.domain.Course;
import io.github.dawithw.attendancetracker.domain.CourseOffering;
import io.github.dawithw.attendancetracker.domain.Faculty;
import io.github.dawithw.attendancetracker.domain.Student;
import io.github.dawithw.attendancetracker.service.CourseOfferingService;
import io.github.dawithw.attendancetracker.service.CourseService;
import io.github.dawithw.attendancetracker.service.FacultyService;
import io.github.dawithw.attendancetracker.service.RegistrationService;
import io.github.dawithw.attendancetracker.service.StudentService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainController {

    @Autowired FacultyService facultyService;
    @Autowired StudentService studentService;
    @Autowired CourseService courseService;
    @Autowired CourseOfferingService courseOfferingService;
    @Autowired RegistrationService registrationService;
    
    @GetMapping(value="/")
    public String getHomePage(Model model) {
        return "home";
    }

    @GetMapping("/initialize")
    public String init(Model model) {
        System.out.println("initializing...");
        Faculty faculty = new Faculty();
        faculty.setId("105200");
        faculty.setFirstName("Tina");
        faculty.setLastName("Xing");
        faculty.setEmail("rxing@mum.edu");
        facultyService.save(faculty);

        Student student = new Student();
        student.setId("986654");
        student.setFirstName("Festus");
        student.setLastName("Iipito");
        student.setEmail("fiipito@mum.edu");
        studentService.save(student);

        Course course = new Course();
        course.setName("WAA");
        course.setCode("CS545");
        courseService.saveCourse(course);

        CourseOffering courseOffering = new CourseOffering();
        courseOffering.setCourse(course);
        courseOfferingService.saveCourseOffering(courseOffering);
        
        populateModel(model);
        model.addAttribute("result", "Initialized database");
        return "home";
    }

    @GetMapping("/assign_courses")
    public String assignCourses(Model model) {

        CourseOffering courseOffering = courseOfferingService.getAllCourseOfferings().get(0);
        Student student = studentService.getAll().get(0);
        Faculty faculty = facultyService.getAll().get(0);

        registrationService.assignTeacherForCourse(faculty, courseOffering);
        registrationService.enrollStudentInCourse(student, courseOffering);
        
        courseOfferingService.saveCourseOffering(courseOffering);

        populateModel(model);
        model.addAttribute("result","Assigned courses");
        return "home";
    }
    
    @GetMapping(value="/multiple_students")
    public String getMethodName(Model model) {

        Student student1 = new Student();
        student1.setId("986655");
        student1.setFirstName("Dawit");
        student1.setLastName("Habte");
        student1.setEmail("dhabte@mum.edu");
        studentService.save(student1);

        Student student2 = new Student();
        student2.setId("986656");
        student2.setFirstName("Bire");
        student2.setLastName("Girma");
        student2.setEmail("bgirma@mum.edu");
        studentService.save(student2);

        CourseOffering courseOffering = courseOfferingService.getAllCourseOfferings().get(0);

        registrationService.enrollStudentInCourse(student1, courseOffering);
        registrationService.enrollStudentInCourse(student2, courseOffering);

        studentService.save(student1);
        studentService.save(student2);

        populateModel(model);
        model.addAttribute("result", "Multiple Students added");
        return "home";
    }
    
    public void populateModel(Model model) {
        model.addAttribute("faculties", facultyService.getAll());
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("courses", courseOfferingService.getAllCourseOfferings());
    }
}
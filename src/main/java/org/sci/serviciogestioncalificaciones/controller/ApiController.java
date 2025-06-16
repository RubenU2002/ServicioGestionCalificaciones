package org.sci.serviciogestioncalificaciones.controller;

import java.util.List;

import org.sci.serviciogestioncalificaciones.model.Course;
import org.sci.serviciogestioncalificaciones.model.Enrollment;
import org.sci.serviciogestioncalificaciones.model.Student;
import org.sci.serviciogestioncalificaciones.service.CourseService;
import org.sci.serviciogestioncalificaciones.service.EnrollmentService;
import org.sci.serviciogestioncalificaciones.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    public ApiController(StudentService studentService, CourseService courseService, EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.findAll();
    }

    @PostMapping("/enrollments")
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.save(enrollment);
    }

    @GetMapping("/courses/{id}/enrollments")
    public List<Enrollment> getEnrollmentsByCourse(@PathVariable Long id) {
        return enrollmentService.findByCourseId(id);
    }
}

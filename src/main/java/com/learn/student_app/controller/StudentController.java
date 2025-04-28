package com.learn.student_app.controller;

import com.learn.student_app.model.Course;
import com.learn.student_app.model.Student;
import com.learn.student_app.service.CourseService;
import com.learn.student_app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private CourseService courseService;

    @GetMapping("/viewStudents")
    public List<Student> viewAllStudents(){
        return service.viewAllStudents();
    }

    @GetMapping("/viewStudent/{rollNo}")
    public Optional<Student> viewStudent(@PathVariable int rollNo){
        return service.findStudent(rollNo);
    }

    @PostMapping("/Student")
    public Optional<Student> addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @DeleteMapping("/Student/{rollNo}")
    public void deleteStudent(@PathVariable int rollNo){
        service.deleteStudent(rollNo);
    }

    @PutMapping("/{rollNo}enroll/{courseID}")
    public Student enrollStudentInCourse(@PathVariable int rollNo, @PathVariable int courseId){
        Optional<Student> student = service.findStudent(rollNo);
        Optional<Course> course = courseService.findCourseById(courseId);

        if (student.isPresent() && course.isPresent()) {
            student.get().getCoursesEnrolled().add(course.get());
            return service.addStudent(student.get()).orElse(null);
        }
        throw new RuntimeException("Student or Course not found!");
    }

}

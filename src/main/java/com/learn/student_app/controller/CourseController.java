package com.learn.student_app.controller;

import com.learn.student_app.model.Course;
import com.learn.student_app.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.OptionPaneUI;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/viewCourses")
    public List<Course> viewAllCourses(){
        return service.findCourses();
    }

    @GetMapping("/viewCourse/{courseId}")
    public Optional<Course> viewAllCourses(int courseID){
        return service.findCourseById(courseID);
    }

    @PostMapping("/addCourse")
    public Optional<Course> addCourse(@RequestBody Course course){
        service.addCourse(course);
        return service.findCourseById(course.getCourseId());
    }

    @DeleteMapping("/deleteCourse/{rollNo}")
    public void deleteCourse(@PathVariable int rollNo){
        service.deleteCourse(rollNo);
    }



}

package com.learn.student_app.service;

import com.learn.student_app.model.Course;
import com.learn.student_app.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public List<Course> findCourses(){
        return repo.findAll();
    }

    public Optional<Course> findCourseById(int courseID){
        return repo.findById(courseID);
    }

    public Optional<Course> addCourse(Course course){
        repo.save(course);
        return repo.findById(course.getCourseId());
    }

    public void deleteCourse(int courseId){
        repo.deleteById(courseId);
    }
}

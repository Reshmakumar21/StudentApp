package com.learn.student_app.service;

import com.learn.student_app.model.Student;
import com.learn.student_app.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> viewAllStudents() {
       return repo.findAll();
    }

    public Optional<Student> addStudent(Student student){
        repo.save(student);
        return repo.findById(student.getRollNo());
    }

    public Optional<Student> findStudent(int rollNo) {
        return repo.findById(rollNo);
    }

    public Student deleteStudent(int rollNo){
        repo.deleteById(rollNo);
        return repo.findById(rollNo).orElse(null);
    }
}

package com.example.studentManagementSystem.service.impl;

import java.util.List;

import com.example.studentManagementSystem.model.Student;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(long id);
    Student updateStudent(Student student,long id);
    void deleteStudent(long id);
    List<Student> getStudentByEnrollmentYear(int year);
    
}

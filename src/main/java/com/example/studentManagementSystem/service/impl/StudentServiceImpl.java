package com.example.studentManagementSystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentManagementSystem.model.Student;
import com.example.studentManagementSystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
 //get all employee form database
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
 //get employee using id
    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }
 //update employee
    @Override
    public Student updateStudent(Student student, long id) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public void deleteStudent (long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentByEnrollmentYear(int year) {
        return studentRepository.findByEnrollmentYear(year);
    }

    public String getStudentDepartmentById(String studentId) {
        Student student = (Student) studentRepository.findAll();
        return student != null ? student.getDepartment() : null;
    }

    public void deleteAllStudentsByEnrollmentYear(int year) {
        studentRepository.findByEnrollmentYear(year);
    }
    
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

}

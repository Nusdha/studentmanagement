package com.example.studentManagementSystem.service.impl;

import java.util.List;

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
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }
 //update employee
    @Override
    public Student updateStudent(Student student, long id) {
        Student exitingStudent = getStudentById(id);
        exitingStudent.setFirstName(student.getFirstName());
        exitingStudent.setLastName(student.getLastName());
        exitingStudent.setEmail(student.getEmail());
        exitingStudent.setDepartment(student.getDepartment());
        exitingStudent.setYearOfEnrollment(student.getYearOfEnrollment());
        return studentRepository.save(exitingStudent);
    }

    @Override
    public void deleteStudent (long id) {
        studentRepository.deleteById(id);
    }
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

}

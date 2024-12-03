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
 //save employee in database
 @Override
 public Student saveStudent(Student student){
    
 return studentRepository.save(student);
 }
 //get all employee form database
 @Override
 public List<Student> getAllStudent() {
 return studentRepository.findAll();
 }
 //get employee using id
 @Override
 public Student getStudentById(long id) {
 java.util.Optional<Student> student = studentRepository.findById(id);
 if(student.isPresent()){
 return student.get();
 }else {
 throw new RuntimeException();
 }
 }
 //update employee
 @Override
 public Student updateStudent(Student student, long id) {
 Student existingStudent = studentRepository.findById(id).orElseThrow(()-> new RuntimeException());
 existingStudent.setFirstName(student.getFirstName());
 existingStudent.setLastName(student.getLastName());
 existingStudent.setEmail(student.getEmail());
 // save
 studentRepository.save(existingStudent);
 return existingStudent;

}

@Override
public void deleteStudent (long id) {
    studentRepository.findById(id).orElseThrow (()->new RuntimeException());
    studentRepository.deleteById(id);
}

@Override
public List<Student> getStudentByEnrollmentYear(int year) {
    return studentRepository.findByEnrollmentYear(year);
}

public String getStudentDepartmentById(String studentId) {
    Student student = studentRepository.findByStudentId(studentId);
    return student != null ? student.getDepartment() : null;
}

public void deleteAllStudentsByEnrollmentYear(int year) {
    studentRepository.deleteByEnrollmentYear(year);
}

}

package com.example.studentManagementSystem.controller;

import com.example.studentManagementSystem.model.Student;
import com.example.studentManagementSystem.service.impl.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    public StudentController(){
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student),HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    //Get by Id Rest Api
    @GetMapping("/{id}")
    // localhost:8080/api/Student/1
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
    return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student student){
        return new ResponseEntity<>(studentService.updateStudent(student, id),HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
    //delete Student from db
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully",HttpStatus.OK);
    }
  
}

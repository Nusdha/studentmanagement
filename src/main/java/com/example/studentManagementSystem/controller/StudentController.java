package com.example.studentManagementSystem.controller;

import com.example.studentManagementSystem.model.Student;
import com.example.studentManagementSystem.service.impl.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    public StudentController(){
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
    Student createdStudent = this.studentService.createStudent(student);
    return ResponseEntity.ok(createdStudent);
    }
    //GetAll Rest Api
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> student = this.studentService.getAllStudent();
        return ResponseEntity.ok(student);
    }
    //Get by Id Rest Api
    @GetMapping("/{id}")
    // localhost:8080/api/Student/1
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
    Student student = this.studentService.getStudentById(id);
    return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }
    //Update Rest Api
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student student){
        Student updatedStudent = this.studentService.updateStudent(student, id);
        return updatedStudent != null ? ResponseEntity.ok(updatedStudent) : ResponseEntity.notFound().build();
    }
    //Delete Rest Api
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id){
    //delete Student from db
        this.studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/students/year/{year}")
    public List<Student> getStudentsByYear(@PathVariable int year) {
        return studentService.getStudentByEnrollmentYear(year);
    }
    
}

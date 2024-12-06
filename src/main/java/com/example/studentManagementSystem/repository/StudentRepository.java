package com.example.studentManagementSystem.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.studentManagementSystem.model.Student;

public interface StudentRepository  extends MongoRepository<Student, Long> {

    List<Student> findByEnrollmentYear(int year);

}

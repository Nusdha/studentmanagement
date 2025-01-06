package com.example.studentManagementSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.studentManagementSystem.model.Student;

public interface StudentRepository  extends MongoRepository<Student, Long> {


}

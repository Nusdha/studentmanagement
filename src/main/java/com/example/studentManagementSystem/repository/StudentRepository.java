package com.example.studentManagementSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.studentManagementSystem.model.Student;

public interface StudentRepository  extends MongoRepository<Student, Long> {

    @SuppressWarnings("unchecked")
    Student save(Student student);

    List<Student> findAll();

    Optional<Student> findById(long id);

    void deleteById(long id);
    
    @Query("{ 'enrollmentYear' : ?0 }")
    List<Student> findByEnrollmentYear(int year);

    Student findByStudentId(String studentId);

    @Query("{ 'enrollmentYear' : ?0 }")
    void deleteByEnrollmentYear(int year);

    

}

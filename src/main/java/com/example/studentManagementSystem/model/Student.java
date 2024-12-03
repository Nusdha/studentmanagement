package com.example.studentManagementSystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Student")
@Data

public class Student {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private int yearOfEnrollment;
}


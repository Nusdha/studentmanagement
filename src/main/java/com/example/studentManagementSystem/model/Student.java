package com.example.studentManagementSystem.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
@Data
@Builder
@Setter
@Getter
public class Student {
    
    @Setter
    @Getter
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private int yearOfEnrollment;
       
}


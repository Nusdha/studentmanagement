package com.example.studentManagementSystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
@Data

public class Student {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private int yearOfEnrollment;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getYear(int yearOfEnrollment) {
        return yearOfEnrollment;
    }
    public void setYear(int yearOfEnrollment) {
        this.yearOfEnrollment = yearOfEnrollment;
    }
       
}


package com.example.studentManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.studentManagementSystem.model.ERole;
import com.example.studentManagementSystem.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
   Optional<Role> findByName(ERole name);
}

package com.example.studentservice.repository;

import com.example.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByIndex(String index);

    boolean existsByIndex(String index);

    boolean existsByEmail(String email);
}

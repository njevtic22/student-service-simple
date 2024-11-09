package com.example.studentservice.service;

import com.example.studentservice.model.Student;

public interface StudentService extends CrudService<Student> {
    Student getByIndex(String index);

    boolean existsByIndex(String index);

    void validateIndex(String index);

    void validateEmail(String email);

    void validatePhone(String phone);
}

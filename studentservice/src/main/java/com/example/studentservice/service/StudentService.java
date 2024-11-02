package com.example.studentservice.service;

import com.example.studentservice.model.Student;

public interface StudentService extends CrudService<Student> {
    boolean existsByIndex(String index);
}

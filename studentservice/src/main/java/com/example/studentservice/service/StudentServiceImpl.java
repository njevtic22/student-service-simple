package com.example.studentservice.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public List<String> getAll() {
        return List.of("Elem 1", "Elem 2", "Elem 3", "Elem 4", "Elem 5", "Elem 6", "Elem 7", "Elem 8", "Elem 9", "Elem 10");
    }
}

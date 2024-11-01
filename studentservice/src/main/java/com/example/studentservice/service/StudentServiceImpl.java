package com.example.studentservice.service;

import com.example.studentservice.model.Student;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }


    @Override
    public Student add(Student newT) {
        return null;
    }

    @Override
    public Slice<Student> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Student getById(Long id) {
        return null;
    }

    @Override
    public Student update(String identification, Student changes) {
        return null;
    }

    @Override
    public void delete(String identification) {

    }
}

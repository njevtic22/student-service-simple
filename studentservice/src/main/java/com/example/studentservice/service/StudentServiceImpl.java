package com.example.studentservice.service;

import com.example.studentservice.core.error.EntityNotFoundException;
import com.example.studentservice.core.error.UniquePropertyException;
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
    public Student update(String index, Student changes) {
        Student existing = getByIndex(index);

        Student updated = new Student(
                existing.getId(),
                changes.getName(),
                changes.getSurname(),
                changes.getIndex(),
                changes.getBirthDate(),
                changes.getAddress(),
                changes.getPhone(),
                changes.getEmail(),
                existing.getYearOfStudies()
        );
        return repository.save(updated);
    }

    @Override
    public void delete(String identification) {

    }

    @Override
    public Student getByIndex(String index) {
        return repository.findByIndex(index)
                .orElseThrow(() -> new EntityNotFoundException("Student", "index", index));
    }

    @Override
    public boolean existsByIndex(String index) {
        return repository.existsByIndex(index);
    }

    @Override
    public void validateIndex(String index) {
        if (existsByIndex(index)) {
            throw new UniquePropertyException("Student", "index", index);
        }
    }

    @Override
    public void validateEmail(String email) {
        if (!email.matches(".+@.+\\..+")) {
            throw new IllegalArgumentException("Email is not properly formed");
        }

        if (repository.existsByEmail(email)) {
            throw new UniquePropertyException("Student", "email", email);
        }
    }
}

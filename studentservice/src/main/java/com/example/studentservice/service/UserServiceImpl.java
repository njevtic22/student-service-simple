package com.example.studentservice.service;

import com.example.studentservice.core.error.EntityNotFoundException;
import com.example.studentservice.model.User;
import com.example.studentservice.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User add(User newT) {
        return null;
    }

    @Override
    public Slice<User> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public User getById(Long id) {
        Objects.requireNonNull(id, "Id must not be null");
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User", id));
    }

    @Override
    public User update(Long id, User changes) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User getByUsername(String username) {
        Objects.requireNonNull(username);
        return repository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User", "username", username));
    }
}

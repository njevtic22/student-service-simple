package com.example.studentservice.service;

import com.example.studentservice.model.User;
import com.example.studentservice.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

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
        // TODO: Throw exception when user not found
        return repository.findById(id).orElseThrow();
    }

    @Override
    public User update(Long id, User changes) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

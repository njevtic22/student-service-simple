package com.example.studentservice.service;

import com.example.studentservice.core.error.EntityNotFoundException;
import com.example.studentservice.core.error.UniquePropertyException;
import com.example.studentservice.model.User;
import com.example.studentservice.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public User add(User newUser) {
//        Validation called outside of service
//        validateUsername(newUser.getUsername());

        User toAdd = new User(
                newUser.getName(),
                newUser.getSurname(),
                newUser.getUsername(),
                encoder.encode(newUser.getPassword()),
                newUser.getRole()
        );
        return repository.save(toAdd);
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

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword, String repeatedPassword) {

    }
    @Override
    public void validateUsername(String username) {
        // TODO: add no whitespace check
        if (existsByUsername(username)) {
            throw new UniquePropertyException("Username '" + username + "' is already taken.");
        }
    }

    private void validatePasswordMatch(User existingUser, String oldPassword, String newPassword, String repeatedPassword) {

    }
}

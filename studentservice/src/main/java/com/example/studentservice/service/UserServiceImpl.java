package com.example.studentservice.service;

import com.example.studentservice.core.error.EntityNotFoundException;
import com.example.studentservice.core.error.InvalidPasswordException;
import com.example.studentservice.core.error.MultipleDeletedRowsException;
import com.example.studentservice.core.error.UniquePropertyException;
import com.example.studentservice.model.Role;
import com.example.studentservice.model.User;
import com.example.studentservice.repository.UserRepository;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordValidator validator;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository, PasswordValidator validator, PasswordEncoder encoder) {
        this.repository = repository;
        this.validator = validator;
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
    public Slice<User> getAll(Map<String, String> filter, Pageable pageable) {
        return getAll(pageable);
    }

    @Override
    public User getById(Long id) {
        Objects.requireNonNull(id, "Id must not be null");
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User", id));
    }

    @Override
    public User update(String existingUsername, User changes) {
        Objects.requireNonNull(changes, "User changes must not be null");

        User existing = getByUsername(existingUsername);
        User updated = new User(
                existing.getId(),
                changes.getName(),
                changes.getSurname(),
                changes.getUsername(),
                existing.getPassword(),
                existing.getRole()
        );
        return repository.save(updated);
    }

    @Override
    @Transactional
    public void delete(String username) {
        if (!repository.existsByUsername(username)) {
            throw new EntityNotFoundException("User", "username", username);
        }

        int rowsAffected = repository.deleteByUsername(username);
        if (rowsAffected != 1) {
            throw new MultipleDeletedRowsException("users", "username");
        }
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
    public boolean existsByUsernameAndRole(String username, Role role) {
        return repository.existsByUsernameAndRole(username, role);
    }

    @Override
    @Transactional
    public void changePassword(String username, String newPassword) {

        int rowsAffected = repository.updatePasswordByUsername(username, encoder.encode(newPassword));
        if (rowsAffected != 1) {
            throw new RuntimeException("Zero or more than one rows in users table is affected by updatePasswordById operation.");
        }
    }
    @Override
    public void validateUsername(String username) {
        if (username.matches("(.*?)\\s(.*?)")) {
            throw new IllegalArgumentException("Username can not contain any space");
        }

        if (existsByUsername(username)) {
            throw new UniquePropertyException("Username '" + username + "' is already taken.");
        }
    }

    @Override
    public void validatePassword(String password) {
        if (password == null) {
            throw new InvalidPasswordException(List.of("Password must not be null"));
        }

        RuleResult result = validator.validate(new PasswordData(password));
        if (!result.isValid()) {
            throw new InvalidPasswordException(validator.getMessages(result));
        }
    }

    @Override
    public void validatePasswordMatch(String userEncodedPassword, String oldPassword, String newPassword, String repeatedPassword) {
        if (!encoder.matches(oldPassword, userEncodedPassword)) {
            throw new InvalidPasswordException("Incorrect password.");
        }

        if (!newPassword.equals(repeatedPassword)) {
            throw new InvalidPasswordException("New password and repeated password do not match.");
        }
    }
}

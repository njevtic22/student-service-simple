package com.example.studentservice.service;

import com.example.studentservice.model.Role;
import com.example.studentservice.model.User;

public interface UserService extends CrudService<User> {
    User getByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByUsernameAndRole(String username, Role role);

    void validateUsername(String username);

    void validatePassword(String password);

    void validatePasswordMatch(String userEncodedPassword, String oldPassword, String newPassword, String repeatedPassword);

    void changePassword(String username, String newPassword);
}

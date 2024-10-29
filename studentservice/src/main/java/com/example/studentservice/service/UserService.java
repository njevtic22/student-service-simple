package com.example.studentservice.service;

import com.example.studentservice.model.User;

public interface UserService extends CrudService<User> {
    User getByUsername(String username);

    boolean existsByUsername(String username);

    void validateUsername(String username);

    void changePassword(/* Long userId,*/ String oldPassword, String newPassword, String repeatedPassword);
}

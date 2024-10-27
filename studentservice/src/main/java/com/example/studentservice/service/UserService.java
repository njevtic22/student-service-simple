package com.example.studentservice.service;

import com.example.studentservice.model.User;

public interface UserService extends CrudService<User> {
    User getByUsername(String username);
}

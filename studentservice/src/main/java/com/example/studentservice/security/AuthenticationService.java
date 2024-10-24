package com.example.studentservice.security;

import com.example.studentservice.model.User;

public interface AuthenticationService {
    User authenticate(String username, String password);

    void invalidateAuthentication();
    User getAuthenticated();
}

package com.example.studentservice.security;

import com.example.studentservice.model.User;
import com.example.studentservice.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class SimpleAuthenticationService implements AuthenticationService {
    private final UserService service;
    private User authenticated;

    public SimpleAuthenticationService(UserService service) {
        this.service = service;
    }

    @Override
    public User authenticate(String username, String password) {
        // TODO: Implement getByUsername
        authenticated = service.getById(1L);
        return authenticated;
    }

    @Override
    public void invalidateAuthentication() {
        authenticated = null;
    }

    @Override
    public User getAuthenticated() {
        return authenticated;
    }
}

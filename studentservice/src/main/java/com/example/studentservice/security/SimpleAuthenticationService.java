package com.example.studentservice.security;

import com.example.studentservice.core.error.BadCredentialsException;
import com.example.studentservice.core.error.EntityNotFoundException;
import com.example.studentservice.model.User;
import com.example.studentservice.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SimpleAuthenticationService implements AuthenticationService {
    private final UserService service;
    private final PasswordEncoder encoder;
    private User authenticated;

    public SimpleAuthenticationService(UserService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    @Override
    public User authenticate(String username, String password) {
        User tmp = getByUsername(username);
        validatePassword(password, tmp.getPassword());

        authenticated = tmp;
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

    private void validatePassword(String rawPassword, String encodedPassword) {
        if (!encoder.matches(rawPassword, encodedPassword)) {
            throw new BadCredentialsException("Invalid password");
        }
    }

    private User getByUsername(String username) {
        try {
            return service.getByUsername(username);
        } catch (EntityNotFoundException e) {
            throw new BadCredentialsException("Invalid username");
        }
    }
}

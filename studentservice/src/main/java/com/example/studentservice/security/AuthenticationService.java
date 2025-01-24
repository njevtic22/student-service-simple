package com.example.studentservice.security;

import com.example.studentservice.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    UserDetails authenticate(String username, String password);

    UserDetails reauthenticate(User changes);

    void invalidateAuthentication();

    UserDetails getAuthenticated();
}

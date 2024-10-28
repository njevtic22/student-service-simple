package com.example.studentservice.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    UserDetails authenticate(String username, String password);

    void invalidateAuthentication();
    UserDetails getAuthenticated();
}

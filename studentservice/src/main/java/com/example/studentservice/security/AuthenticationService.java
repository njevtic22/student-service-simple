package com.example.studentservice.security;

import com.example.studentservice.model.Referent;

public interface AuthenticationService {
    Referent authenticate(String username, String password);

    void invalidateAuthentication();
    Referent getAuthenticated();
}

package com.example.studentservice.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SimpleAuthenticationService implements AuthenticationService {
    private final AuthenticationManager authManager;

    public SimpleAuthenticationService(AuthenticationManager authManager) {
        this.authManager = authManager;
    }


    @Override
    public UserDetails authenticate(String username, String password) {
        Authentication userAuth = authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(userAuth);
        return getPrincipal(userAuth);
    }

    @Override
    public void invalidateAuthentication() {
        SecurityContextHolder.clearContext();
    }

    @Override
    public UserDetails getAuthenticated() {
        Authentication userAuth = SecurityContextHolder.getContext().getAuthentication();
        return getPrincipal(userAuth);
    }

    private UserDetails getPrincipal(Authentication authentication) {
        return (UserDetails) authentication.getPrincipal();
//        return userService.getByUsername(principal.getUsername());
    }
}

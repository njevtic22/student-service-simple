package com.example.studentservice.security;

import com.example.studentservice.core.error.EntityNotFoundException;
import com.example.studentservice.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return userService.getByUsername(username);
        } catch (EntityNotFoundException e) {
            throw new UsernameNotFoundException("Invalid username");
        }
    }
}

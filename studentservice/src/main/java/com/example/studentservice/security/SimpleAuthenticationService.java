package com.example.studentservice.security;

import com.example.studentservice.model.Referent;
import com.example.studentservice.service.ReferentService;
import org.springframework.stereotype.Service;

@Service
public class SimpleAuthenticationService implements AuthenticationService {
    private final ReferentService service;
    private Referent authenticated;

    public SimpleAuthenticationService(ReferentService service) {
        this.service = service;
    }

    @Override
    public Referent authenticate(String username, String password) {
        // TODO: Implement getByUsername
        authenticated = service.getById(1L);
        return authenticated;
    }

    @Override
    public void invalidateAuthentication() {
        authenticated = null;
    }

    @Override
    public Referent getAuthenticated() {
        return authenticated;
    }
}

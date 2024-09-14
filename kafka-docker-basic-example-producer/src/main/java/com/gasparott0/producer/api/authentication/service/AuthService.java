package com.gasparott0.producer.api.authentication.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthService {

    private final JwtService jwtService;

    public String getToken(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }
}

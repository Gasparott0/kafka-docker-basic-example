package com.gasparott0.producer.api.authentication.service;

import com.gasparott0.producer.api.authentication.record.AuthRequestRecord;
import com.gasparott0.producer.api.authentication.record.AuthResponseRecord;
import com.gasparott0.producer.domain.model.User;
import com.gasparott0.producer.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthResponseRecord getToken(AuthRequestRecord authentication) {
        User user = userRepository.findByUsername(authentication.username()).orElseThrow(() -> new BadCredentialsException("user or password is invalid"));
        if(!user.isLoginCorrect(authentication, passwordEncoder)) {
            throw new BadCredentialsException("user or password is invalid");
        }
        long expireIn = 36000L;
        String token = jwtService.generateToken(user, expireIn);
        return new AuthResponseRecord(token, expireIn);
    }
}

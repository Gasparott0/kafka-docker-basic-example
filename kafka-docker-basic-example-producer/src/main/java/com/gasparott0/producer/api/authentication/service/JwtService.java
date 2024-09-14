package com.gasparott0.producer.api.authentication.service;

import com.gasparott0.producer.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@AllArgsConstructor
@Service
public class JwtService {

    private final JwtEncoder jwtEncoder;

    public String generateToken(User authentication, long expiry) {
        Instant now = Instant.now();

        var claims = JwtClaimsSet.builder()
                .issuer("kafka-docker-basic-example-producer")
                .subject(authentication.getUsername())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}

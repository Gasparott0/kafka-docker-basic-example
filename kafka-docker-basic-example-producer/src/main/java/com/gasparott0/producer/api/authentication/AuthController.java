package com.gasparott0.producer.api.authentication;

import com.gasparott0.producer.api.authentication.record.AuthRequestRecord;
import com.gasparott0.producer.api.authentication.record.AuthResponseRecord;
import com.gasparott0.producer.api.authentication.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping
    private ResponseEntity<AuthResponseRecord> auth(@RequestBody AuthRequestRecord authentication) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.getToken(authentication));
    }
}

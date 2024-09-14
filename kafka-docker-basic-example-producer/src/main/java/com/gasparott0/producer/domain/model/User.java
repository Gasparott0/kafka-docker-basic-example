package com.gasparott0.producer.domain.model;

import com.gasparott0.producer.api.authentication.record.AuthRequestRecord;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;

    public boolean isLoginCorrect(AuthRequestRecord authentication, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(authentication.password(), this.password);
    }
}

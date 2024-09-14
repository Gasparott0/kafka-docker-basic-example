package com.gasparott0.producer.api.authentication.config;

import com.gasparott0.producer.domain.model.User;
import com.gasparott0.producer.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@AllArgsConstructor
@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Optional<User> userOptional = userRepository.findByUsername("admin");
        userOptional.ifPresentOrElse(user -> {
            System.out.println("Já existe admin");
        }, () -> {
            User user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("password"));
            userRepository.save(user);
        });
    }
}

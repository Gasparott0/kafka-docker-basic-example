package com.gasparott0.producer.api.hero;

import com.gasparott0.producer.api.hero.record.HeroRequestRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hero")
public class HeroController {

    @PostMapping("/save")
    public ResponseEntity<Void> createHero(@RequestBody HeroRequestRecord heroRequestRecord) {
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}

package com.gasparott0.producer.api.hero;

import com.gasparott0.producer.api.hero.record.HeroRequestRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hero")
@RequiredArgsConstructor
public class HeroController {

    private final KafkaTemplate<Object, Object> template;
    @Value("${topics.hero.request.topic}")
    private String heroRequestTopic;

    @PostMapping("/send/save")
    public ResponseEntity<Void> createHero(@RequestBody HeroRequestRecord heroRequestRecord) {
        this.template.send(heroRequestTopic, heroRequestRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}

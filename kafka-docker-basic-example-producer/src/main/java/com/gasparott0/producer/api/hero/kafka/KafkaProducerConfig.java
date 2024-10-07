package com.gasparott0.producer.api.hero.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class KafkaProducerConfig {

    private final KafkaProperties kafkaProperties;
    @Value("${topics.hero.request.topic}")
    private String heroRequestTopic;

    @Bean
    public NewTopic topic() {
        return new NewTopic(heroRequestTopic, 1, (short) 1);
    }

}

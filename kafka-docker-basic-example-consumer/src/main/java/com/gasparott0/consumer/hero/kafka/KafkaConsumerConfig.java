package com.gasparott0.consumer.hero.kafka;

import com.gasparott0.consumer.domain.model.Hero;
import com.gasparott0.consumer.hero.record.HeroRequestRecord;
import com.gasparott0.consumer.hero.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaConsumerConfig {

    @Autowired
    private HeroService heroService;

    @Bean
    public CommonErrorHandler errorHandler(KafkaOperations<Object, Object> template) {
        return new DefaultErrorHandler(
                new DeadLetterPublishingRecoverer(template), new FixedBackOff(1000L, 2));
    }

    @Bean
    public RecordMessageConverter converter() {
        return new JsonMessageConverter();
    }

    @KafkaListener(id = "heroGroup", topics = "hero.request.topic.v1")
    public void listen(HeroRequestRecord in) {
        System.out.println(in);
        Hero hero = new Hero();
        hero.setAge(in.age());
        hero.setName(in.name());
        hero.setSex(String.valueOf(in.heroSex()));
        hero.setSuperPower(in.superPower());
        heroService.createHero(hero);
    }
}

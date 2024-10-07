package com.gasparott0.consumer.hero.service;

import com.gasparott0.consumer.domain.model.Hero;
import com.gasparott0.consumer.domain.repository.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeroService {

    private final HeroRepository heroRepository;

    public Long createHero(Hero hero) {

        Hero saved = heroRepository.save(hero);
        return saved.getId();
    }
}

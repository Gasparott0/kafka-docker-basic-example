package com.gasparott0.consumer.domain.repository;

import com.gasparott0.consumer.domain.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}

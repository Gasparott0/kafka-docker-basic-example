package com.gasparott0.producer.api.hero.record;

import com.gasparott0.producer.api.hero.constants.HeroSex;

public record HeroRequestRecord(String name, String superPower, int age, HeroSex heroSex) {
}

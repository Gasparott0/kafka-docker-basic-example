package com.gasparott0.consumer.hero.record;

import com.gasparott0.consumer.hero.constants.HeroSex;

public record HeroRequestRecord(String name, String superPower, int age, HeroSex heroSex) {
}

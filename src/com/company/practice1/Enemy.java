package com.company.practice1;

import java.util.Random;

public class Enemy {
    private final String name;
    private int hp;
    private int attackPower;
    private int protectionLevel;

    public Enemy() {
        // Доступные названия противников
        String[] possibleNames = {
                "Краск", "Мев", "Шаута", "Зед",
                "Пура", "Скамос", "Моргран", "Рунефисс"};
        Random random = new Random();
        name = possibleNames[random.nextInt(possibleNames.length)];
        hp = random.nextInt(50) + 50;
        attackPower = random.nextInt(25);
        protectionLevel = random.nextInt(25);
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getProtectionLevel() {
        return protectionLevel;
    }
}

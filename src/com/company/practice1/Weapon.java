package com.company.practice1;

import java.util.Random;

public class Weapon {
    private final String name;
    private int attackPower;
    private int price;
    private int requiredLevel;

    public Weapon(){
        // Доступные названия оружий
        String[] possibleNames = {
                "Аскалон", "Иштен Кардъя", "Азот", "Дамоклов меч",
                "Бжейкуа-Бжашла", "Меч-кладенец", "Фэнэс", "Финист"};
        Random random = new Random();
        name = possibleNames[random.nextInt(possibleNames.length)];
        attackPower = random.nextInt(25);
        price = random.nextInt(500) + 100;
        requiredLevel = random.nextInt(100);

    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getPrice() {
        return price;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }
}

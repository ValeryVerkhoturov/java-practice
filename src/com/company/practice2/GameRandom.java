package com.company.practice2;

import java.util.Random;

public class GameRandom {
    private static final Random random = new Random();

    public static String createWeaponName(){
        String[] possibleNames = {
                "Аскалон", "Иштен Кардъя", "Азот", "Дамоклов меч",
                "Бжейкуа-Бжашла", "Меч-кладенец", "Фэнэс", "Финист"};
        return possibleNames[random.nextInt(possibleNames.length)];
    }

    public static int createPrice(){
        return random.nextInt(500);
    }

    public static int createAttackPower(){
        return random.nextInt(50);
    }

    public static int createProtectionLevel(){
        return random.nextInt(25);
    }

    public static String createCharacterName(){
        String[] possibleNames = {
                "Захар", "Дмитрий", "Тимофей", "Лев", "Роман",
                "Максим", "Георгий", "Руслан", "Артём", "Александр"};
        return possibleNames[random.nextInt(possibleNames.length)];
    }

    public static int createHp(){
        return random.nextInt(50) + 50;
    }

    public static int createXp(){
        return random.nextInt(10000);
    }

    public static int createLevel(){
        return random.nextInt(100);
    }

    public static String createEnemyName(){
        String[] possibleNames = {
                "Краск", "Мев", "Шаута", "Зед",
                "Пура", "Скамос", "Моргран", "Рунефисс"};
        return possibleNames[random.nextInt(possibleNames.length)];
    }

    public static int createRequiredLevel() {
        return createLevel();
    }

}

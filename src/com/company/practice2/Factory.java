package com.company.practice2;

import java.util.Random;

public class Factory {
    public static Weapon createDefaultWeapon(){
        return new Weapon("Unnamed weapon", 0, 0, 0);
    }
    public static Weapon createRandomWeapon(){
        String[] possibleNames = {
                "Аскалон", "Иштен Кардъя", "Азот", "Дамоклов меч",
                "Бжейкуа-Бжашла", "Меч-кладенец", "Фэнэс", "Финист"};
        Random random = new Random();
        String name = possibleNames[random.nextInt(possibleNames.length)];
        int attackPower = random.nextInt(25);
        int price = random.nextInt(500) + 100;
        int requiredLevel = random.nextInt(100);
        return new Weapon(name, price, attackPower, requiredLevel);
    }

    public static Character createDefaulyCharacter(){
        return new Character("Unnamed character", 100, 0, 0, 0, 0, createDefaultWeapon());
    }
    public static Character createRandomCharacter(){
        String[] possibleNames = {
                "Захар", "Дмитрий", "Тимофей", "Лев", "Роман",
                "Максим", "Георгий", "Руслан", "Артём", "Александр"};
        Random random = new Random();
        String name = possibleNames[random.nextInt(possibleNames.length)];
        int hp = random.nextInt(50) + 50;
        int attackPower = random.nextInt(25);
        int protectionLevel = random.nextInt(10);
        int xp = random.nextInt(10000);
        int level = random.nextInt(100);
        return new Character(name, hp, attackPower, protectionLevel, xp, level, createRandomWeapon());
    }

    public static Enemy createDefaultEnemy(){
        return new Enemy("Unnamed enemy", 100, 0, 0, createDefaultWeapon());
    }
    public static Enemy createRandomEnemy(){
        String[] possibleNames = {
                "Краск", "Мев", "Шаута", "Зед",
                "Пура", "Скамос", "Моргран", "Рунефисс"};
        Random random = new Random();
        String name = possibleNames[random.nextInt(possibleNames.length)];
        int hp = random.nextInt(50) + 50;
        int attackPower = random.nextInt(25);
        int protectionLevel = random.nextInt(25);
        return new Enemy(name, hp, attackPower, protectionLevel, createRandomWeapon());
    }
}

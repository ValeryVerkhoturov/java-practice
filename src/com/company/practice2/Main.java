package com.company.practice2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Enemy> enemies = new ArrayList<>();
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            enemies.add(Factory.createRandomEnemy());
            characters.add(Factory.createRandomCharacter());
        }

        System.out.println("Противники:");
        for (var enemy: enemies){
            System.out.printf("Название: %s, очки здоровья: %s, сила атаки: %s, уровень защиты: %s\n",
                    enemy.getName(), enemy.getHp(), enemy.getAttackPower(), enemy.getProtectionLevel());
        }
        System.out.println();

    }
}

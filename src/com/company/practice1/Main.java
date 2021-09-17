package com.company.practice1;

import java.util.ArrayList;

public class Main {

    // Задание 3
    public static void main(String[] args) {
        ArrayList<Enemy> enemies = new ArrayList<>();
        ArrayList<Weapon> weapons = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            enemies.add(new Enemy());
            weapons.add(new Weapon());
        }
        System.out.println("Противники:");
        for (var enemy: enemies){
            System.out.printf("Название: %s, очки здоровья: %s, сила атаки: %s, уровень защиты: %s\n",
                    enemy.getName(), enemy.getHp(), enemy.getAttackPower(), enemy.getProtectionLevel());
        }
        System.out.println();
        System.out.println("Оружие:");
        for (var weapon: weapons){
            System.out.printf("Название: %s, сила атаки: %s, стоимость: %s, требуемый уровень для персонажа: %s\n",
                    weapon.getName(), weapon.getAttackPower(), weapon.getPrice(), weapon.getRequiredLevel());
        }
    }
}

package com.company.practice2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Enemy> enemies = new ArrayList<>();
        ArrayList<Character> characters = new ArrayList<>();
        int sumEnemiesDPS = 0, sumCharactersDPS = 0;
        int sumEnemiesHp = 0, sumCharactersHp = 0;
        for (int i = 0; i < 10; i++){
            Enemy enemy = Factory.createRandomEnemy();
            sumEnemiesDPS += GameLogic.countDPS(enemy.attack());
            sumEnemiesHp += enemy.getHp();
            enemies.add(enemy);
            Character character = Factory.createRandomCharacter();
            sumCharactersDPS += GameLogic.countDPS(character.attack());
            sumCharactersHp += character.getHp();
            characters.add(character);
        }
        int averageEnemiesDPS = sumEnemiesDPS / enemies.size();
        int averageCharactersDPS = sumCharactersDPS / characters.size();
        System.out.printf("Противники\tСуммарный DPS: %d\tСредний DPS: %d\tСуммарное HP: %d\n",
                sumEnemiesDPS, averageEnemiesDPS, sumEnemiesHp);
        System.out.printf("Персонажи\tСуммарный DPS: %d\tСредний DPS: %d\tСуммарное HP: %d\n",
                sumCharactersDPS, averageCharactersDPS, sumCharactersHp);
        System.out.println("________________");
    }

}

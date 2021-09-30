package com.company.practice2;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Enemy> enemies = new ArrayList<>();
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            enemies.add(Factory.createRandomEnemy());
            characters.add(Factory.createRandomCharacter());
        }

        // Общая статистика до боя
        int sumEnemiesDPS = enemies.stream().mapToInt(eneny -> GameLogic.countDPS(eneny.attack())).sum();
        double averageEnemiesDPS = enemies.stream().mapToInt(eneny -> GameLogic.countDPS(eneny.attack())).average().getAsDouble();
        int sumEnemiesHp = enemies.stream().mapToInt(Creature::getHp).sum();
        System.out.printf("Противники\tСуммарный DPS: %d\tСредний DPS: %.2f\tСуммарное HP: %d\n",
                sumEnemiesDPS, averageEnemiesDPS, sumEnemiesHp);
        int sumCharactersDPS = characters.stream().mapToInt(character -> GameLogic.countDPS(character.attack())).sum();
        double averageCharactersDPS = enemies.stream().mapToInt(character -> GameLogic.countDPS(character.attack())).average().getAsDouble();
        int sumCharactersHp = characters.stream().mapToInt(Creature::getHp).sum();
        System.out.printf("Персонажи\tСуммарный DPS: %d\tСредний DPS: %.2f\tСуммарное HP: %d\n",
                sumCharactersDPS, averageCharactersDPS, sumCharactersHp);
        System.out.println("________________");

        // Бой
        Predicate<Attacker> isAlive = ch -> ch.getHp() > 0;
        while(characters.stream().anyMatch(isAlive) && enemies.stream().anyMatch(isAlive)){
            // Рандомный персонаж isAlive
            Object[] charactersAlive = characters.stream().filter(isAlive).toArray();
            Character character = (Character) charactersAlive[random.nextInt(charactersAlive.length)];

            // Рандомный противник isAlive
            Object[] enemiesAlive = enemies.stream().filter(isAlive).toArray();
            Enemy enemy = (Enemy) enemiesAlive[random.nextInt(enemiesAlive.length)];

            switch (random.nextInt(2)) {
                case 0:
                    enemy.defend((character.attack()));
                    System.out.println("Противник атакован на " + character.attack() + " HP");
                    break;
                default:
                    character.defend(enemy.attack());
                    System.out.println("Персонаж атакован на " + enemy.attack() + " HP");
                    break;
            }
        }

        // После боя
        long survivedCharacters = characters.stream().filter(c -> c.getHp() > 0).count();
        long survivedEnemies = enemies.stream().filter(e -> e.getHp() > 0).count();
        System.out.println("_____________");
        System.out.printf("Выживших персонажей: %d, противников: %d\n", survivedCharacters, survivedEnemies);

    }

}

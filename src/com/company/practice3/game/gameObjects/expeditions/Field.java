package com.company.practice3.game.gameObjects.expeditions;

import com.company.practice3.game.gameObjects.GameObject;
import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.creatures.Creature;
import com.company.practice3.game.gameObjects.creatures.Mob;

import java.util.ArrayList;
import java.util.Random;

public class Field extends GameObject {
    private Creature[][] field;
    private int rows;
    private int cols;

    public Field(String name, int rows, int cols) {
        super(name);
        field = new Creature[rows][cols];
    }

    public void insertRandomly(ArrayList<Mob> mobs){
        for (Creature creature : mobs)
            insertRandomly(creature);
    }
    public void insertRandomly(Character character){
        insertRandomly((Creature) character);
    }
    public void insertRandomly(Creature creature){
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(field.length);
            col = random.nextInt(field[row].length);
        } while (field[row][col] != null);
        field[row][col] = creature;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("# ".repeat((field[0].length + 2)));
        for (Creature[] creatures : field) {
            stringBuilder.append("\n# ");
            for (Creature creature : creatures) {
                if (creature == null)
                    stringBuilder.append('_');
                else
                    stringBuilder.append(creature.viewOnMap());
                stringBuilder.append(" ");
            }
            stringBuilder.append("#");
        }
        stringBuilder.append("\n");
        stringBuilder.append("# ".repeat(field[0].length + 2));
        return stringBuilder.toString().replace("M", "\u001B[31mM\u001B[0m").replace("C", "\u001B[32mC\u001B[0m");
    }

}

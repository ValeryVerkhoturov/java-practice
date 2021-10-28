package com.company.practice3.game.objects.expeditions;

import com.company.practice3.game.objects.GameObject;
import com.company.practice3.game.objects.creatures.Character;
import com.company.practice3.game.objects.creatures.Creature;
import com.company.practice3.game.objects.creatures.Mob;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Random;

public class Field extends GameObject {

    @Getter private Creature[][] field;

    public Field(String name, int rows, int cols) throws Exception {
        super(name);
        if (rows <= 0 || cols <= 0)
            throw new Exception("Impossible field");
        field = new Creature[rows][cols];
    }

    public Creature getCreature(@NonNull Coordinates creatureCoords){
        return field[creatureCoords.getY()][creatureCoords.getX()];
    }

    public void removeCreature(Coordinates creatureCoords){
        field[creatureCoords.getY()][creatureCoords.getX()] = null;
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
        return stringBuilder.toString();
    }

    public void moveCell(Coordinates oldCoords, Coordinates newCoords){
        field[newCoords.getY()][newCoords.getX()] = field[oldCoords.getY()][oldCoords.getX()];
        field[oldCoords.getY()][oldCoords.getX()] = null;
    }

    public int getRows() {
        return getField().length;
    }

    public int getCols() {
        return  getField()[0].length;
    }
}

package com.company.practice3.game.gameObjects.expeditions;

import com.company.practice3.game.gameObjects.GameObject;
import com.company.practice3.game.gameObjects.creatures.Character;
import com.company.practice3.game.gameObjects.creatures.Creature;
import com.company.practice3.game.gameObjects.creatures.Mob;

import java.util.ArrayList;
import java.util.Random;

public class Field extends GameObject {
    private Creature[][] field;

    public Field(String name, int rows, int cols) throws Exception {
        super(name);
        if (rows <= 0 || cols <= 0)
            throw new Exception("Impossible field");
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
//        return stringBuilder.toString().replace("M", "\u001B[31mM\u001B[0m").replace("C", "\u001B[32mC\u001B[0m");
        return stringBuilder.toString();
    }

    public Creature[][] getField() {
        return field;
    }

    private void setField(Creature[][] field) {
        this.field = field;
    }

    public void setCell(Coordinates coordinates, Creature creature) throws Exception {
        if (field[coordinates.getY()][coordinates.getX()] != null)
            throw new Exception("Cell with " + coordinates + " is not empty");
        field[coordinates.getY()][coordinates.getX()] = creature;
    }

    public void moveCell(Coordinates oldCoords, Coordinates newCoords){
        Creature creature = field[oldCoords.getY()][oldCoords.getX()];
        field[oldCoords.getY()][oldCoords.getX()] = null;
        field[newCoords.getY()][newCoords.getX()] = creature;
    }
    public int getRows() {
        return getField().length;
    }

    public int getCols() {
        return  getField()[0].length;
    }
}

package com.company.practice3.game.gameObjects.expeditions;

import com.company.practice3.game.gameObjects.GameObject;

public class Field extends GameObject {
    private Character[][] field;
    private int rows;
    private int cols;

    public Field(String name, int rows, int cols) {
        super(name);
        field = new Character[rows][cols];
    }

    public Character[][] getField() {
        return field;
    }

    private void setField(Character[][] field) {
        this.field = field;
    }

    public void replaceCell(int row, int col, Character newChar){
        if (0 > row || row >= rows || 0 > col || col >= cols)
            return;
        field[row][col] = newChar;
    }
}

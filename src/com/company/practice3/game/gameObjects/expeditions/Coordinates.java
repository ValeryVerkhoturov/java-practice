package com.company.practice3.game.gameObjects.expeditions;

public class Coordinates {
    private int x;
    private int y;
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distanceTo(Coordinates coords){
        return Math.sqrt(Math.pow(coords.getX() - getX(), 2) + Math.pow(coords.getY() - getY(), 2));
    }

    @Override
    public String toString() {
        return "Coordinates = { x = "+ x + ", y = " + y + " }";
    }
}

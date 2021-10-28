package com.company.practice3.game.gameObjects.expeditions;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
public class Coordinates {

    private int x;

    private int y;

    public double distanceTo(Coordinates coords){
        return Math.sqrt(Math.pow(coords.getX() - getX(), 2) + Math.pow(coords.getY() - getY(), 2));
    }
}

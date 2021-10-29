package com.company.practice3.game.objects.expeditions;

import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class Coordinates {

    int x;

    int y;

    public double distanceTo(Coordinates coords){
        return Math.sqrt(Math.pow(coords.getX() - getX(), 2) + Math.pow(coords.getY() - getY(), 2));
    }
}

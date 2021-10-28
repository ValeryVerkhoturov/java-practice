package com.company.practice3.game.gameObjects.equipment;

import com.company.practice3.game.gameObjects.GameObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Weapon extends GameObject {

    private int damage;

    public Weapon(String name, int damage) {
        super(name);
        this.damage = damage;
    }
}

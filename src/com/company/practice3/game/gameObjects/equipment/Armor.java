package com.company.practice3.game.gameObjects.equipment;

import com.company.practice3.game.gameObjects.GameObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Armor extends GameObject {

    private int def;

    public Armor(String name, int def) {
        super(name);
        this.def = def;
    }
}

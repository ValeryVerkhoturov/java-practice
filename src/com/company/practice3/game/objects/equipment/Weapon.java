package com.company.practice3.game.objects.equipment;

import com.company.practice3.game.objects.GameObject;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class Weapon extends GameObject {

    @NonNull private int damage;

    public Weapon(String name, int damage) {
        super(name);
        this.damage = damage;
    }
}

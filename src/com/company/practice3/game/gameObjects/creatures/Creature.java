package com.company.practice3.game.gameObjects.creatures;

import com.company.practice3.game.gameObjects.GameObject;
import com.company.practice3.game.gameObjects.equipment.Equipment;
import lombok.*;
import org.jetbrains.annotations.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public abstract class Creature extends GameObject {

    private int hp;

    @NonNull private Equipment equipment;

    private int atk;

    private double aps;

    public Creature(String name, int hp, @NotNull Equipment equipment, int atk, double aps) {
        super(name);
        this.hp = hp;
        this.equipment = equipment;
        this.atk = atk;
        this.aps = aps;
    }

    public void takeDamage(int atk){
        atk -= getEquipment().getArmor().getDef();
        if (atk <= 0)
            return;
        if (getHp() <= atk){
            setHp(0);
            return;
        }
        setHp(getHp() - 1);
    }

    public boolean isAlive(){
        return getHp() > 0;
    }

}

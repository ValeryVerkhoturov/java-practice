package com.company.practice3.game.objects.creatures;

import com.company.practice3.game.objects.GameObject;
import com.company.practice3.game.objects.equipment.Equipment;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Creature extends GameObject {

    int hp;

    Equipment equipment;

    int atk;

    double aps;

    public Creature(String name, int hp, Equipment equipment, int atk, double aps) {
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
        setHp(getHp() - atk);
    }

    public boolean isAlive(){
        return getHp() > 0;
    }

    public void setHp(int hp) {
        if (hp > 100)
            this.hp = 100;
        else
            this.hp = hp;
    }
}

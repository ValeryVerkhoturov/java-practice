package com.company.practice3.game.gameObjects.creatures;

import com.company.practice3.game.gameObjects.GameObject;
import com.company.practice3.game.gameObjects.equipment.Equipment;

public abstract class Creature extends GameObject {
    private int hp;
    private Equipment equipment;
    private int atk;
    private double aps;


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
        setHp(getHp() - 1);
    }

    public boolean isAlive(){
        return getHp() > 0;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public double getAps() {
        return aps;
    }

    public void setAps(double aps) {
        this.aps = aps;
    }
}

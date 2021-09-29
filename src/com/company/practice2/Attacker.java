package com.company.practice2;

abstract class Attacker extends Creature {
    protected Weapon weapon;

    public Attacker(String name, int hp, int attackPower, int protectionLevel, Weapon weapon) {
        super(name, hp, attackPower, protectionLevel);
        this.weapon = weapon;
    }

    public int attack(){
        return getAttackPower() + weapon.getAttackPower();
    }
    public void defend(int damage){
        damage -= getProtectionLevel();
        if (damage < 0)
            return;
        int hp = getHp() - damage;
        if (hp < 0) {
            setHp(0);
            return;
        }
        setHp(hp);
    }
}

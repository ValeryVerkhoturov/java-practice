package com.company.practice2;

import com.company.practice2.spells.SpellStorage;

abstract class Attacker extends Creature {
    protected Weapon weapon;
    protected SpellStorage<?, ?, ?> spellStorage;

    public Attacker(String name, int hp, int attackPower, int protectionLevel, Weapon weapon, SpellStorage<?, ?, ?> spellStorage) {
        super(name, hp, attackPower, protectionLevel);
        this.weapon = weapon;
        this.spellStorage = spellStorage;
    }

    public int attack(){
        double randomChance = Math.random();
        if (randomChance < 0.5){
            System.out.print("При помощи оружия " + weapon.getName() + " ");
            return getAttackPower() + weapon.getAttackPower();
        }
        else if (randomChance < 0.7) {
            System.out.print("При помощи заклинания " + spellStorage.getSpell1().getDamagingElement().getName() + " ");
            return spellStorage.getSpell1().cast();
        }
        else if (randomChance < 0.9) {
            System.out.print("При помощи заклинания " + spellStorage.getSpell2().getDamagingElement().getName() + " ");
            return spellStorage.getSpell2().cast();
        }
        System.out.print("При помощи заклинания " + spellStorage.getSpell3().getDamagingElement().getName() + " ");
        return spellStorage.getSpell3().cast();
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

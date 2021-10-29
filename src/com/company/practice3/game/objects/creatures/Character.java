package com.company.practice3.game.objects.creatures;

import com.company.practice3.game.objects.equipment.Equipment;
import com.company.practice3.game.objects.equipment.spells.Spell;

public class Character extends Creature {

    public Character(String name, int hp, Equipment equipment, int atk, double aps) {
        super(name, hp, equipment, atk, aps);
    }

    public String printStats(){
        StringBuilder out = new StringBuilder("Имя " + getName() + "\n" +
                "Здоровье " + getHp() + "\n" +
                "Оружие\n" +
                "  Имя " + getEquipment().getWeapon().getName() + "\n" +
                "  Урон " + getEquipment().getWeapon().getDamage() + "\n" +
                "Броня\n" +
                "  Имя " + getEquipment().getArmor().getName() + "\n" +
                "  Защита " + getEquipment().getArmor().getDef() + "\n");
        if (getEquipment().getSpells().size() != 0){
            out.append("Заклинания\n");
            for (Spell spell: getEquipment().getSpells()) {
                out.append("  ").append(spell.getName()).append("\n");
                out.append("    Параметр ").append(spell.cast()).append("\n");
            }
        }
        out.append("Атака ").append(getAtk()).append("\n")
                .append("Замах ").append(String.format("%,.2f", getAps())).append("\n");
        return out.toString();
    }

    public void castHealSpell(){
        if (getEquipment().getSpells().size() > 0 && getHp() < 100){
            Spell spell = getEquipment().getSpells().stream().findFirst().get();
            setHp(getHp() + spell.cast());
            getEquipment().getSpells().remove(spell);
        }
    }

    @Override
    public void takeDamage(int atk) {
        super.takeDamage(atk / 2 );
    }

    @Override
    public char viewOnMap() {
        return '@';
    }
}

package com.company.practice2.spells;

public class SpellStorage<Spell1 extends DamagingSpell<?>, Spell2 extends DamagingSpell<?>, Spell3 extends DamagingSpell<?>> {
    private Spell1 spell1;
    private Spell2 spell2;
    private Spell3 spell3;

    public SpellStorage(Spell1 spell1, Spell2 spell2, Spell3 spell3) {
        this.spell1 = spell1;
        this.spell2 = spell2;
        this.spell3 = spell3;
    }

    public Spell1 getSpell1() {
        return spell1;
    }

    private void setSpell1(Spell1 spell1) {
        this.spell1 = spell1;
    }

    public Spell2 getSpell2() {
        return spell2;
    }

    private void setSpell2(Spell2 spell2) {
        this.spell2 = spell2;
    }

    public Spell3 getSpell3() {
        return spell3;
    }

    private void setSpell3(Spell3 spell3) {
        this.spell3 = spell3;
    }
}

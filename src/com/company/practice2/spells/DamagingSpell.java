package com.company.practice2.spells;

public class DamagingSpell<E extends DamagingElement>{
    private DamagingElement damagingElement;
    public DamagingSpell(DamagingElement damagingElement) {
        this.damagingElement = damagingElement;
    }

    // returns spell damage
    public int cast(){
        return damagingElement.getDamage();
    }

    public DamagingElement getDamagingElement() {
        return damagingElement;
    }

    private void setDamagingElement(DamagingElement damagingElement) {
        this.damagingElement = damagingElement;
    }
}

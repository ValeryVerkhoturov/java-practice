package com.company.practice2.spells;

public abstract class Element {
    protected String name;

    public Element(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }
}

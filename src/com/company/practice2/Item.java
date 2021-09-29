package com.company.practice2;

abstract class Item extends Entity {
    protected int price;
    public Item(String name, int price){
        super(name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    protected void setPrice(int price) {
        this.price = price;
    }
}

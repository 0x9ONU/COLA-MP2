package com.example.mp2test;

public class Valuable extends Item{

    Valuable() {
        super(0.0, "Dohickey", false, false);
    }

    Valuable (int value, String name, boolean randomizedValue, boolean indestructible) {
        super(value, name, randomizedValue, indestructible);
    }

    @Override
    public double useItem(Item itemTarget, Member memberTarget) {
        return 0;
    }
}
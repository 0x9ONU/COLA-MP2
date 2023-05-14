/**
 * File Name: Valuable.java
 * Author: Ethan Berei
 * Date: 4/27/23
 * Description: The class responsible for controlling the value of items
 */

package com.example.mp2test;

//This funcition was made to un-abstract the Item class to prevent crashing errors when passing Items through bundles and Intents

public class Valuable extends Item{

    Valuable() {
        super(0.0, "Dohickey", false, false);
    }

    Valuable (int value, String name, boolean randomizedValue, boolean indestructible) {            //gives values to itmes
        super(value, name, randomizedValue, indestructible);
    }

    @Override
    public double useItem(Item itemTarget, Member memberTarget) {
        return 0;
    }
}

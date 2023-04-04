/**
 * File Name: Item.java
 * Author: Ethan Berei
 * Date: 3/30/23
 * Description: The top of the hierarchy for all the items for COLA's Oregon Trail Game. Has abstract methods that must be implemented in its subclasses
 */

package com.example.mp2test;
import java.util.Random;

//The defualt Item Class that is meant to be the super class to all items in the game
public abstract class Item {
    //Data Members
    private double value;
    private String name = "";
    boolean used;
    boolean indestructible;
    String inventoryIdentifier = null;

    /**
     * The default Constructor for Item. Gives it a default value of nothing and "Dohickey" for the name.
     * Only a safety net for when someone forgets to include the proper parameters.
     */
    Item() {
        this.value = 0.0;
        this.name = "Dohickey";
        boolean used = false;
        boolean indestructible = true;
    }

    /**
     * The normal constructor for Item.
     * @param value - The amount of the Item is worth in terms of money
     * @param name - The name of the item. DOES NOT DETERMINE THE ITEMS TYPE
     * @param randomizeValue - Determines whether this item has a randomized value. If true, it will add a random value from 0-50 THEN subtract a random value from 0-50. Otherwise, it will  be the value given.
     * @param indestructible - Determines whether the item is breakable or not
     */
    Item(double value, String name, boolean randomizeValue, boolean indestructible) {
        if (randomizeValue) {
            Random randomValue = new Random(System.currentTimeMillis());
            this.value = value + (double)randomValue.nextInt(5) - (double)randomValue.nextInt(5);
        }
        else {
            this.value = value;
        }
        this.name = name;
        this.indestructible = indestructible;
        boolean used = false;
    }

    Item(Item i) {
        this.value = i.getValue();
        this.name = i.getName();
        this.used = i.getUsed();
        this.indestructible = i.getIndestructible();
    }

    //Getters and Setters

    /**
     * Getter for the value of the Item
     * @return value - The value of the item as a double
     */
    public double getValue() {
        return value;
    }

    /**
     * Get the name of the Item. Used for displaying what the item is
     * @return name - Name of the item
     */
    public String getName() {
        return name;
    }

    public boolean getIndestructible() {
        return indestructible;
    }

    public boolean getUsed() {
        return used;
    }

    public void setIndestructible(boolean indestructible) {
        this.indestructible = indestructible;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    /**
     * Set the value of the item in terms of money
     * @param value - The amount the Item is worth in terms of money
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Set the name of the item to be displayed
     * @param name - The name of the item.
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setInventoryIdentifier(String inventoryIdentifier) {this.inventoryIdentifier = inventoryIdentifier; }
    public String getInventoryIdentifer() {return inventoryIdentifier; }

    public double sellItem() {
        return value;
    }
    //Abstract Methods
    public abstract double useItem(Item itemTarget, Member memberTarget);

}

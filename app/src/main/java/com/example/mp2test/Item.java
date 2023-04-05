/**
 * File Name: Item.java
 * Author: Ethan Berei
 * Date: 3/30/23
 * Description: The top of the hierarchy for all the items for COLA's Oregon Trail Game. Has abstract methods that must be implemented in its subclasses
 */

package com.example.mp2test;
import java.util.Random;

//The default Item Class that is meant to be the super class to all items in the game
public abstract class Item {
    //Data Members
    private double value;
    private String name = "";
    private boolean used;
    private boolean indestructible;
    private String inventoryIdentifier = null;

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

    /**
     * Copy Constructor for Item. It will copy all the values from one item to another, allowing for duplication
     * @param i An item that wants to be copied.
     */
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

    /**
     * Getter for Indestructibility of the Item. These items can be used, but cannot be destroyed by normal means.
     * @return True if Indestructible. False otherwise.
     */
    public boolean getIndestructible() {
        return indestructible;
    }

    /**
     * Getter for whether or not the item has been used
     * @return True with it was used. False otherwise.
     */
    public boolean getUsed() {
        return used;
    }

    /**
     * Sets if the item can be destroyed or not
     * @param indestructible True if indestructible. False if otherwise.
     */
    public void setIndestructible(boolean indestructible) {
        this.indestructible = indestructible;
    }

    /**
     * Setter for whether the object is used or not.
     * @param used True if the item has been used. False otherwise.
     */
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

    /**
     * Setter for the Inventory Identifier
     * @param inventoryIdentifier Sets the inventory identifier that matches either the Shop or Member class' name
     */
    public void setInventoryIdentifier(String inventoryIdentifier) {this.inventoryIdentifier = inventoryIdentifier; }

    /**
     * Getter for the Inventory Identifier
     * @return A String of the Name that matches the Inventory's Shop or Member class
     */
    public String getInventoryIdentifier() {return inventoryIdentifier; }

    /**
     * Returns the value of the item. NOTE: This is different from getValue as it is overridden by future classes.
     * @return Value
     */
    public double sellItem() {
        return value;
    }
    //Abstract Methods

    /**
     * Abstract method that will give usage to new created Items.
     * @param itemTarget What the Item will this affect? May or may not be used.
     * @param memberTarget What Member/Person will this affect? May or may not be used.
     * @return A double value relating to its usage. If boolean is needed, use 0.0 and 1.0. Not always necessary
     */
    public abstract double useItem(Item itemTarget, Member memberTarget);
}

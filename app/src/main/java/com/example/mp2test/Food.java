/**
 * File Name: Food.java
 * Author: Ethan Berei
 * Date: 3/31/23
 * Description: The class that is responsible for holding food items for all characters within the game.
 */

package com.example.mp2test;

public class Food extends Item{

    //Member Variables
    private final int numberOfFood = 3;
    private int type;
    private int healthValue;
    private int pounds;
    private boolean spoiled;
    private String[] typeConvert = new String[numberOfFood];


    /**
     * The default constructor for the Food class. Creates an 10 pounds of apples called "Dohickey".
     */
    Food(String sack_of_potatoes, double v, boolean b, boolean b1, int i) {
        super();
        setupArray();
        this.type = 0;
        this.healthValue = 10;
        this.pounds = 10;
        this.spoiled = false;
    }

    /**
     * The main constructor for the Food Class. Allows for various types of Food to be made
     * @param name Flavor Name of the Food
     * @param value Number of Dollars per Pound
     * @param randomizedValue If true, the value is randomized +-5
     * @param indestructible If true, the item cannot be destroyed by normal means
     * @param type Type of food that is created. Set to 0-X where X is the numberOfFood. See typeConvert for what the
     * @param pounds How many pounds of food is. Cannot be set over 1000 Lbs or less than 1 Lbs
     */
    Food(String name, double value, boolean randomizedValue, boolean indestructible, int type, int pounds) {
        super(value, name, randomizedValue, indestructible);
        this.type = type;
        setPounds(pounds);
        this.spoiled = false;
        switch(type) {
            case 0:
                this.healthValue = 15;
                break;
            case 1:
                this.healthValue = 20;
                break;
            case 2:
                this.healthValue = 10;
                break;
        }
    }

    //Getters and Setters

    /**
     * Getter of the type of Food item
     * @return Type of the item in the format 0-X
     */
    public int getType() {
        return type;
    }

    /**
     * Setter of the type of Food item
     * @param type Sets the type of Food in the format 0-X. See the typeConvert array
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Getter of the amount of Health the food object is worth. Used in health calculations in Member.java
     * @return The amount of Health the food is worth when eaten
     */
    public int getHealthValue() {
        return healthValue;
    }

    /**
     * Sets the amount of Health the food object is worth. Used in health calculations in Member.java
     * @param healthValue The amount of Health the food is worth when eaten
     */
    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

    /**
     * Getter for the amount of pounds are left in the stack of food. If 0, there is no food left in the stack.
     * @return Amount of pounds that are left in the stack of food.
     */
    public int getPounds() {
        return pounds;
    }

    /**
     * Setter for the amount of pounds that are left in the stack of food. Can not be over 1000 lbs but under 1 lbs.
     * @param pounds Amount of pounds between 1-1000.
     */
    public void setPounds(int pounds) {
        if(pounds <= 0) {
            this.pounds = 1;
        }
        else if (pounds < 1000) {
            this.pounds = 1000;
        }
        else {
            this.pounds = pounds;
        }
    }

    /**
     * Getter for whether or not the food is spoiled. Food that is spoiled cannot be eaten and only be sold
     * @return Whether the food is safe to eat or not. True means it is unsafe to eat.
     */
    public boolean getSpoiled() {
        return spoiled;
    }

    /**
     * Setter for when the food is spoiled or not.
     * @param spoiled True when the food becomes spoiled. False otherwise.
     */
    public void setSpoiled(boolean spoiled) {
        this.spoiled = spoiled;
    }

    /**
     * Getter for the name for the type of food. Is taken from the typeConvert Array
     * @return A String of the name of the type of food.
     */
    public String getTypeString() {
        return typeConvert[type];
    }

    /**
     * Increments the number of pounds in the stack of food.
     * @param pounds The amount of pounds ADDED to the food.
     */
    public void incrementPounds(int pounds) {
        this.pounds += pounds;
    }

    /**
     * Decrements the number of pounds in the stack of food.
     * @param pounds The amount of pounds SUBTRACTED from the food.
     */
    public void decrementPounds(int pounds) {
        this.pounds -= pounds;
    }

    /**
     * A helper function that is called within the class to prepare the different types of food. Increase the numberOfFood variable to increase the number of types of food that can be added.
     */
    private void setupArray() {
        typeConvert[0] = "Fruit";
        typeConvert[1] = "Meat";
        typeConvert[2] = "Canned Goods";
    }


    /**
     * Implementation of the useItem abstract method for the Food class. This method works with the Member class and heals the selected Member by the healthValue of the Food
     * @param itemTarget Does not matter and is leftover from the abstraction. May be set to null
     * @param memberTarget The target that is healed by the
     * @return Amount of health healed
     */
    @Override
    public double useItem(Item itemTarget, Member memberTarget) {
        if (getInventoryIdentifier().equals(memberTarget.getName())) {
            if (spoiled) {
                return 0.0;
            }
            if (pounds > 0){
                decrementPounds(10);
                if (pounds < 0) {
                    //Splash text why
                    pounds = 0;
                }
                memberTarget.heal(healthValue);
                return healthValue;
            }
            else {
                return 0.0;
            }
        }
        else {
            return 0.0;
        }
    }

    /**
     * Impletionation of the sellItem abstract method for the Food class. This method gives the value of the item based on the amount of pounds.
     * @return The value of each pound of object multiplied by the number of pounds
     */

    public double sellItem() {
        return super.getValue() * pounds;
    }
}

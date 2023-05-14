/**
 * File Name: Member.java
 * Author: Ashton Beresford
 * Date: 4/1/23
 * Description: The class that controls the Members: which are basically any living thing in the story that can be interacted with
 */

package com.example.mp2test;

import java.io.Serializable;

/**
 * Acts as a class to be used for each instance of a "party" member in the group's wagon
 */
public class Member implements Serializable {                                                       //class is here for updates, it builds groundwork if the game gets improved
    //instance methods
    private String name;
    private int health;
    private int maxHealth;
    private double money;
    Inventory inventory;
    private boolean human;
    private boolean friendly;
    private boolean alive;
    private int xCoordinate;
    private int yCoordinate;


    //constructors

    /**
     * default constructor for the member class, basically just used to show default values
     */
    public Member() {
        this.name = "default name";
        this.health = 100;
        this.human = true;
        this.friendly = true;
        this.alive = true;
        this.money = 0;
        this.xCoordinate = 0;
        this.yCoordinate = 0;
        this.maxHealth = 100;
    }

    /**
     * member constructor that only requires a name and xCoordinate
     * @param name The Member's name
     * @param xCoordinate The Member's location on the map
     */
    public Member(String name, int xCoordinate) {
        this.name = name;
        this.health = 100;
        this.human = true;
        this.friendly = true;
        this.alive = true;
        this.money = 0;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = 0;
        this.maxHealth = 100;
    }

    /**
     * The constructor that will primarily be used for the Member class, member will by default always be (0,0), and will by default always be alive
     * @param health the Member's starting health and maxHealth value
     * @param inventory the Member's starting inventory
     * @param name the Member's name
     * @param human true if member is human, false if member is another species
     * @param friendly true if the member if friendly to the player, false if they are not friendly and will attack
     * @param money the member's starting amount of money
     */
    public Member(int health, Inventory inventory, String name, boolean human, boolean friendly, double money) {
        this.health = health;
        this.maxHealth = health;
        this.inventory = inventory;
        this.name = name;
        this.human = human;
        this.friendly = friendly;
        this.alive = true;
        this.money = money;
        this.xCoordinate = 0;
        this.yCoordinate = 0;
    }

    //getters and setters

    /**
     * Returns the health value of this member
     * @return the member's health
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Allows one to set the member's health
     * @param health amount of health the member has
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * returns the max health value of the member (by default its 100)
     * @return the int value for the max health of the member
     */
    public int getMaxHealth() {return this.maxHealth; }

    /**
     * changes the max health of the member
     * @param maxHealth the member's new max health
     */
    public void setMaxHealth(int maxHealth) {this.maxHealth = maxHealth;}

    /**
     * gets the member's name
     * @return the member's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set's the member's name
     * @param name the member's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the member's inventory
     * @return the member's inventory
     */
    public Inventory getInventory() {
        // Should probably change how this works later once we actually get the inventory set up with the member class
        return inventory;
    }

    /**
     * Allows one to set the inventory of the member
     * @param inventory the new inventory of the member
     */
    public void setInventory(Inventory inventory) {
        // Should probably change how this works later once we actually get the inventory set up with the member class
        this.inventory = inventory;
    }

    /**
     * Tells whether the member is friendly or not
     * @return the member's friendly boolean trait
     */
    public boolean isFriendly() {
        return friendly;
    }

    /**
     * Allows one to change the member's friendly nature
     * @param friendly the member's new friendly value
     */
    public void setFriendly(boolean friendly) {
        this.friendly = friendly;
    }

    /**
     * Tells whether the member is human or not
     * @return the member's human boolean
     */
    public boolean isHuman() {
        return human;
    }

    /**
     * Changes whether the member is human or not
     * @param human the member's new human value
     */
    public void setHuman(boolean human) {
        this.human = human;
    }

    /**
     * Tells whether the member is alive or not
     * @return true if the member is alive, false if they're dead
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * gets the member's current amount of money
     * @return the member's current amount of money
     */
    public double getMoney() {
        return money;
    }

    /**
     * changes the member's money to the amount provided
     * @param money the member's new amount of money
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * gives the member a certain amount of money
     * @param money the amount of money added to the member's total amount
     */
    public void incrementMoney(double money) {
        this.money += money;
    }

    /**
     * takes away a certain amount of money from the member
     * @param money the amount of money taken away from the member
     */
    public void decrementMoney(double money) {
        if (this.money - money < 0) {
            this.money = 0;
        }
        else {
            this.money = this.money - money;
        }
    }

    //other methods

    /**
     * this kills the member by setting their health to 0 and sets the alive value to false
     */
    public void die() {
        this.health = 0;
        this.alive = false;
    }

    /**
     * Will heal the member for 10 health if no amount is specified, max health is 100
     */
    public void heal() {
        //this value can be changed later
        if (this.health + 10 > maxHealth) {
            this.health = maxHealth;
        }
        else {
            this.health +=10;
        }
    }

    /**
     * Heals the member for the number of health provided
     * @param health the number of health added to the member
     */
    public void heal(int health) {
        //this assumes that the max health is 100 for a member
        if (this.health + health > maxHealth) {
            this.health = maxHealth;
        }
        else {
            this.health += health;
        }
    }

    /**
     * damages the member for 10 hp, will kill the member if health drops to 0 or below
     */
    public void damage() {
        //this value can be changed later
        this.health -= 10;
        if (this.health <= 0) {
            die();
        }
    }

    /**
     * damages the member for the number of health provided and kills them if health drops to or below 0
     * @param health
     */
    public void damage(int health) {
        this.health -= health;
        if (this.health <= 0) {
            die();
        }
    }

    /**
     * moves the member by an amount across the map
     * @param x the horizontal movement of the member
     * @param y the vertical movement of the member
     */
    public void move(int x, int y) {
        this.xCoordinate += x;
        this.yCoordinate += y;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Prints out the information of the member string
     * @return the string of the member's information
     */
    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", maxHealth=" + maxHealth +
                ", money=" + money +
                ", inventory=" + inventory +
                ", human=" + human +
                ", friendly=" + friendly +
                ", alive=" + alive +
                ", xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }
}
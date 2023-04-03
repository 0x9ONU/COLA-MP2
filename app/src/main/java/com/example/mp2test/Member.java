package com.example.mp2test;

//added an boolean instance variable for "alive", which tells whether the member is dead or not

/**
 * Acts as a class to be used for each instance of an "party" member in the group's wagon
 */
public class Member {
    //instance methods
    String name;
    int health;
    double money;
    Inventory inventory;
    boolean human;
    boolean friendly;
    boolean alive;

    //constructors
    public Member() {
        this.name = "default name";
        // I'm just using a staring base line for health starting at 100, probably change later
        // Also setting friendly and human to true by default
        this.health = 100;
        this.human = true;
        this.friendly = true;
        this.alive = true;
        this.money = 0;
    }

    public Member(int health, Inventory inventory, String name, boolean human, boolean friendly, int money) {
        this.health = health;
        this.inventory = inventory;
        this.name = name;
        this.human = human;
        this.friendly = friendly;
        this.alive = true;
        this.money = money;
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
     * @return
     */
    public boolean isAlive() {
        return alive;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void incrementMoney(double money) {
        this.money += money;
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
        if (this.health + 10 > 100) {
            this.health = 100;
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
        if (this.health + health > 100) {
            this.health = 100;
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
     * moves the member to a specific spot on the map
     * @param x the member's new x-coordinate of their position
     * @param y the member's new y-coordinate of their position
     */
    public void move(int x, int y) {
        // I have no idea what to do with this cause I don't have a map
        // will have to be implemented later
        System.out.println("This has to be implemented later once the member class gets set up with the map class.");
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
                ", inventory=" + inventory +
                ", human=" + human +
                ", friendly=" + friendly +
                ", alive=" + alive +
                '}';
    }
}
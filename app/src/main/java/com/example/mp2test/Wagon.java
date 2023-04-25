/**
 * File Name: Wagon.java
 * Author: Ashton Beresford
 * Date: 4/2/23
 * Description: The class that controls the wagon, which also keeps track of the game score and the speed at which the player is moving
 */

package com.example.mp2test;

public class Wagon {
    // instance variables
    private int speed;
    private Inventory inventory;
    private int score;

    //constructors

    /**
     * default (and only) constructor for wagon, sets the speed to 1 and score to 0 by default
     */
    public Wagon(Member memberIdentifier) {
        //setting speed automatically to 12, as it will travel at normal speed at 12 miles a day
        this.speed = 12;
        this.score = 0;
        this.inventory = new Inventory(100, memberIdentifier);
    }

    //getters and setters

    /**
     * gets the speed at which the wagon and game is moving
     * @return the wagon's speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * gets the score of the wagon
     * @return the wagpon's score
     */
    public int getScore() {
        return score;
    }

    //other methods

    /**
     * Changes the wagon's speed to be the one supplied
     * @param speed the wagon's new speed
     */
    public void updateSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * increase the wagon/player's score by the amount supplied
     * @param score the amount added to the wagon's score
     */
    public void increaseScore(int score) {
        this.score += score;
    }

    /**
     * decreases the wagon/player's score by the amount specified
     * @param score the amount deducted from the wagon's score
     */
    public void decreaseScore(int score) {
        this.score -= score;
    }
}
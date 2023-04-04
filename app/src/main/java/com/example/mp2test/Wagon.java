package com.example.mp2test;

public class Wagon {
    // instance variables
    private int speed;
    private Inventory inventory;
    private int score;

    //constructors
    public Wagon() {
        //setting speed automatically to 1, probably change automatic value later
        this.speed = 1;
        this.score = 0;
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
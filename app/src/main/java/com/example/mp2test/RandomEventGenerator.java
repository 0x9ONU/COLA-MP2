/**
 * File Name: RandomEventGenerator.java
 * Author: Aiden Tallet
 * Date: 3/31/23
 * Description: The class responsible for allowing random events to happen
 */
package com.example.mp2test;

import java.lang.Math;
import java.util.Random;

public class RandomEventGenerator {
    private String[] GoodRandomEvents = {"Kiss","gold nugget","nice native americans","bundle of food","deserted wagon","miscounted food","house","wandering oxen","good sleep","Alex Frimel"}; // 10 good events
    private String[] BadRandomEvents = {"Volcano","broken wheel","aggressive native americans","thief","bad shortcut","rainy day","broken leg","tired oxen","misplaced food","animals got to the food"}; // 10 bad events
    private int RandomNumber;                                                                       //holds what the generated number is
    private double ProbabilityMultiplier;                                                           //allows the number to have higher chances of good or bad events
    private Random rand = new Random();                                                             //allows for the random number generator to work

    //constructor

    /**
     * default constructor for the RandomEventGenerator
     */
    public RandomEventGenerator() {
        ProbabilityMultiplier = 1;
        RandomNumber = rand.nextInt(100);
    }

    //getters&setters

    /**
     * gives the random number value
     * @return RandomNumber
     */
    public int getRandomNumber() {
        return RandomNumber;
    }

    /**
     * gives a new random number
     */
    public void setRandomNumber() {
        RandomNumber = rand.nextInt(100);
    }

    /**
     * outputs the current Probability Multiplier
     * @return ProbabilityMultiplier
     */
    public double getProbabilityMultiplier() {
        return ProbabilityMultiplier;
    }

    /**
     * sets a new probability multiplier
     * @param probabilityMultiplier a number above 0 that  will be multiplied by our random value
     */
    public void setProbabilityMultiplier(int probabilityMultiplier) {
        if (probabilityMultiplier > 0) {
            this.ProbabilityMultiplier = probabilityMultiplier;
        }
    }

    /**
     * adds 0.1 to the probability multiplier
     */
    public void IncrementProbabilityMultiplier() {
        ProbabilityMultiplier = ProbabilityMultiplier + 0.1;
    }

    /**
     * returns the string of a random event if the value is low or high enough
     * @return the string of a random event or "none"
     */
    public String GetEvent() {
        setRandomNumber();
        if (RandomNumber * ProbabilityMultiplier >= 90 ) {
            String BEvent = BadRandomEvents[(int)(Math.ceil(RandomNumber * ProbabilityMultiplier)) - 90];
            return BEvent;
        }
        if (RandomNumber * ProbabilityMultiplier <= 10) {
            String GEvent = GoodRandomEvents[(int)(Math.floor(RandomNumber * ProbabilityMultiplier))];
            return GEvent;
        }
        return "none";
    }
}



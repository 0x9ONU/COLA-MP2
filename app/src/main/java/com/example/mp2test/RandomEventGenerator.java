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
    private final String[] GoodRandomEvents = {"Kiss","gold nugget","nice native americans","bundle of food","deserted wagon","miscounted food","house","wandering oxen","good sleep","Alex Frimel"}; // 10 good events
    private final String[] BadRandomEvents = {"animals got to the food","broken wheel","aggressive native americans","thief","bad shortcut","rainy day","broken leg","tired oxen","misplaced food","Volcano"}; // 10 bad events
    private int RandomNumber;                                                                       //holds what the generated number is
    private double ProbabilityMultiplier;                                                           //allows the number to have higher chances of good or bad events
    private final Random rand = new Random();                                                       //allows for the random number generator to work

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
        RandomNumber = rand.nextInt(99);
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
     * adds 0.01 to the probability multiplier
     */
    public void IncrementProbabilityMultiplier() {
        ProbabilityMultiplier = ProbabilityMultiplier + 0.001;
    }

    /**
     * subtracts 0.01 to the probability multiplier
     */
    public void DecrementProbabilityMultiplier() {
        if (ProbabilityMultiplier > 0.1) {
            ProbabilityMultiplier = ProbabilityMultiplier - 0.001;
        }
    }
    /**
     * returns the string of a random event if the value is low or high enough
     * @return the string of a random event or "none"
     */

    public String GetEvent() {
        setRandomNumber();                                                                          //sets a new random number
        int NumberDecided = (int)(RandomNumber * ProbabilityMultiplier);                            //finds the number after the multiplier
        if (NumberDecided >= 90) {                                                                  //checks if the number is high enough for a bad event
            if (NumberDecided >= 100) {                                                             //is a check for if the number is > 100
                return BadRandomEvents[10 - 1];                                                     //returns worst scenario if number is > 100
            }
            return BadRandomEvents[NumberDecided % 100 - 90];                                       //otherwise returns the appropriate bad event
        }
        if (NumberDecided < 10) {                                                                  //checks if the number is low enough for a good event
            return GoodRandomEvents[NumberDecided % 100];                                           //returns appropriate good event
        }
        return "none";                                                                              // if number > 10 and < 90 then nothing happens
    }

}



package com.example.mp2test;

import java.lang.Math;
import java.util.Random;

public class RandomEventGenerator {
    private String[] GoodRandomEvents = {"Kiss",""}; // 10
    private String[] BadRandomEvents = {"Volcano",""}; // 10
    private int RandomNumber;
    private double ProbabilityMultiplier;
    private Random rand = new Random();

    //constructor
    public RandomEventGenerator() {
        ProbabilityMultiplier = 1;
        RandomNumber = rand.nextInt(100);
    }

    //getters&setters
    public int getRandomNumber() {
        return RandomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        RandomNumber = rand.nextInt(100);
    }

    public double getProbabilityMultiplier() {
        return ProbabilityMultiplier;
    }

    public void setProbabilityMultiplier(int probabilityMultiplier) {
        ProbabilityMultiplier = probabilityMultiplier;
    }

    public void IncrementProbabilityMultiplier() {
        ProbabilityMultiplier = ProbabilityMultiplier + 0.1;
    }

    public String GetEvent() {
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



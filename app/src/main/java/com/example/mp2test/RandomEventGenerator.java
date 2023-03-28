package com.example.mp2test;

import java.lang.Math;
import java.util.Random;

public class RandomEventGenerator {
    String[] GoodRandomEvents = {"Kiss",""}; // 10
    String[] BadRandomEvents = {"Volcano",""}; // 10
    int RandomNumber;
    double ProbabilityMultiplier;
    Random rand = new Random();

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



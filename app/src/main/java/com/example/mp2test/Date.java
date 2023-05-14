/**
 * File Name: Date.java
 * Author: Aiden Tallet
 * Date: 3/31/23
 * Description: The class responsible for holding the date
 */

package com.example.mp2test;

public class Date {
    //attributes
    private int CurrentDay;                                                                         //holds the current day
    private int CurrentMonth;                                                                       //holds the current month
    private int CurrentYear;                                                                        //holds the current year
    private int GoalDay;                                                                            //holds the day that you should finish by
    private int GoalMonth;                                                                          //holds the month you should finish by
    private int GoalYear;                                                                           //holds the year you should finish by
    private int DayCounter;                                                                         //holds how many days youve been on the trail

    //constructors

    /**
     * constructor of Date with the current day month and year
     * @param currentDay the day the player starts at
     * @param currentMonth the month the player starts at
     * @param currentYear the year the player starts at
     */
    public Date(int currentDay, int currentMonth, int currentYear) {
        CurrentDay = currentDay;
        CurrentMonth = currentMonth;
        CurrentYear = currentYear;
        DayCounter = 0;
    }

    /**
     * default constructor of date
     */
    public Date() {
        CurrentDay = 0;
        CurrentMonth = 0;
        CurrentYear = 0;
        DayCounter = 0;
        GoalMonth = 0;
        GoalDay = 0;
        GoalYear = 0;
    }
    //getters

    /**
     * outputs current day that the player is on
     * @return CurrentDay
     */
    public int getCurrentDay() {
        return CurrentDay;
    }

    /**
     * outputs the current month that the player is on
     * @return CurrentMonth
     */
    public int getCurrentMonth() {
        return CurrentMonth;
    }

    /**
     * outputs the current year that the player is on
     * @return CurrentYear
     */
    public int getCurrentYear() {
        return CurrentYear;
    }

    /**
     * outputs the goal day that the player should get to the destination by
     * @return GoalDay
     */
    public int getGoalDay() {
        return GoalDay;
    }

    /**
     * outputs the goal month
     * @return GoalMonth
     */
    public int getGoalMonth() {
        return GoalMonth;
    }

    /**
     * outputs the goal year
     * @return GoalYear
     */
    public int getGoalYear() {
        return GoalYear;
    }

    /**
     * outputs the amount of days the player has been on the trail
     * @return DayCounter
     */
    public int getDayCounter() {
        return DayCounter;
    }

    //setters

    /**
     * sets the current day to a value
     * @param currentDay the day from 0-31 you want the player to be at
     */
    public void setCurrentDay(int currentDay) {
        if (currentDay < 30) {
            CurrentDay = currentDay;
        }
    }

    /**
     * sets the current month to a value
     * @param currentMonth the month from 0-12 you want the player to be at
     */
    public void setCurrentMonth(int currentMonth) {
        if (currentMonth < 12) {CurrentMonth = currentMonth;}
    }

    /**
     * sets the current year to a value
     * @param currentYear the year from 0-12 you want the player to be at
     */
    public void setCurrentYear(int currentYear) {
        CurrentYear = currentYear;
    }

    /**
     * sets the goal day to a value
     * @param goalDay the day from 0-31 you want the player to complete by
     */
    public void setGoalDay(int goalDay) {
        if (goalDay < 30) {GoalDay = goalDay;}
    }
    /**
     * sets the goal Month to a value
     * @param goalMonth the day from 0-0-12 you want the player to complete by
     */
    public void setGoalMonth(int goalMonth) {
        if (goalMonth < 12) {GoalMonth = goalMonth;}
    }

    /**
     * sets the goal year to a value
     * @param goalYear the year from you want the player to complete by
     */
    public void setGoalYear(int goalYear) {
        GoalYear = goalYear;
    }

    /**
     * sets the day counter to a specific value
     * @param dayCounter the amount of days the player has been on the trail
     */
    public void setDayCounter(int dayCounter) {
        if (dayCounter > 0) {DayCounter = dayCounter;}
    }

    /**
     * increases the current day by 1
     */
    public void IncrementCurrentDay() {
        if (CurrentDay > 30) {
            IncrementCurrentMonth();
            CurrentDay = 1;
        }
        else {
            CurrentDay++;
        }
    }

    /**
     * increases the current month by 1
     */
    public void IncrementCurrentMonth() {
        if (CurrentMonth > 11) {
            IncrementCurrentYear();
            CurrentMonth = 0;
        } else {
            CurrentMonth += 1;
        }
    }

    /**
     * increases the current year by 1
     */
    public void IncrementCurrentYear() {
        CurrentYear += 1;
    }

    /**
     * increases the daycounter by 1
     */
    public void IncrementdayCounter() {
        DayCounter += 1;
    }

    @Override
    public String toString() {
        return CurrentMonth + "/" + CurrentDay + "/" + CurrentYear;
    }
}

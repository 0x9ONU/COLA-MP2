package com.example.mp2test;

public class Date {
    //attributes
    private int CurrentDay;
    private int CurrentMonth;
    private int CurrentYear;
    private int GoalDay;
    private int GoalMonth;
    private int GoalYear;
    private int DayCounter;
    //constructors

    public Date(int currentDay, int currentMonth, int currentYear) {
        CurrentDay = currentDay;
        CurrentMonth = currentMonth;
        CurrentYear = currentYear;
        DayCounter = 0;
    }

    //getters

    public int getCurrentDay() {
        return CurrentDay;
    }

    public int getCurrentMonth() {
        return CurrentMonth;
    }

    public int getCurrentYear() {
        return CurrentYear;
    }

    public int getGoalDay() {
        return GoalDay;
    }

    public int getGoalMonth() {
        return GoalMonth;
    }

    public int getGoalYear() {
        return GoalYear;
    }

    public int getDayCounter() {
        return DayCounter;
    }

    //setters


    public void setCurrentDay(int currentDay) {
        CurrentDay = currentDay;
    }

    public void setCurrentMonth(int currentMonth) {
        CurrentMonth = currentMonth;
    }

    public void setCurrentYear(int currentYear) {
        CurrentYear = currentYear;
    }

    public void setGoalDay(int goalDay) {
        GoalDay = goalDay;
    }

    public void setGoalMonth(int goalMonth) {
        GoalMonth = goalMonth;
    }

    public void setGoalYear(int goalYear) {
        GoalYear = goalYear;
    }

    public void setDayCounter(int dayCounter) {
        DayCounter = dayCounter;
    }

    public void IncrementCurrentDay() {
        CurrentDay += 1;
    }

    public void IncrementCurrentMonth() {
        CurrentMonth += 1;
    }

    public void IncrementCurrentYear() {
        CurrentYear += 1;
    }
}

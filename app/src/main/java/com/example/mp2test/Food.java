package com.example.mp2test;

public class Food extends Item{

    static int numberOfFood = 3;
    int type;
    int healthValue;
    int pounds;
    int spoiled;
    String[] typeConvert = new String[numberOfFood];

    Food() {
        super();
        setupArray();
        this.type = 0;
        this.healthValue = 10;
        this.pounds = 10;
        this.spoiled = 0;
    }

    Food(String name, double value, boolean randomizedValue, boolean indestructible, int type, int pounds) {
        super(value, name, randomizedValue, indestructible);
        this.type = type;
        this.pounds = pounds;
        this.spoiled = 0;
        switch(type) {
            case 0:
                this.healthValue = 15;
                break;
            case 1:
                this.healthValue = 20;
                break;
            case 2:
                this.healthValue = 10;
                break;
        }
    }

    //Getters and Setters

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

    public int getPounds() {
        return pounds;
    }

    public void setPounds(int pounds) {
        this.pounds = pounds;
    }

    public int getSpoiled() {
        return spoiled;
    }

    public void setSpoiled(int spoiled) {
        this.spoiled = spoiled;
    }

    public String getTypeString() {
        return typeConvert[type];
    }

    private void setupArray() {
        typeConvert[0] = "Fruit";
        typeConvert[1] = "Meat";
        typeConvert[2] = "Canned Goods";
    }


    @Override
    public double useItem(Item itemTarget, Member memberTarget) {
        //Member.heal(); Implement function here
        return 0.0;
    }
    @Override
    public double sellItem() {
        return super.value * pounds;
    }
}

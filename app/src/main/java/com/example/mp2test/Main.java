package com.example.mp2test;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        //player starts at {0,0,0}
        Map mp = new Map();
        //journey starts on March 1, 1849
        Date date = new Date(1,3,1849);
        //creates the player as a member, and creates their inventory with a max items of 100
        Member player = new Member();
        Inventory playerInventory = new Inventory(100, player);
        //creates Random event generator
        RandomEventGenerator reg = new RandomEventGenerator();
        //creates the player's wagon
        Wagon wag = new Wagon(player);
        //creates a weapon
        Weapon wep = new Weapon();
        //the player starts out with 10 pounds of food, worth $1 per pound
        Food rations = new Food("rations", 1, false, false, 0, 10);
        playerInventory.addItem(rations);

        //scanner for user input/responses
        Scanner in = new Scanner(System.in);

        //Section for the actual game code
        System.out.println("The Oregon Trail Game");
        System.out.println();
        System.out.println("press any key to Start");
        System.out.println(in.nextLine());
        System.out.println("woah");


    }
}

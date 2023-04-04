package com.example.mp2test;

import java.util.*;

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
        Weapon wep = new Weapon(100.0, "Basic Revolver", true, 0, 26, 0);
        //the player starts out with 10 pounds of food, worth $1 per pound
        Food rations = new Food("rations", 1, false, false, 0, 10);
        playerInventory.addItem(rations);
        //the player starts with $100
        player.incrementMoney(100);
        //creates the shops and shopkeepers along the trails
        Member shopKeeper1 = new Member();
        shopKeeper1.incrementMoney(25);
        Inventory shop1Inventory = new Inventory();
        Food shop1Food = new Food("Supplies", 2, true, false, 1, 100);
        shop1Inventory.addItem(shop1Food);
        Shop shop1 = new Shop(80, 60, "Still-Close-to-Missouri-Saloon", shop1Inventory, shopKeeper1);
        Item clothes1 = new Item(10, "Basic Clothes", true, false) {
            /**
             * Temporary Clothes Class. WIll implement properly later
             * @param itemTarget Does not matter. May be null.
             * @param memberTarget Does not matter. May be null.
             * @return 0
             */
            @Override
            public double useItem(Item itemTarget, Member memberTarget) {
                System.out.println("The Clothes do not fit you unfortunately...");
                return 0;
            }
        };
        playerInventory.addItem(clothes1);
        Item clothes2 = new Item(50, "Fancy Clothes", true, false) {

            /**
             Temporary Clothes Class. WIll implement properly later
             * @param itemTarget Does not matter. May be null.
             * @param memberTarget Does not matter. May be null.
             * @return 0
             */
            @Override
            public double useItem(Item itemTarget, Member memberTarget) {
                System.out.println("The Clothes do not fit you unfortunately...");
                return 0;
            }
        };

        shop1.addItem(clothes2);

        //make shop2 stuff here

        //scanner for user input/responses
        Scanner in = new Scanner(System.in);

        //Section for the actual game code
        System.out.println("The Oregon Trail Game");
        System.out.println("In memory of Hattie Campbell");
        System.out.println();
        System.out.println("Press enter to Start");

        //waits for user input then continues the game
        in.nextLine();
        System.out.println("You start your journey on the Oregon Trail on March 31, 1849 In Missouri.");
        System.out.println("You bring 10 pounds of food and $100.");
        System.out.println("Press enter to begin your journey");
        in.nextLine();

        /*Day 1*/

        //sets day to day 1
        date.IncrementCurrentDay();
        date.IncrementdayCounter();

        System.out.println("Day 1");
        //moves the player to their day1 location
        mp.MovePlayer(60, 20);
        //checks if the player is in the location of a shop or monument
        if (mp.CheckMonument().equals("none") && !mp.CheckShop(shop1)) {
            //displays a message if there's no shop or monument at the player's location
            System.out.println("This is a very uneventful day");
        }
        else if (mp.CheckShop(shop1)) {
            //Allows the player to interact with the shop if their is a shop at the player's location
            System.out.print("You manage to find the " + shop1.getName() + ".");
            System.out.println(" Would you like to Enter?");
            System.out.print("Press y to enter, or any other letter to ignore and pass by the shop. Then hit enter.");
            String decision = in.nextLine();

            if (decision.equals("y") || decision.equals("Y")) {
                //enters the shop if the player types "y"
                System.out.print("You enter the " + shop1.getName() + ".");
                System.out.println("You have the options to buy...");
                for (int i = 0; i < shop1Inventory.getItemsLength(); i++) {
                    System.out.println(i + ": " + shop1Inventory.getItem(i).getName());
                }
                System.out.println("To buy an item, put the number in front of said item and click enter, otherwise press any letter and enter to leave the shop.");

                //int shopItem;
                //buys the item at the provided index or leaves the shop
                try {
                    int shopItem = in.nextInt();
                } catch (Exception e) {
                    System.out.println("You leave the shop.");
                } finally {
                    int shopItem = in.nextInt();
                    shop1.buyItem(player, shopItem);
                    System.out.println("You bought this item.");
                }

            }
            else {
                System.out.println("You leave the shop.");
            }
        }
        else {
            //tells the player if they're passing by a monument
            System.out.println("You pass by the " + mp.CheckMonument() + " today.");
        }
        System.out.println(""); //fill this print statement in a bit

    }
}

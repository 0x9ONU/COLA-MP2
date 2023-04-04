package com.example.mp2test;

import java.util.*;

        /* IMPORTANT: TO GET A SPECIAL ITEM OUT OF THE ARRAY, USE THE FOLLOWING SYNTAX.
        ClassName test = (ClassName) shop2Inventory.getItem(1);
        test.reload();
        */

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

        //creates shop1
        Member shopKeeper1 = new Member();
        shopKeeper1.incrementMoney(25);
        Inventory shop1Inventory = new Inventory();
        Food shop1Food = new Food("Supplies", 2, true, false, 1, 100);
        shop1Inventory.addItem(shop1Food);
        Shop shop1 = new Shop(60, 20, "Still-Close-to-Missouri-Saloon", shop1Inventory, shopKeeper1);
        Item clothes1 = new Item(10, "Basic Clothes", true, false) {
            /**
             * Temporary Clothes Class. WIll implement properly later
             * @param itemTarget Does not matter. May be null.
             * @param memberTarget Does not matter. May be null.
             * @return 0
             */
            @Override
            public double useItem(Item itemTarget, Member memberTarget) {
                if (getInventoryIdentifer().equals(memberTarget.getName())) {
                    System.out.println("The Clothes do not fit you unfortunately...");
                }
                else {
                    System.out.println("They do not own this item");
                }
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
                if (getInventoryIdentifer().equals(memberTarget.getName())) {
                    System.out.println("The Clothes do not fit you unfortunately...");
                }
                else {
                    System.out.println("They do not own this item");
                }
                return 0;

            }
        };

        shop1.addItem(clothes2);

        //creates shop2
        Member shopKeeper2 = new Member();
        shopKeeper2.incrementMoney(75);
        Inventory shop2Inventory = new Inventory();
        Food shop2Food = new Food("Supplies", 3, true, false, 1, 120);
        shop2Inventory.addItem(shop2Food);
        Shop shop2 = new Shop(100, 40, "Almost to Nebraska Saloon", shop2Inventory, shopKeeper2);
        Weapon pan = new Weapon(5000, "Pan", false, 1, 100, 0);
        shop2Inventory.addItem(pan);

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

        /*Game Loop*/

        for (int day = 1; day < 6; day++) {
            //sets day to day 1
            date.IncrementCurrentDay();
            date.IncrementdayCounter();

            System.out.println("Day " + day);
            if (day != 0 ) {
                mp.MovePlayer(30, 10);
            }
            Random temp = new Random();
            System.out.println("Rolling New Event...");

            if(temp.nextBoolean()) {
                //Random Event

                String event = reg.GetEvent();

                //I AM SO SORRY THIS IS HOW IT MUST BE
                if (event.equals("Volcano")) {
                    System.out.println("A volcano erupts in the distance... You loose a random item!");
                    Random roll = new Random();
                    while (true) {
                        int index = roll.nextInt(playerInventory.getItemsLength()-1);
                        if (!playerInventory.getItem(index).getIndestructible()) {
                            System.out.println("You lost your '" + playerInventory.getItem(index).getName() + "'.");
                            playerInventory.getItem(index).setUsed(true);
                            playerInventory.getItem(index).setInventoryIdentifer(null);
                            break;
                        }
                        else {
                            System.out.println("It is unbreakable! Rolling again...");
                        }
                    }
                }
                else if (event.equals("broken wheel")) {
                    System.out.println("You broke a wagon wheel... You pay $10 to a stranger on the road to fix it");
                    player.decrementMoney(10);
                }
                else if (event.equals("aggressive native americans")) {
                    System.out.println("You barged into Native Americans on accident, and they do not seem too kind to you...");
                    System.out.println("Choose your weapon: ");
                    System.out.println(playerInventory.listInventory());
                    int choice = in.nextInt();
                    Weapon runAway = (Weapon) playerInventory.getItem(choice);
                        try {
                            runAway.reload();
                        }
                        catch (Exception e) {
                            System.out.println("That is not a weapon... You take 10 damage");
                            player.damage(10);
                        }
                        finally {
                            System.out.println("Using a warning shot, you barely make it away.");
                            runAway.setBulletCount(runAway.getBulletCount() - 1);
                        }
                }
                else if (event.equals("thief")) {

                }
                else if (event.equals("bad shortcut")) {

                }
                else if (event.equals("rainy day")) {

                }
                else if (event.equals("broken leg")) {

                }
                else if (event.equals("tired oxen")) {

                }
                else if (event.equals("misplaced food")) {

                }
                else if (event.equals("animals got to the food")) {

                }
                else if (event.equals("Kiss")) {

                }
                else if (event.equals("gold nugget")) {

                }
                else if (event.equals("nice native americans")) {

                }
                else if (event.equals("bundle of food")) {

                }
                else if (event.equals("deserted wagon")) {

                }
                else if (event.equals("miscounted food")) {

                }
                else if (event.equals("house")) {

                }
                else if (event.equals("wandering oxen")) {

                }
                else if (event.equals("good sleep")) {

                }
                else if (event.equals("Alex Frimel")) {

                }

            }
            else {
                System.out.println("Nothing particularly eventful happened...");
            }

            reg.IncrementProbabilityMultiplier();
            //checks if the player is in the location of a shop or monument
            if (mp.CheckMonument().equals("none") && !mp.CheckShop(shop1) && !mp.CheckShop(shop2)) {
                //displays a message if there's no shop or monument at the player's location
                System.out.println("There is not much to see in plain sight");
            }
            else if (mp.CheckShop(shop1)) {
                //Allows the player to interact with the shop if their is a shop at the player's location
                System.out.print("You manage to find the " + shop1.getName() + ".");
                System.out.println(" Would you like to Enter?");
                System.out.print("Press y to enter, or any other letter to ignore and pass by the shop. Then hit enter.");
                String decision = in.nextLine();

                if (decision.equals("y") || decision.equals("Y")) {
                    //enters the shop if the player types "y"
                    System.out.println("You enter the " + shop1.getName() + ".");
                    System.out.println("You have the options to buy...");
                    for (int i = 0; i < shop1Inventory.getItemsLength(); i++) {
                        System.out.println(i + ": " + shop1Inventory.getItem(i).getName());
                    }
                    System.out.println("To buy an item, put the number in front of said item and click enter, otherwise press any letter and enter to leave the shop.");

                    int shopItem;
                    //buys the item at the provided index or leaves the shop
                    shopItem = in.nextInt();
                    shop1.buyItem(player, shopItem);
                    System.out.println("You bought this item.");

                }
                else {
                    System.out.println("You leave the shop.");
                }
            }
            else if (mp.CheckShop(shop2)) {
                //Allows the player to interact with the shop if their is a shop at the player's location
                System.out.print("You manage to find the " + shop2.getName() + ".");
                System.out.println(" Would you like to Enter?");
                System.out.print("Press y to enter, or any other letter to ignore and pass by the shop. Then hit enter.");
                String decision = in.nextLine();

                if (decision.equals("y") || decision.equals("Y")) {
                    //enters the shop if the player types "y"
                    System.out.println("You enter the " + shop2.getName() + ".");
                    System.out.println("You have the options to buy...");
                    for (int i = 0; i < shop2Inventory.getItemsLength(); i++) {
                        System.out.println(i + ": " + shop1Inventory.getItem(i).getName());
                    }
                    System.out.println("To buy an item, put the number in front of said item and click enter, otherwise press any letter and enter to leave the shop.");

                    int shopItem;
                    //buys the item at the provided index or leaves the shop
                    shopItem = in.nextInt();
                    shop2.buyItem(player, shopItem);
                    System.out.println("You bought this item.");

                } else {
                    System.out.println("You leave the shop.");
                }
            }
            else {
                //tells the player if they're passing by a monument
                System.out.println("You pass by the " + mp.CheckMonument() + " today.");
            }

            //End of Day Summary
            System.out.println("Press Enter to Continue"); //fill this print statement in a bit
            in.nextLine();

        }


    }
}

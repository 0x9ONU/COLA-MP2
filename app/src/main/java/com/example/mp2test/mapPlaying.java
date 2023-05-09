package com.example.mp2test;

//Main Game Code will Go Here

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Random;

public class mapPlaying extends AppCompatActivity {

    public final static String SHOPNUMBER = "shopNumber";
    public final static String PLAYERMONEY = "playerMoney";
    public final static String MAP = "map";
    public final static String RND = "RandomEvent";
    public final static String PLAYERIVENTORY = "playerInventory";
    public final static String PLAYER = "player";
    public final static String MONEY = "money";

    public static boolean shopFound = false;

    public Map mp = new Map();

    public Date dt = new Date(3, 1, 1834);

    public RandomEventGenerator rnd = new RandomEventGenerator();

    public Member player = new Member(100, new Inventory(), "Jerry Clark", true, true, 0);

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {

            //this was commented out so it would work for the presensation, will probably need to be put back in and fixed
            /*if (shopFound) {
                Log.d("Shop", "Ended");
                //Remove change from player
                Intent intent = getIntent();

                player.decrementMoney(intent.getDoubleExtra(shopScreen.MONEYLEFT, 0));

                //Add Inventory from shop to the player's inventory
                Inventory exportInv = (Inventory) intent.getSerializableExtra(shopScreen.INVEXTRA);
                for (int i = 0; i < exportInv.getItemsLength(); i++) {
                    player.getInventory().addItem(exportInv.getItem(i));
                }

                shopFound = false;
            }*/
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_playing);

        //Receiving values from previous activities
        Intent receivingValues = getIntent();
        int month = (int) receivingValues.getIntExtra(monthSelection.MONTH, 1);

        //Creating the multiple classes for the game
        dt.setCurrentMonth(month);
        player.setMoney(receivingValues.getDoubleExtra(shopScreen.MONEYLEFT, 0));
        player.setInventory((Inventory) receivingValues.getSerializableExtra(shopScreen.SHOPITEM));
        player.getInventory().setMemberIdentifier(player);
        player.getInventory().setMaxItemCount(20);
        Wagon wagon = new Wagon(player);

        //DEBUG: Player Location

        mp.setPlayerLocationX(170);
        mp.setWagonLocationX(170);
        player.setxCoordinate(170);
        mp.setPreviousMonument(2);

        //Add shop items to player

        //Setup Buttons
        final Button proceed = findViewById(R.id.proceed_button);
        final Button inventory = findViewById(R.id.inventory_button);
        final Button mapLocation = findViewById(R.id.map_button);

        //Text Views
        final TextView health = findViewById(R.id.health);
        final TextView date = findViewById(R.id.day);
        final TextView miles = findViewById(R.id.miles);

        //Main Game Loop

        health.setText("Health: " + player.getHealth());
        date.setText("Date: " + dt.toString());
        miles.setText("Miles Traveled: " + mp.getPlayerLocationX());
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {      //Rnaomd events below
                String rndEvent = rnd.GetEvent();
                rnd.IncrementProbabilityMultiplier();
                if (rndEvent.equals("Kiss")) ;
                else if (rndEvent.equals("gold nugget")) {
                    player.incrementMoney(10);

                    //player.getInventory().addItem(new Food("test", 0.0, false, false, 0));
                } else if (rndEvent.equals("nice native americans"))
                    player.getInventory().addItem(new Food("Tanka Me A Lo", 0.5, false, false, 2, 5));
                else if (rndEvent.equals("bundle of food"))
                    player.getInventory().addItem(new Food("Bundle of Food", 0.25, false, false, 0, 5));
                else if (rndEvent.equals("deserted wagon"))
                    player.getInventory().addItem(new Food("Old cakes", 0.1, false, false, 3, 15));
                else if (rndEvent.equals("miscounted food")) {
                    for (int i = 0; i < player.getInventory().getItemsLength(); i++) {
                        try {
                            Food test = (Food) player.getInventory().getItem(i);
                        } catch (ClassCastException e) {
                            continue;
                        }
                        Food test = (Food) player.getInventory().getItem(i);
                        int pounds = test.getPounds();
                        test.setPounds(pounds + 10);
                        break;
                    }
                } else if (rndEvent.equals("house"))
                    player.getInventory().addItem(new Food("Blue-Berei Pie", 1, false, false, 3, 5));
                else if (rndEvent.equals("wandering oxen")) ;
                else if (rndEvent.equals("good sleep")) player.heal(5);
                else if (rndEvent.equals("Alex Fimel")) ;
                else if (rndEvent.equals("animals go to the food")) {
                    for (int i = 0; i < player.getInventory().getItemsLength(); i++) {
                        try {
                            Food test = (Food) player.getInventory().getItem(i);
                        } catch (ClassCastException e) {
                            continue;
                        }
                        Food test = (Food) player.getInventory().getItem(i);
                        int pounds = test.getPounds();
                        test.setPounds(pounds - 5);
                        break;
                    }
                } else if (rndEvent.equals("broken wheel")) {
                    if (player.getMoney() < 50) {
                        double tempMoney = player.getMoney();
                        player.setMoney(50 - tempMoney);
                    } else {
                        for (int i = 0; i < 6; i++) dt.IncrementCurrentDay();
                    }
                } else if (rndEvent.equals("aggressive native americans")) player.damage(5);
                else if (rndEvent.equals("thief")) {
                    int inventoryLength = player.getInventory().getItemsLength();
                    Random rand = new Random(System.currentTimeMillis());
                    int temp = 0;
                    while (true) {
                        temp = rand.nextInt(inventoryLength);
                        if (player.getInventory().getItem(temp).getIndestructible()) ;
                        else break;
                    }
                    player.getInventory().removeItem(temp);
                } else if (rndEvent.equals("bad shortcut")) {
                    for (int i = 0; i < 6; i++) dt.IncrementCurrentDay();
                } else if (rndEvent.equals("rainy day")) {
                    dt.IncrementCurrentDay();
                } else if (rndEvent.equals("broken leg")) {
                    dt.IncrementCurrentDay();
                    player.damage(10);
                } else if (rndEvent.equals("tired oxen")) dt.IncrementCurrentDay();
                else if (rndEvent.equals("misplaced food")) {
                    for (int i = 0; i < player.getInventory().getItemsLength(); i++) {
                        try {
                            Food test = (Food) player.getInventory().getItem(i);
                        } catch (ClassCastException e) {
                            continue;
                        }
                        Food test = (Food) player.getInventory().getItem(i);
                        int pounds = test.getPounds();
                        test.setPounds(pounds - 10);
                        break;
                    }
                } else if (rndEvent.equals("Volcano")) {
                    int inventoryLength = player.getInventory().getItemsLength();
                    if (inventoryLength > 0) {
                        Random rand = new Random(System.currentTimeMillis());
                        int temp = 0;
                        while (true) {
                            temp = rand.nextInt(inventoryLength);
                            if (player.getInventory().getItem(temp).getIndestructible()) ;
                            else break;
                        }
                        player.getInventory().removeItem(temp);
                    }
                } else {
                    dt.IncrementCurrentDay();
                }
                Random rand = new Random();
                int distance = rand.nextInt(11) + 15;
                mp.MovePlayer(distance, 0);
                mp.MoveWagon(distance, 0);
                player.move(distance, 0);
                Intent rndEventActivity = new Intent(mapPlaying.this, randomEventSplash.class);
                rndEventActivity.putExtra(RND, rndEvent);
                rndEventActivity.putExtra(MAP, mp);
                startActivity(rndEventActivity);

                int monument = mp.CheckMonument();
                Log.d("Monument", "" + monument);

                if (monument != -1) {
                    mp.setPlayerLocationX(mp.getMonumentLocationX(monument));
                    mp.setWagonLocationX(mp.getMonumentLocationX(monument));
                    player.setxCoordinate(mp.getMonumentLocationX(monument));
                    Intent monumentActivity = new Intent(mapPlaying.this, monumentDescription.class);
                    monumentActivity.putExtra(MAP, mp);
                    startActivity(monumentActivity);
                }


                int shop = mp.checkShop();
                Log.d("shop", "" + shop);

                if (shop > 0) {
                    shopFound = true;
                    Intent shopActivity = new Intent(mapPlaying.this, shopScreen.class);
                    shopActivity.putExtra(MONEY, player.getMoney());
                    shopActivity.putExtra(SHOPNUMBER, shop + 1);
                    activityResultLauncher.launch(shopActivity);
                }

                //Set display Values
                health.setText("Health: " + player.getHealth());
                date.setText("Date: " + dt.toString());
                miles.setText("Miles Traveled: " + mp.getPlayerLocationX());

                //Check if the Player died
                if (player.getHealth() <= 0) {
                    health.setText("Health: Dead");

                }
            }
        });

        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mapPlaying.this, inventoryScreen.class);
                intent.putExtra(PLAYERIVENTORY, (Serializable) player.getInventory());
                intent.putExtra(PLAYER, player);
                startActivity(intent);
            }
        });

    }

}

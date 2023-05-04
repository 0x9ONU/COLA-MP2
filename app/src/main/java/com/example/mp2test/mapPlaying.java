package com.example.mp2test;

//Main Game Code will Go Here

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mapPlaying extends AppCompatActivity {

    public final static String SHOPNUMBER = "shopNumber";
    public final static String PLAYERMONEY = "playerMoney";
    public final static String MAP = "map";
    public final static String RND = "RandomEvent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_playing);

        //Receiving values from previous activities
        Intent receivingValues = getIntent();
        int month = receivingValues.getIntExtra(monthSelection.MONTH, 1);
        Inventory shopItems = (Inventory) receivingValues.getSerializableExtra(shopScreen.SHOPITEM);

        //Creating the multiple classes for the game
        Map mp = new Map();
        Date dt = new Date(3, month, 1834);
        RandomEventGenerator rnd = new RandomEventGenerator();
        Inventory playerInventory = new Inventory();
        Member player = new Member(100, playerInventory, "Jerry Clark", true, true, receivingValues.getDoubleExtra(shopScreen.MONEYLEFT, 0));
        playerInventory.setMemberIdentifier(player);
        playerInventory.setMaxItemCount(20);
        Wagon wagon = new Wagon(player);

        //Add shop items to player
        for (int i = 0; i < shopItems.getItemsLength(); i++) {
            player.getInventory().addItem(shopItems.getItem(i));
        }

        //Setup Buttons
        final Button proceed = findViewById(R.id.proceed_button);
        final Button inventory = findViewById(R.id.inventory_button);
        final Button mapLocation = findViewById(R.id.map_button);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rndEvent = rnd.GetEvent();
                if (rndEvent.equals("Kiss")) ;
                else if (rndEvent.equals("gold nugget")) ;
                else if (rndEvent.equals("nice native americans"));
                else if (rndEvent.equals("bundle of food"));
                else if (rndEvent.equals("deserted wagon"));
                else if (rndEvent.equals("miscounted food"));
                else if (rndEvent.equals("house"));
                else if (rndEvent.equals("wandering oxen"));
                else if (rndEvent.equals("good sleep"));
                else if (rndEvent.equals("Alex Fimel"));
                else if (rndEvent.equals("animals go to the food"));
                else if (rndEvent.equals("broken wheel"));
                else if (rndEvent.equals("aggressive native americans"));
                else if (rndEvent.equals("thief"));
                else if (rndEvent.equals("bad shortcut"));
                else if (rndEvent.equals("rainy day"));
                else if (rndEvent.equals("broken leg"));
                else if (rndEvent.equals("tired oxen"));
                else if (rndEvent.equals("misplaced food"));
                else if (rndEvent.equals("Volcano"));
                Intent intent = new Intent(mapPlaying.this, randomEventSplash.class);
                intent.putExtra(RND, rndEvent);
                startActivity(intent);
            }
        });

        /*
        int i = 2;
        Intent intent = new Intent(mapPlaying.this, shopScreen.class);
        intent.putExtra(SHOPNUMBER, i);
        intent.putExtra(PLAYERMONEY, player.getMoney());
        i++;
        startActivity(intent);
         */

    }
}

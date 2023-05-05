package com.example.mp2test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class inventoryScreen extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.inventory_screen);

            //setup text
            final TextView items = (TextView) findViewById(R.id.editTextTextMultiLine);
            final TextView count = (TextView) findViewById(R.id.editTextTextMultiLine2);

            //money
                //figure out and set up this part later
            Intent intent = getIntent();
            double money = intent.getDoubleExtra(mapPlaying.PLAYERMONEY, 0);

            //setup inventory
            Inventory playerInventory = getIntent().getParcelableExtra(mapPlaying.PLAYERIVENTORY);
            int inventoryLength = playerInventory.getItemsLength();

            for (int i = 0; i < inventoryLength; i++) {
                String itemType = "Item";
                items.setText(playerInventory.getItem(i).getName());
                try {
                    Weapon test = (Weapon) playerInventory.getItem(i);
                    itemType = "Weapon";
                }
                catch (Exception e) {}

                try {
                    Food test = (Food) playerInventory.getItem(i);
                    itemType = "Food";
                }
                catch (Exception e) {}

                /*if (itemType.equals("Food")) {
                    Food food = (Food) shop.getItem(i);
                    item1Description.setText(itemType + "   Cost: " + food.getValue()*food.getPounds() + " Pounds: " + food.getPounds());
                }
                else if (itemType.equals("Weapon")) {
                    Weapon weapon = (Weapon) shop.getItem(i);
                    item1Description.setText(itemType + "   Cost: " + weapon.getValue() + " Ammo: " + weapon.getAmmo() + " Wear: " + weapon.getWear());
                }
                else {
                    item1Description.setText(itemType + "   Cost: " + shop.getItem(i).getValue() + " ");*/
                }
            finish();


        }
}

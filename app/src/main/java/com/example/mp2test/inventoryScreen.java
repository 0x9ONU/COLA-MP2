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

            Intent intent = getIntent();

            //setup text
            final TextView items = (TextView) findViewById(R.id.editTextTextMultiLine);
            final TextView count = (TextView) findViewById(R.id.editTextTextMultiLine2);

            //money
                //figure out and set up this part later
            double money = intent.getDoubleExtra(mapPlaying.PLAYERMONEY, 0);

            //setup inventory
            Inventory playerInventory = getIntent().getParcelableExtra(mapPlaying.PLAYERIVENTORY);
            int inventoryCounted = 0;
            int inventoryLength = 5 /*playerInventory.getItemsLength()*/;

            for (int i = 0; i < inventoryLength; i++) {
                String itemType = "Item";
                String itemTest = items + playerInventory.getItem(i).getName() + "\n";
                items.setText(itemTest /*playerInventory.getItem(i).getName()*/);
                /*try {
                    Weapon test = (Weapon) playerInventory.getItem(i);
                    itemType = "Weapon";
                    inventoryCounted++;
                } catch (Exception e) {
                }

                try {
                    Food test = (Food) playerInventory.getItem(i);
                    itemType = "Food";
                    inventoryCounted++;
                } catch (Exception e) {
                }*/

                /*if (itemType.equals("Food")) {
                    Food food = (Food) shop.getItem(i);
                    item1Description.setText(itemType + "   Cost: " + food.getValue()*food.getPounds() + " Pounds: " + food.getPounds());
                }
                else if (itemType.equals("Weapon")) {
                    Weapon weapon = (Weapon) shop.getItem(i);
                    item1Description.setText(itemType + "   Cost: " + weapon.getValue() + " Ammo: " + weapon.getAmmo() + " Wear: " + weapon.getWear());
                }
                else {
                    item1Description.setText(itemType + "   Cost: " + shop.getItem(i).getValue() + " ");
                } */
            }
            /*if (inventoryCounted == inventoryLength) {
                finish();
            }
            else {
                finish();
            }*/
            //finish();


        }
}

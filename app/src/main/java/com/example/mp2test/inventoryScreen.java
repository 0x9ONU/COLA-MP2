/**
 * File Name: InventoryScreen.java
 * Author: Ashton Beresford
 * Date: 4/26/23
 * Description: The class responsible displaying the player's inventory
 */

package com.example.mp2test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class inventoryScreen extends AppCompatActivity {

    public final static String HEAL = "heal";
    public final static String NEWINV = "new inventory after healing";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_screen);                                                  //sets display to inventory screen

        //setup text
        final TextView items = (TextView) findViewById(R.id.editTextTextMultiLine);
        final TextView count = (TextView) findViewById(R.id.editTextTextMultiLine2);
        final TextView moneyText = (TextView) findViewById(R.id.invMoney);

        final Button back = findViewById(R.id.back_button);
        final Button heal = findViewById(R.id.heal);


        Intent intent = getIntent();

        Member player = (Member) intent.getSerializableExtra(mapPlaying.PLAYER);

        moneyText.setText("$" + player.getMoney());


        //setup inventory
        Inventory playerInventory = (Inventory) getIntent().getSerializableExtra(mapPlaying.PLAYERIVENTORY);
        int inventoryLength = playerInventory.getItemsLength();

        //get Player



        String exportTextTitle = "";
        String exportTextDetail = "";

        for (int i = 0; i < inventoryLength; i++) {                                                 //makes the list of items
            String itemType = "Item";
            exportTextTitle += playerInventory.getItem(i).getName() + "\n";
            try {
                Weapon test = (Weapon) playerInventory.getItem(i);
                itemType = "Weapon";
            } catch (Exception e) {
            }

            try {
                Food test = (Food) playerInventory.getItem(i);
                itemType = "Food";
            } catch (Exception e) {
            }

            try {
                Valuable test = (Valuable) playerInventory.getItem(i);
                itemType = "Valuable";
            } catch (Exception e) {
            }

            if (itemType.equals("Food")) {
                Food food = (Food) playerInventory.getItem(i);
                exportTextDetail += itemType + "   Cost: " + food.getValue()*food.getPounds() + " Pounds: " + food.getPounds() + "\n";
            }
            else if (itemType.equals("Weapon")) {
                Weapon weapon = (Weapon) playerInventory.getItem(i);
                exportTextDetail += itemType + "   Cost: " + weapon.getValue() + " Ammo: " + weapon.getAmmo() + " Wear: " + weapon.getWear() + "\n";
            }
            else if (itemType.equals("Valuable")) {
                Valuable valuable = (Valuable) playerInventory.getItem(i);
                exportTextDetail += itemType + "Cost: " + valuable.getValue() + "\n";
            }
            else {
                exportTextDetail += itemType + "   Cost: " + playerInventory.getItem(i).getValue() + "\n";
            }
        }

        items.setText(exportTextTitle);
        count.setText(exportTextDetail);

        back.setOnClickListener(new View.OnClickListener() {                                        //returns to main screen on click
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        heal.setOnClickListener(new View.OnClickListener() {                                        //heals the player if they have healing items
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(inventoryScreen.this, mapPlaying.class);
                intent.putExtra(HEAL, 1);
                setResult(3, intent);
                finish();
            }
        });


    }
}
package com.example.mp2test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
            final TextView moneyText = (TextView) findViewById(R.id.invMoney);

            final Button back = findViewById(R.id.back_button);

            Member player = (Member) intent.getSerializableExtra(mapPlaying.PLAYER);

            moneyText.setText("$" + player.getMoney());


            //setup inventory
            Inventory playerInventory = (Inventory) getIntent().getSerializableExtra(mapPlaying.PLAYERIVENTORY);
            int inventoryLength = playerInventory.getItemsLength();

            //get Player



            String exportTextTitle = "";
            String exportTextDetail = "";

            for (int i = 0; i < inventoryLength; i++) {
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

                if (itemType.equals("Food")) {
                    Food food = (Food) playerInventory.getItem(i);
                    exportTextDetail += itemType + "   Cost: " + food.getValue()*food.getPounds() + " Pounds: " + food.getPounds() + "\n";
                }
                else if (itemType.equals("Weapon")) {
                    Weapon weapon = (Weapon) playerInventory.getItem(i);
                    exportTextDetail +=  "   Cost: " + weapon.getValue() + " Ammo: " + weapon.getAmmo() + " Wear: " + weapon.getWear() + "\n";
                }
                else {
                    exportTextDetail += itemType + "   Cost: " + playerInventory.getItem(i).getValue() + "\n";
                }
            }

            items.setText(exportTextTitle);
            count.setText(exportTextDetail);

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });


        }
}

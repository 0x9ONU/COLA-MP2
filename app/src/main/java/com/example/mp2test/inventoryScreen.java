package com.example.mp2test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class inventoryScreen extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.inventory_screen);

            Inventory playerInventory = getIntent().getParcelableExtra(mapPlaying.PLAYERIVENTORY);


        }
}

package com.example.mp2test;

//Main Game Code will Go Here

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class mapPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_playing);
        //Receiving values from previous activities
        Intent receivingValues = getIntent();
        int month = receivingValues.getIntExtra(monthSelection.MONTH, 0);
        Inventory shop1Items = receivingValues.getSerializableExtra(shopScreen., new Inventory());
        //Creating the multiple classes for the game
        Map mp = new Map();
    }
}

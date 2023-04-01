package com.example.mp2test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TEST CODE
        Weapon testWeapon = new Weapon();
        Inventory testInventory = new Inventory();

        testInventory.addItem(testWeapon);
    }
}
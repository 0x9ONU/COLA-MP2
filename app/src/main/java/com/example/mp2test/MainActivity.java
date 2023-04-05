package com.example.mp2test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    Item itm = new Item() {
        @Override
        public double useItem(Item itemTarget, Member memberTarget) {
            return 0;
        }

        @Override
        public double sellItem() {
            return 0;
        }
    };
    Map mp = new Map();
    Date date = new Date();
    Member member = new Member();
    RandomEventGenerator reg = new RandomEventGenerator();
    Wagon wag = new Wagon(member);
    Weapon wep = new Weapon();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //USE THIS FOR EXPORTING TO THE CONSOLE
        Log.d("MainActivity", "Test");
        Log.d("MainActivity","Test2");
        /*








        //TEST CODE
       // Weapon testWeapon = new Weapon();
        //Food testFood = new Food();
        //Inventory testInventory = new Inventory();
        //Inventory testInventory2 = new Inventory();

        //testInventory.addItem(testWeapon);
        //testInventory2.addItem(testFood);

        //testInventory.giveItem(0, testInventory2);
         */
    }
}


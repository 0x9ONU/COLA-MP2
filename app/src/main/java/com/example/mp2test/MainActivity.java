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

    //shop 1, at 180 miles and same place (and name) as the Hollenberg Pony Express Station
    Member shopKeeper1 = new Member();
    Inventory shop1Inventory = new Inventory();
    //add things for the shop to sell here
    //also here add any money the shopkeeper will already have
    Shop shop1 = new Shop(60, 0, "The Hollenberg Pony Express Station", shop1Inventory, shopKeeper1);

    //add additional shops here in the same format as above

    //An NPC (DOESN'T DO ANYTHING AS OF NOW) located at the Gardner Junction monument
    Member gardnerNPC = new Member("Gardner NPC", 44);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
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


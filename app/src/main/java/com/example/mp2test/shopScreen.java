package com.example.mp2test;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class shopScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shops_screen);
        setupShops();
    }

    public void setupShops() {
        Intent intent = getIntent();
        int shopValue = intent.getIntExtra(monthSelection.MONTH, -1);
        //shopValue += int.getIntExtra
        if (shopValue == -1) {
            Shop shopNull = new Shop();
        }
        switch (shopValue) {
            case 0:
                Member shopKeeper1 = new Member("Independence Shop Keeper", 0);
                Inventory shop1Inventory = new Inventory(10, shopKeeper1);
                shopKeeper1.setInventory(shop1Inventory);
                Shop shop1 = new Shop(0, 0, "shop1", shop1Inventory, shopKeeper1);
            case 1:
                Member shopKeeper2 = new Member("Independence Shop Keeper", 180);
                Inventory shop2Inventory = new Inventory(10, shopKeeper2);
                shopKeeper2.setInventory(shop2Inventory);
                Shop shop2 = new Shop(180, 0, "shop1", shop2Inventory, shopKeeper2);
        }
    }
}

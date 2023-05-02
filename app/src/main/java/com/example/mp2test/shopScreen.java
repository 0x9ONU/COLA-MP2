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
                Shop shop1 = new Shop(0, 0, "Independence Shop", shop1Inventory, shopKeeper1);
                Food potatoes = new Food("Sack of Potatoes", 0.5, false, false, 0, 15);
                Food beans = new Food("Can of Beans", 0.75, false, false, 2, 20);
                Weapon DBS = new Weapon(40, "Double Barrel Shotgun", true, 1, 20, 0);
                DBS.setMaxBulletCount(2);
                DBS.setBulletCount(2);
                shop1.addItem(potatoes);
                shop1.addItem(beans);
                shop1.addItem(DBS);
                break;
            case 1:
                Member shopKeeper2 = new Member("Hollenberg Shop Keeper", 180);
                Inventory shop2Inventory = new Inventory(10, shopKeeper2);
                shopKeeper2.setInventory(shop2Inventory);
                Shop shop2 = new Shop(180, 0, "Hollenberg Shop", shop2Inventory, shopKeeper2);
                Food fish = new Food("Sack of Cod", 1, false, false, 1, 25);
                Food berries = new Food("Bundle of Berries", 0.75, false, false, 0, 10);
                Item ps5 = new Item(20, "Piano Stool Five", true, false) {
                    /**
                     * @param itemTarget   What the Item will this affect? May or may not be used.
                     * @param memberTarget What Member/Person will this affect? May or may not be used.
                     * @return
                     */
                    @Override
                    public double useItem(Item itemTarget, Member memberTarget) {
                        return 0;
                    }
                };
                Weapon revolver = new Weapon(5, "Broken Revolver", true, 0, 20, 90);
                shop2.addItem(fish);
                shop2.addItem(berries);
                shop2.addItem(ps5);
                shop2.addItem(revolver);
                break;
            case 2:
                Member shopKeeper3 = new Member("Slimmy Jimmy", 335);
                Inventory shop3Inventory = new Inventory(10, shopKeeper3);
                shopKeeper3.setInventory(shop3Inventory);
                Shop shop3 = new Shop(335, 0, "Fort Kearny Tavern", shop3Inventory, shopKeeper3);
                Food sunflower = new Food("Sunflower Seeds", 0.80, false, false, 0, 10);
                Food apple = new Food("Bundle of Apples", 0.85, false, false, 0, 20);
                Item mirror = new Item(20, "Expensive Mirror", true, true) {
                    /**
                     * @param itemTarget   What the Item will this affect? May or may not be used.
                     * @param memberTarget What Member/Person will this affect? May or may not be used.
                     * @return
                     */
                    @Override
                    public double useItem(Item itemTarget, Member memberTarget) {
                        return 0;
                    }
                };
                shop3.addItem(sunflower);
                shop3.addItem(apple);
                shop3.addItem(mirror);
                break;
            case 3:
                Member shopKeeper4 = new Member("Mary Brown", 564);
                Inventory shop4Inventory = new Inventory(10, shopKeeper4);
                shopKeeper4.setInventory(shop4Inventory);
                Shop shop4 = new Shop(564, 0, "Mary's Mercantile",shop4Inventory, shopKeeper4);
                break;
            case 4:
                Member shopKeeper5 = new Member("Rebecca Taylor", 660);
                Inventory shop5Inventory = new Inventory(10, shopKeeper5);
                shopKeeper5.setInventory(shop5Inventory);
                Shop shop5 = new Shop(660, 0, "High Plains Trader",shop5Inventory, shopKeeper5);
                break;
            case 5:
                Member shopKeeper6 = new Member("David Miller", 975);
                Inventory shop6Inventory = new Inventory(10, shopKeeper6);
                shopKeeper6.setInventory(shop6Inventory);
                Shop shop6 = new Shop(975, 0, "Fort Bridger Frontier Supplies",shop6Inventory, shopKeeper6);
                break;
        }
    }
}

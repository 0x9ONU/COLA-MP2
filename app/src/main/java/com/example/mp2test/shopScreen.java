package com.example.mp2test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class shopScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shops_screen);
        Intent intent = getIntent();
        int shopValue = intent.getIntExtra(monthSelection.MONTH, -1);
        if (shopValue > -1) shopValue = 0;
        //shopValue += int.getIntExtra
        //Setup Text
        final TextView title = (TextView) findViewById(R.id.shopName);
        final TextView item1 = (TextView) findViewById(R.id.item1);
        final TextView item2 = (TextView) findViewById(R.id.item2);
        final TextView item3 = (TextView) findViewById(R.id.item3);
        final TextView item4 = (TextView) findViewById(R.id.item4);
        final TextView item5 = (TextView) findViewById(R.id.item5);
        final TextView item1Description = (TextView) findViewById(R.id.item1Description);
        final TextView item2Description = (TextView) findViewById(R.id.item2Description);
        final TextView item3Description = (TextView) findViewById(R.id.item3Description);
        final TextView item4Description = (TextView) findViewById(R.id.item4Description);
        final TextView item5Description = (TextView) findViewById(R.id.item5Description);
        Shop shop = setupShop(shopValue);
        int inventoryLength = shop.getInventory().getItemsLength();

        for (int i = 0; i < inventoryLength; i++) {
            title.setText(shop.getName());
            item1.setText(shop.getItem(i).getName());
            String itemType = "Item";
            try {
                Weapon test = (Weapon) shop.getItem(i);
                itemType = "Weapon";
            }
            catch (Exception e) {}

            try {
                Food test = (Food) shop.getItem(i);
                itemType = "Food";
            }
            catch (Exception e) {}
            if (itemType.equals("Food")) {
                Food food = (Food) shop.getItem(i);
                item1Description.setText(itemType + "   Cost: " + food.getValue()*food.getPounds() + " Pounds: " + food.getPounds());
            }
            else if (itemType.equals("Weapon")) {
                Weapon weapon = (Weapon) shop.getItem(i);
                item1Description.setText(itemType + "   Cost: " + weapon.getValue() + " Ammo: " + weapon.getAmmo() + " Wear: " + weapon.getWear());
            }
            else {
                item1Description.setText(itemType + "   Cost: " + shop.getItem(i).getValue() + " ");
            }

        }

        setupBackButton(shop);
    }


    private Shop setupShop(int shopValue) {
        if (shopValue == -1) {
            Shop shopNull = new Shop();
        }
        switch (shopValue) {
            case 0:
                Member shopKeeper1 = new Member("Independence Shop Keeper", 0);
                Inventory shop1Inventory = new Inventory(4, shopKeeper1);
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
                return shop1;
            case 1:
                Member shopKeeper2 = new Member("Hollenberg Shop Keeper", 180);
                Inventory shop2Inventory = new Inventory(4, shopKeeper2);
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
                return shop2;
            case 2:
                Member shopKeeper3 = new Member("Slimmy Jimmy", 335);
                Inventory shop3Inventory = new Inventory(3, shopKeeper3);
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
                return shop3;
            case 3:
                Member shopKeeper4 = new Member("Mary Brown", 564);
                Inventory shop4Inventory = new Inventory(4, shopKeeper4);
                shopKeeper4.setInventory(shop4Inventory);
                Shop shop4 = new Shop(564, 0, "Mary's Mercantile", shop4Inventory, shopKeeper4);
                Food pineNuts = new Food("Pine Nuts", 0.85, false, false, 0, 10);
                Food cake = new Food("Slice of Cake", 1, false, false, 3, 1);
                Food militaryRations = new Food("Military Rations", 0.6, false, false, 2, 20);
                Weapon beatRifle = new Weapon(10, "Beaten Rifle", true, 2, 8, 75);
                shop4.addItem(pineNuts);
                shop4.addItem(cake);
                shop4.addItem(militaryRations);
                shop4.addItem(beatRifle);
                return shop4;
            case 4:
                Member shopKeeper5 = new Member("Rebecca Taylor", 660);
                Inventory shop5Inventory = new Inventory(2, shopKeeper5);
                shopKeeper5.setInventory(shop5Inventory);
                Shop shop5 = new Shop(660, 0, "High Plains Trader", shop5Inventory, shopKeeper5);
                Item chair = new Item(5, "Oak Chair", true, true) {
                    @Override
                    public double useItem(Item itemTarget, Member memberTarget) {
                        return 0;
                    }
                };
                Food carrots = new Food("Sack of Carrots", 0.9, false, false, 0, 10);
                shop5.addItem(chair);
                shop5.addItem(carrots);
                return shop5;
            case 5:
                Member shopKeeper6 = new Member("David Miller", 975);
                Inventory shop6Inventory = new Inventory(3, shopKeeper6);
                shopKeeper6.setInventory(shop6Inventory);
                Shop shop6 = new Shop(975, 0, "Fort Bridger Frontier Supplies", shop6Inventory, shopKeeper6);
                Food rottenFood = new Food("Mysterious Food", 0.1, false, false, 0, 30);
                rottenFood.setHealthValue(0);
                Food premiumRations = new Food("Premium Rations", 0.8, false, false, 2, 15);
                Weapon fryingPan = new Weapon(100, "Golden Frying Pan", false, 2, 1000, 0);
                fryingPan.setIndestructible(true);
                fryingPan.setBulletCount(1);
                fryingPan.setMaxBulletCount(1);
                shop6.addItem(rottenFood);
                shop6.addItem(premiumRations);
                shop6.addItem(fryingPan);
                return shop6;
        }

        return new Shop();
    }

    private void setupBackButton(Shop shop) {
        final Button backButton = (Button) findViewById(R.id.back_button5);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(shopScreen.this, mapPlaying.class);
                //intent.putExtra("SHOPITEM", shop.getInventory());
                startActivity(intent);
            }
        });
    }

}



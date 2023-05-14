/**
 * File Name: shopScreen.java
 * Author: Ethan Berei
 * Date: 4/19/23
 * Description: The class responsible for displaying the shops and their information
 */

package com.example.mp2test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class shopScreen extends AppCompatActivity {
    public static final String SHOPITEM = "shopItem";
    public static final String MONEYLEFT = "moneyLeft";
    public static final String MONTH = "month";
    public static final String INVEXTRA = "invExtra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Get values from previous activities
        double money = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shops_screen);
        Intent intent = getIntent();
        int shopValue = 0;
        shopValue += intent.getIntExtra(mapPlaying.SHOPNUMBER, 0);
        if (shopValue == 0) {
            money = 1000;
        }
        else {
            money = intent.getDoubleExtra(mapPlaying.MONEY, 0);
        }

        //Setup Text
        final TextView title = (TextView) findViewById(R.id.shopName);
        final TextView item1 = (TextView) findViewById(R.id.item1);
        item1.setText("");
        final TextView item2 = (TextView) findViewById(R.id.item2);
        item2.setText("");
        final TextView item3 = (TextView) findViewById(R.id.item3);
        item3.setText("");
        final TextView item4 = (TextView) findViewById(R.id.health);
        item4.setText("");
        final TextView item5 = (TextView) findViewById(R.id.miles);
        item5.setText("");
        final TextView item1Description = (TextView) findViewById(R.id.item1Description);
        item1Description.setText("");
        final TextView item2Description = (TextView) findViewById(R.id.item2Description);
        item2Description.setText("");
        final TextView item3Description = (TextView) findViewById(R.id.item3Description);
        item3Description.setText("");
        final TextView item4Description = (TextView) findViewById(R.id.item4Description);
        item4Description.setText("");
        final TextView item5Description = (TextView) findViewById(R.id.item5Description);
        item5Description.setText("");
        final TextView moneyText = (TextView) findViewById(R.id.moneyShop);
        moneyText.setText("$ " + money);
        //Setup Shop
        Shop shop = setupShop(shopValue);
        int inventoryLength = shop.getInventory().getItemsLength();
        title.setText(shop.getName());

        for (int i = 0; i < inventoryLength; i++) {
            String itemType = "Item";
            switch (i) {
                case 0:
                    item1.setText(shop.getItem(i).getName());
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

                    try {
                        Valuable test = (Valuable) shop.getItem(i);
                        itemType = "Valuable";
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
                    else if (itemType.equals("Valuable")) {
                        Valuable valuable = (Valuable) shop.getItem(i);
                        item1Description.setText(itemType + "   Cost: " + valuable.getValue());
                    }
                    else {
                        item1Description.setText(itemType + "   Cost: " + shop.getItem(i).getValue() + " ");
                    }
                    break;
                case 1:
                    item2.setText(shop.getItem(i).getName());
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

                    try {
                        Valuable test = (Valuable) shop.getItem(i);
                        itemType = "Valuable";
                    }
                    catch (Exception e) {}


                    if (itemType.equals("Food")) {
                        Food food = (Food) shop.getItem(i);
                        item2Description.setText(itemType + "   Cost: " + food.getValue()*food.getPounds() + " Pounds: " + food.getPounds());
                    }
                    else if (itemType.equals("Weapon")) {
                        Weapon weapon = (Weapon) shop.getItem(i);
                        item2Description.setText(itemType + "   Cost: " + weapon.getValue() + " Ammo: " + weapon.getAmmo() + " Wear: " + weapon.getWear());
                    }
                    else if (itemType.equals("Valuable")) {
                        Valuable valuable = (Valuable) shop.getItem(i);
                        item2Description.setText(itemType + "   Cost: " + valuable.getValue());
                    }
                    else {
                        item2Description.setText(itemType + "   Cost: " + shop.getItem(i).getValue() + " ");
                    }
                    break;
                case 2:
                    item3.setText(shop.getItem(i).getName());
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

                    try {
                        Valuable test = (Valuable) shop.getItem(i);
                        itemType = "Valuable";
                    }
                    catch (Exception e) {}


                    if (itemType.equals("Food")) {
                        Food food = (Food) shop.getItem(i);
                        item3Description.setText(itemType + "   Cost: " + food.getValue()*food.getPounds() + " Pounds: " + food.getPounds());
                    }
                    else if (itemType.equals("Weapon")) {
                        Weapon weapon = (Weapon) shop.getItem(i);
                        item3Description.setText(itemType + "   Cost: " + weapon.getValue() + " Ammo: " + weapon.getAmmo() + " Wear: " + weapon.getWear());
                    }
                    else if (itemType.equals("Valuable")) {
                        Valuable valuable = (Valuable) shop.getItem(i);
                        item3Description.setText(itemType + "   Cost: " + valuable.getValue());
                    }
                    else {
                        item3Description.setText(itemType + "   Cost: " + shop.getItem(i).getValue() + " ");
                    }
                    break;
                case 3:
                    item4.setText(shop.getItem(i).getName());
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

                    try {
                        Valuable test = (Valuable) shop.getItem(i);
                        itemType = "Valuable";
                    }
                    catch (Exception e) {}


                    if (itemType.equals("Food")) {
                        Food food = (Food) shop.getItem(i);
                        item4Description.setText(itemType + "   Cost: " + food.getValue()*food.getPounds() + " Pounds: " + food.getPounds());
                    }
                    else if (itemType.equals("Weapon")) {
                        Weapon weapon = (Weapon) shop.getItem(i);
                        item4Description.setText(itemType + "   Cost: " + weapon.getValue() + " Ammo: " + weapon.getAmmo() + " Wear: " + weapon.getWear());
                    }
                    else if (itemType.equals("Valuable")) {
                        Valuable valuable = (Valuable) shop.getItem(i);
                        item4Description.setText(itemType + "   Cost: " + valuable.getValue());
                    }
                    else {
                        item4Description.setText(itemType + "   Cost: " + shop.getItem(i).getValue() + " ");
                    }
                    break;
                case 4:
                    item5.setText(shop.getItem(i).getName());
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

                    try {
                        Valuable test = (Valuable) shop.getItem(i);
                        itemType = "Valuable";
                    }
                    catch (Exception e) {}


                    if (itemType.equals("Food")) {
                        Food food = (Food) shop.getItem(i);
                        item5Description.setText(itemType + "   Cost: " + food.getValue()*food.getPounds() + " Pounds: " + food.getPounds());
                    }
                    else if (itemType.equals("Weapon")) {
                        Weapon weapon = (Weapon) shop.getItem(i);
                        item5Description.setText(itemType + "   Cost: " + weapon.getValue() + " Ammo: " + weapon.getAmmo() + " Wear: " + weapon.getWear());
                    }
                    else if (itemType.equals("Valuable")) {
                        Valuable valuable = (Valuable) shop.getItem(i);
                        item5Description.setText(itemType + "   Cost: " + valuable.getValue());
                    }
                    else {
                        item5Description.setText(itemType + "   Cost: " + shop.getItem(i).getValue() + " ");
                    }
                    break;
            }

        }
        setupBackButton(shop, money, shopValue);
    }


    private Shop setupShop(int shopValue) {
        if (shopValue == -1) {
            Shop shopNull = new Shop();
        }
        switch (shopValue) {
            case 0:
                Member shopKeeper1 = new Member("Independence Shop Keeper", 0);
                Inventory shop1Inventory = new Inventory(5, shopKeeper1);
                shopKeeper1.setInventory(shop1Inventory);
                Shop shop1 = new Shop(0, 0, "Independence Shop", shop1Inventory, shopKeeper1);
                Food potatoes = new Food("Sack of Potatoes", 0.5, false, false, 0, 15);
                Food beans = new Food("Can of Beans", 0.75, false, false, 2, 20);
                Food basicRations = new Food("Basic Rations", 0.6, false, false, 2, 200);
                Food cookies = new Food("Cookies", 0.75, false, false, 3, 10);
                Weapon DBS = new Weapon(1000, "Double Barrel Shotgun", true, 1, 20, 0);
                DBS.setMaxBulletCount(2);
                DBS.setBulletCount(2);
                shop1.addItem(potatoes);
                shop1.addItem(beans);
                shop1.addItem(basicRations);
                shop1.addItem(cookies);
                shop1.addItem(DBS);
                return shop1;
            case 1:
                Member shopKeeper2 = new Member("Hollenberg Shop Keeper", 180);
                Inventory shop2Inventory = new Inventory(4, shopKeeper2);
                shopKeeper2.setInventory(shop2Inventory);
                Shop shop2 = new Shop(180, 0, "Hollenberg Shop", shop2Inventory, shopKeeper2);
                Food fish = new Food("Sack of Cod", 1, false, false, 1, 25);
                Food berries = new Food("Bundle of Berries", 0.75, false, false, 0, 10);
                Item ps5 = new Valuable(20, "Piano Stool Five", true, false);
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
                Item mirror = new Valuable(20, "Expensive Mirror", true, true);
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
                Item chair = new Valuable(5, "Oak Chair", true, true);
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

    private void setupBackButton(Shop shop, double money, int shopValue) {
        final Button backButton = (Button) findViewById(R.id.back_button5);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CheckBox item1Check = (CheckBox) findViewById(R.id.item1CheckBox);
                final CheckBox item2Check = (CheckBox) findViewById(R.id.item2CheckBox);
                final CheckBox item3Check = (CheckBox) findViewById(R.id.item3CheckBox);
                final CheckBox item4Check = (CheckBox) findViewById(R.id.item4CheckBox);
                final CheckBox item5Check = (CheckBox) findViewById(R.id.item5CheckBox);
                final TextView error = (TextView) findViewById(R.id.errorMessageShop);
                //final TextView moneyLeft = (TextView) findViewById(R.id.moneyShop);

                Inventory exportInv = new Inventory();
                exportInv.setMaxItemCount(5);

                double total = 0;

                if (item1Check.isChecked()) {
                    try {
                        shop.getItem(0);
                        try {
                            Food test = (Food) shop.getItem(0);
                            total += test.getValue() * test.getPounds();
                        }
                        catch (Exception e) {
                            total += shop.getItem(0).getValue();
                        }
                        finally {
                            exportInv.addItem(shop.getItem(0));
                        }
                    }
                    catch (IndexOutOfBoundsException e) {}
                }
                if (item2Check.isChecked()) {
                    try {
                        shop.getItem(1);
                        try {
                            Food test = (Food) shop.getItem(1);
                            total += test.getValue() * test.getPounds();
                        }
                        catch (Exception e) {
                            total += shop.getItem(1).getValue();
                        }
                        finally {
                            exportInv.addItem(shop.getItem(1));
                        }
                    }
                    catch (IndexOutOfBoundsException e) {}
                }
                if (item3Check.isChecked()) {
                    try {
                        shop.getItem(2);
                        try {
                            Food test = (Food) shop.getItem(2);
                            total += test.getValue() * test.getPounds();
                        }
                        catch (Exception e) {
                            total += shop.getItem(2).getValue();
                        }
                        finally {
                            exportInv.addItem(shop.getItem(2));
                        }
                    }
                    catch (IndexOutOfBoundsException e) {}
                }
                if (item4Check.isChecked()) {
                    try {
                        shop.getItem(3);
                        try {
                            Food test = (Food) shop.getItem(3);
                            total += test.getValue() * test.getPounds();
                        }
                        catch (Exception e) {
                            total += shop.getItem(3).getValue();
                        }
                        finally {
                            exportInv.addItem(shop.getItem(3));
                        }
                    }
                    catch (IndexOutOfBoundsException e) {}
                }
                if (item5Check.isChecked()) {
                    try {
                        shop.getItem(4);
                        try {
                            Food test = (Food) shop.getItem(4);
                            total += test.getValue() * test.getPounds();
                        }
                        catch (Exception e) {
                            total += shop.getItem(4).getValue();
                        }
                        finally {
                            exportInv.addItem(shop.getItem(4));
                        }
                    }
                    catch (IndexOutOfBoundsException e) {}
                }
                Log.d("Debug", "Total: " + total);
                if (total > money) {
                    error.setText("Not enough funds.");
                }
                else {
                    double change = money - total;
                    //moneyLeft.setText("$ " + change);
                    //int temp = intent.getIntExtra(monthSelection.MONTH, 1);
                    //intent.putExtra(MONTH, temp);
                    if (shopValue == 0) {
                        Intent intent = new Intent(shopScreen.this, mapPlaying.class);
                        intent.putExtra(SHOPITEM, exportInv);
                        intent.putExtra(MONEYLEFT, change);
                        startActivity(intent);
                    }
                    else {
                        Intent shopReturn = new Intent(shopScreen.this, mapPlaying.class);
                        shopReturn.putExtra(INVEXTRA, exportInv);
                        shopReturn.putExtra(MONEYLEFT, change);
                        setResult(2, shopReturn);
                        finish();
                    }
                }
            }
        });
    }

}



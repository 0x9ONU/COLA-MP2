package com.example.mp2test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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

        final Button start = findViewById(R.id.startButton);
        final ImageView wagon = findViewById(R.id.wagon);
        final ImageView Oxen = findViewById(R.id.OXEN);
        final ImageView Oxen2 = findViewById(R.id.OXEN2);
        final ImageView Oxen3 = findViewById(R.id.OXEN3);
        final ImageView Oxen4 = findViewById(R.id.OXEN4);
        final ImageView startBackground = findViewById(R.id.background);
        final Button next = findViewById(R.id.Nextbutton);
        final TextView bio = findViewById(R.id.textView4);
        final TextView age = findViewById(R.id.textView3);
        final TextView name = findViewById(R.id.textView2);
        final TextView month = findViewById(R.id.Month);
        final Button shopNext = findViewById(R.id.ShopNext);
        final Button march = findViewById(R.id.MarchButton);
        final Button april = findViewById(R.id.AprilButton);
        final Button may = findViewById(R.id.MayButton);
        final Button june = findViewById(R.id.JuneButton);
        final Button july = findViewById(R.id.Julybutton);
        final Button information = findViewById(R.id.MonthMore);
        final Button back = findViewById(R.id.BackButton);
        final TextView moreInfo = findViewById(R.id.MoreInfoText);
        final Button yoke = findViewById(R.id.OxenButton);
        final Button ammunition = findViewById(R.id.AmmunitionButton);
        final Button clothes = findViewById(R.id.ClothesButton);
        final Button food = findViewById(R.id.FoodButton);
        final Button parts = findViewById(R.id.SparePartsButton);
        final TextView shop = findViewById(R.id.Shop);
        final ImageView oxenYoke = findViewById(R.id.OxenYoke);
        final ImageView shirt = findViewById(R.id.Clothes);
        final ImageView sandwich = findViewById(R.id.Food);
        final ImageView ammo = findViewById(R.id.Ammo);
        final ImageView spares = findViewById(R.id.Spare);
        final TextView balance = findViewById(R.id.Balance);
        final TextView balanceAmount = findViewById(R.id.BalanceAmount);
        final TextView infoYoke = findViewById(R.id.YokeInfo);
        final TextView yokeNumQues = findViewById(R.id.NumYoke);
        final EditText numYoke = findViewById(R.id.NumDesiredYokes);
        final Button shopBack = findViewById(R.id.YokeBack);

        final ImageView clothing = findViewById(R.id.Shirt);
        final TextView infoClothes = findViewById(R.id.ClothesInfo);
        final TextView clothesQues = findViewById(R.id.AmountClothes);
        final EditText numClothes = findViewById(R.id.ClothesValue);

        final ImageView beef = findViewById(R.id.sandwich);
        final TextView infoFood = findViewById(R.id.FoodInfo);
        final TextView foodQues = findViewById(R.id.FoodAmount);
        final EditText numFood = findViewById(R.id.FoodValue);

        final ImageView bullet = findViewById(R.id.Bullet);
        final TextView infoAmmo = findViewById(R.id.AmmoInfo);
        final TextView ammoQues = findViewById(R.id.AmmoAmount);
        final EditText numAmmo = findViewById(R.id.AmmoValue);

        final ImageView stuff = findViewById(R.id.Stuff);
        final TextView infoParts = findViewById(R.id.PartsInfo);
        final TextView wheelQues = findViewById(R.id.WheelAmount);
        final EditText numWheel = findViewById(R.id.WheelValue);
        final TextView axelQues = findViewById(R.id.AxleAmount);
        final EditText numAxel = findViewById(R.id.AxelValue);
        final TextView tongueQues = findViewById(R.id.TongueAmount);
        final EditText numTongue = findViewById(R.id.TongueValue);

        shopBack.setVisibility(View.GONE);
        balance.setVisibility(View.GONE);
        balanceAmount.setVisibility(View.GONE);
        infoYoke.setVisibility(View.GONE);
        yokeNumQues.setVisibility(View.GONE);
        numYoke.setVisibility(View.GONE);
        month.setVisibility(View.GONE);
        shopNext.setVisibility(View.GONE);
        march.setVisibility(View.GONE);
        april.setVisibility(View.GONE);
        may.setVisibility(View.GONE);
        june.setVisibility(View.GONE);
        july.setVisibility(View.GONE);
        information.setVisibility(View.GONE);
        next.setVisibility(View.GONE);
        bio.setVisibility(View.GONE);
        age.setVisibility(View.GONE);
        name.setVisibility(View.GONE);
        back.setVisibility(View.GONE);
        moreInfo.setVisibility(View.GONE);
        sandwich.setVisibility(View.GONE);
        yoke.setVisibility(View.GONE);
        ammunition.setVisibility(View.GONE);
        clothes.setVisibility(View.GONE);
        food.setVisibility(View.GONE);
        parts.setVisibility(View.GONE);
        shop.setVisibility(View.GONE);
        oxenYoke.setVisibility(View.GONE);
        shirt.setVisibility(View.GONE);
        ammo.setVisibility(View.GONE);
        spares.setVisibility(View.GONE);

        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                wagon.setVisibility(View.GONE);
                Oxen.setVisibility(View.GONE);
                Oxen2.setVisibility(View.GONE);
                Oxen3.setVisibility(View.GONE);
                Oxen4.setVisibility(View.GONE);
                startBackground.setVisibility(View.GONE);
                next.setVisibility(View.VISIBLE);
                bio.setVisibility(View.VISIBLE);
                age.setVisibility(View.VISIBLE);
                name.setVisibility(View.VISIBLE);
            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                next.setVisibility(View.GONE);
                bio.setVisibility(View.GONE);
                age.setVisibility(View.GONE);
                name.setVisibility(View.GONE);
                month.setVisibility(View.VISIBLE);
                shopNext.setVisibility(View.GONE);
                march.setVisibility(View.VISIBLE);
                april.setVisibility(View.VISIBLE);
                may.setVisibility(View.VISIBLE);
                june.setVisibility(View.VISIBLE);
                july.setVisibility(View.VISIBLE);
                information.setVisibility(View.VISIBLE);
            }
        });

        march.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                int startMonth = 03;
                int startDay = 01;
                int startYear = 1849;
                date.setCurrentDay(startDay);
                date.setCurrentMonth(startMonth);
                date.setCurrentYear(startYear);
                month.setVisibility(View.GONE);
                shopNext.setVisibility(View.VISIBLE);
                march.setVisibility(View.GONE);
                april.setVisibility(View.GONE);
                may.setVisibility(View.GONE);
                june.setVisibility(View.GONE);
                july.setVisibility(View.GONE);
                information.setVisibility(View.GONE);
                sandwich.setVisibility(View.VISIBLE);
                yoke.setVisibility(View.VISIBLE);
                ammunition.setVisibility(View.VISIBLE);
                clothes.setVisibility(View.VISIBLE);
                food.setVisibility(View.VISIBLE);
                parts.setVisibility(View.VISIBLE);
                shop.setVisibility(View.VISIBLE);
                oxenYoke.setVisibility(View.VISIBLE);
                shirt.setVisibility(View.VISIBLE);
                ammo.setVisibility(View.VISIBLE);
                spares.setVisibility(View.VISIBLE);
                balance.setVisibility(View.VISIBLE);
                balanceAmount.setVisibility(View.VISIBLE);

            }
        });

        april.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                int startMonth = 04;
                int startDay = 01;
                int startYear = 1849;
                date.setCurrentDay(startDay);
                date.setCurrentMonth(startMonth);
                date.setCurrentYear(startYear);
                month.setVisibility(View.GONE);
                shopNext.setVisibility(View.VISIBLE);
                march.setVisibility(View.GONE);
                april.setVisibility(View.GONE);
                may.setVisibility(View.GONE);
                june.setVisibility(View.GONE);
                july.setVisibility(View.GONE);
                information.setVisibility(View.GONE);
                sandwich.setVisibility(View.VISIBLE);
                yoke.setVisibility(View.VISIBLE);
                ammunition.setVisibility(View.VISIBLE);
                clothes.setVisibility(View.VISIBLE);
                food.setVisibility(View.VISIBLE);
                parts.setVisibility(View.VISIBLE);
                shop.setVisibility(View.VISIBLE);
                oxenYoke.setVisibility(View.VISIBLE);
                shirt.setVisibility(View.VISIBLE);
                ammo.setVisibility(View.VISIBLE);
                spares.setVisibility(View.VISIBLE);
                balance.setVisibility(View.VISIBLE);
                balanceAmount.setVisibility(View.VISIBLE);
            }
        });

        may.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                int startMonth = 05;
                int startDay = 01;
                int startYear = 1849;
                date.setCurrentDay(startDay);
                date.setCurrentMonth(startMonth);
                date.setCurrentYear(startYear);
                month.setVisibility(View.GONE);
                shopNext.setVisibility(View.VISIBLE);
                march.setVisibility(View.GONE);
                april.setVisibility(View.GONE);
                may.setVisibility(View.GONE);
                june.setVisibility(View.GONE);
                july.setVisibility(View.GONE);
                information.setVisibility(View.GONE);
                sandwich.setVisibility(View.VISIBLE);
                yoke.setVisibility(View.VISIBLE);
                ammunition.setVisibility(View.VISIBLE);
                clothes.setVisibility(View.VISIBLE);
                food.setVisibility(View.VISIBLE);
                parts.setVisibility(View.VISIBLE);
                shop.setVisibility(View.VISIBLE);
                oxenYoke.setVisibility(View.VISIBLE);
                shirt.setVisibility(View.VISIBLE);
                ammo.setVisibility(View.VISIBLE);
                spares.setVisibility(View.VISIBLE);
                balance.setVisibility(View.VISIBLE);
                balanceAmount.setVisibility(View.VISIBLE);
            }
        });

        june.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                int startMonth = 06;
                int startDay = 01;
                int startYear = 1849;
                date.setCurrentDay(startDay);
                date.setCurrentMonth(startMonth);
                date.setCurrentYear(startYear);
                month.setVisibility(View.GONE);
                shopNext.setVisibility(View.VISIBLE);
                march.setVisibility(View.GONE);
                april.setVisibility(View.GONE);
                may.setVisibility(View.GONE);
                june.setVisibility(View.GONE);
                july.setVisibility(View.GONE);
                information.setVisibility(View.GONE);
                sandwich.setVisibility(View.VISIBLE);
                yoke.setVisibility(View.VISIBLE);
                ammunition.setVisibility(View.VISIBLE);
                clothes.setVisibility(View.VISIBLE);
                food.setVisibility(View.VISIBLE);
                parts.setVisibility(View.VISIBLE);
                shop.setVisibility(View.VISIBLE);
                oxenYoke.setVisibility(View.VISIBLE);
                shirt.setVisibility(View.VISIBLE);
                ammo.setVisibility(View.VISIBLE);
                spares.setVisibility(View.VISIBLE);
                balance.setVisibility(View.VISIBLE);
                balanceAmount.setVisibility(View.VISIBLE);
            }
        });

        july.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                int startMonth = 07;
                int startDay = 01;
                int startYear = 1849;
                date.setCurrentDay(startDay);
                date.setCurrentMonth(startMonth);
                date.setCurrentYear(startYear);
                month.setVisibility(View.GONE);
                shopNext.setVisibility(View.VISIBLE);
                march.setVisibility(View.GONE);
                april.setVisibility(View.GONE);
                may.setVisibility(View.GONE);
                june.setVisibility(View.GONE);
                july.setVisibility(View.GONE);
                information.setVisibility(View.GONE);
                sandwich.setVisibility(View.VISIBLE);
                yoke.setVisibility(View.VISIBLE);
                ammunition.setVisibility(View.VISIBLE);
                clothes.setVisibility(View.VISIBLE);
                food.setVisibility(View.VISIBLE);
                parts.setVisibility(View.VISIBLE);
                shop.setVisibility(View.VISIBLE);
                oxenYoke.setVisibility(View.VISIBLE);
                shirt.setVisibility(View.VISIBLE);
                ammo.setVisibility(View.VISIBLE);
                spares.setVisibility(View.VISIBLE);
                balance.setVisibility(View.VISIBLE);
                balanceAmount.setVisibility(View.VISIBLE);
            }
        });

        information.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                month.setVisibility(View.GONE);
                shopNext.setVisibility(View.GONE);
                march.setVisibility(View.GONE);
                april.setVisibility(View.GONE);
                may.setVisibility(View.GONE);
                june.setVisibility(View.GONE);
                july.setVisibility(View.GONE);
                information.setVisibility(View.GONE);
                back.setVisibility(View.VISIBLE);
                moreInfo.setVisibility(View.VISIBLE);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                march.setVisibility(View.VISIBLE);
                april.setVisibility(View.VISIBLE);
                may.setVisibility(View.VISIBLE);
                june.setVisibility(View.VISIBLE);
                july.setVisibility(View.VISIBLE);
                information.setVisibility(View.VISIBLE);
            }
        });

        yoke.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                balance.setVisibility(View.GONE);
                balanceAmount.setVisibility(View.GONE);
                infoYoke.setVisibility(View.VISIBLE);
                yokeNumQues.setVisibility(View.VISIBLE);
                numYoke.setVisibility(View.VISIBLE);
                //member.set??();

            }
        });

        ammunition.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                balance.setVisibility(View.GONE);
                balanceAmount.setVisibility(View.GONE);
                //wep.setAmmo();
            }
        });

        clothes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                balance.setVisibility(View.GONE);
                balanceAmount.setVisibility(View.GONE);
                //itm.set??();
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                balance.setVisibility(View.GONE);
                balanceAmount.setVisibility(View.GONE);
                //itm.set??();
            }
        });

        parts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                balance.setVisibility(View.GONE);
                balanceAmount.setVisibility(View.GONE);
                //itm.set??();
            }
        });







        //TEST CODE
       // Weapon testWeapon = new Weapon();
        //Food testFood = new Food();
        //Inventory testInventory = new Inventory();
        //Inventory testInventory2 = new Inventory();

        //testInventory.addItem(testWeapon);
        //testInventory2.addItem(testFood);

        //testInventory.giveItem(0, testInventory2);
    }
}
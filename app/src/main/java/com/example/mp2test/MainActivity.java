package com.example.mp2test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Item itm = new Item();
    Map mp = new Map();
    Date date = new Date();
    Member member = new Member();
    RandomEventGenerator reg = new RandomEventGenerator();
    Wagon wag = new Wagon();
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
        moreInfo.setVisibility((View.GONE));

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
                date.setCurrentMonth(startMonth);
                month.setVisibility(View.GONE);
                shopNext.setVisibility(View.VISIBLE);
                march.setVisibility(View.GONE);
                april.setVisibility(View.GONE);
                may.setVisibility(View.GONE);
                june.setVisibility(View.GONE);
                july.setVisibility(View.GONE);
                information.setVisibility(View.GONE);

            }
        });

        april.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                int startMonth = 04;
                date.setCurrentMonth(startMonth);
                month.setVisibility(View.GONE);
                shopNext.setVisibility(View.VISIBLE;
                march.setVisibility(View.GONE);
                april.setVisibility(View.GONE);
                may.setVisibility(View.GONE);
                june.setVisibility(View.GONE);
                july.setVisibility(View.GONE);
                information.setVisibility(View.GONE);
            }
        });

        may.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                int startMonth = 05;
                date.setCurrentMonth(startMonth);
                month.setVisibility(View.GONE);
                shopNext.setVisibility(View.VISIBLE;
                march.setVisibility(View.GONE);
                april.setVisibility(View.GONE);
                may.setVisibility(View.GONE);
                june.setVisibility(View.GONE);
                july.setVisibility(View.GONE);
                information.setVisibility(View.GONE);
            }
        });

        june.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                int startMonth = 06;
                date.setCurrentMonth(startMonth);
                month.setVisibility(View.GONE);
                shopNext.setVisibility(View.VISIBLE;
                march.setVisibility(View.GONE);
                april.setVisibility(View.GONE);
                may.setVisibility(View.GONE);
                june.setVisibility(View.GONE);
                july.setVisibility(View.GONE);
                information.setVisibility(View.GONE);
            }
        });

        july.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                int startMonth = 07;
                date.setCurrentMonth(startMonth);
                month.setVisibility(View.GONE);
                shopNext.setVisibility(View.VISIBLE;
                march.setVisibility(View.GONE);
                april.setVisibility(View.GONE);
                may.setVisibility(View.GONE);
                june.setVisibility(View.GONE);
                july.setVisibility(View.GONE);
                information.setVisibility(View.GONE);
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
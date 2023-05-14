/**
 * File Name: monthSelection.java
 * Author: Ethan Berei
 * Date: 4/16/23
 * Description: The class responsible for controlling the month selection screen
 */

package com.example.mp2test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class monthSelection extends AppCompatActivity {                                             //buttons for month selection screen
    public static final String MONTH = "month";
    public static final String SHOP = "shop";
    @Override
    protected void onCreate(Bundle savedInstanceState) {                                            //sets up buttons
        super.onCreate(savedInstanceState);
        setContentView(R.layout.months_selection);
        setupMoreInfoButton();
        setupMarchButton();
        setupAprilButton();
        setupMayButton();
        setupJuneButton();
        setupJulyButton();
    }

    private void setupMoreInfoButton() {                                                            //sets up moreInfo button
        final Button moreInfoMonths = findViewById(R.id.moreInfoMonths);
        moreInfoMonths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(monthSelection.this, monthMoreInfo.class));
            }
        });
    }

    private void setupMarchButton() {                                                               //sets up the 'March' selection
        final Button marchButton = findViewById(R.id.marchButton);
        marchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(monthSelection.this, shopScreen.class);
                Bundle bundle = new Bundle();
                bundle.putInt(MONTH, 3);
                bundle.putInt(SHOP, 0);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void setupAprilButton() {                                                               //sets up the 'April' selection
        final Button marchButton = findViewById(R.id.aprilButton);
        marchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(monthSelection.this, shopScreen.class);
                Bundle bundle = new Bundle();
                bundle.putInt(MONTH, 4);
                bundle.putInt(SHOP, 0);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void setupMayButton() {                                                                 //sets up the 'May' selection
        final Button marchButton = findViewById(R.id.mayButton);
        marchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(monthSelection.this, shopScreen.class);
                Bundle bundle = new Bundle();
                bundle.putInt(MONTH, 5);
                bundle.putInt(SHOP, 0);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void setupJuneButton() {                                                                //sets up the 'June' selection
        final Button marchButton = findViewById(R.id.juneButton);
        marchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(monthSelection.this, shopScreen.class);
                Bundle bundle = new Bundle();
                bundle.putInt(MONTH, 6);
                bundle.putInt(SHOP, 0);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void setupJulyButton() {                                                                //sets up the 'July' selection
        final Button marchButton = findViewById(R.id.julyButton);
        marchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(monthSelection.this, shopScreen.class);
                Bundle bundle = new Bundle();
                bundle.putInt(MONTH, 7);
                bundle.putInt(SHOP, 0);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}

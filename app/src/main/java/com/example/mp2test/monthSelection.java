package com.example.mp2test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class monthSelection extends AppCompatActivity {
    public static final String MONTH = "month";
    public static final String SHOP = "shop";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.months_selection);
        setupMoreInfoButton();
        setupMarchButton();
        setupAprilButton();
        setupMayButton();
        setupJuneButton();
        setupJulyButton();
    }

    private void setupMoreInfoButton() {
        final Button moreInfoMonths = findViewById(R.id.moreInfoMonths);
        moreInfoMonths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(monthSelection.this, monthMoreInfo.class));
            }
        });
    }

    private void setupMarchButton() {
        final Button marchButton = findViewById(R.id.marchButton);
        marchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(monthSelection.this, shopScreen.class);
                intent.putExtra(MONTH, 3);
                intent.putExtra(SHOP, 0);
                startActivity(intent);
            }
        });
    }

    private void setupAprilButton() {
        final Button marchButton = findViewById(R.id.aprilButton);
        marchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(monthSelection.this, shopScreen.class);
                intent.putExtra(MONTH, 4);
                intent.putExtra(SHOP, 0);
                startActivity(intent);
            }
        });
    }

    private void setupMayButton() {
        final Button marchButton = findViewById(R.id.mayButton);
        marchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(monthSelection.this, shopScreen.class);
                intent.putExtra(MONTH, 5);
                intent.putExtra(SHOP, 0);
                startActivity(intent);
            }
        });
    }

    private void setupJuneButton() {
        final Button marchButton = findViewById(R.id.juneButton);
        marchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(monthSelection.this, shopScreen.class);
                intent.putExtra(MONTH, 6);
                intent.putExtra(SHOP, 0);
                startActivity(intent);
            }
        });
    }

    private void setupJulyButton() {
        final Button marchButton = findViewById(R.id.julyButton);
        marchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(monthSelection.this, shopScreen.class);
                intent.putExtra(MONTH, 7);
                intent.putExtra(SHOP, 0);
                startActivity(intent);
            }
        });
    }
}

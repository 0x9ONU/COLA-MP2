package com.example.mp2test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class monthMoreInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.months_more_info);

        setupBackButton();
    }

    private void setupBackButton() {
        final Button backButton = findViewById(R.id.backMonthMoreInfo);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(monthMoreInfo.this, monthSelection.class));
            }
        });
    }
}

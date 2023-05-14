/**
 * File Name: monthMoreInfo.java
 * Author: Ethan Berei
 * Date: 4/28/23
 * Description: The class responsible for controlling and displaying the extra information of the months
 */

package com.example.mp2test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class monthMoreInfo extends AppCompatActivity {                                              //buttons for monument screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {                                            //changes state to the moreinfo screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.months_more_info);

        setupBackButton();
    }

    private void setupBackButton() {
        final Button backButton = findViewById(R.id.backMonthMoreInfo);                             //changes display back to monument screen
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(monthMoreInfo.this, monthSelection.class));
            }
        });
    }
}

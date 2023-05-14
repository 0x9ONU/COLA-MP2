/**
 * File Name: citations.java
 * Author: Ethan Berei
 * Date: 5/6/23
 * Description: The class responsible for the game's citations
 */

package com.example.mp2test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class citations extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.citations);

        final Button backButton = findViewById(R.id.back_button4);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}

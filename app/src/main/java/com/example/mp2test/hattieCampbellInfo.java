package com.example.mp2test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//This this controls the .xml of the same name. It has an image of Hattie Campbell and gives background info about here journey
public class hattieCampbellInfo extends AppCompatActivity {

    //This
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hattie_campbell_info);                                              //sets the display to hattie campbells info

        setupNextButton();

    }

    //This function is responsible for setting up the continue button that takes the user to the next activity.
    private void setupNextButton() {
        final Button nextHattieCampbell = findViewById(R.id.nextHattieCampbell);                    //displays button and all included info

        nextHattieCampbell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This code sends the user to the monthSelection activity
                startActivity(new Intent (hattieCampbellInfo.this, monthSelection.class));
            }
        });
    }
}

package com.example.mp2test;

//Does Kind of Nothing Only Switches between Title Screen and Hattie Campbell

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {                                               //switches to title screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        configureNextButton();
    }

    private void configureNextButton() {
        final Button ADVENTURE_AWAITS = findViewById(R.id.start_button);                            //starts the game/switches to hattieCampbell screen
        ADVENTURE_AWAITS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent (MainActivity.this, hattieCampbellInfo.class));
            }
        });
    }
}


package com.example.mp2test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class hattieCampbellInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hattie_campbell_info);                                              //sets the display to hattie campbells info

        setupNextButton();

    }

    private void setupNextButton() {
        final Button nextHattieCampbell = findViewById(R.id.nextHattieCampbell);                    //displays button and all included info

        nextHattieCampbell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent (hattieCampbellInfo.this, monthSelection.class));
            }
        });
    }
}

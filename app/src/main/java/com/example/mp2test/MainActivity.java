package com.example.mp2test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        configureNextButton();
    }

    private void configureNextButton() {
        final Button ADVENTURE_AWAITS = findViewById(R.id.start_button);
        ADVENTURE_AWAITS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent (MainActivity.this, hattieCampbellInfo.class));
            }
        });
    }
}


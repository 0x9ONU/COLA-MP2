package com.example.mp2test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import com.jakewharton.processphoenix.ProcessPhoenix;

public class gameOver extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        final Button yes = findViewById(R.id.gameOverYes);
        final Button no = findViewById(R.id.gameOverNo);
        final Button sources = findViewById(R.id.sourcesButton);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProcessPhoenix.triggerRebirth(getApplicationContext());
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //https://www.geeksforgeeks.org/how-to-quit-android-application-programmatically/
                gameOver.this.finish();
                System.exit(0);
            }
        });

        sources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gameOver.this, citations.class));
            }
        });
    }
}
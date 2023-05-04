package com.example.mp2test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class randomEventSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_event_splash);
        String title = getIntent().getStringExtra(mapPlaying.RND);

        //Setup Text and buttons

        final TextView titleText = findViewById(R.id.randomEventSplashTitle);
        titleText.setText(title);
        final TextView splashText = findViewById(R.id.randomEventSplashText);

        if (title.equals("Kiss")) ;
        else if (title.equals("gold nugget")) ;
        else if (title.equals("nice native americans"));
        else if (title.equals("bundle of food"));
        else if (title.equals("deserted wagon"));
        else if (title.equals("miscounted food"));
        else if (title.equals("house"));
        else if (title.equals("wandering oxen"));
        else if (title.equals("good sleep"));
        else if (title.equals("Alex Fimel"));
        else if (title.equals("animals go to the food"));
        else if (title.equals("broken wheel"));
        else if (title.equals("aggressive native americans"));
        else if (title.equals("thief"));
        else if (title.equals("bad shortcut"));
        else if (title.equals("rainy day"));
        else if (title.equals("broken leg"));
        else if (title.equals("tired oxen"));
        else if (title.equals("misplaced food"));
        else if (title.equals("Volcano"));

        final Button cont = findViewById(R.id.contButton);
    }
}
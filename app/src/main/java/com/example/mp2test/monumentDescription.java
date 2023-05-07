package com.example.mp2test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class monumentDescription extends AppCompatActivity {
    public final static String FINISHED = "finished";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monument_description);

        Map map = (Map) getIntent().getSerializableExtra(randomEventSplash.MAP);

        final Button back = findViewById(R.id.back_button6);
        final TextView title = findViewById(R.id.MonumentTitle);
        final TextView description = findViewById(R.id.monumentDescription);

        title.setText(map.getMonumentTitle(map.getPreviousMonument()));
        description.setText(map.getMonumentDescription(map.getPreviousMonument()));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getIntent().putExtra(FINISHED, true);
                finish();
            }
        });
    }
}

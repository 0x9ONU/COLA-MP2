/**
 * File Name: monumentDescription.java
 * Author: Ethan Berei
 * Date: 4/03/23
 * Description: The class responsible for keeping track of the information from each month
 */

package com.example.mp2test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class monumentDescription extends AppCompatActivity {
    public final static String FINISHED = "finished";

    @Override
    protected void onCreate(Bundle savedInstanceState) {                                            //sets up all the buttons
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monument_description);

        Map map = (Map) getIntent().getSerializableExtra(randomEventSplash.MAP);

        final Button back = findViewById(R.id.back_button6);
        final TextView title = findViewById(R.id.MonumentTitle);
        final TextView description = findViewById(R.id.monumentDescription);
        final ImageView image = findViewById(R.id.MonumentImage);

        int monumentNumber = map.getPreviousMonument();

        title.setText(map.getMonumentTitle(monumentNumber));                                        //sets up the display text
        description.setText(map.getMonumentDescription(monumentNumber));

        switch (monumentNumber) {                                                                   //figures out which monument the player is at and what to display
            case 0:
                break;
            case 1:
                image.setImageResource(R.drawable._1_redvermillioncrossing);
                break;
            case 2:
                image.setImageResource(R.drawable._2_bigblueriver);
                break;
            case 3:
                image.setImageResource(R.drawable._3_hollenbergponyexpress);
                break;
            case 4:
                image.setImageResource(R.drawable._4_libertyfarmstation);
                break;
            case 5:
                image.setImageResource(R.drawable._5_fortkearnyoutpost);
                break;
            case 6:
                image.setImageResource(R.drawable._6_fortkearny);
                break;
            case 7:
                image.setImageResource(R.drawable._7_californiahill);
                break;
            case 8:
                image.setImageResource(R.drawable._8_ashhollow);
                break;
            case 9:
                image.setImageResource(R.drawable._9_courthousejailrock);
                break;
            case 10:
                image.setImageResource(R.drawable._10_chimneyrock);
                break;
            case 11:
                image.setImageResource(R.drawable._11_pioneergraves);
                break;
            case 12:
                image.setImageResource(R.drawable._12_coldsprings);
                break;
            case 13:
                image.setImageResource(R.drawable._13_fortlaramie);
                break;
            case 14:
                image.setImageResource(R.drawable.deercreekcrossing);
                break;
            case 15:
                image.setImageResource(R.drawable._15_independencerock);
                break;
            case 16:
                image.setImageResource(R.drawable._16_fortbridger);
                break;
            case 17:
                image.setImageResource(R.drawable._17_thomasforkcrossing);
                break;
            case 18:
                image.setImageResource(R.drawable._18_sulphursprings);
                break;
            case 19:
                image.setImageResource(R.drawable._19_massacrerocks);
                break;
            case 20:
                image.setImageResource(R.drawable._20_raftriver);
                break;
            case 21:
                //image.setImageResource(R.drawable.);
                break;
            case 22:
                image.setImageResource(R.drawable._22_thousandsprings);
                break;
            case 23:
                image.setImageResource(R.drawable._23_hotspring);
                break;
            case 24:
                image.setImageResource(R.drawable.umatillariver);
                break;
            case 25:
                image.setImageResource(R.drawable._25_fortvancouver);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getIntent().putExtra(FINISHED, true);
                finish();
            }
        });
    }
}

/**
 * File Name: mapStart.java
 * Author: Ethan Berei
 * Date: 3/31/23
 * Description: The class responsible for controlling the start of the map
 */

package com.example.mp2test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class mapStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {                                            //changes the display state
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_start);
    }
}

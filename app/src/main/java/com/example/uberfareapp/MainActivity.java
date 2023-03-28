package com.example.uberfareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the "Estimate Uber Cost" button
        Button estimateButton = findViewById(R.id.estimate_button);

        // Set a click listener on the button
        estimateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to launch the EstimateCostActivity
                Intent intent = new Intent(MainActivity.this, EstimateCostActivity.class);
                startActivity(intent);
            }
        });
    }
}

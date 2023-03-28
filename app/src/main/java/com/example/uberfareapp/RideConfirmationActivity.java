package com.example.uberfareapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RideConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_confirmation);

        // Find view elements
        TextView rideConfirmationTextView = findViewById(R.id.ride_confirmation_textview);
        ImageView driverImageView = findViewById(R.id.driver_imageview);
        TextView driverNameTextView = findViewById(R.id.driver_name_textview);
        TextView estimatedArrivalTimeTextView = findViewById(R.id.estimated_arrival_time_textview);
        Button backButton = findViewById(R.id.back_to_beginning_button);

        // Get driver name and estimated fare from Intent
        String driverName = getIntent().getStringExtra("driverName");
        String vehicleType = getIntent().getStringExtra("vehicleType");
        double estimatedFare = getIntent().getDoubleExtra("estimatedFare", 0.0);

        // Set driver name in textview
        driverNameTextView.setText("Your driver " + driverName + " will arrive soon.");

        // Generate random estimated arrival time
        Random random = new Random();
        int estimatedArrivalTime = random.nextInt(11) + 5;

        // Set estimated arrival time in textview
        estimatedArrivalTimeTextView.setText("Estimated arrival time: " + estimatedArrivalTime + " minutes");

        // Set ride confirmation message
        rideConfirmationTextView.setText("Your " + vehicleType + " ride has been requested! Your driver will arrive soon. The estimated fare is $" + String.format("%.2f", estimatedFare));

        // Set click listener for "Go back to Beginning" button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create Intent to go back to MainActivity
                Intent mainActivityIntent = new Intent(RideConfirmationActivity.this, MainActivity.class);
                mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainActivityIntent);
            }
        });
    }
}


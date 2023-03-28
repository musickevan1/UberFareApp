package com.example.uberfareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class EstimateCostActivity extends AppCompatActivity {
    private EditText distanceInput;
    private Spinner vehicleSpinner;
    private Button calculateButton;
    private TextView fareTextView;
    private TextView fareOutputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate_cost);
        // Initialize views
        distanceInput = findViewById(R.id.distance_edittext);
        vehicleSpinner = findViewById(R.id.vehicle_spinner);
        calculateButton = findViewById(R.id.calculate_button);
        fareTextView = findViewById(R.id.fare_textview);
        fareOutputTextView = findViewById(R.id.fare_output_textview);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get distance value from input
                String distanceStr = distanceInput.getText().toString();
                double distance = Double.parseDouble(distanceStr);

                // Get vehicle selection value from spinner
                String vehicleSelection = vehicleSpinner.getSelectedItem().toString();

                // Calculate fare based on algorithms provided
                double fare = 3.00 + distance * 3.25;
                if (vehicleSelection.equals("Smart Car")) {
                    fare += 2.00;
                } else if (vehicleSelection.equals("Minivan")) {
                    fare += 5.00;
                }

                // Create Intent for RideConfirmationActivity
                Intent rideConfirmationIntent = new Intent(EstimateCostActivity.this, RideConfirmationActivity.class);

                // Add extras for vehicle type and estimated fare
                rideConfirmationIntent.putExtra("vehicleType", vehicleSelection);
                rideConfirmationIntent.putExtra("estimatedFare", fare);

                // Start RideConfirmationActivity
                startActivity(rideConfirmationIntent);
            }
        });


    }
}
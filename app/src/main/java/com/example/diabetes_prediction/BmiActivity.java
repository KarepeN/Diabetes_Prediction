package com.example.diabetes_prediction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BmiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView displayTV = findViewById(R.id.displayTV);
        displayTV.setText("BMI");

    }


    public void computeAction(View v) {
        TextView displayTV = findViewById(R.id.displayTV);
        EditText heightET = findViewById(R.id.heightET);
        EditText radiusET = findViewById(R.id.weightET);
        String current = displayTV.getText().toString();
        try {
            double height = Double.parseDouble(heightET.getText().toString());
            double weight = Double.parseDouble(radiusET.getText().toString());


            if(weight>0 && height>0) {
                double a =  weight/ Math.pow(height, 2);

                displayTV.setText("BMI " + new DecimalFormat("##.##").format(a));
            }
            else{

                displayTV.setText("Enter non-negative values greater than 0");
            }
        }
        catch (NumberFormatException e){
            Log.d("Input", "Failed");
            displayTV.setText("Enter the Values");
        }
    }
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
        EditText weightET = findViewById(R.id.weightET);

    }
}

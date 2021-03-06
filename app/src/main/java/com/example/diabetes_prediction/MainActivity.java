package com.example.diabetes_prediction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button predict, medicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        predict=findViewById(R.id.button);
        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diabetesPrediction(v);
            }
        });
        medicine=findViewById(R.id.button);
        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medicineReminder(v);
            }
        });
    }

    public void diabetesPrediction(View v){
        Intent explicit = new Intent(this, Prediction.class);


    }

    public void medicineReminder(View v){
        Intent explicit = new Intent(this, MedicalReminder.class);


    }

    }

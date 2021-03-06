package com.example.diabetes_prediction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button predict, medicine,bmi;
    public static final int SUCCESS=1;

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
        medicine=findViewById(R.id.button3);
        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medicineReminder(v);
            }
        });
        bmi=findViewById(R.id.button2);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmiCalc(v);
            }
        });
    }

    public void diabetesPrediction(View v){
        Intent explicit = new Intent(this, Prediction.class);
        startActivityForResult(explicit,SUCCESS );


    }

    public void medicineReminder(View v){
        Intent explicit = new Intent(this, MedicalReminder.class);
        startActivityForResult(explicit,SUCCESS );


    }
    public void bmiCalc(View v){
        Intent explicit = new Intent(this, BmiActivity.class);
        startActivityForResult(explicit,SUCCESS );


    }

    public void outAction(View v){
        Intent implicit = new Intent();
        implicit.setAction(Intent.ACTION_VIEW);
        String location = "https://www.healthline.com/health/type-2-diabetes/top-exercises#cycling";
        Uri data = Uri.parse(location);
        implicit.setData(data);
        startActivity(implicit);
    }    }

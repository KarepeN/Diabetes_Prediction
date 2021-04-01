package com.example.diabetes_prediction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    CardView predict, medicine,bmi,exercise,location;
    public static final int SUCCESS=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        predict=findViewById(R.id.btnPredict);
        predict.setOnClickListener(v -> diabetesPrediction(v));
        bmi=findViewById(R.id.btnBmi);
        bmi.setOnClickListener(v -> bmiCalc(v));
        exercise = findViewById(R.id.btnExercise);
        exercise.setOnClickListener(v -> outAction());
        location = findViewById(R.id.btnLocation);
        medicine=findViewById(R.id.btnMedicine);
        medicine.setOnClickListener(v -> medicineReminder(v));
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LocationActivity.class));
            }
        });


    }

    public void diabetesPrediction(View v){
        Intent explicit = new Intent(MainActivity.this, Prediction.class);
        startActivity(explicit );


    }


    public void bmiCalc(View v){
        Intent explicit = new Intent(MainActivity.this, BmiActivity.class);
        startActivity(explicit );


    }
    public void medicineReminder(View v){
        Intent explicit = new Intent(MainActivity.this, MainPage.class);
        startActivity(explicit );

    }

    public void outAction(){
       startActivity(new Intent(MainActivity.this,ExerciseActivity.class));
    }    }

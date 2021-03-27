package com.example.diabetes_prediction;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Prediction extends AppCompatActivity {
    ImageView imgBack;
    EditText etGlucose, etBlood, etSkin, etInsulin, etWeight, etHeight, etDiabetesFunc, etAge;
    Button btnPredict;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);
        etGlucose = findViewById(R.id.etGlucose);
        etBlood = findViewById(R.id.etBloodP);
        etSkin = findViewById(R.id.etSkinThick);
        etInsulin = findViewById(R.id.etInsulin);
        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        etDiabetesFunc = findViewById(R.id.etDiabetesFunction);
        etAge = findViewById(R.id.etAge);
        btnPredict = findViewById(R.id.btnPredict);
        tvResult = findViewById(R.id.tvResult);


    }

    @SuppressLint("SetTextI18n")
    private void Predict() {

        int glucose = Integer.parseInt(etGlucose.getText().toString());
        int blood = Integer.parseInt(etBlood.getText().toString());
        int skin = Integer.parseInt(etSkin.getText().toString());
        int insulin = Integer.parseInt(etInsulin.getText().toString());
        int weight = Integer.parseInt(etWeight.getText().toString());
        int height = Integer.parseInt(etHeight.getText().toString());
        int diabetes = Integer.parseInt(etDiabetesFunc.getText().toString());
        int age = Integer.parseInt(etAge.getText().toString());


        tvResult.setText("Result: Diabetes Active");


    }
}

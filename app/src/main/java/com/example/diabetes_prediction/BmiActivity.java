package com.example.diabetes_prediction;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class BmiActivity extends AppCompatActivity {

    ImageView imgBack;
    EditText height,weight;
    Button calculateBtn;
    TextView bmiTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        imgBack = findViewById(R.id.imgBack);
        height = findViewById(R.id.etHeight);
        weight = findViewById(R.id.etWeight);
        calculateBtn = findViewById(R.id.btnCalculate);
        bmiTV = findViewById(R.id.tvResult);
        imgBack.setOnClickListener(v -> onBackPressed());
        calculateBtn.setOnClickListener(v -> {
            if (!height.getText().toString().isEmpty() && !weight.getText().toString().isEmpty())
            {
                hideKeyboard(this);
                calculateBMI();
            }
            else
            {
                hideKeyboard(this);
                Toast.makeText(BmiActivity.this, "Please Enter All Info..", Toast.LENGTH_SHORT).show();
            }
        });




    }
    private void calculateBMI()
    {
        double weight1 = Double.parseDouble(weight.getText().toString());
        weight1 *= 2.205;
        double height1 = Double.parseDouble(height.getText().toString());
        double result = (703*weight1/(height1*height1));
        bmiTV.setText("your BMI: "+String.format("%.2f", result));



    }

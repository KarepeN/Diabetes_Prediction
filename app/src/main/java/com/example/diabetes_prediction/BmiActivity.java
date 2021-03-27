package com.example.diabetes_prediction;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
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
int fCode=1;
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
        calculateBtn.setOnClickListener(v -> { calculateBMI();
        });




    }
    private void calculateBMI()
    {
        double weight1 = Double.parseDouble(weight.getText().toString());

        double height1 = Double.parseDouble(height.getText().toString());
        double result =20.00;
        bmiTV.setText("your BMI: "+String.format("%.2f", result));



    }
    public void onclickcancelBtn(View v){
        Intent resultint = new Intent(this,MainActivity.class);
        setResult(fCode,resultint);
        finish();
    }

}

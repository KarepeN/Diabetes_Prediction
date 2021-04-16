package com.example.diabetes_prediction;

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
     EditText etGlucose,etBlood,etSkin,etInsulin,etWeight,etHeight,etDiabetesFunc,etAge;
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



        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(v -> onBackPressed());

        btnPredict.setOnClickListener(v -> {
            if (!etGlucose.getText().toString().isEmpty() &&
                    !etBlood.getText().toString().isEmpty() &&
                    !etSkin.getText().toString().isEmpty() &&
                    !etInsulin.getText().toString().isEmpty() &&
                    !etWeight.getText().toString().isEmpty() &&
                    !etHeight.getText().toString().isEmpty() &&
                    !etDiabetesFunc.getText().toString().isEmpty() &&
                    !etAge.getText().toString().isEmpty())
            {
                hideKeyboard(this);
                Predict();
            }
            else
            {
                hideKeyboard(this);
                Toast.makeText(Prediction.this, "Please Enter All Info..", Toast.LENGTH_SHORT).show();
            }

        });
    }
    @SuppressLint("SetTextI18n")
    private void Predict()
    {

        int glucose = Integer.parseInt(etGlucose.getText().toString());
        int blood = Integer.parseInt(etBlood.getText().toString());
        int skin = Integer.parseInt(etSkin.getText().toString());
        int insulin = Integer.parseInt(etInsulin.getText().toString());
        int weight = Integer.parseInt(etWeight.getText().toString());
        int height = Integer.parseInt(etHeight.getText().toString());
        int diabetes = Integer.parseInt(etDiabetesFunc.getText().toString());
        int age = Integer.parseInt(etAge.getText().toString());


        if ((glucose >140 && insulin > 120) || (blood > 120 && diabetes > 140) ||( skin > 0.5 && age > 35))
        {
            tvResult.setText("Result: Diabetes Active");
        }
        else
        {
            tvResult.setText("Result: Diabetes Not Active");


        }

    }
     public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}

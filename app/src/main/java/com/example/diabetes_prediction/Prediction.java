package com.example.diabetes_prediction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Prediction extends AppCompatActivity {
     private Button button;
    int fCode=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);
        button = (Button) findViewById(R.id.button1);

        button = (Button) findViewById(R.id.button);
    }
    public void Pre(View v){

        TextView txtw = findViewById(R.id.textView9);
        txtw.setText("positive");

    }

    public void onclickcancelBtn(View v){
        Intent resultint = new Intent(this,MainActivity.class);
        setResult(fCode,resultint);
        finish();
     }
}

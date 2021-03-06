package com.example.diabetes_prediction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Prediction extends AppCompatActivity {
    private Button button;
    private TextView txtw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);
        button = (Button) findViewById(R.id.button1);
        TextView txtvw = findViewById(R.id.textView9);
        button = (Button) findViewById(R.id.button);
    }
        public void Pre(View v){


            txtw.setText("positive");

        }

    public void onClick(View v) {
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
            }
        });
    }
    }

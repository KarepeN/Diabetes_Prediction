package com.example.diabetes_prediction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VideoActivity extends AppCompatActivity {
   public void outAction(View v){
        Intent implicit = new Intent();
        implicit.setAction(Intent.ACTION_VIEW);
        String location = "https://www.healthline.com/health/type-2-diabetes/top-exercises#cycling";
        Uri data = Uri.parse(location);
        implicit.setData(data);
        startActivity(implicit);
    } 
}

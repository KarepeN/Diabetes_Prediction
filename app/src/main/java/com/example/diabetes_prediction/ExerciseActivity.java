package com.example.diabetes_prediction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ExerciseActivity extends AppCompatActivity {
ImageView imgback;
    CardView video1, video2, video3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        video1 = findViewById(R.id.video1);
        video2 = findViewById(R.id.video2);
        video3 = findViewById(R.id.video3);

        imgback  = findViewById(R.id.imgBack);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        video1.setOnClickListener(v -> playVideo("HZH4QASD3ss"));
        video2.setOnClickListener(v -> playVideo("J7h-5PGbGVc"));
         video3.setOnClickListener(v -> playVideo("ePylP2XmNRs"));


    }

    private void playVideo(String videoId) {
        Intent intent = new Intent(ExerciseActivity.this, VideoActivity.class);
        intent.putExtra("videoid", videoId);
        startActivity(intent);

    }
}

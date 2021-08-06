package com.example.tsvid_ff.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import com.example.tsvid_ff.Database.DBContext;
import com.example.tsvid_ff.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CountDownTimer countDownTimer = new CountDownTimer(2000,2000){

            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        };
        countDownTimer.start();

    }
}
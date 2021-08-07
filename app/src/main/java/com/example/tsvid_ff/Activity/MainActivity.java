package com.example.tsvid_ff.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tsvid_ff.Common.CheckInternetConnection;
import com.example.tsvid_ff.Database.DBContext;
import com.example.tsvid_ff.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

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
                if(CheckInternetConnection.isNetworkConnected(getApplicationContext())){
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Không có kết nối mạng",Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        };
        countDownTimer.start();
    }

}
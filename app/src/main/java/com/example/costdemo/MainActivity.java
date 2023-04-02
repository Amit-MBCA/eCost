package com.example.costdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
//import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      new Handler().postDelayed(() -> {
              SharedPreferences shrd = getSharedPreferences(Signup.PREFS_NAME, 0);
              boolean hasSignedUp = shrd.getBoolean("hasSignedUp", false);
//              boolean check=hasSignedUp;
              if (hasSignedUp) {
                  Intent intent = new Intent(MainActivity.this,Home.class);
                  startActivity(intent);
                  finish();
              } else {
                  Intent intents = new Intent(MainActivity.this,Signup.class);
                  startActivity(intents);
                  finish();
              }

      },SPLASH_TIME_OUT);
    }
}
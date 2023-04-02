package com.example.costdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class whatShould extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_should);
    }

    public void onHome(View view) {
        Intent hm=new Intent(whatShould.this,Home.class);
        startActivity(hm);
        finish();
    }

    public void onProfile(View view) {
        Intent onPr=new Intent(whatShould.this,Profile.class);
        startActivity(onPr);
        finish();
    }

    public void back(View view) {
        Intent bck=new Intent(whatShould.this,eCostForAll.class);
        startActivity(bck);
        finish();
    }

    public void definedCharges(View view) {
        Intent funits=new Intent(whatShould.this,fromUnits.class);
        startActivity(funits);

    }

    public void customCharges(View view) {
        Intent cstch=new Intent(whatShould.this,custCharges.class);
        startActivity(cstch);

    }

    public void gotocpt(View view) {
        Intent goback=new Intent(whatShould.this,eCostForAll.class);
        startActivity(goback);
        finish();
    }
}
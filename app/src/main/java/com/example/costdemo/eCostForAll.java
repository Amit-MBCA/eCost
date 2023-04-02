package com.example.costdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class eCostForAll extends AppCompatActivity {
    ImageButton btn_comp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecost_for_all);
        btn_comp=findViewById(R.id.btn_computation);
        btn_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You are already on the Computation Page",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void fromAppl(View view) {
        Intent appforall=new Intent(this,applForAll.class);
        startActivity(appforall);
    }

    public void fromUnits(View view) {
        Intent fUnits=new Intent(eCostForAll.this,whatShould.class);
        startActivity(fUnits);

    }

    public void back(View view) {
        Intent back=new Intent(eCostForAll.this,Home.class);
        startActivity(back);
        finish();
    }

    public void onProfile(View view) {
        Intent prof=new Intent(eCostForAll.this,Profile.class);
        startActivity(prof);
        finish();
    }

    public void onHome(View view) {
        Intent tohome=new Intent(eCostForAll.this,Home.class);
        startActivity(tohome);
        finish();
    }
}
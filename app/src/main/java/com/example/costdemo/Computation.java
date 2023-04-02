package com.example.costdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Computation extends AppCompatActivity {
    private String nationName,stateName;
    private String currency;
    private double urCurrency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computation);
        Intent intent=getIntent();
        currency=intent.getStringExtra("currency");
        urCurrency=intent.getFloatExtra("urCurrency",70);
        nationName=intent.getStringExtra("checkNation");
        stateName=intent.getStringExtra("checkState");
        Intent gotoComp=new Intent(Computation.this, eCostForAll.class);
        startActivity(gotoComp);
        finish();
//        if(nationName.equals("India (IN)")){
//            if(stateName.equals("Haryana | HR")) {
//               Intent gotoHr=new Intent(Computation.this,stHaryana.class);
//               gotoHr.putExtra("currency",currency);
//               gotoHr.putExtra("urCurrency",urCurrency);
//               startActivity(gotoHr);
//            }
//            else {
//                Intent intent1 = new Intent(Computation.this, stHaryana.class);
//                startActivity(intent1);
//                 }
//        }
//        else{
//            Intent intent2=new Intent(Computation.this,eCostWorld.class);
//            intent2.putExtra("nationName",nationName);
//            startActivity(intent2);
//        }
    }
}
package com.example.costdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    private String userName,nationName,stateName,occName;
    boolean check;
//    private final double usDollar=1;
//    private double urCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        SharedPreferences shrd=getSharedPreferences(Signup.PREFS_NAME,MODE_PRIVATE);
        userName=shrd.getString("user","User Name");
        nationName=shrd.getString("nation","Country Name");
        check=shrd.getBoolean("hasSignedUp",false);
        if(nationName.equals("India (IN)")){
        stateName=shrd.getString("selectedState","AP | Andhra Pradesh");
        }
        else{
          occName=shrd.getString("selectedOccupation","Household");
        }

    }

    public void exitCalled(View view) {
        //for terminate all activity in our app
//        this.finishAffinity();
            new AlertDialog.Builder(this).setIcon(R.drawable.ic_baseline_warning_24).setTitle("Close Application").setMessage("Are you sure to want exit ?").setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            }
        }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            finishAffinity();
            System.exit(0);
            }
//        })
//                    .setNeutralButton("About eCost", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent3=new Intent(Home.this,abtECost.class);
//                startActivity(intent3);
//                finish();
//            }

      }).show();
    }

    public void viewProfile(View view) {
         Intent intent=new Intent(Home.this,Profile.class);
         intent.putExtra("userName",userName);
         intent.putExtra("nationName",nationName);
         if(nationName.equals("India (IN)")){
             intent.putExtra("stateName",stateName);
         }
         else{
             intent.putExtra("occupation",occName);
         }
         startActivity(intent);
    }

    public void homepage(View view) {
        Toast.makeText(getApplicationContext(),"This is Home Page of your app",Toast.LENGTH_SHORT).show();
    }

    public void computationCalled(View view) {
        Intent intent1=new Intent(Home.this,Computation.class);
        intent1.putExtra("checkNation",nationName);
        intent1.putExtra("checkState",stateName);

        startActivity(intent1);
    }

    public void onInfo(View view) {
        Intent abt=new Intent(Home.this,abtECost.class);
        abt.putExtra("name",userName);
        abt.putExtra("nation",nationName);
        if(nationName.equals("India (IN)")){
            abt.putExtra("stateName",stateName);
        }
        startActivity(abt);

    }
}
package com.example.costdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
        private String user,nation,state,occ;
        TextView tvuser,tvnation,tvDyn;
        private boolean check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        SharedPreferences shrd1=getSharedPreferences(Signup.PREFS_NAME,MODE_PRIVATE);
        user=shrd1.getString("user","User Name");
        nation=shrd1.getString("nation","Country Name");
        check=shrd1.getBoolean("hasSignedUp",false);
        if(nation.equals("India (IN)")){
            state=shrd1.getString("selectedState","AP | Andhra Pradesh");
        }
        else{
            occ=shrd1.getString("selectedOccupation","Household");
        }
        tvuser=(TextView) findViewById(R.id.userName);
        tvnation=(TextView) findViewById(R.id.userNation);
        tvDyn=(TextView)findViewById(R.id.userState);
        Intent intent=getIntent();
//        user=intent.getStringExtra("userName");
//        nation=intent.getStringExtra("nationName");
        if(nation.equals("India (IN)")){
            tvDyn.setText(state.toUpperCase());
        }
        else{
            tvDyn.setText(occ);
        }
        tvuser.setText(user); // In lower case
        tvnation.setText(nation.toUpperCase()); // In upper case
    }

    public void onHome(View view) {
        Intent intent1=new Intent(Profile.this,Home.class);
        startActivity(intent1);
    }

    public void onProfile(View view) {
        Toast.makeText(getApplicationContext(),"You are currently on Profile Page",Toast.LENGTH_LONG).show();
    }

    public void onComputation(View view) {
        Intent gotoComputation=new Intent(Profile.this,Computation.class);
        gotoComputation.putExtra("checkNation",nation);
        startActivity(gotoComputation);

    }

    public void updateDetails(View view) {
        Intent intent2=new Intent(Profile.this,Signup.class);
        intent2.putExtra("userName",user);
        intent2.putExtra("nationName",nation);
        if(nation.equals("India (IN)")){
            intent2.putExtra("stateName",state);
        }
        else{
            intent2.putExtra("occupation",occ);
            }
        startActivity(intent2);
    }
}
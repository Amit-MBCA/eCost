package com.example.costdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class abtECost extends AppCompatActivity {
    private String userName,country,state;
    private TextView appinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abt_ecost);
        Intent uname=getIntent();
        userName=uname.getStringExtra("name");
        country=uname.getStringExtra("nation");

        appinfo=findViewById(R.id.textView7);
        if(country.equals("India (IN)")){
            state = uname.getStringExtra("stateName");
            appinfo.setText("\nHi " + userName + ",\neCost team is thankful to you for using it.\n\n- eCost is an application which is designed for those users who have an electricity connection and they want to know how their electricity (several appliances) cost/bill is computed.\n\n- eCost able to compute electricity cost of 180+ countries. You are now able to know about the electricity cost of another countries by changing your profile information.\n\n- The electricity tariff charges are applied according to " + state + " tariff charges.\n\n- Cost is also computed in your national currency so you don't need to convert it form another currency.\n\n- In the case of recently updation in electricity tariff charges you can customize it as per new tariff charges.\n\n- eCost user friendly interface makes it easy to use.\n\n- In this tariff are applied on the basis of household connection tariffs.\n\n- You can use ADD button when you want to compute cost of multiple appliances. Press COMPUTE button to get the result of ADD.\n");
        }
        else
        {
         appinfo.setText("\nHi " + userName + ",\neCost team is thankful to you for using it.\n\n- eCost is an application which is designed for those users who have an electricity connection and they want to know how their electricity (several appliances) cost/bill is computed.\n\n- eCost able to compute electricity cost of 180+ countries. You are now able to know about the electricity cost of another countries by changing your profile information.\n\n- The electricity tariff charges are applied according to " + country + " tariff charges.\n\n- Cost is also computed in your national currency so you don't need to convert it form another currency.\n\n- In the case of recently updation in electricity tariff charges you can customize it as per new tariff charges.\n\n- eCost user friendly interface makes it easy to use.\n\n- You can use ADD button when you want to compute cost of multiple appliances. Press COMPUTE button to get the result of ADD.\n");
        }

    }

    public void returnHome(View view) {
        Intent rHome=new Intent(abtECost.this,Home.class);
        startActivity(rHome);
        finish();
    }
}
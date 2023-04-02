package com.example.costdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DecimalFormat;

public class fromUnits extends AppCompatActivity {
        private String userName,nationName,stateName,occName,sign,setUnitCost,getUnitInStr;
        private EditText getUnit;
        private double cst,result,getCostInDbl;
        private TextView tvforcp,setInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_units);
        SharedPreferences shrd=getSharedPreferences(Signup.PREFS_NAME,MODE_PRIVATE);
        userName=shrd.getString("user","User Name");
        nationName=shrd.getString("nation","Country Name");
        if(nationName.equals("India (IN)")){
            stateName=shrd.getString("selectedState","AP | Andhra Pradesh");
        }
        else{
            occName=shrd.getString("selectedOccupation","Household");
        }
        tvforcp=findViewById(R.id.tvResult);
        setInfo=findViewById(R.id.tvResult2);
        getUnit=findViewById(R.id.etGetUnit);
    }

    public void computeNow(View view) {
        getUnitInStr = getUnit.getText().toString();
        hideSoftKeyboard(fromUnits.this, view);
        if(getUnitInStr.equals(null)||getUnitInStr.equals("")){ //return empty string
            Toast.makeText(getApplicationContext(),"Please enter any value",Toast.LENGTH_SHORT).show();
        }
        else {
            cst = Double.parseDouble(getUnitInStr);
            tvforcp.setVisibility(View.VISIBLE);
            setInfo.setVisibility(View.VISIBLE);
            setCost(nationName);

            getCostInDbl = Double.parseDouble(setUnitCost);
            result = cst * getCostInDbl;
//            setInfo.setText("Error");
            DecimalFormat df = new DecimalFormat("#.###");
            df.setGroupingUsed(true);
            df.setGroupingSize(3);
            tvforcp.setText("Cost of Electricity : " + df.format(result) + " " + sign);
//        tvforcp.setText("Cost of Electricity per day : " +result+ " " + sign);
        }
        }

    public void back(View view) {
        Intent bck=new Intent(fromUnits.this,whatShould.class);
        startActivity(bck);
        finish();
    }
    public static void hideSoftKeyboard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    public void clearit(View view) {
    Intent clr=new Intent(fromUnits.this,fromUnits.class);
    startActivity(clr);
    finish();
    }
    public void setCost(String country) {
        if (country.equals("India (IN)")) {
            sign = "INR";
            switch (stateName) {
                case "AP | Andhra Pradesh":
                if(cst>=0&&cst<=100){
                    setUnitCost="3.35";
                     setInfo.setText("Electricity charges per unit : 3.35 INR \n\n  (0-100 units)");
                }
                else if(cst>=101&&cst<=200){
                    setUnitCost="5.40";
                      setInfo.setText("Electricity charges per unit : 5.40 INR \n\n (101-200 units)");
                }
                else if(cst>=201&&cst<=300){
                    setUnitCost="7.10";
                      setInfo.setText("Electricity charges per unit : 7.10 INR \n\n  (201-300 units)");
                }
                else{
                    setUnitCost="7.80";
                      setInfo.setText("Electricity charges per unit : 7.80 INR \n\n  (Above 300 units)");
                }
                break;
                case "AN | Andaman and Nicobar":
                    if(cst>=0&&cst<=100){
                        setUnitCost="2.25";
                          setInfo.setText("Electricity charges per unit : 2.25 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="5";
                          setInfo.setText("Electricity charges per unit : 5.00 INR \n\n (101-200 units)");
                    }
                    else{
                        setUnitCost="7.2";
                          setInfo.setText("Electricity charges per unit : 7.2 INR \n\n  (Above 300 units)");
                    }
                    break;
                case "MH | Maharashtra":
                    if(cst>=0&&cst<=100){
                        setUnitCost="3.05";
                          setInfo.setText("Electricity charges per unit : 3.05 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=300){
                        setUnitCost="5";
                          setInfo.setText("Electricity charges per unit : 5.00 INR \n\n (101-300 units)");
                    }
                    else if(cst>=301&&cst<=500){
                        setUnitCost="6.65";
                          setInfo.setText("Electricity charges per unit : 6.65 INR \n\n  (301-500 units)");
                    }
                    else{
                        setUnitCost="7.80";
                          setInfo.setText("Electricity charges per unit : 7.80 INR \n\n  (Above 500 units)");
                    }
                    break;
                case "AR | Arunachal Pradesh":
                    if(cst>=0&&cst<=100){
                        setUnitCost="2.65";
                          setInfo.setText("Electricity charges per unit : 2.65 INR \n\n  (0-100 units)");
                    }
                    else{
                        setUnitCost="4";
                          setInfo.setText("Electricity charges per unit : 4.00 INR \n\n  (Above 100 units)");
                        }
                    break;
                case "UT | Uttarakhand":
                    if(cst>=0&&cst<=100){
                        setUnitCost="2.8";
                          setInfo.setText("Electricity charges per unit : 2.80 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="4";
                          setInfo.setText("Electricity charges per unit : 4.00 INR \n\n (101-200 units)");
                    }
                    else if(cst>=201&&cst<=400){
                        setUnitCost="5.5";
                          setInfo.setText("Electricity charges per unit : 5.50 INR \n\n  (201-400 units)");
                    }
                    else{
                        setUnitCost="6.25";
                          setInfo.setText("Electricity charges per unit : 6.25 INR \n\n  (Above 400 units)");
                    }
                    break;
                case "AS | Assam":
                    if(cst>=0&&cst<=120){
                        setUnitCost="4.90";
                          setInfo.setText("Electricity charges per unit : 4.90 INR \n\n  (0-120 units)");
                    }
                    else if(cst>=121&&cst<=240){
                        setUnitCost="6.15";
                          setInfo.setText("Electricity charges per unit : 6.15 INR \n\n (121-240 units)");
                    }
                    else{
                        setUnitCost="7.15";
                          setInfo.setText("Electricity charges per unit : 7.15 INR \n\n  (Above 300 units)");
                    }
                    break;
                case "BR | Bihar":
                    if(cst>=0&&cst<=100){
                        setUnitCost="6.10";
                          setInfo.setText("Electricity charges per unit : 6.10 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="6.95";
                          setInfo.setText("Electricity charges per unit : 6.95 INR \n\n (101-200 units)");
                    }
                    else{
                        setUnitCost="8.05";
                          setInfo.setText("Electricity charges per unit : 8.05 INR \n\n  (Above 200 units)");
                    }
                    break;
                case "CH | Chandigarh":
                    if(cst>=0&&cst<=100){
                        setUnitCost="3.49";
                          setInfo.setText("Electricity charges per unit : 3.49 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=300){
                        setUnitCost="5.84";
                          setInfo.setText("Electricity charges per unit : 5.84 INR \n\n (101-300 units)");
                    }
                    else{
                        setUnitCost="7.30";
                          setInfo.setText("Electricity charges per unit : 7.30 INR \n\n  (Above 300 units)");
                    }
                    break;
                case "PB | Punjab":
                    if(cst>=0&&cst<=100){
                        setUnitCost="3.74";
                          setInfo.setText("Electricity charges per unit : 3.74 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=300){
                        setUnitCost="5.84";
                          setInfo.setText("Electricity charges per unit : 5.84 INR \n\n (101-300 units)");
                    }
                    else{
                        setUnitCost="7.30";
                          setInfo.setText("Electricity charges per unit : 7.30 INR \n\n  (Above 300 units)");
                    }
                    break;
                case "CT | Chhattisgarh":
                    if(cst>=0&&cst<=100){
                        setUnitCost="1";
                          setInfo.setText("Electricity charges per unit : 1.00 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="1.10";
                          setInfo.setText("Electricity charges per unit : 1.10 INR \n\n (101-200 units)");
                    }
                    else if(cst>=201&&cst<=400){
                        setUnitCost="1.70";
                          setInfo.setText("Electricity charges per unit : 1.70 INR \n\n  (201-400 units)");
                    }
                    else if(cst>=401&&cst<=600){
                        setUnitCost="2";
                          setInfo.setText("Electricity charges per unit : 2.00 INR \n\n  (201-400 units)");
                    }
                    else{
                        setUnitCost="2.45";
                          setInfo.setText("Electricity charges per unit : 2.45 INR \n\n  (Above 600 units)");
                    }
                    break;
                case "DN | Dadra and Nagar Haveli":
                    if(cst>=0&&cst<=50){
                        setUnitCost="0.25";
                          setInfo.setText("Electricity charges per unit : 0.25 INR \n\n  (0-50 units)");
                    }
                    else if(cst>=51&&cst<=200){
                        setUnitCost="5.56";
                          setInfo.setText("Electricity charges per unit : 5.56 INR \n\n (51-200 units)");
                    }
                    else if(cst>=201&&cst<=400){
                        setUnitCost="6.67";
                          setInfo.setText("Electricity charges per unit : 6.67 INR \n\n  (201-400 units)");
                    }
                    else{
                        setUnitCost="18.42";
                          setInfo.setText("Electricity charges per unit : 18.42 INR \n\n  (Above 400 units)");
                    }
                    break;
                case "DD | Daman and Diu":
                    if(cst>=0&&cst<=100){
                        setUnitCost="1.60";
                          setInfo.setText("Electricity charges per unit : 1.60 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="2.30";
                          setInfo.setText("Electricity charges per unit : 2.30 INR \n\n (101-200 units)");
                    }
                    else if(cst>=201&&cst<=400){
                        setUnitCost="2.80";
                          setInfo.setText("Electricity charges per unit : 2.80 INR \n\n  (201-400 units)");
                    }
                    else{
                        setUnitCost="3.40";
                          setInfo.setText("Electricity charges per unit : 3.40 INR \n\n  (Above 400 units)");
                        }
                    break;
                case "DL | Delhi":
                    if(cst>=0&&cst<=200){
                        setUnitCost="3";
                          setInfo.setText("Electricity charges per unit : 3.00 INR \n\n  (0-200 units)");
                    }
                    else if(cst>=201&&cst<=400){
                        setUnitCost="4.50";
                          setInfo.setText("Electricity charges per unit : 4.50 INR \n\n (201-400 units)");
                    }
                    else if(cst>=401&&cst<=800){
                        setUnitCost="6.5";
                          setInfo.setText("Electricity charges per unit : 6.50 INR \n\n  (401-800 units)");
                    }
                    else if(cst>=801&&cst<=1200){
                        setUnitCost="7";
                          setInfo.setText("Electricity charges per unit : 7.00 INR \n\n  (801-1200 units)");
                    }
                    else{
                        setUnitCost="8";
                          setInfo.setText("Electricity charges per unit : 8.00 INR \n\n  (Above 1200 units)");
                    }
                    break;
                case "GA | Goa":
                    if(cst>=0&&cst<=100){
                        setUnitCost="1.5";
                          setInfo.setText("Electricity charges per unit : 1.50 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="2.25";
                          setInfo.setText("Electricity charges per unit : 2.25 INR \n\n (101-200 units)");
                    }
                    else if(cst>=201&&cst<=300){
                        setUnitCost="2.85";
                          setInfo.setText("Electricity charges per unit : 2.85 INR \n\n  (201-300 units)");
                    }
                    else if(cst>=301&&cst<=400){
                        setUnitCost="3.65";
                          setInfo.setText("Electricity charges per unit : 3.65 INR \n\n  (301-400 units)");
                    }
                    else{
                        setUnitCost="4.25";
                          setInfo.setText("Electricity charges per unit : 3.40 INR \n\n  (Above 400 units)");
                    }
                    break;
                case "GJ | Gujarat":
                    if(cst>=0&&cst<=50){
                        setUnitCost="3.05";
                          setInfo.setText("Electricity charges per unit : 3.05 INR \n\n  (0-50 units)");
                    }
                    else if(cst>=51&&cst<=100){
                        setUnitCost="3.5";
                          setInfo.setText("Electricity charges per unit : 3.50 INR \n\n (51-100 units)");
                    }
                    else if(cst>=101&&cst<=250){
                        setUnitCost="4.15";
                          setInfo.setText("Electricity charges per unit : 4.15 INR \n\n  (101-250 units)");
                    }
                    else{
                        setUnitCost="5.2";
                          setInfo.setText("Electricity charges per unit : 5.2 INR \n\n  (Above 250 units)");
                    }
                    break;
                case "HR | Haryana":
                    if(cst>=0&&cst<=50){
                        setUnitCost="2";
                          setInfo.setText("Electricity charges per unit : 2.00 INR \n\n  (0-50 units)");
                    }
                    else if(cst>=51&&cst<=150){
                        setUnitCost="2.5";
                          setInfo.setText("Electricity charges per unit : 2.5 INR \n\n (51-150 units)");
                    }
                    else if(cst>=151&&cst<=250){
                        setUnitCost="5.25";
                          setInfo.setText("Electricity charges per unit : 5.25 INR \n\n  (151-250 units)");
                    }
                    else if(cst>=251&&cst<=500){
                        setUnitCost="6.35";
                          setInfo.setText("Electricity charges per unit : 6.35 INR \n\n  (251-500 units)");
                    }
                    else{
                        setUnitCost="7.1";
                          setInfo.setText("Electricity charges per unit : 7.10 INR \n\n  (Above 500 units)");
                    }
                    break;
                case "HP | Himachal Pradesh":
                    if(cst>=0&&cst<=60){
                        setUnitCost="3.30";
                          setInfo.setText("Electricity charges per unit : 3.30 INR \n\n  (0-60 units)");
                    }
                    else if(cst>=61&&cst<=125){
                        setUnitCost="3.95";
                          setInfo.setText("Electricity charges per unit : 3.95 INR \n\n (61-125 units)");
                    }
                    else if(cst>=126&&cst<=300){
                        setUnitCost="4.85";
                          setInfo.setText("Electricity charges per unit : 4.85 INR \n\n  (126-300 units)");
                    }
                    else{
                        setUnitCost="5.45";
                          setInfo.setText("Electricity charges per unit : 5.45 INR \n\n  (Above 300 units)");
                    }
                    break;
                case "JK | Jammu and Kashmir":
                    if(cst>=0&&cst<=100){
                        setUnitCost="1.69";
                          setInfo.setText("Electricity charges per unit : 3.30 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="2.2";
                          setInfo.setText("Electricity charges per unit : 2.20 INR \n\n (101-200 units)");
                    }
                    else if(cst>=201&&cst<=400){
                        setUnitCost="3.3";
                          setInfo.setText("Electricity charges per unit : 3.30 INR \n\n  (201-400 units)");
                    }
                    else{
                        setUnitCost="3.52";
                          setInfo.setText("Electricity charges per unit : 3.52 INR \n\n  (Above 400 units)");
                    }
                    break;
                case "JH | Jharkhand":
                        setUnitCost="5.75";
                          setInfo.setText("Electricity charges per unit : 5.75 INR \n\n  (For all customers)");

                    break;
                case "KA | Karnataka":
                    if(cst>=0&&cst<=50){
                        setUnitCost="4";
                          setInfo.setText("Electricity charges per unit : 4.00 INR \n\n  (0-50 units)");
                    }
                    else if(cst>=51&&cst<=100){
                        setUnitCost="5.25";
                          setInfo.setText("Electricity charges per unit : 5.25 INR \n\n (51-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="6.8";
                          setInfo.setText("Electricity charges per unit : 6.80 INR \n\n  (101-200 units)");
                    }
                    else{
                        setUnitCost="7.65";
                          setInfo.setText("Electricity charges per unit : 7.65 INR \n\n  (Above 200 units)");
                    }
                    break;
                case "KL | Kerala":
                    if(cst>=0&&cst<=50){
                        setUnitCost="3.15";
                          setInfo.setText("Electricity charges per unit : 3.15 INR \n\n  (0-50 units)");
                    }
                    else if(cst>=51&&cst<=100){
                        setUnitCost="3.70";
                          setInfo.setText("Electricity charges per unit : 3.70 INR \n\n (51-100 units)");
                    }
                    else if(cst>=101&&cst<=150){
                        setUnitCost="4.80";
                          setInfo.setText("Electricity charges per unit : 4.80 INR \n\n  (101-150 units)");
                    }
                    else if(cst>=151&&cst<=200){
                        setUnitCost="6.40";
                          setInfo.setText("Electricity charges per unit : 6.40INR \n\n (151-200 units)");
                    }
                    else if(cst>=201&&cst<=250){
                        setUnitCost="7.60";
                          setInfo.setText("Electricity charges per unit : 7.60 INR \n\n  (201-250 units)");
                    }
                    else if(cst>=251&&cst<=300){
                        setUnitCost="5.80";
                          setInfo.setText("Electricity charges per unit : 5.80 INR \n\n (251-300 units)");
                    }
                    else if(cst>=301&&cst<=350){
                        setUnitCost="6.60";
                          setInfo.setText("Electricity charges per unit : 6.60 INR \n\n  (301-350 units)");
                    }
                    else if(cst>=351&&cst<=400){
                        setUnitCost="6.9";
                          setInfo.setText("Electricity charges per unit : 6.90 INR \n\n (351-400 units)");
                    }
                    else if(cst>=401&&cst<=500){
                        setUnitCost="7.1";
                          setInfo.setText("Electricity charges per unit : 7.10 INR \n\n  (401-500 units)");
                    }
                    else{
                        setUnitCost="7.9";
                          setInfo.setText("Electricity charges per unit : 7.90 INR \n\n  (Above 500 units)");
                    }
                    break;
                case "LD | Lakshadweep":
                    if(cst>=0&&cst<=100){
                        setUnitCost="1.35";
                          setInfo.setText("Electricity charges per unit : 1.35 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="3.1";
                          setInfo.setText("Electricity charges per unit : 3.10 INR \n\n (101-200 units)");
                    }
                    else if(cst>=201&&cst<=300){
                        setUnitCost="5.2";
                          setInfo.setText("Electricity charges per unit : 5.20 INR \n\n  (201-300 units)");
                    }
                    else{
                        setUnitCost="6.85";
                          setInfo.setText("Electricity charges per unit : 6.85 INR \n\n  (Above 300 units)");
                    }
                    break;
                case "MP | Madhya Pradesh":
                    if(cst>=0&&cst<=50){
                        setUnitCost="4.13";
                          setInfo.setText("Electricity charges per unit : 4.13 INR \n\n  (0-50 units)");
                    }
                    else if(cst>=51&&cst<=150){
                        setUnitCost="5.05";
                          setInfo.setText("Electricity charges per unit : 5.05 INR \n\n (51-150 units)");
                    }
                    else{
                        setUnitCost="5.05";
                          setInfo.setText("Electricity charges per unit : 5.05 INR \n\n  (Above 150 units)");
                    }
                    break;
                case "MN | Manipur":
                    if(cst>=0&&cst<=100){
                        setUnitCost="5.1";
                          setInfo.setText("Electricity charges per unit : 5.10 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="5.95";
                          setInfo.setText("Electricity charges per unit : 5.95 INR \n\n (101-200 units)");
                    }
                    else{
                        setUnitCost="6.75";
                          setInfo.setText("Electricity charges per unit : 6.75 INR \n\n  (Above 200 units)");
                    }
                    break;
                case "ML | Meghalaya":
                    if(cst>=0&&cst<=100){
                        setUnitCost="4";
                          setInfo.setText("Electricity charges per unit : 4.00 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="4.4";
                          setInfo.setText("Electricity charges per unit : 4.40 INR \n\n (101-200 units)");
                    }
                    else{
                        setUnitCost="6";
                          setInfo.setText("Electricity charges per unit : 6.00 INR \n\n  (Above 200 units)");
                    }
                    break;
                    case "MZ | Mizoram":
                        if(cst>=0&&cst<=100){
                            setUnitCost="4.80";
                              setInfo.setText("Electricity charges per unit : 4.80 INR \n\n  (0-100 units)");
                        }
                        else if(cst>=101&&cst<=200){
                            setUnitCost="5.50";
                              setInfo.setText("Electricity charges per unit : 5.50 INR \n\n (101-200 units)");
                        }
                        else{
                            setUnitCost="5.90";
                              setInfo.setText("Electricity charges per unit : 5.90 INR \n\n  (Above 200 units)");
                        }
                    break;
                case "NL | Nagaland":
                    if(cst>=0&&cst<=30){
                        setUnitCost="4.5";
                          setInfo.setText("Electricity charges per unit : 4.50 INR \n\n  (0-30 units)");
                    }
                    else if(cst>=31&&cst<=100){
                        setUnitCost="5.4";
                          setInfo.setText("Electricity charges per unit : 5.40 INR \n\n (31-100 units)");
                    }
                    else if(cst>=101&&cst<=250){
                        setUnitCost="6";
                          setInfo.setText("Electricity charges per unit : 6.00 INR \n\n  (101-250 units)");
                    }
                    else{
                        setUnitCost="7";
                          setInfo.setText("Electricity charges per unit : 7.00 INR \n\n  (Above 300 units)");
                    }
                    break;
                case "OR | Orissa":
                    if(cst>=0&&cst<=50){
                        setUnitCost="3";
                          setInfo.setText("Electricity charges per unit : 3.00 INR \n\n  (0-50 units)");
                    }
                    else if(cst>=51&&cst<=200){
                        setUnitCost="4.8";
                          setInfo.setText("Electricity charges per unit : 4.8 INR \n\n (51-200 units)");
                    }
                    else if(cst>=201&&cst<=400){
                        setUnitCost="5.8";
                          setInfo.setText("Electricity charges per unit : 5.80 INR \n\n  (201-400 units)");
                    }
                    else{
                        setUnitCost="6.2";
                          setInfo.setText("Electricity charges per unit : 6.20 INR \n\n  (Above 400 units)");
                    }
                    break;
                case "PY | Pondicherry":
                    if(cst>=0&&cst<=100){
                        setUnitCost="1.9";
                          setInfo.setText("Electricity charges per unit : 1.90 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="2.9";
                          setInfo.setText("Electricity charges per unit : 2.90 INR \n\n (101-200 units)");
                    }
                    else if(cst>=201&&cst<=300){
                        setUnitCost="5";
                          setInfo.setText("Electricity charges per unit : 5.00 INR \n\n  (201-300 units)");
                    }
                    else{
                        setUnitCost="6.45";
                          setInfo.setText("Electricity charges per unit : 6.45 INR \n\n  (Above 300 units)");
                    }
                    break;
                case "RJ | Rajasthan":
                    if(cst>=0&&cst<=50){
                        setUnitCost="4.75";
                          setInfo.setText("Electricity charges per unit : 4.75 INR \n\n  (0-50 units)");
                    }
                    else if(cst>=51&&cst<=150){
                        setUnitCost="6.50";
                          setInfo.setText("Electricity charges per unit : 6.50 INR \n\n (51-150 units)");
                    }
                    else if(cst>=151&&cst<=300){
                        setUnitCost="7.35";
                          setInfo.setText("Electricity charges per unit : 7.35 INR \n\n  (151-300 units)");
                    }
                    else if(cst>=301&&cst<=500){
                        setUnitCost="7.65";
                          setInfo.setText("Electricity charges per unit : 7.65 INR \n\n  (301-500 units)");
                    }
                    else{
                        setUnitCost="7.95";
                          setInfo.setText("Electricity charges per unit : 7.95 INR \n\n  (Above 500 units)");
                    }
                    break;
                case "SK | Sikkim":
                    if(cst>=0&&cst<=50){
                        setUnitCost="1";
                          setInfo.setText("Electricity charges per unit : 1.0 INR \n\n INR \n\n  (0-50 units)");
                    }
                    else if(cst>=51&&cst<=100){
                        setUnitCost="2";
                          setInfo.setText("Electricity charges per unit : 3.10 INR \n\n (51-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="3";
                          setInfo.setText("Electricity charges per unit : 3.00 INR \n\n  (101-200 units)");
                    }
                    else if(cst>=201&&cst<=400){
                        setUnitCost="3.50";
                          setInfo.setText("Electricity charges per unit : 3.50 INR \n\n  (201-400 units)");
                    }
                    else{
                        setUnitCost="4";
                          setInfo.setText("Electricity charges per unit : 4 INR \n\n  (Above 400 units)");
                    }
                    break;
                case "TN | Tamil Nadu":
                    if(cst>=0&&cst<=100){
                        setUnitCost="0";
                          setInfo.setText("Electricity charges per unit : 0.00 INR \n\n  (0-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="1.5";
                          setInfo.setText("Electricity charges per unit : 1.50 INR \n\n (101-200 units)");
                    }
                    else if(cst>=201&&cst<=500){
                        setUnitCost="3";
                          setInfo.setText("Electricity charges per unit : 3.00 INR \n\n  (201-500 units)");
                    }
                    else{
                        setUnitCost="6.60";
                          setInfo.setText("Electricity charges per unit : 6.60 INR \n\n  (Above 500 units)");
                    }
                    break;
                case "TG | Telangana":
                    if(cst>=0&&cst<=50){
                        setUnitCost="1.45";
                          setInfo.setText("Electricity charges per unit : 1.45 INR \n\n  (0-50 units)");
                    }
                    else if(cst>=51&&cst<=100){
                        setUnitCost="3.3";
                          setInfo.setText("Electricity charges per unit : 2.60 INR \n\n (51-100 units)");
                    }
                    else if(cst>=101&&cst<=200){
                        setUnitCost="4.3";
                          setInfo.setText("Electricity charges per unit : 5.20 INR \n\n  (101-200 units)");
                    }
                    else if(cst>=201&&cst<=300){
                        setUnitCost="7.2";
                          setInfo.setText("Electricity charges per unit : 7.20 INR \n\n  (201-300 units)");
                    }
                    else if(cst>=301&&cst<=400){
                        setUnitCost="8.5";
                          setInfo.setText("Electricity charges per unit : 8.50 INR \n\n  (301-400 units)");
                    }
                    else if(cst>=401&&cst<=800){
                        setUnitCost="9";
                          setInfo.setText("Electricity charges per unit : 9.00 INR \n\n  (400-800 units)");
                    }

                    else{
                        setUnitCost="9.5";
                          setInfo.setText("Electricity charges per unit : 9.50 INR \n\n  (Above 800 units)");
                    }
                    break;
                case "TR | Tripura":
                    if(cst>=0&&cst<=50){
                        setUnitCost="4.84";
                          setInfo.setText("Electricity charges per unit : 4.84 INR \n\n  (0-50 units)");
                    }
                    else if(cst>=51&&cst<=150){
                        setUnitCost="5.98";
                          setInfo.setText("Electricity charges per unit : 5.98 INR \n\n (51-150 units)");
                    }
                    else if(cst>=151&&cst<=300){
                        setUnitCost="6.16";
                          setInfo.setText("Electricity charges per unit : 6.16 INR \n\n  (151-300 units)");
                    }
                    else{
                        setUnitCost="7.2";
                          setInfo.setText("Electricity charges per unit : 7.20 INR \n\n  (Above 300 units)");
                    }
                    break;
                case "UP | Uttar Pradesh":
                    if(cst>=0&&cst<=150){
                        setUnitCost="5.50";
                          setInfo.setText("Electricity charges per unit : 5.50 INR \n\n  (0-150 units)");
                    }
                    else if(cst>=151&&cst<=300){
                        setUnitCost="6";
                          setInfo.setText("Electricity charges per unit : 6.00 INR \n\n (151-300 units)");
                    }
                    else if(cst>=301&&cst<=500){
                        setUnitCost="6.5";
                          setInfo.setText("Electricity charges per unit : 6.50 INR \n\n  (301-500 units)");
                    }
                    else{
                        setUnitCost="7";
                          setInfo.setText("Electricity charges per unit : 7.00 INR \n\n  (Above 500 units)");
                    }
                    break;
                case "WB | West Bengal":
                    if(cst>=0&&cst<=102){
                        setUnitCost="5.26";
                          setInfo.setText("Electricity charges per unit : 5.26 INR \n\n  (0-102 units)");
                    }
                    else if(cst>=103&&cst<=180){
                        setUnitCost="5.86";
                          setInfo.setText("Electricity charges per unit : 5.86 INR \n\n (103-180 units)");
                    }
                    else if(cst>=181&&cst<=300){
                        setUnitCost="6.73";
                          setInfo.setText("Electricity charges per unit : 6.73 INR \n\n  (181-300 units)");
                    }
                    else if(cst>=301&&cst<=600){
                        setUnitCost="7.23";
                          setInfo.setText("Electricity charges per unit : 7.23 INR \n\n  (301-600 units)");
                    }
                    else if(cst>=601&&cst<=900){
                        setUnitCost="7.32";
                          setInfo.setText("Electricity charges per unit : 6.73 INR \n\n  (601-900 units)");
                    }
                    else{
                        setUnitCost="8.99";
                          setInfo.setText("Electricity charges per unit : 8.99 INR \n\n  (Above 900 units)");
                    }
                    break;
                default:
                    setUnitCost="4.44";
                      setInfo.setText("Electricity charges per unit : 4.44 INR");
                    break;
            }
        }
        else {
            if (occName.equals("Household")) {
                switch (country) {
                    case "Afghanistan (AFG)":
                        sign = "AFN";
                        setUnitCost="3.750";
                          setInfo.setText("Electricity Charges per unit :\n\n 3.750 AFN");
                        break;
                    case "Albania (ALB)":
                        sign = "ALL";
                        setUnitCost="11.400";
                          setInfo.setText("Electricity Charges per unit :\n\n 11.400 ALB");
                        break;

                    case "Algeria (DZ)":
                        sign = "DZD";
                        setUnitCost="5.340";
                          setInfo.setText("Electricity Charges per unit :\n\n 5.340 DZD");
                          break;
                    case "Andorra (AD)":
                        sign = "EUR";
                        setUnitCost="0.100"; //W
                        setInfo.setText("Electricity charges per unit :\n\n 0.100 EUR");
                        break;
                    case "Angola (AO)":
                        sign = "AOA";
                        setUnitCost="11.830";
                        setInfo.setText("Electricity charges per unit :\n\n 11.830 AOA");
                        break;
                    case "Antigua and Barbuda (ATG)":
                        sign = "XCD";
                        setUnitCost="1.00"; //W
                        setInfo.setText("Electricity charges per unit :\n\n 1.00 XCD");
                        break;
                    case "Argentina (AR)":
                        sign = "ARS";
                        setUnitCost="5.870";
                        setInfo.setText("Electricity charges per unit :\n\n 5.870 ARS");
                        break;
                    case "Armenia (AM)":
                        sign = "AMD";
                        setUnitCost="39.980";
                        setInfo.setText("Electricity charges per unit :\n\n 39.980 AMD");
                        break;
                    case "Australia (AUS)":
                        sign = "AUD";
                        setUnitCost="0.312";
                        setInfo.setText("Electricity charges per unit :\n\n 0.312 AUD");
                        break;
                    case "Austria (AT)":
                        sign = "EUR";
                        setUnitCost="0.221";
                        setInfo.setText("Electricity charges per unit :\n\n 0.221 EUR");
                        break;
                    case "Azerbaijan (AZ)":
                        sign = "AZN";
                        setUnitCost="0.070";
                        setInfo.setText("Electricity charges per unit :\n\n 0.070 AZN");
                        break;
                    case "Bahamas (BS)":
                        sign = "BSD";
                        setUnitCost="0.262";
                        setInfo.setText("Electricity charges per unit :\n\n 0.262 BSD");
                        break;
                    case "Bahrain (BH)":
                        sign = "BHD";
                        setUnitCost="0.018";
                        setInfo.setText("Electricity charges per unit :\n\n 0.018 BHD");
                        break;
                    case "Bangladesh (BD)":
                        sign = "BDT";
                        setUnitCost="5.614";
                        setInfo.setText("Electricity charges per unit :\n\n 5.614 BDT");
                        break;
                    case "Barbados (BB)":
                        sign = "BBD";
                        setUnitCost="0.583";
                        setInfo.setText("Electricity charges per unit :\n\n 0.583 BBD");
                        break;
                    case "Belarus (BY)":
                        sign = "BYN";
                        setUnitCost="0.209";
                        setInfo.setText("Electricity charges per unit :\n\n 0.209 BYN");
                        break;
                    case "Belgium (BE)":
                        sign = "EUR";
                        setUnitCost="0.291";
                        setInfo.setText("Electricity charges per unit :\n\n 0.291 EUR");
                        break;
                    case "Belize (BZ)":
                        sign = "BZD";
                        setUnitCost="0.446";
                        setInfo.setText("Electricity charges per unit :\n\n 0.446 BZD");
                        break;
                    case "Benin (BJ)":
                        sign = "XOF";
                        setUnitCost="24.49";//W
                        setInfo.setText("Electricity charges per unit :\n\n 24.49");
                        break;
                    case "Bermuda (BM)":
                        sign = "BMD";
                        setUnitCost="0.370";
                        setInfo.setText("Electricity charges per unit :\n\n 0.370 BMD");
                        break;
                    case "Bhutan (BT)":
                        sign = "BTN";
                        setUnitCost="1.28";
                        setInfo.setText("Electricity charges per unit :\n\n 1.28 BTN");
                        break;
                    case "Bolivia (BO)":
                        sign = "BOV";
                        setUnitCost="0.809";
                        setInfo.setText("Electricity charges per unit :\n\n 0.809 BOV");
                        break;
                    case "Bosnia and Herzegovina (BiH)":
                        sign = "BAM";
                        setUnitCost="0.18";  //W
                        setInfo.setText("Electricity charges per unit :\n\n 0.18 BAM");
                        break;
                    case "Botswana (BW)":
                        sign = "BWP";
                        setUnitCost="1.267";
                        setInfo.setText("Electricity charges per unit :\n\n 1.267 BWP");
                        break;
                    case "Brazil (BR)":
                        sign = "BRL";
                        setUnitCost="0.749";
                        setInfo.setText("Electricity charges per unit :\n\n 0.749 BRL");
                        break;
                    case "Brunei (BN)":
                        sign = "BND";
                        setUnitCost="0.10"; // W
                        setInfo.setText("Electricity charges per unit :\n\n 0.10 BND");
                        break;
                    case "Bulgaria (BG)":
                        sign = "BGN";
                        setUnitCost="0.241";
                        setInfo.setText("Electricity charges per unit :\n\n 0.241 BGN");
                        break;
                    case "Burkina Faso (BF)":
                        sign = "XOF";
                        setUnitCost="123.440";
                        setInfo.setText("Electricity charges per unit :\n\n 123.440 XOF");
                        break;
                    case "Burundi (BI)":
                        sign = "BIF";
                        setUnitCost="264.66"; //W
                        setInfo.setText("Electricity charges per unit :\n\n 264.66 BIF");
                        break;
                    case "Cabo Verde (CV)":
                        sign = "CVE";
                        setUnitCost="24.360";
                        setInfo.setText("Electricity charges per unit :\n\n 24.360 CVE");
                        break;
                    case "Cambodia (KH)":
                        sign = "KHR";
                        setUnitCost="462.29"; //W
                        setInfo.setText("Electricity charges per unit :\n\n 462.29 KHR");
                        break;
                    case "Cameroon (CMR)":
                        sign = "XAF";
                        setUnitCost="50.000";
                        setInfo.setText("Electricity charges per unit :\n\n 50.000 XAF");
                        break;
                    case "Canada (CA)":
                        sign = "CAD";
                        setUnitCost="6.051"; //   7.1
                        setInfo.setText("Electricity charges per unit :\n\n 6.051 CAD");
                        break;
                    case "Central African Republic (CAR)":
                        sign = "XAF";
                        setUnitCost="558"; //W
                        setInfo.setText("Electricity charges per unit :\n\n 558.00 XAF");
                        break;
                    case "Chile (CL)":
                        sign = "CLP";
                        setUnitCost="142.634";
                        setInfo.setText("Electricity charges per unit :\n\n 142.634 CLP");
                        break;
                    case "China (CN)":
                        sign = "CNY";
                        setUnitCost="0.559";
                        setInfo.setText("Electricity charges per unit :\n\n 0.559 CLP");
                        break;
                    case "Colombia (CO)":
                        sign = "COP";
                        setUnitCost="583.620";
                        setInfo.setText("Electricity charges per unit :\n\n 583.620 COP");
                        break;
                    case "Congo (CD)":
                        sign = "XAF";
                        setUnitCost="166.611";
                        setInfo.setText("Electricity charges per unit :\n\n 166.611 XAF");
                        break;
                    case "Costa Rica (CR)":
                        sign = "CRC";
                        setUnitCost="75.240";
                        setInfo.setText("Electricity charges per unit :\n\n 75.240 CRC");
                        break;
                    case "Croatia (HR)":
                        sign = "HRK";
                        setUnitCost="1.041";
                        setInfo.setText("Electricity charges per unit :\n\n 1.041 HRK");
                        break;
                    case "Cuba (CU)":
                        sign = "CUC";
                        setUnitCost="0.720";
                        setInfo.setText("Electricity charges per unit :\n\n 0.720 CUC");
                        break;
                    case "Cyprus (CY)":
                        sign = "EUR";
                        setUnitCost="0.260";
                        setInfo.setText("Electricity charges per unit :\n\n 0.260 EUR");
                        break;
                    case "Czech Republic (CZ)":
                        sign = "CZK";
                        setUnitCost="5.561";
                        setInfo.setText("Electricity charges per unit :\n\n 5.561 CZK");
                        break;
                    case "Denmark (DK)":
                        sign = "DKK";
                        setUnitCost="2.456";
                        setInfo.setText("Electricity charges per unit :\n\n 2.456 DKK");
                        break;
                    case "Djibouti (DJ)":
                        sign = "DJF";
                        setUnitCost="26.72"; // 55.22
                        setInfo.setText("Electricity charges per unit :\n\n 26.72 DJF");
                        break;
                    case "Dominican Republic (DO)":
                        sign = "DOP";
                        setUnitCost="5.126";
                        setInfo.setText("Electricity charges per unit :\n\n 5.126 DOP");
                        break;
                    case "Ecuador (EC)":
                        sign = "USD";
                        setUnitCost="0.096";
                        setInfo.setText("Electricity charges per unit :\n\n 0.096 USD");
                        break;
                    case "Egypt (EG)":
                        sign = "EGP";
                        setUnitCost="0.828";
                        setInfo.setText("Electricity charges per unit :\n\n 0.828 EGP");
                        break;
                    case "El Salvador (SV)":
                        sign = "USD";
                        setUnitCost="0.199";
                        setInfo.setText("Electricity charges per unit :\n\n 0.199 USD");
                        break;
                    case "Estonia (EE)":
                        sign = "EUR";
                        setUnitCost="0.176";
                        setInfo.setText("Electricity charges per unit :\n\n 0.176 EUR");
                        break;
                    case "Ethiopia (ET)":
                        sign = "ETB";
                        setUnitCost="0.349";
                        setInfo.setText("Electricity charges per unit :\n\n 0.349 ETB");
                        break;
                    case "Fiji (FJ)":
                        sign = "FJD";
                        setUnitCost="0.34";
                        setInfo.setText("Electricity charges per unit :\n\n 0.34 FJD");
                        break;
                    case "Finland (FI)":
                        sign = "EUR";
                        setUnitCost="0.172";
                        setInfo.setText("Electricity charges per unit :\n\n 0.172 EUR");
                        break;
                    case "France (FR)":
                        sign = "EUR";
                        setUnitCost="0.185";
                        setInfo.setText("Electricity charges per unit :\n\n 0.185 EUR");
                        break;
                    case "Gabon (GA)":
                        sign = "XAF";
                        setUnitCost="122.960";
                        setInfo.setText("Electricity charges per unit :\n\n 122.960 XAF");
                        break;
                    case "Gambia (GM)":
                        sign = "GMD";
                        setUnitCost="10.14"; //10.90
                        setInfo.setText("Electricity charges per unit :\n\n 10.14 GMD");
                        break;
                    case "Georgia (GA)":
                        sign = "GEL";
                        setUnitCost="0.199";
                        setInfo.setText("Electricity charges per unit :\n\n 0.199 GEL");
                        break;
                    case "Germany (DE)":
                        sign = "EUR";
                        setUnitCost="0.317";
                        setInfo.setText("Electricity charges per unit :\n\n 0.317 EUR");
                        break;
                    case "Ghana (GH)":
                        sign = "GHS";
                        setUnitCost="0.369";
                        setInfo.setText("Electricity charges per unit :\n\n 0.369 GHS");
                        break;
                    case "Great Britain [UK]":
                        sign = "GBP";
                        setUnitCost="0.218";
                        setInfo.setText("Electricity charges per unit :\n\n 0.218 GBP");
                        break;
                    case "Greece (GR)":
                        sign = "EUR";
                        setUnitCost="0.187";
                        setInfo.setText("Electricity charges per unit :\n\n 0.187 EUR");
                        break;
                    case "Guatemala (GT)":
                        sign = "GTQ";
                        setUnitCost="1.996";
                        setInfo.setText("Electricity charges per unit :\n\n 1.996 GTQ");
                        break;
                    case "Guyana (GY)":
                        sign = "GYD";
                        setUnitCost="66.86";
                        setInfo.setText("Electricity charges per unit :\n\n 66.86 GYD");
                        break;
                    case "Haiti (HT)":
                        sign = "HTG";
                        setUnitCost="39.57";
                        setInfo.setText("Electricity charges per unit :\n\n 39.57 HTG");
                        break;
                    case "Honduras (HN)":
                        sign = "HNL";
                        setUnitCost="4.402";
                        setInfo.setText("Electricity charges per unit :\n\n 4.402 HNL");
                        break;
                    case "Hong Kong (HK)":
                        sign = "HKD";
                        setUnitCost="1.176";
                        setInfo.setText("Electricity charges per unit :\n\n 1.176 HKD");
                        break;
                    case "Hungary (HU)":
                        sign = "HUF";
                        setUnitCost="37.462";
                        setInfo.setText("Electricity charges per unit :\n\n 37.462 HUF");
                        break;
                    case "Iceland (IS)":
                        sign = "ISK";
                        setUnitCost="18.477";
                        setInfo.setText("Electricity charges per unit :\n\n 18.477 ISK");
                        break;
                    case "Indonesia (ID)":
                        sign = "IDR";
                        setUnitCost="1444.700";
                        setInfo.setText("Electricity charges per unit :\n\n 1,444.700 IDR");
                        break;
                    case "Iran (IR)":
                        sign = "IRR";
                        setUnitCost="1402.0";
                        setInfo.setText("Electricity charges per unit :\n\n 1,402.00 IRR");
                        break;
                    case "Iraq (IQ)":
                        sign = "IQD";
                        setUnitCost="35.0";
                        setInfo.setText("Electricity charges per unit :\n\n 35.00 IQD");
                        break;
                    case "Ireland (IE)":
                        sign = "EUR";
                        setUnitCost="0.242";
                        setInfo.setText("Electricity charges per unit :\n\n 0.242 EUR");
                        break;
                    case "Israel (IL)":
                        sign = "ILS";
                        setUnitCost="0.549";
                        setInfo.setText("Electricity charges per unit :\n\n 0.549 ILS");
                        break;
                    case "Italy (IT)":
                        sign = "EUR";
                        setUnitCost="0.214";
                        setInfo.setText("Electricity charges per unit :\n\n 0.214 EUR");
                        break;
                    case "Ivory Coast (CI)":
                        sign = "XOF";
                        setUnitCost="72.604";
                        setInfo.setText("Electricity charges per unit :\n\n 72.604 XOF");
                        break;
                    case "Jamaica (JM)":
                        sign = "JMD";
                        setUnitCost="39.683";
                        setInfo.setText("Electricity charges per unit :\n\n 39.683 JMD");
                        break;
                    case "Japan (JP)":
                        sign = "JPY";
                        setUnitCost="30.262";
                        setInfo.setText("Electricity charges per unit :\n\n 30.262 JPY");
                        break;
                    case "Jordan (JO)":
                        sign = "JOD";
                        setUnitCost="0.071";
                        setInfo.setText("Electricity charges per unit :\n\n 0.071 JOD");
                        break;
                    case "Kazakhstan (KZ)":
                        sign = "KZT";
                        setUnitCost="19.129";
                        setInfo.setText("Electricity charges per unit :\n\n 0.071 KZT");
                        break;
                    case "Kenya (KE)":
                        sign = "KES";
                        setUnitCost="24.770";//20.280
                        setInfo.setText("Electricity charges per unit :\n\n 24.77 KES");
                        break;
                    case "Kiribati (KI)":
                        sign = "AUD";
                        setUnitCost="0.60";
                        setInfo.setText("Electricity charges per unit :\n\n 0.60 AUD");
                        break;
                    case "Kuwait (KW)":
                        sign = "KWD";
                        setUnitCost="0.009";
                        setInfo.setText("Electricity charges per unit :\n\n 0.009 KWD");
                        break;
                    case "Kyrgyzstan (KG)":
                        sign = "KGS";
                        setUnitCost="0.860";
                        setInfo.setText("Electricity charges per unit :\n\n 0.860 KGS");
                        break;
                    case "Laos":
                        sign = "LAK";
                        setUnitCost="593.380";
                        setInfo.setText("Electricity charges per unit :\n\n 593.380 LAK");
                        break;
                    case "Latvia (LV)":
                        sign = "EUR";
                        setUnitCost="0.156";
                        setInfo.setText("Electricity charges per unit :\n\n 0.156 EUR");
                        break;
                    case "Lebanon (LB)":
                        sign = "LBP";
                        setUnitCost="116.720";
                        setInfo.setText("Electricity charges per unit :\n\n 116.720 LBP");
                        break;
                    case "Lesotho (LS)":
                        sign = "LSL";
                        setUnitCost="1.550";
                        setInfo.setText("Electricity charges per unit :\n\n 1.550 LSL");
                        break;
                    case "Liberia (LR)":
                        sign = "LRD";
                        setUnitCost="82.35";
                        setInfo.setText("Electricity charges per unit :\n\n 82.35 LRD");
                        break;
                    case "Libya (LY)":
                        sign = "LYD";
                        setUnitCost="0.02";
                        setInfo.setText("Electricity charges per unit :\n\n 0.02 LYD");
                        break;
                    case "Liechtenstein (LI)":
                        sign = "CHF";
                        setUnitCost="0.257";
                        setInfo.setText("Electricity charges per unit :\n\n 0.257 CHF");
                        break;
                    case "Lithuania (LT)":
                        sign = "EUR";
                        setUnitCost="0.186";
                        setInfo.setText("Electricity charges per unit :\n\n 0.186 EUR");
                        break;
                    case "Luxembourg (LU)":
                        sign = "EUR";
                        setUnitCost="0.212";
                        setInfo.setText("Electricity charges per unit :\n\n 0.212 EUR");
                        break;
                    case "Madagascar (MG)":
                        sign = "MGA";
                        setUnitCost="581.890";
                        setInfo.setText("Electricity charges per unit :\n\n 581.890 MGA");
                        break;
                    case "Malawi (MW)":
                        sign = "MWK";
                        setUnitCost="112.100";
                        setInfo.setText("Electricity charges per unit :\n\n 112.10 MWK");
                        break;
                    case "Malaysia (MY)":
                        sign = "MYR";
                        setUnitCost="0.221";
                        setInfo.setText("Electricity charges per unit :\n\n 0.221 MYR");
                        break;
                    case "Maldives (MV)":
                        sign = "MVR";
                        setUnitCost="1.7";//3.55
                        setInfo.setText("Electricity charges per unit :\n\n 1.70 MVR");
                        break;
                    case "Mali (ML)":
                        sign = "XOF";
                        setUnitCost="131.080";
                        setInfo.setText("Electricity charges per unit :\n\n 131.08 XOF");
                        break;
                    case "Malta (MT)":
                        sign = "EUR";
                        setUnitCost="0.134";
                        setInfo.setText("Electricity charges per unit :\n\n 0.134 EUR");
                        break;
                    case "Marshall Islands (MI)":
                        sign = "USD";
                        setUnitCost="0.346";//0.406
                        setInfo.setText("Electricity charges per unit :\n\n 0.346 USD");
                        break;
                    case "Mauritius (MU)":
                        sign = "MUR";
                        setUnitCost="6.050";
                        setInfo.setText("Electricity charges per unit :\n\n 6.05 MUR");
                        break;
                    case "Mexico (MX)":
                        sign = "MXN";
                        setUnitCost="1.712";
                        setInfo.setText("Electricity charges per unit :\n\n 1.712 MXN");
                        break;
                    case "Micronesia (FM)":
                        sign = "USD";
                        setUnitCost="0.48";
                        setInfo.setText("Electricity charges per unit :\n\n 0.48 USD");
                        break;
                    case "Moldova (MD)":
                        sign = "MDL";
                        setUnitCost="1.510";
                        setInfo.setText("Electricity charges per unit :\n\n 1.51 MDL");
                        break;
                    case "Monaco (MC)":
                        sign = "EUR";
                        setUnitCost="0.15";
                        setInfo.setText("Electricity charges per unit :\n\n 0.15 EUR");
                        break;
                    case "Mongolia (MN)":
                        sign = "MNT";
                        setUnitCost="188.16";
                        setInfo.setText("Electricity charges per unit :\n\n 188.16 MNT");
                        break;
                    case "Montenegro (ME)":
                        sign = "EUR";
                        setUnitCost="0.097";
                        setInfo.setText("Electricity charges per unit :\n\n 0.097 EUR");
                        break;
                    case "Morocco (MA)":
                        sign = "MAD";
                        setUnitCost="1.172";
                        setInfo.setText("Electricity charges per unit :\n\n 1.172 MAD");
                        break;
                    case "Mozambique (MZ)":
                        sign = "MZN";
                        setUnitCost="8.975";
                        setInfo.setText("Electricity charges per unit :\n\n 8.975 MZN");
                        break;
                    case "Myanmar (MM)":
                        sign = "MMK";
                        setUnitCost="60.500";
                        setInfo.setText("Electricity charges per unit :\n\n 60.50 MMK");
                        break;
                    case "Namibia (NA)":
                        sign = "NAD";
                        setUnitCost="1.952";
                        setInfo.setText("Electricity charges per unit :\n\n 1.952 NAD");
                        break;
                    case "Nauru (NR)":
                        sign = "AUD";
                        setUnitCost="0.10";//0.20
                        setInfo.setText("Electricity charges per unit :\n\n 0.10 AUD");
                        break;
                    case "Nepal (NP)":
                        sign = "NPR";
                        setUnitCost="8.290";
                        setInfo.setText("Electricity charges per unit :\n\n 8.29 NPR");
                        break;
                    case "Netherlands (NL)":
                        sign = "EUR";
                        setUnitCost="0.191";
                        setInfo.setText("Electricity charges per unit :\n\n 0.191 EUR");
                        break;
                    case "New Zealand (NZ)":
                        sign = "NZD";
                        setUnitCost="0.304";
                        setInfo.setText("Electricity charges per unit :\n\n 0.304 NZD");
                        break;
                    case "Nicaragua (NI)":
                        sign = "NIO";
                        setUnitCost="6.226";
                        setInfo.setText("Electricity charges per unit :\n\n 6.226 NIO");
                        break;
                    case "Niger (NE)":
                        sign = "XOF";
                        setUnitCost="104.19";
                        setInfo.setText("Electricity charges per unit :\n\n 104.19 XOF");
                        break;
                    case "Nigeria (NG)":
                        sign = "NGN";
                        setUnitCost="23.592";
                        setInfo.setText("Electricity charges per unit :\n\n 23.592 NGN");
                        break;
                    case "Norway (NO)":
                        sign = "NOK";
                        setUnitCost="1.377";
                        setInfo.setText("Electricity charges per unit :\n\n 1.377 NOK");
                        break;
                    case "Oman (OM)":
                        sign = "OMR";
                        setUnitCost="0.010";
                        setInfo.setText("Electricity charges per unit :\n\n 0.01 OMR");
                        break;
                    case "Pakistan (PK)":
                        sign = "PKR";
                        setUnitCost="9.230";
                        setInfo.setText("Electricity charges per unit :\n\n 9.23 PKR");
                        break;
                    case "Palau (PW)":
                        sign = "USD";
                        setUnitCost="0.28";
                        setInfo.setText("Electricity charges per unit :\n\n 0.28 USD");
                        break;
                    case "Palestine State (PS)":
                        sign = "PSP";
                        setUnitCost="0.085";
                        setInfo.setText("Electricity charges per unit :\n\n 0.085 PSP");
                        break;
                    case "Panama (PA)":
                        sign = "USD";
                        setUnitCost="0.154";
                        setInfo.setText("Electricity charges per unit :\n\n 0.154 USD");
                        break;
                    case "Papua New Guinea (PG)":
                        sign = "PGK";
                        setUnitCost="1029";
                        setInfo.setText("Electricity charges per unit :\n\n 1,029 PGK");
                        break;
                    case "Paraguay (PY)":
                        sign = "PYG";
                        setUnitCost="401.995";
                        setInfo.setText("Electricity charges per unit :\n\n 401.995 PYG");
                        break;
                    case "Peru (PE)":
                        sign = "PEN";
                        setUnitCost="0.773";
                        setInfo.setText("Electricity charges per unit :\n\n 0.773 PEN");
                        break;
                    case "Philippines (PH)":
                        sign = "PHP";
                        setUnitCost="8.907";
                        setInfo.setText("Electricity charges per unit :\n\n 8.907 PHP");
                        break;
                    case "Poland (PL)":
                        sign = "PLN";
                        setUnitCost="0.756";
                        setInfo.setText("Electricity charges per unit :\n\n 0.756 PLN");
                        break;
                    case "Puerto Rico (PR)":
                        sign = "USD";
                        setUnitCost="0.26";//0.30
                        setInfo.setText("Electricity charges per unit :\n\n 0.26 USD");
                        break;
                    case "Portugal (PT)":
                        sign = "EUR";
                        setUnitCost="0.229";
                        setInfo.setText("Electricity charges per unit :\n\n 0.229 EUR");
                        break;
                    case "Qatar (QA)":
                        sign = "QAR";
                        setUnitCost="0.115";
                        setInfo.setText("Electricity charges per unit :\n\n 0.115 QAR");
                        break;
                    case "Republic of Korea (KR)":
                        sign = "LRW";
                        setUnitCost="130.000";
                        setInfo.setText("Electricity charges per unit :\n\n 130.00 LRW");
                        break;
                    case "Romania (RO)":
                        sign = "RON";
                        setUnitCost="0.737";
                        setInfo.setText("Electricity charges per unit :\n\n 0.737 RON");
                        break;
                    case "Russian Federation (RU)":
                        sign = "RUB";
                        setUnitCost="4.811";
                        setInfo.setText("Electricity charges per unit :\n\n 4.811 RUB");
                        break;
                    case "Rwanda (RW)":
                        sign = "RWF";
                        setUnitCost="257.290";
                        setInfo.setText("Electricity charges per unit :\n\n 257.29 RWF");
                        break;
                    case "Saint Kitts and Nevis (KN)":
                        sign = "XCD";
                        setUnitCost="0.89";
                        setInfo.setText("Electricity charges per unit :\n\n 0.89 XCD");
                        break;
                    case "Saint Lucia (LC)":
                        sign = "XCD";
                        setUnitCost="0.90";
                        setInfo.setText("Electricity charges per unit :\n\n 0.90 XCD");
                        break;
                    case "Saint Vincent and the Grenadines (VC)":
                        sign = "XCD";
                        setUnitCost="0.26";
                        setInfo.setText("Electricity charges per unit :\n\n 0.26 XCD");
                        break;
                    case "Samoa (SO)":
                        sign = "WST";
                        setUnitCost="0.375";//0.321
                        setInfo.setText("Electricity charges per unit :\n\n 0.375 WST");
                        break;
                    case "San Marino (SM)":
                        sign = "EUR";
                        setUnitCost="0.16";
                        setInfo.setText("Electricity charges per unit :\n\n 0.16 EUR");
                        break;
                    case "Sao Tome and Principe":
                        sign = "STN";
                        setUnitCost="7.5";
                        setInfo.setText("Electricity charges per unit :\n\n 7.50 STN");
                        break;
                    case "Saudi Arabia (SA)":
                        sign = "SAR";
                        setUnitCost="0.180";
                        setInfo.setText("Electricity charges per unit :\n\n 0.180 SAR");
                        break;
                    case "Senegal (SN)":
                        sign = "XOF";
                        setUnitCost="103.245";
                        setInfo.setText("Electricity charges per unit :\n\n 103.245 XOF");
                        break;
                    case "Serbia (RS)":
                        sign = "RSD";
                        setUnitCost="10.250";
                        setInfo.setText("Electricity charges per unit :\n\n 10.25 RSD");
                        break;
                    case "Seychelles (SC)":
                        sign = "SCR";
                        setUnitCost="1.60";//3.5
                        setInfo.setText("Electricity charges per unit :\n\n 1.60 SCR");
                        break;
                    case "Sierra Leone (SL)":
                        sign = "SLL";
                        setUnitCost="1606.000";
                        setInfo.setText("Electricity charges per unit :\n\n 1,606 SLL");
                        break;
                    case "Singapore (SG)":
                        sign = "SGD";
                        setUnitCost="0.250";
                        setInfo.setText("Electricity charges per unit :\n\n 0.25 SGD");
                        break;
                    case "Slovakia (SK)":
                        sign = "EUR";
                        setUnitCost="0.169";
                        setInfo.setText("Electricity charges per unit :\n\n 0.169 EUR");
                        break;
                    case "Slovenia (SI)":
                        sign = "EUR";
                        setUnitCost="0.179";
                        setInfo.setText("Electricity charges per unit :\n\n 0.179 EUR");
                        break;
                    case "Somalia (SO)":
                        sign = "SOS";
                        setUnitCost="350";
                        setInfo.setText("Electricity charges per unit :\n\n 350 SOS");
                        break;
                    case "South Africa (ZA)":
                        sign = "ZAR";
                        setUnitCost="2.558";
                        setInfo.setText("Electricity charges per unit :\n\n 2.558 ZAR");
                        break;
                    case "South Korea (KR)":
                        sign = "SKW";
                        setUnitCost="123.022";
                        setInfo.setText("Electricity charges per unit :\n\n 123.022 SKW");
                        break;
                    case "Spain (ES)":
                        sign = "EUR";
                        setUnitCost="0.242";
                        setInfo.setText("Electricity charges per unit :\n\n 0.242 EUR");
                        break;
                    case "Sri Lanka (LK)":
                        sign = "LKR";
                        setUnitCost="15.290";
                        setInfo.setText("Electricity charges per unit :\n\n 15.290 LKR");
                        break;
                    case "Sudan (SD)":
                        sign = "SDG";
                        setUnitCost="0.800";
                        setInfo.setText("Electricity charges per unit :\n\n 0.80 SDG");
                        break;
                    case "Suriname (SR)":
                        sign = "SRD";
                        setUnitCost="0.350";
                        setInfo.setText("Electricity charges per unit :\n\n 0.350 SRD");
                        break;
                    case "Sweden (SE)":
                        sign = "SEK";
                        setUnitCost="1.770";
                        setInfo.setText("Electricity charges per unit :\n\n 1.77 SEK");
                        break;
                    case "Switzerland (CH)":
                        sign = "CHF";
                        setUnitCost="0.206";
                        setInfo.setText("Electricity charges per unit :\n\n 0.206 CHF");
                        break;
                    case "Syria (SY)":
                        sign = "SYP";
                        setUnitCost="560";
                        setInfo.setText("Electricity charges per unit :\n\n 560 SYP");
                        break;
                    case "Taiwan (TW)":
                        sign = "TWD";
                        setUnitCost="2.924";
                        setInfo.setText("Electricity charges per unit :\n\n 2.924 TWD");
                        break;
                    case "Tajikistan (TJ)":
                        sign = "TJS";
                        setUnitCost="0.081";//0.13
                        setInfo.setText("Electricity charges per unit :\n\n 0.081 TJS");
                        break;
                    case "Tanzania (TZ)":
                        sign = "TZS";
                        setUnitCost="229.590";
                        setInfo.setText("Electricity charges per unit :\n\n 229.59 TZS");
                        break;
                    case "Thailand (TH)":
                        sign = "THB";
                        setUnitCost="3.777";
                        setInfo.setText("Electricity charges per unit :\n\n 3.777 THB");
                        break;
                    case "Timor-Leste (TL)":
                        sign = "USD";
                        setUnitCost="0.12";
                        setInfo.setText("Electricity charges per unit :\n\n 0.12 USD");
                        break;
                    case "Togo (TG)":
                        sign = "XOF";
                        setUnitCost="115.880";
                        setInfo.setText("Electricity charges per unit :\n\n 115.88 XOF");
                        break;
                    case "Tonga (TO)":
                        sign = "TOP";
                        setUnitCost="0.76";
                        setInfo.setText("Electricity charges per unit :\n\n 0.76 TOP");
                        break;
                    case "Trinidad and Tobago (TT)":
                        sign = "TTD";
                        setUnitCost="0.354";
                        setInfo.setText("Electricity charges per unit :\n\n 0.354 TTD");
                        break;
                    case "Tunisia (TN)":
                        sign = "TND";
                        setUnitCost="0.210";
                        setInfo.setText("Electricity charges per unit :\n\n 0.210 TND");
                        break;
                    case "Turkey (TR)":
                        sign = "TRY";
                        setUnitCost="0.920";
                        setInfo.setText("Electricity charges per unit :\n\n 0.920 TRY");
                        break;
                    case "Turkmenistan (TK)":
                        sign = "TMT";
                        setUnitCost="0.98";
                        setInfo.setText("Electricity charges per unit :\n\n 0.98 TMT");
                        break;
                    case "Tuvalu (TV)":
                        sign = "AUD";
                        setUnitCost="0.05";
                        setInfo.setText("Electricity charges per unit :\n\n 0.05");
                        break;
                    case "Uganda (UG)":
                        sign = "UGX";
                        setUnitCost="672.875";
                        setInfo.setText("Electricity charges per unit :\n\n 672.875 UGX");
                        break;
                    case "Ukraine (UA)":
                        sign = "UAH";
                        setUnitCost="1.680";
                        setInfo.setText("Electricity charges per unit :\n\n 1.680 UAH");
                        break;
                    case "United Arab Emirates (AE)":
                        sign = "AED";
                        setUnitCost="0.296";
                        setInfo.setText("Electricity charges per unit :\n\n 0.296 AED");
                        break;
                    case "United Kingdom (UK)":
                        sign = "GBP";
                        setUnitCost="0.218";
                        setInfo.setText("Electricity charges per unit :\n\n 0.218 GBP");
                        break;
                    case "Uruguay (UY)":
                        sign = "UYI";
                        setUnitCost="9.156";
                        setInfo.setText("Electricity charges per unit :\n\n 9.156 UYI");
                        break;
                    case "Uzbekistan (UZ)":
                        sign = "UZS";
                        setUnitCost="295";
                        setInfo.setText("Electricity charges per unit :\n\n 295.000 UZS");
                        break;
                    case "Vanuatu (VU)":
                        sign = "VUV";
                        setUnitCost="59.71";
                        setInfo.setText("Electricity charges per unit :\n\n 59.71 VUV");
                        break;
                    case "Venezuela (VE)":
                        sign = "VEF";
                        setUnitCost="1.093";
                        setInfo.setText("Electricity charges per unit :\n\n 1.093 VEF");
                        break;
                    case "Vietnam (VN)":
                        sign = "VND";
                        setUnitCost="1876.600";
                        setInfo.setText("Electricity charges per unit :\n\n 1876.000 VND");
                        break;
                    case "Yemen (YE)":
                        sign = "YER";
                        setUnitCost="350.0";//650
                        setInfo.setText("Electricity charges per unit :\n\n 350.00 YER");
                        break;
                    case "Zambia (ZM)":
                        sign = "ZMW";
                        setUnitCost="0.559";
                        setInfo.setText("Electricity charges per unit :\n\n 0.559 ZMW");
                        break;
                    case "Zimbabwe (ZW)":
                        sign = "ZWL";
                        setUnitCost="4.282";
                        setInfo.setText("Electricity charges per unit :\n\n 4.282 ZWL");
                        break;
                    default:
                        sign = "$";
                        setUnitCost="0.060";
                }
            }
            else {
                switch (country) {
                    case "Afghanistan (AFG)":
                        sign = "AFN";
                        setUnitCost="3.750";
                        setInfo.setText("Electricity charges per unit :\n\n3.750 AFN");
                        break;
                    case "Albania (ALB)":
                        sign = "ALL";
                        setUnitCost="12.650";
                        setInfo.setText("Electricity charges per unit :\n\n 12.650 ALL");
                        break;

                    case "Algeria (DZ)":
                        sign = "DZD";
                        setUnitCost="4.578";
                        setInfo.setText("Electricity charges per unit :\n\n 4.578 DZD");
                        break;

                    case "Andorra (AD)":
                        sign = "EUR";
                        setUnitCost="0.100";
                        setInfo.setText("Electricity charges per unit :\n\n 0.10 EUR");
                        break;
                    case "Angola (AO)":
                        sign = "AOA";
                        setUnitCost="9.640";
                        setInfo.setText("Electricity charges per unit :\n\n 9.640 AOA");
                        break;
                    case "Antigua and Barbuda (ATG)":
                        sign = "XCD";
                        setUnitCost="1.00";
                        setInfo.setText("Electricity charges per unit :\n\n 1.00 XCD");
                        break;
                    case "Argentina (AR)":
                        sign = "ARS";
                        setUnitCost="4.420";
                        setInfo.setText("Electricity charges per unit :\n\n 4.420 ARS");
                        break;
                    case "Armenia (AM)":
                        sign = "AMD";
                        setUnitCost="32.480";
                        setInfo.setText("Electricity charges per unit :\n\n 32.480 AMD");
                        break;
                    case "Australia (AUS)":
                        sign = "AUD";
                        setUnitCost="0.262";
                        setInfo.setText("Electricity charges per unit :\n\n 0.262 AUD");
                        break;
                    case "Austria (AT)":
                        sign = "EUR";
                        setUnitCost="0.162";
                        setInfo.setText("Electricity charges per unit :\n\n 0.162 EUR");
                        break;
                    case "Azerbaijan (AZ)":
                        sign = "AZN";
                        setUnitCost="0.090";
                        setInfo.setText("Electricity charges per unit :\n\n 0.09 AZN");
                        break;
                    case "Bahamas (BS)":
                        sign = "BSD";
                        setUnitCost="0.253";
                        setInfo.setText("Electricity charges per unit :\n\n 0.253 BSD");
                        break;
                    case "Bahrain (BH)":
                        sign = "BHD";
                        setUnitCost="0.029";
                        setInfo.setText("Electricity charges per unit :\n\n 0.029 BHD");
                        break;
                    case "Bangladesh (BD)":
                        sign = "BDT";
                        setUnitCost="8.990";
                        setInfo.setText("Electricity charges per unit :\n\n 8.99 BDT");
                        break;
                    case "Barbados (BB)":
                        sign = "BBD";
                        setUnitCost="0.579";
                        setInfo.setText("Electricity charges per unit :\n\n 0.579 BBD");
                        break;
                    case "Belarus (BY)":
                        sign = "BYN";
                        setUnitCost="0.287";
                        setInfo.setText("Electricity charges per unit :\n\n 0.287 BYN");
                        break;
                    case "Belgium (BE)":
                        sign = "EUR";
                        setUnitCost="0.106";
                        setInfo.setText("Electricity charges per unit :\n\n 0.106 EUR");
                        break;
                    case "Belize (BZ)":
                        sign = "BZD";
                        setUnitCost="0.349";
                        setInfo.setText("Electricity charges per unit :\n\n 0.349 BZD");
                        break;
                    case "Benin (BJ)":
                        sign = "XOF";
                        setUnitCost="24.49";
                        setInfo.setText("Electricity charges per unit :\n\n 24.49 XOF");
                        break;
                    case "Bermuda (BM)":
                        sign = "BMD";
                        setUnitCost="0.216";
                        setInfo.setText("Electricity charges per unit :\n\n 0.216 BMD");
                        break;
                    case "Bhutan (BT)":
                        sign = "BTN";
                        setUnitCost="2.720";
                        setInfo.setText("Electricity charges per unit :\n\n 2.720 BTN");
                        break;
                    case "Bolivia (BO)":
                        sign = "BOV";
                        setUnitCost="0.809";
                        setInfo.setText("Electricity charges per unit :\n\n 0.809 BOV");
                        break;
                    case "Bosnia and Herzegovina (BiH)":
                        sign = "BAM";
                        setUnitCost="0.18";
                        setInfo.setText("Electricity charges per unit :\n\n 0.18 BAM");
                        break;
                    case "Botswana (BW)":
                        sign = "BWP";
                        setUnitCost="1.480";
                        setInfo.setText("Electricity charges per unit :\n\n 1.480 BWP");
                        break;
                    case "Brazil (BR)":
                        sign = "BRL";
                        setUnitCost="0.759";
                        setInfo.setText("Electricity charges per unit :\n\n 0.759 BRL");
                        break;
                    case "Brunei (BN)":
                        sign = "BND";
                        setUnitCost="0.12";
                        setInfo.setText("Electricity charges per unit :\n\n 0.12 BND");
                        break;
                    case "Bulgaria (BG)":
                        sign = "BGN";
                        setUnitCost="0.253";
                        setInfo.setText("Electricity charges per unit :\n\n 0.253 BGN");
                        break;
                    case "Burkina Faso (BF)":
                        sign = "XOF";
                        setUnitCost="272.600";
                        setInfo.setText("Electricity charges per unit :\n\n 272.600 XOF");
                        break;
                    case "Burundi (BI)":
                        sign = "BIF";
                        setUnitCost="264.66";
                        setInfo.setText("Electricity charges per unit :\n\n 264.66 BIF");
                        break;
                    case "Cabo Verde (CV)":
                        sign = "CVE";
                        setUnitCost="24.360";
                        setInfo.setText("Electricity charges per unit :\n\n 24.360 CVE");
                        break;
                    case "Cambodia (KH)":
                        sign = "KHR";
                        setUnitCost="462.29";
                        setInfo.setText("Electricity charges per unit :\n\n 462.29 KHR");
                        break;
                    case "Cameroon (CMR)":
                        sign = "XAF";
                        setUnitCost="91.980";
                        setInfo.setText("Electricity charges per unit :\n\n 91.980 XAF");
                        break;
                    case "Canada (CA)":
                        sign = "CAD";
                        setUnitCost="7.1";
                        setInfo.setText("Electricity charges per unit :\n\n 7.10 CAD");
                        break;
                    case "Central African Republic (CAR)":
                        sign = "XAF";
                        setUnitCost="558";
                        setInfo.setText("Electricity charges per unit :\n\n 558.00 XAF");
                        break;
                    case "Chile (CL)":
                        sign = "CLP";
                        setUnitCost="104.270";
                        setInfo.setText("Electricity charges per unit :\n\n 104.27 CLP");
                        break;
                    case "China (CN)":
                        sign = "CNY";
                        setUnitCost="0.633";
                        setInfo.setText("Electricity charges per unit :\n\n 0.633 CNY");
                        break;
                    case "Colombia (CO)":
                        sign = "COP";
                        setUnitCost="558.740";
                        setInfo.setText("Electricity charges per unit :\n\n 558.740 COP");
                        break;
                    case "Congo (CD)":
                        sign = "XAF";
                        setUnitCost="194.400";
                        setInfo.setText("Electricity charges per unit :\n\n 194.40 XAF");
                        break;
                    case "Costa Rica (CR)":
                        sign = "CRC";
                        setUnitCost="103.919";
                        setInfo.setText("Electricity charges per unit :\n\n 103.919 CRC");
                        break;
                    case "Croatia (HR)":
                        sign = "HRK";
                        setUnitCost="0.858";
                        setInfo.setText("Electricity charges per unit :\n\n 0.858 HRK");
                        break;
                    case "Cuba (CU)":
                        sign = "CUC";
                        setUnitCost="0.750";
                        setInfo.setText("Electricity charges per unit :\n\n 0.750 CUC");
                        break;
                    case "Cyprus (CY)":
                        sign = "EUR";
                        setUnitCost="0.246";
                        setInfo.setText("Electricity charges per unit :\n\n 0.246 EUR");
                        break;
                    case "Czech Republic (CZ)":
                        sign = "CZK";
                        setUnitCost="2.280";
                        setInfo.setText("Electricity charges per unit :\n\n 2.280 CZK");
                        break;
                    case "Denmark (DK)":
                        sign = "DKK";
                        setUnitCost="1.655";
                        setInfo.setText("Electricity charges per unit :\n\n 1.655 DKK");
                        break;
                    case "Djibouti (DJ)":
                        sign = "DJF";
                        setUnitCost="55.22";
                        setInfo.setText("Electricity charges per unit :\n\n 55.22 DJF");
                        break;
                    case "Dominican Republic (DO)":
                        sign = "DOP";
                        setUnitCost="8.200";
                        setInfo.setText("Electricity charges per unit :\n\n 8.200 DOP");
                        break;
                    case "Ecuador (EC)":
                        sign = "USD";
                        setUnitCost="0.085";
                        setInfo.setText("Electricity charges per unit :\n\n 0.085 USD");
                        break;
                    case "Egypt (EG)":
                        sign = "EGP";
                        setUnitCost="1.150";
                        setInfo.setText("Electricity charges per unit :\n\n 1.150 EGP");
                        break;
                    case "El Salvador (SV)":
                        sign = "USD";
                        setUnitCost="0.191";
                        setInfo.setText("Electricity charges per unit :\n\n 0.191 USD");
                        break;
                    case "Estonia (EE)":
                        sign = "EUR";
                        setUnitCost="0.088";
                        setInfo.setText("Electricity charges per unit :\n\n 0.088 EUR");
                        break;
                    case "Ethiopia (ET)":
                        sign = "ETB";
                        setUnitCost="1.019";
                        setInfo.setText("Electricity charges per unit :\n\n 1.019 ETB");
                        break;
                    case "Fiji (FJ)":
                        sign = "FJD";
                        setUnitCost="0.36";
                        setInfo.setText("Electricity charges per unit :\n\n 0.36 FJD");
                        break;
                    case "Finland (FI)":
                        sign = "EUR";
                        setUnitCost="0.114";
                        setInfo.setText("Electricity charges per unit :\n\n 0.114 EUR");
                        break;
                    case "France (FR)":
                        sign = "EUR";
                        setUnitCost="0.125";
                        setInfo.setText("Electricity charges per unit :\n\n 0.125 EUR");
                        break;
                    case "Gabon (GA)":
                        sign = "XAF";
                        setUnitCost="122.960";
                        setInfo.setText("Electricity charges per unit :\n\n 122.960 XAF");
                        break;
                    case "Gambia (GM)":
                        sign = "GMD";
                        setUnitCost="10.90";
                        setInfo.setText("Electricity charges per unit :\n\n 10.90 GMD");
                        break;
                    case "Georgia (GA)":
                        sign = "GEL";
                        setUnitCost="0.303";
                        setInfo.setText("Electricity charges per unit :\n\n 0.303 GEL");
                        break;
                    case "Germany (DE)":
                        sign = "EUR";
                        setUnitCost="0.247";
                        setInfo.setText("Electricity charges per unit :\n\n 0.247 EUR");
                        break;
                    case "Ghana (GH)":
                        sign = "GHS";
                        setUnitCost="0.796";
                        setInfo.setText("Electricity charges per unit :\n\n 0.796 GHS");
                        break;
                    case "Great Britain [UK]":
                        sign = "GBP";
                        setUnitCost="0.218";
                        setInfo.setText("Electricity charges per unit :\n\n 0.218 GBP");
                        break;
                    case "Greece (GR)":
                        sign = "EUR";
                        setUnitCost="0.117";
                        setInfo.setText("Electricity charges per unit :\n\n 0.117 EUR");
                        break;
                    case "Guatemala (GT)":
                        sign = "GTQ";
                        setUnitCost="1.206";
                        setInfo.setText("Electricity charges per unit :\n\n 1.206 GTQ");
                        break;
                    case "Guyana (GY)":
                        sign = "GYD";
                        setUnitCost="66.86";
                        setInfo.setText("Electricity charges per unit :\n\n 66.86 GYD");
                        break;
                    case "Haiti (HT)":
                        sign = "HTG";
                        setUnitCost="39.57";
                        setInfo.setText("Electricity charges per unit :\n\n 39.57 HTG");
                        break;
                    case "Honduras (HN)":
                        sign = "HNL";
                        setUnitCost="4.811";
                        setInfo.setText("Electricity charges per unit :\n\n 4.811 HNL");
                        break;
                    case "Hong Kong (HK)":
                        sign = "HKD";
                        setUnitCost="1.164";
                        setInfo.setText("Electricity charges per unit :\n\n 1.164 HKD");
                        break;
                    case "Hungary (HU)":
                        sign = "HUF";
                        setUnitCost="46.340";
                        setInfo.setText("Electricity charges per unit :\n\n 46.340 HUF");
                        break;
                    case "Iceland (IS)":
                        sign = "ISK";
                        setUnitCost="7.100";
                        setInfo.setText("Electricity charges per unit :\n\n 7.10 ISK");
                        break;
                    case "Indonesia (ID)":
                        sign = "IDR";
                        setUnitCost="1114.740";
                        setInfo.setText("Electricity charges per unit :\n\n 1,114.740 IDR");
                        break;
                    case "Iran (IR)":
                        sign = "IRR";
                        setUnitCost="1402.0";
                        setInfo.setText("Electricity charges per unit :\n\n 1,402.00 IRR");
                        break;
                    case "Iraq (IQ)":
                        sign = "IQD";
                        setUnitCost="60.000";
                        setInfo.setText("Electricity charges per unit :\n\n 60.00 IQD");
                        break;
                    case "Ireland (IE)":
                        sign = "EUR";
                        setUnitCost="0.242";
                        setInfo.setText("Electricity charges per unit :\n\n 0.242 EUR");
                        break;
                    case "Israel (IL)":
                        sign = "ILS";
                        setUnitCost="0.549";
                        setInfo.setText("Electricity charges per unit :\n\n 0.549 ILS");
                        break;
                    case "Italy (IT)":
                        sign = "EUR";
                        setUnitCost="0.187";
                        setInfo.setText("Electricity charges per unit :\n\n 0.187 EUR");
                        break;
                    case "Ivory Coast (CI)":
                        sign = "XOF";
                        setUnitCost="123.260";
                        setInfo.setText("Electricity charges per unit :\n\n 123.260 XOF");
                        break;
                    case "Jamaica (JM)":
                        sign = "JMD";
                        setUnitCost="36.890";
                        setInfo.setText("Electricity charges per unit :\n\n 36.890 JMD");
                        break;
                    case "Japan (JP)":
                        sign = "JPY";
                        setUnitCost="23.130";
                        setInfo.setText("Electricity charges per unit :\n\n 23.130 JPY");
                        break;
                    case "Jordan (JO)":
                        sign = "JOD";
                        setUnitCost="0.087";
                        setInfo.setText("Electricity charges per unit :\n\n 0.087 JOD");
                        break;
                    case "Kazakhstan (KZ)":
                        sign = "KZT";
                        setUnitCost="24.750";
                        setInfo.setText("Electricity charges per unit :\n\n 27.750 KZT");
                        break;
                    case "Kenya (KE)":
                        sign = "KES";
                        setUnitCost="20.280";
                        setInfo.setText("Electricity charges per unit :\n\n 20.280 KES");
                        break;
                    case "Kiribati (KI)":
                        sign = "AUD";
                        setUnitCost="0.60";
                        setInfo.setText("Electricity charges per unit :\n\n 0.60 AUD");
                        break;
                    case "Kuwait (KW)":
                        sign = "KWD";
                        setUnitCost="0.015";
                        setInfo.setText("Electricity charges per unit :\n\n 0.015 KWD");
                        break;
                    case "Kyrgyzstan (KG)":
                        sign = "KGS";
                        setUnitCost="2.510";
                        setInfo.setText("Electricity charges per unit :\n\n 2.510 KGS");
                        break;
                    case "Laos":
                        sign = "LAK";
                        setUnitCost="593.380";
                        setInfo.setText("Electricity charges per unit :\n\n 593.380 LAK");
                        break;
                    case "Latvia (LV)":
                        sign = "EUR";
                        setUnitCost="0.153";
                        setInfo.setText("Electricity charges per unit :\n\n 0.153 EUR");
                        break;
                    case "Lebanon (LB)":
                        sign = "LBP";
                        setUnitCost="144.830";
                        setInfo.setText("Electricity charges per unit :\n\n 144.830 LBP");
                        break;
                    case "Lesotho (LS)":
                        sign = "LSL";
                        setUnitCost="0.326";
                        setInfo.setText("Electricity charges per unit :\n\n 0.326 LSL");
                        break;
                    case "Liberia (LR)":
                        sign = "LRD";
                        setUnitCost="82.35";
                        setInfo.setText("Electricity charges per unit :\n\n 82.35 LRD");
                        break;
                    case "Libya (LY)":
                        sign = "LYD";
                        setUnitCost="0.031";
                        setInfo.setText("Electricity charges per unit :\n\n 0.031 LYD");
                        break;
                    case "Liechtenstein (LI)":
                        sign = "CHF";
                        setUnitCost="0.169";
                        setInfo.setText("Electricity charges per unit :\n\n 0.169 CHF");
                        break;
                    case "Lithuania (LT)":
                        sign = "EUR";
                        setUnitCost="0.176";
                        setInfo.setText("Electricity charges per unit :\n\n 0.176 EUR");
                        break;
                    case "Luxembourg (LU)":
                        sign = "EUR";
                        setUnitCost="0.117";
                        setInfo.setText("Electricity charges per unit :\n\n 0.117 EUR");
                        break;
                    case "Madagascar (MG)":
                        sign = "MGA";
                        setUnitCost="443.900";
                        setInfo.setText("Electricity charges per unit :\n\n 443.900 MGA");
                        break;
                    case "Malawi (MW)":
                        sign = "MWK";
                        setUnitCost="155.850";
                        setInfo.setText("Electricity charges per unit :\n\n 155.850 MWK");
                        break;
                    case "Malaysia (MY)":
                        sign = "MYR";
                        setUnitCost="0.388";
                        setInfo.setText("Electricity charges per unit :\n\n 0.388 MYR");
                        break;
                    case "Maldives (MV)":
                        sign = "MVR";
                        setUnitCost="3.55";
                        setInfo.setText("Electricity charges per unit :\n\n 3.55 MVR");
                        break;
                    case "Mali (ML)":
                        sign = "XOF";
                        setUnitCost="94.930";
                        setInfo.setText("Electricity charges per unit :\n\n 94.930 XOF");
                        break;
                    case "Malta (MT)":
                        sign = "EUR";
                        setUnitCost="0.149";
                        setInfo.setText("Electricity charges per unit :\n\n 0.149 EUR");
                        break;
                    case "Marshall Islands (MI)":
                        sign = "USD";
                        setUnitCost="0.406";
                        setInfo.setText("Electricity charges per unit :\n\n 0.406 USD");
                        break;
                    case "Mauritius (MU)":
                        sign = "MUR";
                        setUnitCost="5.400";
                        setInfo.setText("Electricity charges per unit :\n\n 5.40 MUR");
                        break;
                    case "Mexico (MX)":
                        sign = "MXN";
                        setUnitCost="3.327";
                        setInfo.setText("Electricity charges per unit :\n\n 3.327 MXN");
                        break;
                    case "Micronesia (FM)":
                        sign = "USD";
                        setUnitCost="0.48";
                        setInfo.setText("Electricity charges per unit :\n\n 0.48 USD");
                        break;
                    case "Moldova (MD)":
                        sign = "MDL";
                        setUnitCost="1.250";
                        setInfo.setText("Electricity charges per unit :\n\n 1.250 MDL");
                        break;
                    case "Monaco (MC)":
                        sign = "EUR";
                        setUnitCost="0.15";
                        setInfo.setText("Electricity charges per unit :\n\n 0.15 EUR");
                        break;
                    case "Mongolia (MN)":
                        sign = "MNT";
                        setUnitCost="188.16";
                        setInfo.setText("Electricity charges per unit :\n\n 188.16 MNT");
                        break;
                    case "Montenegro (ME)":
                        sign = "EUR";
                        setUnitCost="0.097";
                        setInfo.setText("Electricity charges per unit :\n\n 0.097 EUR");
                        break;
                    case "Morocco (MA)":
                        sign = "MAD";
                        setUnitCost="1.072";
                        setInfo.setText("Electricity charges per unit :\n\n 1.072 MAD");
                        break;
                    case "Mozambique (MZ)":
                        sign = "MZN";
                        setUnitCost="4.348";
                        setInfo.setText("Electricity charges per unit :\n\n 4.348 MZN");
                        break;
                    case "Myanmar (MM)":
                        sign = "MMK";
                        setUnitCost="60.500";
                        setInfo.setText("Electricity charges per unit :\n\n 60.500 MMK");
                        break;
                    case "Namibia (NA)":
                        sign = "NAD";
                        setUnitCost="1.952";
                        setInfo.setText("Electricity charges per unit :\n\n 1.952 NAD");
                        break;
                    case "Nauru (NR)":
                        sign = "AUD";
                        setUnitCost="0.20";
                        setInfo.setText("Electricity charges per unit :\n\n 0.20 AUD");
                        break;
                    case "Nepal (NP)":
                        sign = "NPR";
                        setUnitCost="9.010";
                        setInfo.setText("Electricity charges per unit :\n\n 9.010 NPR");
                        break;
                    case "Netherlands (NL)":
                        sign = "EUR";
                        setUnitCost="0.124";
                        setInfo.setText("Electricity charges per unit :\n\n 0.124 EUR");
                        break;
                    case "New Zealand (NZ)":
                        sign = "NZD";
                        setUnitCost="0.304";
                        setInfo.setText("Electricity charges per unit :\n\n 0.384 NZD");
                        break;
                    case "Nicaragua (NI)":
                        sign = "NIO";
                        setUnitCost="6.510";
                        setInfo.setText("Electricity charges per unit :\n\n 6.510 NIO");
                        break;
                    case "Niger (NE)":
                        sign = "XOF";
                        setUnitCost="104.19";
                        setInfo.setText("Electricity charges per unit :\n\n 104.19 XOF");
                        break;
                    case "Nigeria (NG)":
                        sign = "NGN";
                        setUnitCost="38.530";
                        setInfo.setText("Electricity charges per unit :\n\n 38.530 NGN");
                        break;
                    case "Norway (NO)":
                        sign = "NOK";
                        setUnitCost="0.968";
                        setInfo.setText("Electricity charges per unit :\n\n 0.968 NOK");
                        break;
                    case "Oman (OM)":
                        sign = "OMR";
                        setUnitCost="0.063";
                        setInfo.setText("Electricity charges per unit :\n\n 0.063 OMR");
                        break;
                    case "Pakistan (PK)":
                        sign = "PKR";
                        setUnitCost="27.020";
                        setInfo.setText("Electricity charges per unit :\n\n 27.020 PKR");
                        break;
                    case "Palau (PW)":
                        sign = "USD";
                        setUnitCost="0.28";
                        setInfo.setText("Electricity charges per unit :\n\n 0.28 USD");
                        break;
                    case "Palestine State (PS)":
                        sign = "PSP";
                        setUnitCost="0.085";
                        setInfo.setText("Electricity charges per unit :\n\n 0.085 PSP");
                        break;
                    case "Panama (PA)":
                        sign = "USD";
                        setUnitCost="0.169";
                        setInfo.setText("Electricity charges per unit :\n\n 0.169 USD");
                        break;
                    case "Papua New Guinea (PG)":
                        sign = "PGK";
                        setUnitCost="1029";
                        setInfo.setText("Electricity charges per unit :\n\n 1,029.00 PGK");
                        break;
                    case "Paraguay (PY)":
                        sign = "PYG";
                        setUnitCost="334.798";
                        setInfo.setText("Electricity charges per unit :\n\n 334.798 PYG");
                        break;
                    case "Peru (PE)":
                        sign = "PEN";
                        setUnitCost="0.550";
                        setInfo.setText("Electricity charges per unit :\n\n 0.55 PEN");
                        break;
                    case "Philippines (PH)":
                        sign = "PHP";
                        setUnitCost="6.235";
                        setInfo.setText("Electricity charges per unit :\n\n 6.235 PHP");
                        break;
                    case "Poland (PL)":
                        sign = "PLN";
                        setUnitCost="0.636";
                        setInfo.setText("Electricity charges per unit :\n\n 0.636 PLN");
                        break;
                    case "Puerto Rico (PR)":
                        sign = "USD";
                        setUnitCost="0.30";
                        setInfo.setText("Electricity charges per unit :\n\n 0.30 USD");
                        break;
                    case "Portugal (PT)":
                        sign = "EUR";
                        setUnitCost="0.172";
                        setInfo.setText("Electricity charges per unit :\n\n 0.172 EUR");
                        break;
                    case "Qatar (QA)":
                        sign = "QAR";
                        setUnitCost="0.130";
                        setInfo.setText("Electricity charges per unit :\n\n 0.130 QAR");
                        break;
                    case "Republic of Korea (KR)":
                        sign = "LRW";
                        setUnitCost="130.000";
                        setInfo.setText("Electricity charges per unit :\n\n 130.00 LRW");
                        break;
                    case "Romania (RO)":
                        sign = "RON";
                        setUnitCost="0.762";
                        setInfo.setText("Electricity charges per unit :\n\n 0.762 RON");
                        break;
                    case "Russian Federation (RU)":
                        sign = "RUB";
                        setUnitCost="6.874";
                        setInfo.setText("Electricity charges per unit :\n\n 6.874 RUB");
                        break;
                    case "Rwanda (RW)":
                        sign = "RWF";
                        setUnitCost="257.290";
                        setInfo.setText("Electricity charges per unit :\n\n 257.290 RWF");
                        break;
                    case "Saint Kitts and Nevis (KN)":
                        sign = "XCD";
                        setUnitCost="0.89";
                        setInfo.setText("Electricity charges per unit :\n\n 0.89 XCD");
                        break;
                    case "Saint Lucia (LC)":
                        sign = "XCD";
                        setUnitCost="0.90";
                        setInfo.setText("Electricity charges per unit :\n\n 0.90 XCD");
                        break;
                    case "Saint Vincent and the Grenadines (VC)":
                        sign = "XCD";
                        setUnitCost="0.26";
                        setInfo.setText("Electricity charges per unit :\n\n 0.26 XCD");
                        break;
                    case "Samoa (SO)":
                        sign = "WST";
                        setUnitCost="0.321";
                        setInfo.setText("Electricity charges per unit :\n\n 0.321 WST");
                        break;
                    case "San Marino (SM)":
                        sign = "EUR";
                        setUnitCost="0.16";
                        setInfo.setText("Electricity charges per unit :\n\n 0.16 EUR");
                        break;
                    case "Sao Tome and Principe":
                        sign = "STN";
                        setUnitCost="7.5";
                        setInfo.setText("Electricity charges per unit :\n\n 7.50 STN");
                        break;
                    case "Saudi Arabia (SA)":
                        sign = "SAR";
                        setUnitCost="0.257";
                        setInfo.setText("Electricity charges per unit :\n\n 0.257 SAR");
                        break;
                    case "Senegal (SN)":
                        sign = "XOF";
                        setUnitCost="103.245";
                        setInfo.setText("Electricity charges per unit :\n\n 103.245 XOF");
                        break;
                    case "Serbia (RS)":
                        sign = "RSD";
                        setUnitCost="11.040";
                        setInfo.setText("Electricity charges per unit :\n\n 11.040 RSD");
                        break;
                    case "Seychelles (SC)":
                        sign = "SCR";
                        setUnitCost="3.5";
                        setInfo.setText("Electricity charges per unit :\n\n 3.50 SCR");
                        break;
                    case "Sierra Leone (SL)":
                        sign = "SLL";
                        setUnitCost="2151.000";
                        setInfo.setText("Electricity charges per unit :\n\n 2,151.000 SLL");
                        break;
                    case "Singapore (SG)":
                        sign = "SGD";
                        setUnitCost="0.213";
                        setInfo.setText("Electricity charges per unit :\n\n 0.213 SGD");
                        break;
                    case "Slovakia (SK)":
                        sign = "EUR";
                        setUnitCost="0.152";
                        setInfo.setText("Electricity charges per unit :\n\n 0.152 EUR");
                        break;
                    case "Slovenia (SI)":
                        sign = "EUR";
                        setUnitCost="0.110";
                        setInfo.setText("Electricity charges per unit :\n\n 0.110 EUR");
                        break;
                    case "Somalia (SO)":
                        sign = "SOS";
                        setUnitCost="350";
                        setInfo.setText("Electricity charges per unit :\n\n 350.00 SOS");
                        break;
                    case "South Africa (ZA)":
                        sign = "ZAR";
                        setUnitCost="1.209";
                        setInfo.setText("Electricity charges per unit :\n\n 1.209 ZAR");
                        break;
                    case "South Korea (KR)":
                        sign = "SKW";
                        setUnitCost="89.568";
                        setInfo.setText("Electricity charges per unit :\n\n 89.568 SKW");
                        break;
                    case "Spain (ES)":
                        sign = "EUR";
                        setUnitCost="0.106";
                        setInfo.setText("Electricity charges per unit :\n\n 0.106 EUR");
                        break;
                    case "Sri Lanka (LK)":
                        sign = "LKR";
                        setUnitCost="12.930";
                        setInfo.setText("Electricity charges per unit :\n\n 12.930 LKR");
                        break;
                    case "Sudan (SD)":
                        sign = "SDG";
                        setUnitCost="10.200";
                        setInfo.setText("Electricity charges per unit :\n\n 10.200 SDG");
                        break;
                    case "Suriname (SR)":
                        sign = "SRD";
                        setUnitCost="0.350";
                        setInfo.setText("Electricity charges per unit :\n\n 0.350 SRD");
                        break;
                    case "Sweden (SE)":
                        sign = "SEK";
                        setUnitCost="1.770";
                        setInfo.setText("Electricity charges per unit :\n\n 1.770 SEK");
                        break;
                    case "Switzerland (CH)":
                        sign = "CHF";
                        setUnitCost="0.156";
                        setInfo.setText("Electricity charges per unit :\n\n 0.156 CHF");
                        break;
                    case "Syria (SY)":
                        sign = "SYP";
                        setUnitCost="326";
                        setInfo.setText("Electricity charges per unit :\n\n 326.00 SYP");
                        break;
                    case "Taiwan (TW)":
                        sign = "TWD";
                        setUnitCost="3.830";
                        setInfo.setText("Electricity charges per unit :\n\n 3.830 TWD");
                        break;
                    case "Tajikistan (TJ)":
                        sign = "TJS";
                        setUnitCost="0.013";
                        setInfo.setText("Electricity charges per unit :\n\n 0.013 TJS");
                        break;
                    case "Tanzania (TZ)":
                        sign = "TZS";
                        setUnitCost="236.370";
                        setInfo.setText("Electricity charges per unit :\n\n 236.370 TZS");
                        break;
                    case "Thailand (TH)":
                        sign = "THB";
                        setUnitCost="3.711";
                        setInfo.setText("Electricity charges per unit :\n\n 3.711 THB");
                        break;
                    case "Timor-Leste (TL)":
                        sign = "USD";
                        setUnitCost="0.12";
                        setInfo.setText("Electricity charges per unit :\n\n 0.12 USD");
                        break;
                    case "Togo (TG)":
                        sign = "XOF";
                        setUnitCost="106.930";
                        setInfo.setText("Electricity charges per unit :\n\n 106.930 XOF");
                        break;
                    case "Tonga (TO)":
                        sign = "TOP";
                        setUnitCost="0.76";
                        setInfo.setText("Electricity charges per unit :\n\n 0.76 TOP");
                        break;
                    case "Trinidad and Tobago (TT)":
                        sign = "TTD";
                        setUnitCost="0.359";
                        setInfo.setText("Electricity charges per unit :\n\n 0.359 TTD");
                        break;
                    case "Tunisia (TN)":
                        sign = "TND";
                        setUnitCost="0.305";
                        setInfo.setText("Electricity charges per unit :\n\n 0.305 TND");
                        break;
                    case "Turkey (TR)":
                        sign = "TRY";
                        setUnitCost="0.950";
                        setInfo.setText("Electricity charges per unit :\n\n 0.950 TRY");
                        break;
                    case "Turkmenistan (TK)":
                        sign = "TMT";
                        setUnitCost="0.98";
                        setInfo.setText("Electricity charges per unit :\n\n 0.98 TMT");
                        break;
                    case "Tuvalu (TV)":
                        sign = "AUD";
                        setUnitCost="0.05";
                        setInfo.setText("Electricity charges per unit :\n\n 0.05 AUD");
                        break;
                    case "Uganda (UG)":
                        sign = "UGX";
                        setUnitCost="526.900";
                        setInfo.setText("Electricity charges per unit :\n\n 526.90 UGX");
                        break;
                    case "Ukraine (UA)":
                        sign = "UAH";
                        setUnitCost="2.520";
                        setInfo.setText("Electricity charges per unit :\n\n 2.520 UAH");
                        break;
                    case "United Arab Emirates (AE)":
                        sign = "AED";
                        setUnitCost="0.366";
                        setInfo.setText("Electricity charges per unit :\n\n 0.366 AED");
                        break;
                    case "United Kingdom (UK)":
                        sign = "GBP";
                        setUnitCost="0.218";
                        setInfo.setText("Electricity charges per unit :\n\n 0.218 GBP");
                        break;
                    case "Uruguay (UY)":
                        sign = "UYI";
                        setUnitCost="4.300";
                        setInfo.setText("Electricity charges per unit :\n\n 4.300 UYI");
                        break;
                    case "Uzbekistan (UZ)":
                        sign = "UZS";
                        setUnitCost="450.000";
                        setInfo.setText("Electricity charges per unit :\n\n 450.00 UZS");
                        break;
                    case "Vanuatu (VU)":
                        sign = "VUV";
                        setUnitCost="59.71";
                        setInfo.setText("Electricity charges per unit :\n\n 59.71 VUV");
                        break;
                    case "Venezuela (VE)":
                        sign = "VEF";
                        setUnitCost="1.093";
                        setInfo.setText("Electricity charges per unit :\n\n 1.093 VEF");
                        break;
                    case "Vietnam (VN)":
                        sign = "VND";
                        setUnitCost="1772.100";
                        setInfo.setText("Electricity charges per unit :\n\n 1,772.100 VND");
                        break;
                    case "Yemen (YE)":
                        sign = "YER";
                        setUnitCost="650";
                        setInfo.setText("Electricity charges per unit :\n\n 650.00 YER");
                        break;
                    case "Zambia (ZM)":
                        sign = "ZMW";
                        setUnitCost="0.854";
                        setInfo.setText("Electricity charges per unit :\n\n 0.854 ZMW");
                        break;
                    case "Zimbabwe (ZW)":
                        sign = "ZWL";
                        setUnitCost="4.282";
                        setInfo.setText("Electricity charges per unit :\n\n 4.282 ZWL");
                        break;
                    default:
                        sign = "$";
                        setUnitCost="0.060";
                }
            }
        }
    }
}
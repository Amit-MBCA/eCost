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

public class custCharges extends AppCompatActivity {
    TextView tvUnitCost,tvforcp;
    EditText getUnit,editCost;
    String setUnitCost,sign,userName,nationName,stateName,occName,country,getUnitInStr,getCostInStr;
    Double cst,result,getCostInDbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_charges);
        SharedPreferences shrd = getSharedPreferences(Signup.PREFS_NAME, MODE_PRIVATE);
        userName = shrd.getString("user", "User Name");
        nationName = shrd.getString("nation", "Country Name");
        if (nationName.equals("India (IN)")) {
            stateName = shrd.getString("selectedState", "AP | Andhra Pradesh");
        } else {
            occName = shrd.getString("selectedOccupation", "Household");
        }
        tvforcp=findViewById(R.id.tvResult);
        tvUnitCost = findViewById(R.id.tvResult3);
        getUnit = findViewById(R.id.etGetUnit);
        editCost = findViewById(R.id.etGetCost);
        setSign(nationName);
        editCost.setHint("Enter 1 kWh cost in " + sign);
    }


    public void back(View view) {
        Intent gobck = new Intent(custCharges.this, whatShould.class);
        startActivity(gobck);
        finish();
    }

    public void clearit(View view) {
        Intent clr = new Intent(custCharges.this, custCharges.class);
        startActivity(clr);
        finish();
    }


    public void computeNow(View view) {
        hideSoftKeyboard(custCharges.this,view);
//        setSign(nationName);
//        tvUnitCost.setText("Enter 1 kWh cost in " + sign + " :");
        getUnitInStr = getUnit.getText().toString();
        getCostInStr = editCost.getText().toString();
        if(getCostInStr.equals("")||getUnitInStr.equals("")){ //return empty string
            tvforcp.setVisibility(View.INVISIBLE);
            tvUnitCost.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(),"Both fields are required",Toast.LENGTH_SHORT).show();
        }
        else {
            getCostInDbl = Double.parseDouble(getCostInStr);
            cst=Double.parseDouble(getUnitInStr);
            tvforcp.setVisibility(View.VISIBLE);
            tvUnitCost.setVisibility(View.VISIBLE);

//            getCostInDbl = Double.parseDouble(//setUnitCost);
            result = cst * getCostInDbl;
//            //setInfo.setText("Error");
            DecimalFormat df = new DecimalFormat("#.###");
            df.setGroupingUsed(true);
            df.setGroupingSize(3);
            tvforcp.setText("Cost of Electricity : " + df.format(result) + " " + sign);
            tvUnitCost.setText("You apply charges rate as "+df.format(getCostInDbl)+" "+sign);
//        tvforcp.setText("Cost of Electricity per day : " +result+ " " + sign);
        }
    }
    public static void hideSoftKeyboard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    public void setSign(String country) {
                    switch (country) {
                    case "India (IN)":
                        sign="INR";
                        break;
                    case "Afghanistan (AFG)":
                        sign = "AFN";
                        break;
                    case "Albania (ALB)":
                        sign = "ALL";
                        break;

                    case "Algeria (DZ)":
                        sign = "DZD";
                        ////setUnitCost="5.340";
                        //setInfo.setText("Electricity Charges per unit : 5.340 DZD");
                        break;
                    case "Andorra (AD)":
                        sign = "EUR";
                        ////setUnitCost="0.100"; //W
                        //setInfo.setText("Electricity charges per unit : 0.100 EUR");
                        break;
                    case "Angola (AO)":
                        sign = "AOA";
                        ////setUnitCost="11.830";
                        //setInfo.setText("Electricity charges per unit : 11.830 AOA");
                        break;
                    case "Antigua and Barbuda (ATG)":
                        sign = "XCD";
                        ////setUnitCost="1.00"; //W
                        //setInfo.setText("Electricity charges per unit : 1.00 XCD");
                        break;
                    case "Argentina (AR)":
                        sign = "ARS";
                        ////setUnitCost="5.870";
                        //setInfo.setText("Electricity charges per unit : 5.870 ARS");
                        break;
                    case "Armenia (AM)":
                        sign = "AMD";
                        ////setUnitCost="39.980";
                        //setInfo.setText("Electricity charges per unit : 39.980 AMD");
                        break;
                    case "Australia (AUS)":
                        sign = "AUD";
                        ////setUnitCost="0.312";
                        //setInfo.setText("Electricity charges per unit : 0.312 AUD");
                        break;
                    case "Austria (AT)":
                        sign = "EUR";
                        ////setUnitCost="0.221";
                        //setInfo.setText("Electricity charges per unit : 0.221 EUR");
                        break;
                    case "Azerbaijan (AZ)":
                        sign = "AZN";
                        ////setUnitCost="0.070";
                        //setInfo.setText("Electricity charges per unit : 0.070 AZN");
                        break;
                    case "Bahamas (BS)":
                        sign = "BSD";
                        ////setUnitCost="0.262";
                        //setInfo.setText("Electricity charges per unit : 0.262 BSD");
                        break;
                    case "Bahrain (BH)":
                        sign = "BHD";
                        ////setUnitCost="0.018";
                        //setInfo.setText("Electricity charges per unit : 0.018 BHD");
                        break;
                    case "Bangladesh (BD)":
                        sign = "BDT";
                        ////setUnitCost="5.614";
                        //setInfo.setText("Electricity charges per unit : 5.614 BDT");
                        break;
                    case "Barbados (BB)":
                        sign = "BBD";
                        ////setUnitCost="0.583";
                        //setInfo.setText("Electricity charges per unit : 0.583 BBD");
                        break;
                    case "Belarus (BY)":
                        sign = "BYN";
                        ////setUnitCost="0.209";
                        //setInfo.setText("Electricity charges per unit : 0.209 BYN");
                        break;
                    case "Belgium (BE)":
                        sign = "EUR";
                        ////setUnitCost="0.291";
                        //setInfo.setText("Electricity charges per unit : 0.291 EUR");
                        break;
                    case "Belize (BZ)":
                        sign = "BZD";
                        ////setUnitCost="0.446";
                        //setInfo.setText("Electricity charges per unit : 0.446 BZD");
                        break;
                    case "Benin (BJ)":
                        sign = "XOF";
                        ////setUnitCost="24.49";//W
                        //setInfo.setText("Electricity charges per unit : 24.49");
                        break;
                    case "Bermuda (BM)":
                        sign = "BMD";
                        ////setUnitCost="0.370";
                        //setInfo.setText("Electricity charges per unit : 0.370 BMD");
                        break;
                    case "Bhutan (BT)":
                        sign = "BTN";
                        ////setUnitCost="1.28";
                        //setInfo.setText("Electricity charges per unit : 1.28 BTN");
                        break;
                    case "Bolivia (BO)":
                        sign = "BOV";
                        ////setUnitCost="0.809";
                        //setInfo.setText("Electricity charges per unit : 0.809 BOV");
                        break;
                    case "Bosnia and Herzegovina (BiH)":
                        sign = "BAM";
                        ////setUnitCost="0.18";  //W
                        //setInfo.setText("Electricity charges per unit : 0.18 BAM");
                        break;
                    case "Botswana (BW)":
                        sign = "BWP";
                        ////setUnitCost="1.267";
                        //setInfo.setText("Electricity charges per unit : 1.267 BWP");
                        break;
                    case "Brazil (BR)":
                        sign = "BRL";
                        ////setUnitCost="0.749";
                        //setInfo.setText("Electricity charges per unit : 0.749 BRL");
                        break;
                    case "Brunei (BN)":
                        sign = "BND";
                        ////setUnitCost="0.10"; // W
                        //setInfo.setText("Electricity charges per unit : 0.10 BND");
                        break;
                    case "Bulgaria (BG)":
                        sign = "BGN";
                        ////setUnitCost="0.241";
                        //setInfo.setText("Electricity charges per unit : 0.241 BGN");
                        break;
                    case "Burkina Faso (BF)":
                        sign = "XOF";
                        ////setUnitCost="123.440";
                        //setInfo.setText("Electricity charges per unit : 123.440 XOF");
                        break;
                    case "Burundi (BI)":
                        sign = "BIF";
                        ////setUnitCost="264.66"; //W
                        //setInfo.setText("Electricity charges per unit : 264.66 BIF");
                        break;
                    case "Cabo Verde (CV)":
                        sign = "CVE";
                        ////setUnitCost="24.360";
                        //setInfo.setText("Electricity charges per unit : 24.360 CVE");
                        break;
                    case "Cambodia (KH)":
                        sign = "KHR";
                        ////setUnitCost="462.29"; //W
                        //setInfo.setText("Electricity charges per unit : 462.29 KHR");
                        break;
                    case "Cameroon (CMR)":
                        sign = "XAF";
                        ////setUnitCost="50.000";
                        //setInfo.setText("Electricity charges per unit : 50.000 XAF");
                        break;
                    case "Canada (CA)":
                        sign = "CAD";
                        ////setUnitCost="6.051"; //   7.1
                        //setInfo.setText("Electricity charges per unit : 6.051 CAD");
                        break;
                    case "Central African Republic (CAR)":
                        sign = "XAF";
                        ////setUnitCost="558"; //W
                        //setInfo.setText("Electricity charges per unit : 558.00 XAF");
                        break;
                    case "Chile (CL)":
                        sign = "CLP";
                        ////setUnitCost="142.634";
                        //setInfo.setText("Electricity charges per unit : 142.634 CLP");
                        break;
                    case "China (CN)":
                        sign = "CNY";
                        ////setUnitCost="0.559";
                        //setInfo.setText("Electricity charges per unit : 0.559 CLP");
                        break;
                    case "Colombia (CO)":
                        sign = "COP";
                        ////setUnitCost="583.620";
                        //setInfo.setText("Electricity charges per unit : 583.620 COP");
                        break;
                    case "Congo (CD)":
                        sign = "XAF";
                        ////setUnitCost="166.611";
                        //setInfo.setText("Electricity charges per unit : 166.611 XAF");
                        break;
                    case "Costa Rica (CR)":
                        sign = "CRC";
                        ////setUnitCost="75.240";
                        //setInfo.setText("Electricity charges per unit : 75.240 CRC");
                        break;
                    case "Croatia (HR)":
                        sign = "HRK";
                        ////setUnitCost="1.041";
                        //setInfo.setText("Electricity charges per unit : 1.041 HRK");
                        break;
                    case "Cuba (CU)":
                        sign = "CUC";
                        ////setUnitCost="0.720";
                        //setInfo.setText("Electricity charges per unit : 0.720 CUC");
                        break;
                    case "Cyprus (CY)":
                        sign = "EUR";
                        ////setUnitCost="0.260";
                        //setInfo.setText("Electricity charges per unit : 0.260 EUR");
                        break;
                    case "Czech Republic (CZ)":
                        sign = "CZK";
                        ////setUnitCost="5.561";
                        //setInfo.setText("Electricity charges per unit : 5.561 CZK");
                        break;
                    case "Denmark (DK)":
                        sign = "DKK";
                        ////setUnitCost="2.456";
                        //setInfo.setText("Electricity charges per unit : 2.456 DKK");
                        break;
                    case "Djibouti (DJ)":
                        sign = "DJF";
                        ////setUnitCost="26.72"; // 55.22
                        //setInfo.setText("Electricity charges per unit : 26.72 DJF");
                        break;
                    case "Dominican Republic (DO)":
                        sign = "DOP";
                        ////setUnitCost="5.126";
                        //setInfo.setText("Electricity charges per unit : 5.126 DOP");
                        break;
                    case "Ecuador (EC)":
                        sign = "USD";
                        ////setUnitCost="0.096";
                        //setInfo.setText("Electricity charges per unit : 0.096 USD");
                        break;
                    case "Egypt (EG)":
                        sign = "EGP";
                        ////setUnitCost="0.828";
                        //setInfo.setText("Electricity charges per unit : 0.828 EGP");
                        break;
                    case "El Salvador (SV)":
                        sign = "USD";
                        ////setUnitCost="0.199";
                        //setInfo.setText("Electricity charges per unit : 0.199 USD");
                        break;
                    case "Estonia (EE)":
                        sign = "EUR";
                        ////setUnitCost="0.176";
                        //setInfo.setText("Electricity charges per unit : 0.176 EUR");
                        break;
                    case "Ethiopia (ET)":
                        sign = "ETB";
                        ////setUnitCost="0.349";
                        //setInfo.setText("Electricity charges per unit : 0.349 ETB");
                        break;
                    case "Fiji (FJ)":
                        sign = "FJD";
                        ////setUnitCost="0.34";
                        //setInfo.setText("Electricity charges per unit : 0.34 FJD");
                        break;
                    case "Finland (FI)":
                        sign = "EUR";
                        ////setUnitCost="0.172";
                        //setInfo.setText("Electricity charges per unit : 0.172 EUR");
                        break;
                    case "France (FR)":
                        sign = "EUR";
                        ////setUnitCost="0.185";
                        //setInfo.setText("Electricity charges per unit : 0.185 EUR");
                        break;
                    case "Gabon (GA)":
                        sign = "XAF";
                        ////setUnitCost="122.960";
                        //setInfo.setText("Electricity charges per unit : 122.960 XAF");
                        break;
                    case "Gambia (GM)":
                        sign = "GMD";
                        ////setUnitCost="10.14"; //10.90
                        //setInfo.setText("Electricity charges per unit : 10.14 GMD");
                        break;
                    case "Georgia (GA)":
                        sign = "GEL";
                        ////setUnitCost="0.199";
                        //setInfo.setText("Electricity charges per unit : 0.199 GEL");
                        break;
                    case "Germany (DE)":
                        sign = "EUR";
                        ////setUnitCost="0.317";
                        //setInfo.setText("Electricity charges per unit : 0.317 EUR");
                        break;
                    case "Ghana (GH)":
                        sign = "GHS";
                        ////setUnitCost="0.369";
                        //setInfo.setText("Electricity charges per unit : 0.369 GHS");
                        break;
                    case "Great Britain [UK]":
                        sign = "GBP";
                        ////setUnitCost="0.218";
                        //setInfo.setText("Electricity charges per unit : 0.218 GBP");
                        break;
                    case "Greece (GR)":
                        sign = "EUR";
                        ////setUnitCost="0.187";
                        //setInfo.setText("Electricity charges per unit : 0.187 EUR");
                        break;
                    case "Guatemala (GT)":
                        sign = "GTQ";
                        ////setUnitCost="1.996";
                        //setInfo.setText("Electricity charges per unit : 1.996 GTQ");
                        break;
                    case "Guyana (GY)":
                        sign = "GYD";
                        ////setUnitCost="66.86";
                        //setInfo.setText("Electricity charges per unit : 66.86 GYD");
                        break;
                    case "Haiti (HT)":
                        sign = "HTG";
                        ////setUnitCost="39.57";
                        //setInfo.setText("Electricity charges per unit : 39.57 HTG");
                        break;
                    case "Honduras (HN)":
                        sign = "HNL";
                        ////setUnitCost="4.402";
                        //setInfo.setText("Electricity charges per unit : 4.402 HNL");
                        break;
                    case "Hong Kong (HK)":
                        sign = "HKD";
                        ////setUnitCost="1.176";
                        //setInfo.setText("Electricity charges per unit : 1.176 HKD");
                        break;
                    case "Hungary (HU)":
                        sign = "HUF";
                        ////setUnitCost="37.462";
                        //setInfo.setText("Electricity charges per unit : 37.462 HUF");
                        break;
                    case "Iceland (IS)":
                        sign = "ISK";
                        ////setUnitCost="18.477";
                        //setInfo.setText("Electricity charges per unit : 18.477 ISK");
                        break;
                    case "Indonesia (ID)":
                        sign = "IDR";
                        ////setUnitCost="1444.700";
                        //setInfo.setText("Electricity charges per unit : 1,444.700 IDR");
                        break;
                    case "Iran (IR)":
                        sign = "IRR";
                        ////setUnitCost="1402.0";
                        //setInfo.setText("Electricity charges per unit : 1,402.00 IRR");
                        break;
                    case "Iraq (IQ)":
                        sign = "IQD";
                        ////setUnitCost="35.0";
                        //setInfo.setText("Electricity charges per unit : 35.00 IQD");
                        break;
                    case "Ireland (IE)":
                        sign = "EUR";
                        ////setUnitCost="0.242";
                        //setInfo.setText("Electricity charges per unit : 0.242 EUR");
                        break;
                    case "Israel (IL)":
                        sign = "ILS";
                        ////setUnitCost="0.549";
                        //setInfo.setText("Electricity charges per unit : 0.549 ILS");
                        break;
                    case "Italy (IT)":
                        sign = "EUR";
                        ////setUnitCost="0.214";
                        //setInfo.setText("Electricity charges per unit : 0.214 EUR");
                        break;
                    case "Ivory Coast (CI)":
                        sign = "XOF";
                        ////setUnitCost="72.604";
                        //setInfo.setText("Electricity charges per unit : 72.604 XOF");
                        break;
                    case "Jamaica (JM)":
                        sign = "JMD";
                        ////setUnitCost="39.683";
                        //setInfo.setText("Electricity charges per unit : 39.683 JMD");
                        break;
                    case "Japan (JP)":
                        sign = "JPY";
                        ////setUnitCost="30.262";
                        //setInfo.setText("Electricity charges per unit : 30.262 JPY");
                        break;
                    case "Jordan (JO)":
                        sign = "JOD";
                        ////setUnitCost="0.071";
                        //setInfo.setText("Electricity charges per unit : 0.071 JOD");
                        break;
                    case "Kazakhstan (KZ)":
                        sign = "KZT";
                        ////setUnitCost="19.129";
                        //setInfo.setText("Electricity charges per unit : 0.071 KZT");
                        break;
                    case "Kenya (KE)":
                        sign = "KES";
                        ////setUnitCost="24.770";//20.280
                        //setInfo.setText("Electricity charges per unit : 24.77 KES");
                        break;
                    case "Kiribati (KI)":
                        sign = "AUD";
                        ////setUnitCost="0.60";
                        //setInfo.setText("Electricity charges per unit : 0.60 AUD");
                        break;
                    case "Kuwait (KW)":
                        sign = "KWD";
                        ////setUnitCost="0.009";
                        //setInfo.setText("Electricity charges per unit : 0.009 KWD");
                        break;
                    case "Kyrgyzstan (KG)":
                        sign = "KGS";
                        ////setUnitCost="0.860";
                        //setInfo.setText("Electricity charges per unit : 0.860 KGS");
                        break;
                    case "Laos":
                        sign = "LAK";
                        ////setUnitCost="593.380";
                        //setInfo.setText("Electricity charges per unit : 593.380 LAK");
                        break;
                    case "Latvia (LV)":
                        sign = "EUR";
                        ////setUnitCost="0.156";
                        //setInfo.setText("Electricity charges per unit : 0.156 EUR");
                        break;
                    case "Lebanon (LB)":
                        sign = "LBP";
                        ////setUnitCost="116.720";
                        //setInfo.setText("Electricity charges per unit : 116.720 LBP");
                        break;
                    case "Lesotho (LS)":
                        sign = "LSL";
                        ////setUnitCost="1.550";
                        //setInfo.setText("Electricity charges per unit : 1.550 LSL");
                        break;
                    case "Liberia (LR)":
                        sign = "LRD";
                        ////setUnitCost="82.35";
                        //setInfo.setText("Electricity charges per unit : 82.35 LRD");
                        break;
                    case "Libya (LY)":
                        sign = "LYD";
                        ////setUnitCost="0.02";
                        //setInfo.setText("Electricity charges per unit : 0.02 LYD");
                        break;
                    case "Liechtenstein (LI)":
                        sign = "CHF";
                        ////setUnitCost="0.257";
                        //setInfo.setText("Electricity charges per unit : 0.257 CHF");
                        break;
                    case "Lithuania (LT)":
                        sign = "EUR";
                        ////setUnitCost="0.186";
                        //setInfo.setText("Electricity charges per unit : 0.186 EUR");
                        break;
                    case "Luxembourg (LU)":
                        sign = "EUR";
                        ////setUnitCost="0.212";
                        //setInfo.setText("Electricity charges per unit : 0.212 EUR");
                        break;
                    case "Madagascar (MG)":
                        sign = "MGA";
                        ////setUnitCost="581.890";
                        //setInfo.setText("Electricity charges per unit : 581.890 MGA");
                        break;
                    case "Malawi (MW)":
                        sign = "MWK";
                        ////setUnitCost="112.100";
                        //setInfo.setText("Electricity charges per unit : 112.10 MWK");
                        break;
                    case "Malaysia (MY)":
                        sign = "MYR";
                        ////setUnitCost="0.221";
                        //setInfo.setText("Electricity charges per unit : 0.221 MYR");
                        break;
                    case "Maldives (MV)":
                        sign = "MVR";
                        ////setUnitCost="1.7";//3.55
                        //setInfo.setText("Electricity charges per unit : 1.70 MVR");
                        break;
                    case "Mali (ML)":
                        sign = "XOF";
                        ////setUnitCost="131.080";
                        //setInfo.setText("Electricity charges per unit : 131.08 XOF");
                        break;
                    case "Malta (MT)":
                        sign = "EUR";
                        ////setUnitCost="0.134";
                        //setInfo.setText("Electricity charges per unit : 0.134 EUR");
                        break;
                    case "Marshall Islands (MI)":
                        sign = "USD";
                        ////setUnitCost="0.346";//0.406
                        //setInfo.setText("Electricity charges per unit : 0.346 USD");
                        break;
                    case "Mauritius (MU)":
                        sign = "MUR";
                        ////setUnitCost="6.050";
                        //setInfo.setText("Electricity charges per unit : 6.05 MUR");
                        break;
                    case "Mexico (MX)":
                        sign = "MXN";
                        ////setUnitCost="1.712";
                        //setInfo.setText("Electricity charges per unit : 1.712 MXN");
                        break;
                    case "Micronesia (FM)":
                        sign = "USD";
                        ////setUnitCost="0.48";
                        //setInfo.setText("Electricity charges per unit : 0.48 USD");
                        break;
                    case "Moldova (MD)":
                        sign = "MDL";
                        ////setUnitCost="1.510";
                        //setInfo.setText("Electricity charges per unit : 1.51 MDL");
                        break;
                    case "Monaco (MC)":
                        sign = "EUR";
                        ////setUnitCost="0.15";
                        //setInfo.setText("Electricity charges per unit : 0.15 EUR");
                        break;
                    case "Mongolia (MN)":
                        sign = "MNT";
                        ////setUnitCost="188.16";
                        //setInfo.setText("Electricity charges per unit : 188.16 MNT");
                        break;
                    case "Montenegro (ME)":
                        sign = "EUR";
                        ////setUnitCost="0.097";
                        //setInfo.setText("Electricity charges per unit : 0.097 EUR");
                        break;
                    case "Morocco (MA)":
                        sign = "MAD";
                        ////setUnitCost="1.172";
                        //setInfo.setText("Electricity charges per unit : 1.172 MAD");
                        break;
                    case "Mozambique (MZ)":
                        sign = "MZN";
                        ////setUnitCost="8.975";
                        //setInfo.setText("Electricity charges per unit : 8.975 MZN");
                        break;
                    case "Myanmar (MM)":
                        sign = "MMK";
                        ////setUnitCost="60.500";
                        //setInfo.setText("Electricity charges per unit : 60.50 MMK");
                        break;
                    case "Namibia (NA)":
                        sign = "NAD";
                        ////setUnitCost="1.952";
                        //setInfo.setText("Electricity charges per unit : 1.952 NAD");
                        break;
                    case "Nauru (NR)":
                        sign = "AUD";
                        ////setUnitCost="0.10";//0.20
                        //setInfo.setText("Electricity charges per unit : 0.10 AUD");
                        break;
                    case "Nepal (NP)":
                        sign = "NPR";
                        ////setUnitCost="8.290";
                        //setInfo.setText("Electricity charges per unit : 8.29 NPR");
                        break;
                    case "Netherlands (NL)":
                        sign = "EUR";
                        ////setUnitCost="0.191";
                        //setInfo.setText("Electricity charges per unit : 0.191 EUR");
                        break;
                    case "New Zealand (NZ)":
                        sign = "NZD";
                        ////setUnitCost="0.304";
                        //setInfo.setText("Electricity charges per unit : 0.304 NZD");
                        break;
                    case "Nicaragua (NI)":
                        sign = "NIO";
                        ////setUnitCost="6.226";
                        //setInfo.setText("Electricity charges per unit : 6.226 NIO");
                        break;
                    case "Niger (NE)":
                        sign = "XOF";
                        ////setUnitCost="104.19";
                        //setInfo.setText("Electricity charges per unit : 104.19 XOF");
                        break;
                    case "Nigeria (NG)":
                        sign = "NGN";
                        ////setUnitCost="23.592";
                        //setInfo.setText("Electricity charges per unit : 23.592 NGN");
                        break;
                    case "Norway (NO)":
                        sign = "NOK";
                        ////setUnitCost="1.377";
                        //setInfo.setText("Electricity charges per unit : 1.377 NOK");
                        break;
                    case "Oman (OM)":
                        sign = "OMR";
                        ////setUnitCost="0.010";
                        //setInfo.setText("Electricity charges per unit : 0.01 OMR");
                        break;
                    case "Pakistan (PK)":
                        sign = "PKR";
                        ////setUnitCost="9.230";
                        //setInfo.setText("Electricity charges per unit : 9.23 PKR");
                        break;
                    case "Palau (PW)":
                        sign = "USD";
                        ////setUnitCost="0.28";
                        //setInfo.setText("Electricity charges per unit : 0.28 USD");
                        break;
                    case "Palestine State (PS)":
                        sign = "PSP";
                        ////setUnitCost="0.085";
                        //setInfo.setText("Electricity charges per unit : 0.085 PSP");
                        break;
                    case "Panama (PA)":
                        sign = "USD";
                        ////setUnitCost="0.154";
                        //setInfo.setText("Electricity charges per unit : 0.154 USD");
                        break;
                    case "Papua New Guinea (PG)":
                        sign = "PGK";
                        ////setUnitCost="1029";
                        //setInfo.setText("Electricity charges per unit : 1,029 PGK");
                        break;
                    case "Paraguay (PY)":
                        sign = "PYG";
                        ////setUnitCost="401.995";
                        //setInfo.setText("Electricity charges per unit : 401.995 PYG");
                        break;
                    case "Peru (PE)":
                        sign = "PEN";
                        ////setUnitCost="0.773";
                        //setInfo.setText("Electricity charges per unit : 0.773 PEN");
                        break;
                    case "Philippines (PH)":
                        sign = "PHP";
                        ////setUnitCost="8.907";
                        //setInfo.setText("Electricity charges per unit : 8.907 PHP");
                        break;
                    case "Poland (PL)":
                        sign = "PLN";
                        ////setUnitCost="0.756";
                        //setInfo.setText("Electricity charges per unit : 0.756 PLN");
                        break;
                    case "Puerto Rico (PR)":
                        sign = "USD";
                        ////setUnitCost="0.26";//0.30
                        //setInfo.setText("Electricity charges per unit : 0.26 USD");
                        break;
                    case "Portugal (PT)":
                        sign = "EUR";
                        ////setUnitCost="0.229";
                        //setInfo.setText("Electricity charges per unit : 0.229 EUR");
                        break;
                    case "Qatar (QA)":
                        sign = "QAR";
                        ////setUnitCost="0.115";
                        //setInfo.setText("Electricity charges per unit : 0.115 QAR");
                        break;
                    case "Republic of Korea (KR)":
                        sign = "LRW";
                        ////setUnitCost="130.000";
                        //setInfo.setText("Electricity charges per unit : 130.00 LRW");
                        break;
                    case "Romania (RO)":
                        sign = "RON";
                        //setUnitCost="0.737";
                        //setInfo.setText("Electricity charges per unit : 0.737 RON");
                        break;
                    case "Russian Federation (RU)":
                        sign = "RUB";
                        //setUnitCost="4.811";
                        //setInfo.setText("Electricity charges per unit : 4.811 RUB");
                        break;
                    case "Rwanda (RW)":
                        sign = "RWF";
                        //setUnitCost="257.290";
                        //setInfo.setText("Electricity charges per unit : 257.29 RWF");
                        break;
                    case "Saint Kitts and Nevis (KN)":
                        sign = "XCD";
                        //setUnitCost="0.89";
                        //setInfo.setText("Electricity charges per unit : 0.89 XCD");
                        break;
                    case "Saint Lucia (LC)":
                        sign = "XCD";
                        //setUnitCost="0.90";
                        //setInfo.setText("Electricity charges per unit : 0.90 XCD");
                        break;
                    case "Saint Vincent and the Grenadines (VC)":
                        sign = "XCD";
                        //setUnitCost="0.26";
                        //setInfo.setText("Electricity charges per unit : 0.26 XCD");
                        break;
                    case "Samoa (SO)":
                        sign = "WST";
                        //setUnitCost="0.375";//0.321
                        //setInfo.setText("Electricity charges per unit : 0.375 WST");
                        break;
                    case "San Marino (SM)":
                        sign = "EUR";
                        //setUnitCost="0.16";
                        //setInfo.setText("Electricity charges per unit : 0.16 EUR");
                        break;
                    case "Sao Tome and Principe":
                        sign = "STN";
                        //setUnitCost="7.5";
                        //setInfo.setText("Electricity charges per unit : 7.50 STN");
                        break;
                    case "Saudi Arabia (SA)":
                        sign = "SAR";
                        //setUnitCost="0.180";
                        //setInfo.setText("Electricity charges per unit : 0.180 SAR");
                        break;
                    case "Senegal (SN)":
                        sign = "XOF";
                        //setUnitCost="103.245";
                        //setInfo.setText("Electricity charges per unit : 103.245 XOF");
                        break;
                    case "Serbia (RS)":
                        sign = "RSD";
                        //setUnitCost="10.250";
                        //setInfo.setText("Electricity charges per unit : 10.25 RSD");
                        break;
                    case "Seychelles (SC)":
                        sign = "SCR";
                        //setUnitCost="1.60";//3.5
                        //setInfo.setText("Electricity charges per unit : 1.60 SCR");
                        break;
                    case "Sierra Leone (SL)":
                        sign = "SLL";
                        //setUnitCost="1606.000";
                        //setInfo.setText("Electricity charges per unit : 1,606 SLL");
                        break;
                    case "Singapore (SG)":
                        sign = "SGD";
                        //setUnitCost="0.250";
                        //setInfo.setText("Electricity charges per unit : 0.25 SGD");
                        break;
                    case "Slovakia (SK)":
                        sign = "EUR";
                        //setUnitCost="0.169";
                        //setInfo.setText("Electricity charges per unit : 0.169 EUR");
                        break;
                    case "Slovenia (SI)":
                        sign = "EUR";
                        //setUnitCost="0.179";
                        //setInfo.setText("Electricity charges per unit : 0.179 EUR");
                        break;
                    case "Somalia (SO)":
                        sign = "SOS";
                        //setUnitCost="350";
                        //setInfo.setText("Electricity charges per unit : 350 SOS");
                        break;
                    case "South Africa (ZA)":
                        sign = "ZAR";
                        //setUnitCost="2.558";
                        //setInfo.setText("Electricity charges per unit : 2.558 ZAR");
                        break;
                    case "South Korea (KR)":
                        sign = "SKW";
                        //setUnitCost="123.022";
                        //setInfo.setText("Electricity charges per unit : 123.022 SKW");
                        break;
                    case "Spain (ES)":
                        sign = "EUR";
                        //setUnitCost="0.242";
                        //setInfo.setText("Electricity charges per unit : 0.242 EUR");
                        break;
                    case "Sri Lanka (LK)":
                        sign = "LKR";
                        //setUnitCost="15.290";
                        //setInfo.setText("Electricity charges per unit : 15.290 LKR");
                        break;
                    case "Sudan (SD)":
                        sign = "SDG";
                        //setUnitCost="0.800";
                        //setInfo.setText("Electricity charges per unit : 0.80 SDG");
                        break;
                    case "Suriname (SR)":
                        sign = "SRD";
                        //setUnitCost="0.350";
                        //setInfo.setText("Electricity charges per unit : 0.350 SRD");
                        break;
                    case "Sweden (SE)":
                        sign = "SEK";
                        //setUnitCost="1.770";
                        //setInfo.setText("Electricity charges per unit : 1.77 SEK");
                        break;
                    case "Switzerland (CH)":
                        sign = "CHF";
                        //setUnitCost="0.206";
                        //setInfo.setText("Electricity charges per unit : 0.206 CHF");
                        break;
                    case "Syria (SY)":
                        sign = "SYP";
                        //setUnitCost="560";
                        //setInfo.setText("Electricity charges per unit : 560 SYP");
                        break;
                    case "Taiwan (TW)":
                        sign = "TWD";
                        //setUnitCost="2.924";
                        //setInfo.setText("Electricity charges per unit : 2.924 TWD");
                        break;
                    case "Tajikistan (TJ)":
                        sign = "TJS";
                        //setUnitCost="0.081";//0.13
                        //setInfo.setText("Electricity charges per unit : 0.081 TJS");
                        break;
                    case "Tanzania (TZ)":
                        sign = "TZS";
                        //setUnitCost="229.590";
                        //setInfo.setText("Electricity charges per unit : 229.59 TZS");
                        break;
                    case "Thailand (TH)":
                        sign = "THB";
                        //setUnitCost="3.777";
                        //setInfo.setText("Electricity charges per unit : 3.777 THB");
                        break;
                    case "Timor-Leste (TL)":
                        sign = "USD";
                        //setUnitCost="0.12";
                        //setInfo.setText("Electricity charges per unit : 0.12 USD");
                        break;
                    case "Togo (TG)":
                        sign = "XOF";
                        //setUnitCost="115.880";
                        //setInfo.setText("Electricity charges per unit : 115.88 XOF");
                        break;
                    case "Tonga (TO)":
                        sign = "TOP";
                        //setUnitCost="0.76";
                        //setInfo.setText("Electricity charges per unit : 0.76 TOP");
                        break;
                    case "Trinidad and Tobago (TT)":
                        sign = "TTD";
                        //setUnitCost="0.354";
                        //setInfo.setText("Electricity charges per unit : 0.354 TTD");
                        break;
                    case "Tunisia (TN)":
                        sign = "TND";
                        //setUnitCost="0.210";
                        //setInfo.setText("Electricity charges per unit : 0.210 TND");
                        break;
                    case "Turkey (TR)":
                        sign = "TRY";
                        //setUnitCost="0.920";
                        //setInfo.setText("Electricity charges per unit : 0.920 TRY");
                        break;
                    case "Turkmenistan (TK)":
                        sign = "TMT";
                        //setUnitCost="0.98";
                        //setInfo.setText("Electricity charges per unit : 0.98 TMT");
                        break;
                    case "Tuvalu (TV)":
                        sign = "AUD";
                        //setUnitCost="0.05";
                        //setInfo.setText("Electricity charges per unit : 0.05");
                        break;
                    case "Uganda (UG)":
                        sign = "UGX";
                        //setUnitCost="672.875";
                        //setInfo.setText("Electricity charges per unit : 672.875 UGX");
                        break;
                    case "Ukraine (UA)":
                        sign = "UAH";
                        //setUnitCost="1.680";
                        //setInfo.setText("Electricity charges per unit : 1.680 UAH");
                        break;
                    case "United Arab Emirates (AE)":
                        sign = "AED";
                        //setUnitCost="0.296";
                        //setInfo.setText("Electricity charges per unit : 0.296 AED");
                        break;
                    case "United Kingdom (UK)":
                        sign = "GBP";
                        //setUnitCost="0.218";
                        //setInfo.setText("Electricity charges per unit : 0.218 GBP");
                        break;
                    case "Uruguay (UY)":
                        sign = "UYI";
                        //setUnitCost="9.156";
                        //setInfo.setText("Electricity charges per unit : 9.156 UYI");
                        break;
                    case "Uzbekistan (UZ)":
                        sign = "UZS";
                        //setUnitCost="295";
                        //setInfo.setText("Electricity charges per unit : 295.000 UZS");
                        break;
                    case "Vanuatu (VU)":
                        sign = "VUV";
                        //setUnitCost="59.71";
                        //setInfo.setText("Electricity charges per unit : 59.71 VUV");
                        break;
                    case "Venezuela (VE)":
                        sign = "VEF";
                        //setUnitCost="1.093";
                        //setInfo.setText("Electricity charges per unit : 1.093 VEF");
                        break;
                    case "Vietnam (VN)":
                        sign = "VND";
                        //setUnitCost="1876.600";
                        //setInfo.setText("Electricity charges per unit : 1876.000 VND");
                        break;
                    case "Yemen (YE)":
                        sign = "YER";
                        //setUnitCost="350.0";//650
                        //setInfo.setText("Electricity charges per unit : 350.00 YER");
                        break;
                    case "Zambia (ZM)":
                        sign = "ZMW";
                        //setUnitCost="0.559";
                        //setInfo.setText("Electricity charges per unit : 0.559 ZMW");
                        break;
                    case "Zimbabwe (ZW)":
                        sign = "ZWL";
                        //setUnitCost="4.282";
                        //setInfo.setText("Electricity charges per unit : 4.282 ZWL");
                        break;
                    default:
                        sign = "USD";
                        //setUnitCost="0.060";

    }
}
}

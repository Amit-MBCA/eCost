package com.example.costdemo;

import static java.lang.String.format;
import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class applForAll extends AppCompatActivity {
    private String applName, nationName, stateName, getNum, occuName;
    private Spinner selectAppl;
    private ArrayAdapter applAdapter;
    private TextView tvforcpd, tvforcpm, tvforcpy, tvUnitCost;
    private EditText setPowerUsage, setkwhCost, nohours, selectNum;
    private double getNumOfAppl, getNumOfHours, getPowCost, getPowCon;
    private String numberhour, kwhct, pusage,d, m, y;;
    private int flag=0;
    private double day, month, year ;
    private String sign;
    private double dnew=0,mnew=0,ynew=0;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appl_for_all);
        nohours = findViewById(R.id.numofHours);
        tvUnitCost = findViewById(R.id.tvUnitCost);
        selectAppl = findViewById(R.id.applSpinner);
        selectNum = findViewById(R.id.numofappl);
        setPowerUsage = findViewById(R.id.powerUsage);
        setkwhCost = findViewById(R.id.kwhCost);
        tvforcpd = findViewById(R.id.tvperday);
        tvforcpm = findViewById(R.id.tvpermonth);
        tvforcpy = findViewById(R.id.tvperyear);
        btn=findViewById(R.id.btn_compute);
        setPowerUsage.setText("100");
        SharedPreferences shrd = getSharedPreferences(Signup.PREFS_NAME, 0);
        nationName = shrd.getString("nation", "Country Name");
        if (nationName.equals("India (IN)")) {
            stateName = shrd.getString("selectedState", "userState");
        } else {
            occuName = shrd.getString("selectedOccupation", "Household");
        }
        setCost(nationName);
        tvUnitCost.setText("1 Unit (kWh) cost in " + sign + " :"); //this one
        applAdapter = ArrayAdapter.createFromResource(this, R.array.array_appl_type, R.layout.cptspinnerbg);
        applAdapter.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
        selectAppl.setAdapter(applAdapter);
        selectAppl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                applName = selectAppl.getSelectedItem().toString();
                switch (applName) {
                    case "Air Conditioner (AC)":
                        setPowerUsage.setText("2900");
                        break;
                    case "Blender":
                        setPowerUsage.setText("500");
                        break;
                    case "Clothes Dryer":
                        setPowerUsage.setText("3000");
                        break;
                    case "Clothes Iron":
                        setPowerUsage.setText("1400");
                        break;
                    case "Coffee Machine":
                        setPowerUsage.setText("1000");
                        break;
                    case "Dishwasher":
                        setPowerUsage.setText("1300");
                        break;
                    case "Desktop Computer":
                        setPowerUsage.setText("200");
                        break;
                    case "Electric Heater":
                        setPowerUsage.setText("2000");
                        break;
                    case "Electric Kettle":
                        setPowerUsage.setText("1700");
                        break;
                    case "Fan":
                        setPowerUsage.setText("80");
                        break;
                    case "Hair Dryer":
                        setPowerUsage.setText("1500");
                        break;
                    case "Laptop Computer":
                        setPowerUsage.setText("100");
                        break;
                    case "LED Bulb":
                        setPowerUsage.setText("20");
                        break;
                    case "Microwave Oven":
                        setPowerUsage.setText("1000");
                        break;
                    case "Sewing Machine":
                        setPowerUsage.setText("100");
                        break;
                    case "Stereo Receiver":
                        setPowerUsage.setText("300");
                        break;
                    case "Tankless Water Heater (Geyser)":
                        setPowerUsage.setText("2000");
                        break;
                    case "Toaster Oven":
                        setPowerUsage.setText("1100");
                        break;
                    case "TV/LED Monitor":
                        setPowerUsage.setText("120");
                        break;
                    case "Vacuum Cleaner":
                        setPowerUsage.setText("1200");
                        break;
                    case "Washing Machine":
                        setPowerUsage.setText("1500");
                        break;
                    case "Water Heater":
                        setPowerUsage.setText("4000");
                        break;
                    case "Water Pump":
                        setPowerUsage.setText("1000");
                        break;
                    case "Others":
                        setPowerUsage.setText("100");
                        break;
                    default:
                        setPowerUsage.setText("100");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Please select appliance", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clearit(View view) {
        Intent stayhere = new Intent(this, applForAll.class);
        startActivity(stayhere);
        finish();
    }
    public void addCost(View view){
        dnew=day;
        mnew=month;
        ynew=year;
        if(flag==0){
           Toast.makeText(getApplicationContext(),"Press COMPUTE after ADD for addition",Toast.LENGTH_LONG).show();
           flag++;
        }
    }

    public void computeNow(View view) {

        hideSoftKeyboard(applForAll.this, view);
        getNum = selectNum.getText().toString();
        pusage = setPowerUsage.getText().toString();
        kwhct = setkwhCost.getText().toString();
        numberhour = nohours.getText().toString();
        if(getNum.equals("")||pusage.equals("")||kwhct.equals("")||numberhour.equals("")){
                Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_SHORT).show();
            tvforcpd.setVisibility(View.INVISIBLE);
            tvforcpm.setVisibility(View.INVISIBLE);
            tvforcpy.setVisibility(View.INVISIBLE);
        }

            else {
            getNumOfHours = Double.parseDouble(numberhour);
            int temp;
            temp = (int) getNumOfHours;
            if (temp>24||temp<0) {
                nohours.requestFocus();
                nohours.setError("Hours Format Error");
                tvforcpd.setVisibility(View.INVISIBLE);
                tvforcpm.setVisibility(View.INVISIBLE);
                tvforcpy.setVisibility(View.INVISIBLE);
            }
            else {
                btn.setVisibility(View.VISIBLE);
                getPowCon = Double.parseDouble(pusage);
                getPowCost = Double.parseDouble(kwhct);
                getNumOfAppl = Double.valueOf(getNum);
                getNumOfHours = Double.parseDouble(numberhour);
                day = ((getNumOfHours * getPowCon * getPowCost * getNumOfAppl) / 1000)+dnew;
                month = ((getNumOfHours * getPowCon * getPowCost * getNumOfAppl * 30) / 1000)+mnew;
                year = ((getNumOfHours * getPowCon * getPowCost * getNumOfAppl * 365) / 1000)+ynew;
                dnew=0;
                mnew=0;
                ynew=0;
                tvforcpd.setVisibility(View.VISIBLE);
                tvforcpm.setVisibility(View.VISIBLE);
                tvforcpy.setVisibility(View.VISIBLE);

                DecimalFormat df = new DecimalFormat("#.###");
                df.setGroupingUsed(true);
                df.setGroupingSize(3);

                tvforcpd.setText("Cost of Electricity per day : " + df.format(day) + " " + sign);
                tvforcpm.setText("Cost of Electricity per month : " + df.format(month) + " " + sign);
                tvforcpy.setText("Cost of Electricity per year : " + df.format(year) + " " + sign);
            }
            }
    }

    public void setCost(String country) {
        if (country.equals("India (IN)")) {
            sign = "INR";
            switch (stateName) {

                case "AP | Andhra Pradesh":
                case "AN | Andaman and Nicobar":
                case "MH | Maharashtra":
                    setkwhCost.setText("5 ");
                    break;
                case "AR | Arunachal Pradesh":
                case "UT | Uttarakhand":
                    setkwhCost.setText("4");
                    break;
                case "AS | Assam":
                    setkwhCost.setText("8.14");
                    break;
                case "BR | Bihar":
                    setkwhCost.setText("6.95");
                    break;
                case "CH | Chandigarh":
                case "PB | Punjab":
                    setkwhCost.setText("5.84");
                    break;
                case "CT | Chhattisgarh":
                    setkwhCost.setText("6.22");
                    break;
                case "DN | Dadra and Nagar Haveli":
                    setkwhCost.setText("2.30");
                    break;
                case "DD | Daman and Diu":
                    setkwhCost.setText("3");
                    break;
                case "DL | Delhi":
                    setkwhCost.setText("3");
                    break;
                case "GA | Goa":
                    setkwhCost.setText("2.35");
                    break;
                case "GJ | Gujarat":
                    setkwhCost.setText("4.15");
                    break;
                case "HR | Haryana":
                    setkwhCost.setText("2.5");
                    break;
                case "HP | Himachal Pradesh":
                    setkwhCost.setText("1");
                    break;
                case "JK | Jammu and Kashmir":
                    setkwhCost.setText("2.20");
                    break;
                case "JH | Jharkhand":
                    setkwhCost.setText("5.75");
                    break;
                case "KA | Karnataka":
                    setkwhCost.setText("9");
                    break;
                case "KL | Kerala":
                    setkwhCost.setText("3.15");
                    break;
                case "LD | Lakshadweep":
                    setkwhCost.setText("3.1");
                    break;
                case "MP | Madhya Pradesh":
                    setkwhCost.setText("5.17");
                    break;
                case "MN | Manipur":
                    setkwhCost.setText("5.95");
                    break;
                case "ML | Meghalaya":
                    setkwhCost.setText("4.40");
                    break;
                case "MZ | Mizoram":
                    setkwhCost.setText("5.50");
                    break;
                case "NL | Nagaland":
                    setkwhCost.setText("6");
                    break;
                case "OR | Orissa":
                    setkwhCost.setText("4.8");
                    break;
                case "PY | Pondicherry":
                    setkwhCost.setText("2.9");
                    break;
                case "RJ | Rajasthan":
                    setkwhCost.setText("6.5");
                    break;
                case "SK | Sikkim":
                    setkwhCost.setText("3");
                    break;
                case "TN | Tamil Nadu":
                    setkwhCost.setText("1.5");
                    break;
                case "TG | Telangana":
                    setkwhCost.setText("4.3");
                    break;
                case "TR | Tripura":
                    setkwhCost.setText("5.98");
                    break;
                case "UP | Uttar Pradesh":
                    setkwhCost.setText("3.85");
                    break;
                case "WB | West Bengal":
                    setkwhCost.setText("6.5");
                    break;
                default:
                    setkwhCost.setText("3.33");
                    break;
            }
        }
        else {
            if (occuName.equals("Household")) {
                switch (country) {
                    case "Afghanistan (AFG)":
                        sign = "AFN";
                        setkwhCost.setText("3.750");
                        break;
                    case "Albania (ALB)":
                        sign = "ALL";
                        setkwhCost.setText("11.400");
                        break;

                    case "Algeria (DZ)":
                        sign = "DZD";
                        setkwhCost.setText("5.340");
                        break;
                    case "Andorra (AD)":
                        sign = "EUR";
                        setkwhCost.setText("0.100"); //W
                        break;
                    case "Angola (AO)":
                        sign = "AOA";
                        setkwhCost.setText("11.830");
                        break;
                    case "Antigua and Barbuda (ATG)":
                        sign = "XCD";
                        setkwhCost.setText("1.00"); //W
                        break;
                    case "Argentina (AR)":
                        sign = "ARS";
                        setkwhCost.setText("5.870");
                        break;
                    case "Armenia (AM)":
                        sign = "AMD";
                        setkwhCost.setText("39.980");
                        break;
                    case "Australia (AUS)":
                        sign = "AUD";
                        setkwhCost.setText("0.312");
                        break;
                    case "Austria (AT)":
                        sign = "EUR";
                        setkwhCost.setText("0.221");
                        break;
                    case "Azerbaijan (AZ)":
                        sign = "AZN";
                        setkwhCost.setText("0.070");
                        break;
                    case "Bahamas (BS)":
                        sign = "BSD";
                        setkwhCost.setText("0.262");
                        break;
                    case "Bahrain (BH)":
                        sign = "BHD";
                        setkwhCost.setText("0.018");
                        break;
                    case "Bangladesh (BD)":
                        sign = "BDT";
                        setkwhCost.setText("5.614");
                        break;
                    case "Barbados (BB)":
                        sign = "BBD";
                        setkwhCost.setText("0.583");
                        break;
                    case "Belarus (BY)":
                        sign = "BYN";
                        setkwhCost.setText("0.209");
                        break;
                    case "Belgium (BE)":
                        sign = "EUR";
                        setkwhCost.setText("0.291");
                        break;
                    case "Belize (BZ)":
                        sign = "BZD";
                        setkwhCost.setText("0.446");
                        break;
                    case "Benin (BJ)":
                        sign = "XOF";
                        setkwhCost.setText("24.49");   //W
                        break;
                    case "Bermuda (BM)":
                        sign = "BMD";
                        setkwhCost.setText("0.370");
                        break;
                    case "Bhutan (BT)":
                        sign = "BTN";
                        setkwhCost.setText("1.28");
                        break;
                    case "Bolivia (BO)":
                        sign = "BOV";
                        setkwhCost.setText("0.809");
                        break;
                    case "Bosnia and Herzegovina (BiH)":
                        sign = "BAM";
                        setkwhCost.setText("0.18");  //W
                        break;
                    case "Botswana (BW)":
                        sign = "BWP";
                        setkwhCost.setText("1.267");
                        break;
                    case "Brazil (BR)":
                        sign = "BRL";
                        setkwhCost.setText("0.749");
                        break;
                    case "Brunei (BN)":
                        sign = "BND";
                        setkwhCost.setText("0.10"); // W
                        break;
                    case "Bulgaria (BG)":
                        sign = "BGN";
                        setkwhCost.setText("0.241");
                        break;
                    case "Burkina Faso (BF)":
                        sign = "XOF";
                        setkwhCost.setText("123.440");
                        break;
                    case "Burundi (BI)":
                        sign = "BIF";
                        setkwhCost.setText("264.66"); //W
                        break;
                    case "Cabo Verde (CV)":
                        sign = "CVE";
                        setkwhCost.setText("24.360");
                        break;
                    case "Cambodia (KH)":
                        sign = "KHR";
                        setkwhCost.setText("462.29"); //W
                        break;
                    case "Cameroon (CMR)":
                        sign = "XAF";
                        setkwhCost.setText("50.000");
                        break;
                    case "Canada (CA)":
                        sign = "CAD";
                        setkwhCost.setText("6.051"); //   7.1
                        break;
                    case "Central African Republic (CAR)":
                        sign = "XAF";
                        setkwhCost.setText("558"); //W
                        break;
                    case "Chile (CL)":
                        sign = "CLP";
                        setkwhCost.setText("142.634");
                        break;
                    case "China (CN)":
                        sign = "CNY";
                        setkwhCost.setText("0.559");
                        break;
                    case "Colombia (CO)":
                        sign = "COP";
                        setkwhCost.setText("583.620");
                        break;
                    case "Congo (CD)":
                        sign = "XAF";
                        setkwhCost.setText("166.611");
                        break;
                    case "Costa Rica (CR)":
                        sign = "CRC";
                        setkwhCost.setText("75.240");
                        break;
                    case "Croatia (HR)":
                        sign = "HRK";
                        setkwhCost.setText("1.041");
                        break;
                    case "Cuba (CU)":
                        sign = "CUC";
                        setkwhCost.setText("0.720");
                        break;
                    case "Cyprus (CY)":
                        sign = "EUR";
                        setkwhCost.setText("0.260");
                        break;
                    case "Czech Republic (CZ)":
                        sign = "CZK";
                        setkwhCost.setText("5.561");
                        break;
                    case "Denmark (DK)":
                        sign = "DKK";
                        setkwhCost.setText("2.456");
                        break;
                    case "Djibouti (DJ)":
                        sign = "DJF";
                        setkwhCost.setText("26.72"); // 55.22
                        break;
                    case "Dominican Republic (DO)":
                        sign = "DOP";
                        setkwhCost.setText("5.126");
                        break;
                    case "Ecuador (EC)":
                        sign = "USD";
                        setkwhCost.setText("0.096");
                        break;
                    case "Egypt (EG)":
                        sign = "EGP";
                        setkwhCost.setText("0.828");
                        break;
                    case "El Salvador (SV)":
                        sign = "USD";
                        setkwhCost.setText("0.199");
                        break;
                    case "Estonia (EE)":
                        sign = "EUR";
                        setkwhCost.setText("0.176");
                        break;
                    case "Ethiopia (ET)":
                        sign = "ETB";
                        setkwhCost.setText("0.349");
                        break;
                    case "Fiji (FJ)":
                        sign = "FJD";
                        setkwhCost.setText("0.34");
                        break;
                    case "Finland (FI)":
                        sign = "EUR";
                        setkwhCost.setText("0.172");
                        break;
                    case "France (FR)":
                        sign = "EUR";
                        setkwhCost.setText("0.185");
                        break;
                    case "Gabon (GA)":
                        sign = "XAF";
                        setkwhCost.setText("122.960");
                        break;
                    case "Gambia (GM)":
                        sign = "GMD";
                        setkwhCost.setText("10.14"); //10.90
                        break;
                    case "Georgia (GA)":
                        sign = "GEL";
                        setkwhCost.setText("0.199");
                        break;
                    case "Germany (DE)":
                        sign = "EUR";
                        setkwhCost.setText("0.317");
                        break;
                    case "Ghana (GH)":
                        sign = "GHS";
                        setkwhCost.setText("0.369");
                        break;
                    case "Great Britain [UK]":
                        sign = "GBP";
                        setkwhCost.setText("0.218");
                        break;
                    case "Greece (GR)":
                        sign = "EUR";
                        setkwhCost.setText("0.187");
                        break;
                    case "Guatemala (GT)":
                        sign = "GTQ";
                        setkwhCost.setText("1.996");
                        break;
                    case "Guyana (GY)":
                        sign = "GYD";
                        setkwhCost.setText("66.86");
                        break;
                    case "Haiti (HT)":
                        sign = "HTG";
                        setkwhCost.setText("39.57");
                        break;
                    case "Honduras (HN)":
                        sign = "HNL";
                        setkwhCost.setText("4.402");
                        break;
                    case "Hong Kong (HK)":
                        sign = "HKD";
                        setkwhCost.setText("1.176");
                        break;
                    case "Hungary (HU)":
                        sign = "HUF";
                        setkwhCost.setText("37.462");
                        break;
                    case "Iceland (IS)":
                        sign = "ISK";
                        setkwhCost.setText("18.477");
                        break;
                    case "Indonesia (ID)":
                        sign = "IDR";
                        setkwhCost.setText("1444.700");
                        break;
                    case "Iran (IR)":
                        sign = "IRR";
                        setkwhCost.setText("1402.0");
                        break;
                    case "Iraq (IQ)":
                        sign = "IQD";
                        setkwhCost.setText("35.0");
                        break;
                    case "Ireland (IE)":
                        sign = "EUR";
                        setkwhCost.setText("0.242");
                        break;
                    case "Israel (IL)":
                        sign = "ILS";
                        setkwhCost.setText("0.549");
                        break;
                    case "Italy (IT)":
                        sign = "EUR";
                        setkwhCost.setText("0.214");
                        break;
                    case "Ivory Coast (CI)":
                        sign = "XOF";
                        setkwhCost.setText("72.604");
                        break;
                    case "Jamaica (JM)":
                        sign = "JMD";
                        setkwhCost.setText("39.683");
                        break;
                    case "Japan (JP)":
                        sign = "JPY";
                        setkwhCost.setText("30.262");
                        break;
                    case "Jordan (JO)":
                        sign = "JOD";
                        setkwhCost.setText("0.071");
                        break;
                    case "Kazakhstan (KZ)":
                        sign = "KZT";
                        setkwhCost.setText("19.129");
                        break;
                    case "Kenya (KE)":
                        sign = "KES";
                        setkwhCost.setText("24.770");//20.280
                        break;
                    case "Kiribati (KI)":
                        sign = "AUD";
                        setkwhCost.setText("0.60");
                        break;
                    case "Kuwait (KW)":
                        sign = "KWD";
                        setkwhCost.setText("0.009");
                        break;
                    case "Kyrgyzstan (KG)":
                        sign = "KGS";
                        setkwhCost.setText("0.860");
                        break;
                    case "Laos":
                        sign = "LAK";
                        setkwhCost.setText("593.380");
                        break;
                    case "Latvia (LV)":
                        sign = "EUR";
                        setkwhCost.setText("0.156");
                        break;
                    case "Lebanon (LB)":
                        sign = "LBP";
                        setkwhCost.setText("116.720");
                        break;
                    case "Lesotho (LS)":
                        sign = "LSL";
                        setkwhCost.setText("1.550");
                        break;
                    case "Liberia (LR)":
                        sign = "LRD";
                        setkwhCost.setText("82.35");
                        break;
                    case "Libya (LY)":
                        sign = "LYD";
                        setkwhCost.setText("0.020");
                        break;
                    case "Liechtenstein (LI)":
                        sign = "CHF";
                        setkwhCost.setText("0.257");
                        break;
                    case "Lithuania (LT)":
                        sign = "EUR";
                        setkwhCost.setText("0.186");
                        break;
                    case "Luxembourg (LU)":
                        sign = "EUR";
                        setkwhCost.setText("0.212");
                        break;
                    case "Madagascar (MG)":
                        sign = "MGA";
                        setkwhCost.setText("581.890");
                        break;
                    case "Malawi (MW)":
                        sign = "MWK";
                        setkwhCost.setText("112.100");
                        break;
                    case "Malaysia (MY)":
                        sign = "MYR";
                        setkwhCost.setText("0.221");
                        break;
                    case "Maldives (MV)":
                        sign = "MVR";
                        setkwhCost.setText("1.7");//3.55
                        break;
                    case "Mali (ML)":
                        sign = "XOF";
                        setkwhCost.setText("131.080");
                        break;
                    case "Malta (MT)":
                        sign = "EUR";
                        setkwhCost.setText("0.134");
                        break;
                    case "Marshall Islands (MI)":
                        sign = "USD";
                        setkwhCost.setText("0.346");//0.406
                        break;
                    case "Mauritius (MU)":
                        sign = "MUR";
                        setkwhCost.setText("6.050");
                        break;
                    case "Mexico (MX)":
                        sign = "MXN";
                        setkwhCost.setText("1.712");
                        break;
                    case "Micronesia (FM)":
                        sign = "USD";
                        setkwhCost.setText("0.48");
                        break;
                    case "Moldova (MD)":
                        sign = "MDL";
                        setkwhCost.setText("1.510");
                        break;
                    case "Monaco (MC)":
                        sign = "EUR";
                        setkwhCost.setText("0.15");
                        break;
                    case "Mongolia (MN)":
                        sign = "MNT";
                        setkwhCost.setText("188.16");
                        break;
                    case "Montenegro (ME)":
                        sign = "EUR";
                        setkwhCost.setText("0.097");
                        break;
                    case "Morocco (MA)":
                        sign = "MAD";
                        setkwhCost.setText("1.172");
                        break;
                    case "Mozambique (MZ)":
                        sign = "MZN";
                        setkwhCost.setText("8.975");
                        break;
                    case "Myanmar (MM)":
                        sign = "MMK";
                        setkwhCost.setText("60.500");
                        break;
                    case "Namibia (NA)":
                        sign = "NAD";
                        setkwhCost.setText("1.952");
                        break;
                    case "Nauru (NR)":
                        sign = "AUD";
                        setkwhCost.setText("0.10");//0.20
                        break;
                    case "Nepal (NP)":
                        sign = "NPR";
                        setkwhCost.setText("8.290");
                        break;
                    case "Netherlands (NL)":
                        sign = "EUR";
                        setkwhCost.setText("0.191");
                        break;
                    case "New Zealand (NZ)":
                        sign = "NZD";
                        setkwhCost.setText("0.304");
                        break;
                    case "Nicaragua (NI)":
                        sign = "NIO";
                        setkwhCost.setText("6.226");
                        break;
                    case "Niger (NE)":
                        sign = "XOF";
                        setkwhCost.setText("104.19");
                        break;
                    case "Nigeria (NG)":
                        sign = "NGN";
                        setkwhCost.setText("23.592");
                        break;
                    case "Norway (NO)":
                        sign = "NOK";
                        setkwhCost.setText("1.377");
                        break;
                    case "Oman (OM)":
                        sign = "OMR";
                        setkwhCost.setText("0.010");
                        break;
                    case "Pakistan (PK)":
                        sign = "PKR";
                        setkwhCost.setText("9.230");
                        break;
                    case "Palau (PW)":
                        sign = "USD";
                        setkwhCost.setText("0.28");
                        break;
                    case "Palestine State (PS)":
                        sign = "PSP";
                        setkwhCost.setText("0.085");
                        break;
                    case "Panama (PA)":
                        sign = "USD";
                        setkwhCost.setText("0.154");
                        break;
                    case "Papua New Guinea (PG)":
                        sign = "PGK";
                        setkwhCost.setText("1029");
                        break;
                    case "Paraguay (PY)":
                        sign = "PYG";
                        setkwhCost.setText("401.995");
                        break;
                    case "Peru (PE)":
                        sign = "PEN";
                        setkwhCost.setText("0.773");
                        break;
                    case "Philippines (PH)":
                        sign = "PHP";
                        setkwhCost.setText("8.907");
                        break;
                    case "Poland (PL)":
                        sign = "PLN";
                        setkwhCost.setText("0.756");
                        break;
                    case "Puerto Rico (PR)":
                        sign = "USD";
                        setkwhCost.setText("0.26");//0.30
                        break;
                    case "Portugal (PT)":
                        sign = "EUR";
                        setkwhCost.setText("0.229");
                        break;
                    case "Qatar (QA)":
                        sign = "QAR";
                        setkwhCost.setText("0.115");
                        break;
                    case "Republic of Korea (KR)":
                        sign = "LRW";
                        setkwhCost.setText("130.000");
                        break;
                    case "Romania (RO)":
                        sign = "RON";
                        setkwhCost.setText("0.737");
                        break;
                    case "Russian Federation (RU)":
                        sign = "RUB";
                        setkwhCost.setText("4.811");
                        break;
                    case "Rwanda (RW)":
                        sign = "RWF";
                        setkwhCost.setText("257.290");
                        break;
                    case "Saint Kitts and Nevis (KN)":
                        sign = "XCD";
                        setkwhCost.setText("0.89");
                        break;
                    case "Saint Lucia (LC)":
                        sign = "XCD";
                        setkwhCost.setText("0.90");
                        break;
                    case "Saint Vincent and the Grenadines (VC)":
                        sign = "XCD";
                        setkwhCost.setText("0.26");
                        break;
                    case "Samoa (SO)":
                        sign = "WST";
                        setkwhCost.setText("0.375");//0.321
                        break;
                    case "San Marino (SM)":
                        sign = "EUR";
                        setkwhCost.setText("0.16");
                        break;
                    case "Sao Tome and Principe":
                        sign = "STN";
                        setkwhCost.setText("7.5");
                        break;
                    case "Saudi Arabia (SA)":
                        sign = "SAR";
                        setkwhCost.setText("0.180");
                        break;
                    case "Senegal (SN)":
                        sign = "XOF";
                        setkwhCost.setText("103.245");
                        break;
                    case "Serbia (RS)":
                        sign = "RSD";
                        setkwhCost.setText("10.250");
                        break;
                    case "Seychelles (SC)":
                        sign = "SCR";
                        setkwhCost.setText("1.60");//3.5
                        break;
                    case "Sierra Leone (SL)":
                        sign = "SLL";
                        setkwhCost.setText("1606.000");
                        break;
                    case "Singapore (SG)":
                        sign = "SGD";
                        setkwhCost.setText("0.250");
                        break;
                    case "Slovakia (SK)":
                        sign = "EUR";
                        setkwhCost.setText("0.169");
                        break;
                    case "Slovenia (SI)":
                        sign = "EUR";
                        setkwhCost.setText("0.179");
                        break;
                    case "Somalia (SO)":
                        sign = "SOS";
                        setkwhCost.setText("350");
                        break;
                    case "South Africa (ZA)":
                        sign = "ZAR";
                        setkwhCost.setText("2.558");
                        break;
                    case "South Korea (KR)":
                        sign = "SKW";
                        setkwhCost.setText("123.022");
                        break;
                    case "Spain (ES)":
                        sign = "EUR";
                        setkwhCost.setText("0.242");
                        break;
                    case "Sri Lanka (LK)":
                        sign = "LKR";
                        setkwhCost.setText("15.290");
                        break;
                    case "Sudan (SD)":
                        sign = "SDG";
                        setkwhCost.setText("0.800");
                        break;
                    case "Suriname (SR)":
                        sign = "SRD";
                        setkwhCost.setText("0.350");
                        break;
                    case "Sweden (SE)":
                        sign = "SEK";
                        setkwhCost.setText("1.770");
                        break;
                    case "Switzerland (CH)":
                        sign = "CHF";
                        setkwhCost.setText("0.206");
                        break;
                    case "Syria (SY)":
                        sign = "SYP";
                        setkwhCost.setText("560");
                        break;
                    case "Taiwan (TW)":
                        sign = "TWD";
                        setkwhCost.setText("2.924");
                        break;
                    case "Tajikistan (TJ)":
                        sign = "TJS";
                        setkwhCost.setText("0.081");//0.13
                        break;
                    case "Tanzania (TZ)":
                        sign = "TZS";
                        setkwhCost.setText("229.590");
                        break;
                    case "Thailand (TH)":
                        sign = "THB";
                        setkwhCost.setText("3.777");
                        break;
                    case "Timor-Leste (TL)":
                        sign = "USD";
                        setkwhCost.setText("0.12");
                        break;
                    case "Togo (TG)":
                        sign = "XOF";
                        setkwhCost.setText("115.880");
                        break;
                    case "Tonga (TO)":
                        sign = "TOP";
                        setkwhCost.setText("0.76");
                        break;
                    case "Trinidad and Tobago (TT)":
                        sign = "TTD";
                        setkwhCost.setText("0.354");
                        break;
                    case "Tunisia (TN)":
                        sign = "TND";
                        setkwhCost.setText("0.210");
                        break;
                    case "Turkey (TR)":
                        sign = "TRY";
                        setkwhCost.setText("0.920");
                        break;
                    case "Turkmenistan (TK)":
                        sign = "TMT";
                        setkwhCost.setText("0.98");
                        break;
                    case "Tuvalu (TV)":
                        sign = "AUD";
                        setkwhCost.setText("0.05");
                        break;
                    case "Uganda (UG)":
                        sign = "UGX";
                        setkwhCost.setText("672.875");
                        break;
                    case "Ukraine (UA)":
                        sign = "UAH";
                        setkwhCost.setText("1.680");
                        break;
                    case "United Arab Emirates (AE)":
                        sign = "AED";
                        setkwhCost.setText("0.296");
                        break;
                    case "United Kingdom (UK)":
                        sign = "GBP";
                        setkwhCost.setText("0.218");
                        break;
                    case "Uruguay (UY)":
                        sign = "UYI";
                        setkwhCost.setText("9.156");
                        break;
                    case "Uzbekistan (UZ)":
                        sign = "UZS";
                        setkwhCost.setText("295.000");
                        break;
                    case "Vanuatu (VU)":
                        sign = "VUV";
                        setkwhCost.setText("59.71");
                        break;
                    case "Venezuela (VE)":
                        sign = "VEF";
                        setkwhCost.setText("1.093");
                        break;
                    case "Vietnam (VN)":
                        sign = "VND";
                        setkwhCost.setText("1876.600");
                        break;
                    case "Yemen (YE)":
                        sign = "YER";
                        setkwhCost.setText("350.0");//650
                        break;
                    case "Zambia (ZM)":
                        sign = "ZMW";
                        setkwhCost.setText("0.559");
                        break;
                    case "Zimbabwe (ZW)":
                        sign = "ZWL";
                        setkwhCost.setText("4.282");
                        break;
                    default:
                        sign = "$";
                        setkwhCost.setText("0.060");
                }
            }
            else {
                switch (country) {
                    case "Afghanistan (AFG)":
                        sign = "AFN";
                        setkwhCost.setText("3.750");
                        break;
                    case "Albania (ALB)":
                        sign = "ALL";
                        setkwhCost.setText("12.650");
                        break;

                    case "Algeria (DZ)":
                        sign = "DZD";
                        setkwhCost.setText("4.578");
                        break;
                    case "Andorra (AD)":
                        sign = "EUR";
                        setkwhCost.setText("0.100");
                        break;
                    case "Angola (AO)":
                        sign = "AOA";
                        setkwhCost.setText("9.640");
                        break;
                    case "Antigua and Barbuda (ATG)":
                        sign = "XCD";
                        setkwhCost.setText("1.00");
                        break;
                    case "Argentina (AR)":
                        sign = "ARS";
                        setkwhCost.setText("4.420");
                        break;
                    case "Armenia (AM)":
                        sign = "AMD";
                        setkwhCost.setText("32.480");
                        break;
                    case "Australia (AUS)":
                        sign = "AUD";
                        setkwhCost.setText("0.262");
                        break;
                    case "Austria (AT)":
                        sign = "EUR";
                        setkwhCost.setText("0.162");
                        break;
                    case "Azerbaijan (AZ)":
                        sign = "AZN";
                        setkwhCost.setText("0.090");
                        break;
                    case "Bahamas (BS)":
                        sign = "BSD";
                        setkwhCost.setText("0.253");
                        break;
                    case "Bahrain (BH)":
                        sign = "BHD";
                        setkwhCost.setText("0.029");
                        break;
                    case "Bangladesh (BD)":
                        sign = "BDT";
                        setkwhCost.setText("8.990");
                        break;
                    case "Barbados (BB)":
                        sign = "BBD";
                        setkwhCost.setText("0.579");
                        break;
                    case "Belarus (BY)":
                        sign = "BYN";
                        setkwhCost.setText("0.287");
                        break;
                    case "Belgium (BE)":
                        sign = "EUR";
                        setkwhCost.setText("0.106");
                        break;
                    case "Belize (BZ)":
                        sign = "BZD";
                        setkwhCost.setText("0.349");
                        break;
                    case "Benin (BJ)":
                        sign = "XOF";
                        setkwhCost.setText("24.49");
                        break;
                    case "Bermuda (BM)":
                        sign = "BMD";
                        setkwhCost.setText("0.216");
                        break;
                    case "Bhutan (BT)":
                        sign = "BTN";
                        setkwhCost.setText("2.720");
                        break;
                    case "Bolivia (BO)":
                        sign = "BOV";
                        setkwhCost.setText("0.809");
                        break;
                    case "Bosnia and Herzegovina (BiH)":
                        sign = "BAM";
                        setkwhCost.setText("0.18");
                        break;
                    case "Botswana (BW)":
                        sign = "BWP";
                        setkwhCost.setText("1.480");
                        break;
                    case "Brazil (BR)":
                        sign = "BRL";
                        setkwhCost.setText("0.759");
                        break;
                    case "Brunei (BN)":
                        sign = "BND";
                        setkwhCost.setText("0.12");
                        break;
                    case "Bulgaria (BG)":
                        sign = "BGN";
                        setkwhCost.setText("0.253");
                        break;
                    case "Burkina Faso (BF)":
                        sign = "XOF";
                        setkwhCost.setText("272.600");
                        break;
                    case "Burundi (BI)":
                        sign = "BIF";
                        setkwhCost.setText("264.66");
                        break;
                    case "Cabo Verde (CV)":
                        sign = "CVE";
                        setkwhCost.setText("24.360");
                        break;
                    case "Cambodia (KH)":
                        sign = "KHR";
                        setkwhCost.setText("462.29");
                        break;
                    case "Cameroon (CMR)":
                        sign = "XAF";
                        setkwhCost.setText("91.980");
                        break;
                    case "Canada (CA)":
                        sign = "CAD";
                        setkwhCost.setText("7.1");
                        break;
                    case "Central African Republic (CAR)":
                        sign = "XAF";
                        setkwhCost.setText("558");
                        break;
                    case "Chile (CL)":
                        sign = "CLP";
                        setkwhCost.setText("104.270");
                        break;
                    case "China (CN)":
                        sign = "CNY";
                        setkwhCost.setText("0.633");
                        break;
                    case "Colombia (CO)":
                        sign = "COP";
                        setkwhCost.setText("558.740");
                        break;
                    case "Congo (CD)":
                        sign = "XAF";
                        setkwhCost.setText("194.400");
                        break;
                    case "Costa Rica (CR)":
                        sign = "CRC";
                        setkwhCost.setText("103.919");
                        break;
                    case "Croatia (HR)":
                        sign = "HRK";
                        setkwhCost.setText("0.858");
                        break;
                    case "Cuba (CU)":
                        sign = "CUC";
                        setkwhCost.setText("0.750");
                        break;
                    case "Cyprus (CY)":
                        sign = "EUR";
                        setkwhCost.setText("0.246");
                        break;
                    case "Czech Republic (CZ)":
                        sign = "CZK";
                        setkwhCost.setText("2.280");
                        break;
                    case "Denmark (DK)":
                        sign = "DKK";
                        setkwhCost.setText("1.655");
                        break;
                    case "Djibouti (DJ)":
                        sign = "DJF";
                        setkwhCost.setText("55.22");
                        break;
                    case "Dominican Republic (DO)":
                        sign = "DOP";
                        setkwhCost.setText("8.200");
                        break;
                    case "Ecuador (EC)":
                        sign = "USD";
                        setkwhCost.setText("0.085");
                        break;
                    case "Egypt (EG)":
                        sign = "EGP";
                        setkwhCost.setText("1.150");
                        break;
                    case "El Salvador (SV)":
                        sign = "USD";
                        setkwhCost.setText("0.191");
                        break;
                    case "Estonia (EE)":
                        sign = "EUR";
                        setkwhCost.setText("0.088");
                        break;
                    case "Ethiopia (ET)":
                        sign = "ETB";
                        setkwhCost.setText("1.019");
                        break;
                    case "Fiji (FJ)":
                        sign = "FJD";
                        setkwhCost.setText("0.36");
                        break;
                    case "Finland (FI)":
                        sign = "EUR";
                        setkwhCost.setText("0.114");
                        break;
                    case "France (FR)":
                        sign = "EUR";
                        setkwhCost.setText("0.125");
                        break;
                    case "Gabon (GA)":
                        sign = "XAF";
                        setkwhCost.setText("122.960");
                        break;
                    case "Gambia (GM)":
                        sign = "GMD";
                        setkwhCost.setText("10.90");
                        break;
                    case "Georgia (GA)":
                        sign = "GEL";
                        setkwhCost.setText("0.303");
                        break;
                    case "Germany (DE)":
                        sign = "EUR";
                        setkwhCost.setText("0.247");
                        break;
                    case "Ghana (GH)":
                        sign = "GHS";
                        setkwhCost.setText("0.796");
                        break;
                    case "Great Britain [UK]":
                        sign = "GBP";
                        setkwhCost.setText("0.218");
                        break;
                    case "Greece (GR)":
                        sign = "EUR";
                        setkwhCost.setText("0.117");
                        break;
                    case "Guatemala (GT)":
                        sign = "GTQ";
                        setkwhCost.setText("1.206");
                        break;
                    case "Guyana (GY)":
                        sign = "GYD";
                        setkwhCost.setText("66.86");
                        break;
                    case "Haiti (HT)":
                        sign = "HTG";
                        setkwhCost.setText("39.57");
                        break;
                    case "Honduras (HN)":
                        sign = "HNL";
                        setkwhCost.setText("4.811");
                        break;
                    case "Hong Kong (HK)":
                        sign = "HKD";
                        setkwhCost.setText("1.164");
                        break;
                    case "Hungary (HU)":
                        sign = "HUF";
                        setkwhCost.setText("46.340");
                        break;
                    case "Iceland (IS)":
                        sign = "ISK";
                        setkwhCost.setText("7.100");
                        break;
                    case "Indonesia (ID)":
                        sign = "IDR";
                        setkwhCost.setText("1114.740");
                        break;
                    case "Iran (IR)":
                        sign = "IRR";
                        setkwhCost.setText("1402.0");
                        break;
                    case "Iraq (IQ)":
                        sign = "IQD";
                        setkwhCost.setText("60.000");
                        break;
                    case "Ireland (IE)":
                        sign = "EUR";
                        setkwhCost.setText("0.242");
                        break;
                    case "Israel (IL)":
                        sign = "ILS";
                        setkwhCost.setText("0.549");
                        break;
                    case "Italy (IT)":
                        sign = "EUR";
                        setkwhCost.setText("0.187");
                        break;
                    case "Ivory Coast (CI)":
                        sign = "XOF";
                        setkwhCost.setText("123.260");
                        break;
                    case "Jamaica (JM)":
                        sign = "JMD";
                        setkwhCost.setText("36.890");
                        break;
                    case "Japan (JP)":
                        sign = "JPY";
                        setkwhCost.setText("23.130");
                        break;
                    case "Jordan (JO)":
                        sign = "JOD";
                        setkwhCost.setText("0.087");
                        break;
                    case "Kazakhstan (KZ)":
                        sign = "KZT";
                        setkwhCost.setText("24.750");
                        break;
                    case "Kenya (KE)":
                        sign = "KES";
                        setkwhCost.setText("20.280");
                        break;
                    case "Kiribati (KI)":
                        sign = "AUD";
                        setkwhCost.setText("0.60");
                        break;
                    case "Kuwait (KW)":
                        sign = "KWD";
                        setkwhCost.setText("0.015");
                        break;
                    case "Kyrgyzstan (KG)":
                        sign = "KGS";
                        setkwhCost.setText("2.510");
                        break;
                    case "Laos":
                        sign = "LAK";
                        setkwhCost.setText("593.380");
                        break;
                    case "Latvia (LV)":
                        sign = "EUR";
                        setkwhCost.setText("0.153");
                        break;
                    case "Lebanon (LB)":
                        sign = "LBP";
                        setkwhCost.setText("144.830");
                        break;
                    case "Lesotho (LS)":
                        sign = "LSL";
                        setkwhCost.setText("0.326");
                        break;
                    case "Liberia (LR)":
                        sign = "LRD";
                        setkwhCost.setText("82.35");
                        break;
                    case "Libya (LY)":
                        sign = "LYD";
                        setkwhCost.setText("0.031");
                        break;
                    case "Liechtenstein (LI)":
                        sign = "CHF";
                        setkwhCost.setText("0.169");
                        break;
                    case "Lithuania (LT)":
                        sign = "EUR";
                        setkwhCost.setText("0.176");
                        break;
                    case "Luxembourg (LU)":
                        sign = "EUR";
                        setkwhCost.setText("0.117");
                        break;
                    case "Madagascar (MG)":
                        sign = "MGA";
                        setkwhCost.setText("443.900");
                        break;
                    case "Malawi (MW)":
                        sign = "MWK";
                        setkwhCost.setText("155.850");
                        break;
                    case "Malaysia (MY)":
                        sign = "MYR";
                        setkwhCost.setText("0.388");
                        break;
                    case "Maldives (MV)":
                        sign = "MVR";
                        setkwhCost.setText("3.55");
                        break;
                    case "Mali (ML)":
                        sign = "XOF";
                        setkwhCost.setText("94.930");
                        break;
                    case "Malta (MT)":
                        sign = "EUR";
                        setkwhCost.setText("0.149");
                        break;
                    case "Marshall Islands (MI)":
                        sign = "USD";
                        setkwhCost.setText("0.406");
                        break;
                    case "Mauritius (MU)":
                        sign = "MUR";
                        setkwhCost.setText("5.400");
                        break;
                    case "Mexico (MX)":
                        sign = "MXN";
                        setkwhCost.setText("3.327");
                        break;
                    case "Micronesia (FM)":
                        sign = "USD";
                        setkwhCost.setText("0.48");
                        break;
                    case "Moldova (MD)":
                        sign = "MDL";
                        setkwhCost.setText("1.250");
                        break;
                    case "Monaco (MC)":
                        sign = "EUR";
                        setkwhCost.setText("0.15");
                        break;
                    case "Mongolia (MN)":
                        sign = "MNT";
                        setkwhCost.setText("188.16");
                        break;
                    case "Montenegro (ME)":
                        sign = "EUR";
                        setkwhCost.setText("0.097");
                        break;
                    case "Morocco (MA)":
                        sign = "MAD";
                        setkwhCost.setText("1.072");
                        break;
                    case "Mozambique (MZ)":
                        sign = "MZN";
                        setkwhCost.setText("4.348");
                        break;
                    case "Myanmar (MM)":
                        sign = "MMK";
                        setkwhCost.setText("60.500");
                        break;
                    case "Namibia (NA)":
                        sign = "NAD";
                        setkwhCost.setText("1.952");
                        break;
                    case "Nauru (NR)":
                        sign = "AUD";
                        setkwhCost.setText("0.20");
                        break;
                    case "Nepal (NP)":
                        sign = "NPR";
                        setkwhCost.setText("9.010");
                        break;
                    case "Netherlands (NL)":
                        sign = "EUR";
                        setkwhCost.setText("0.124");
                        break;
                    case "New Zealand (NZ)":
                        sign = "NZD";
                        setkwhCost.setText("0.304");
                        break;
                    case "Nicaragua (NI)":
                        sign = "NIO";
                        setkwhCost.setText("6.510");
                        break;
                    case "Niger (NE)":
                        sign = "XOF";
                        setkwhCost.setText("104.19");
                        break;
                    case "Nigeria (NG)":
                        sign = "NGN";
                        setkwhCost.setText("38.530");
                        break;
                    case "Norway (NO)":
                        sign = "NOK";
                        setkwhCost.setText("0.968");
                        break;
                    case "Oman (OM)":
                        sign = "OMR";
                        setkwhCost.setText("0.063");
                        break;
                    case "Pakistan (PK)":
                        sign = "PKR";
                        setkwhCost.setText("27.020");
                        break;
                    case "Palau (PW)":
                        sign = "USD";
                        setkwhCost.setText("0.28");
                        break;
                    case "Palestine State (PS)":
                        sign = "PSP";
                        setkwhCost.setText("0.085");
                        break;
                    case "Panama (PA)":
                        sign = "USD";
                        setkwhCost.setText("0.169");
                        break;
                    case "Papua New Guinea (PG)":
                        sign = "PGK";
                        setkwhCost.setText("1029");
                        break;
                    case "Paraguay (PY)":
                        sign = "PYG";
                        setkwhCost.setText("334.798");
                        break;
                    case "Peru (PE)":
                        sign = "PEN";
                        setkwhCost.setText("0.550");
                        break;
                    case "Philippines (PH)":
                        sign = "PHP";
                        setkwhCost.setText("6.235");
                        break;
                    case "Poland (PL)":
                        sign = "PLN";
                        setkwhCost.setText("0.636");
                        break;
                    case "Puerto Rico (PR)":
                        sign = "USD";
                        setkwhCost.setText("0.30");
                        break;
                    case "Portugal (PT)":
                        sign = "EUR";
                        setkwhCost.setText("0.172");
                        break;
                    case "Qatar (QA)":
                        sign = "QAR";
                        setkwhCost.setText("0.130");
                        break;
                    case "Republic of Korea (KR)":
                        sign = "LRW";
                        setkwhCost.setText("130.000");
                        break;
                    case "Romania (RO)":
                        sign = "RON";
                        setkwhCost.setText("0.762");
                        break;
                    case "Russian Federation (RU)":
                        sign = "RUB";
                        setkwhCost.setText("6.874");
                        break;
                    case "Rwanda (RW)":
                        sign = "RWF";
                        setkwhCost.setText("257.290");
                        break;
                    case "Saint Kitts and Nevis (KN)":
                        sign = "XCD";
                        setkwhCost.setText("0.89");
                        break;
                    case "Saint Lucia (LC)":
                        sign = "XCD";
                        setkwhCost.setText("0.90");
                        break;
                    case "Saint Vincent and the Grenadines (VC)":
                        sign = "XCD";
                        setkwhCost.setText("0.26");
                        break;
                    case "Samoa (SO)":
                        sign = "WST";
                        setkwhCost.setText("0.321");
                        break;
                    case "San Marino (SM)":
                        sign = "EUR";
                        setkwhCost.setText("0.16");
                        break;
                    case "Sao Tome and Principe":
                        sign = "STN";
                        setkwhCost.setText("7.5");
                        break;
                    case "Saudi Arabia (SA)":
                        sign = "SAR";
                        setkwhCost.setText("0.257");
                        break;
                    case "Senegal (SN)":
                        sign = "XOF";
                        setkwhCost.setText("103.245");
                        break;
                    case "Serbia (RS)":
                        sign = "RSD";
                        setkwhCost.setText("11.040");
                        break;
                    case "Seychelles (SC)":
                        sign = "SCR";
                        setkwhCost.setText("3.5");
                        break;
                    case "Sierra Leone (SL)":
                        sign = "SLL";
                        setkwhCost.setText("2151.000");
                        break;
                    case "Singapore (SG)":
                        sign = "SGD";
                        setkwhCost.setText("0.213");
                        break;
                    case "Slovakia (SK)":
                        sign = "EUR";
                        setkwhCost.setText("0.152");
                        break;
                    case "Slovenia (SI)":
                        sign = "EUR";
                        setkwhCost.setText("0.110");
                        break;
                    case "Somalia (SO)":
                        sign = "SOS";
                        setkwhCost.setText("350");
                        break;
                    case "South Africa (ZA)":
                        sign = "ZAR";
                        setkwhCost.setText("1.209");
                        break;
                    case "South Korea (KR)":
                        sign = "SKW";
                        setkwhCost.setText("89.568");
                        break;
                    case "Spain (ES)":
                        sign = "EUR";
                        setkwhCost.setText("0.106");
                        break;
                    case "Sri Lanka (LK)":
                        sign = "LKR";
                        setkwhCost.setText("12.930");
                        break;
                    case "Sudan (SD)":
                        sign = "SDG";
                        setkwhCost.setText("10.200");
                        break;
                    case "Suriname (SR)":
                        sign = "SRD";
                        setkwhCost.setText("0.350");
                        break;
                    case "Sweden (SE)":
                        sign = "SEK";
                        setkwhCost.setText("1.770");
                        break;
                    case "Switzerland (CH)":
                        sign = "CHF";
                        setkwhCost.setText("0.156");
                        break;
                    case "Syria (SY)":
                        sign = "SYP";
                        setkwhCost.setText("326");
                        break;
                    case "Taiwan (TW)":
                        sign = "TWD";
                        setkwhCost.setText("3.830");
                        break;
                    case "Tajikistan (TJ)":
                        sign = "TJS";
                        setkwhCost.setText("0.013");
                        break;
                    case "Tanzania (TZ)":
                        sign = "TZS";
                        setkwhCost.setText("236.370");
                        break;
                    case "Thailand (TH)":
                        sign = "THB";
                        setkwhCost.setText("3.711");
                        break;
                    case "Timor-Leste (TL)":
                        sign = "USD";
                        setkwhCost.setText("0.12");
                        break;
                    case "Togo (TG)":
                        sign = "XOF";
                        setkwhCost.setText("106.930");
                        break;
                    case "Tonga (TO)":
                        sign = "TOP";
                        setkwhCost.setText("0.76");
                        break;
                    case "Trinidad and Tobago (TT)":
                        sign = "TTD";
                        setkwhCost.setText("0.359");
                        break;
                    case "Tunisia (TN)":
                        sign = "TND";
                        setkwhCost.setText("0.305");
                        break;
                    case "Turkey (TR)":
                        sign = "TRY";
                        setkwhCost.setText("0.950");
                        break;
                    case "Turkmenistan (TK)":
                        sign = "TMT";
                        setkwhCost.setText("0.98");
                        break;
                    case "Tuvalu (TV)":
                        sign = "AUD";
                        setkwhCost.setText("0.05");
                        break;
                    case "Uganda (UG)":
                        sign = "UGX";
                        setkwhCost.setText("526.900");
                        break;
                    case "Ukraine (UA)":
                        sign = "UAH";
                        setkwhCost.setText("2.520");
                        break;
                    case "United Arab Emirates (AE)":
                        sign = "AED";
                        setkwhCost.setText("0.366");
                        break;
                    case "United Kingdom (UK)":
                        sign = "GBP";
                        setkwhCost.setText("0.218");
                        break;
                    case "Uruguay (UY)":
                        sign = "UYI";
                        setkwhCost.setText("4.300");
                        break;
                    case "Uzbekistan (UZ)":
                        sign = "UZS";
                        setkwhCost.setText("450.000");
                        break;
                    case "Vanuatu (VU)":
                        sign = "VUV";
                        setkwhCost.setText("59.71");
                        break;
                    case "Venezuela (VE)":
                        sign = "VEF";
                        setkwhCost.setText("1.093");
                        break;
                    case "Vietnam (VN)":
                        sign = "VND";
                        setkwhCost.setText("1772.100");
                        break;
                    case "Yemen (YE)":
                        sign = "YER";
                        setkwhCost.setText("650");
                        break;
                    case "Zambia (ZM)":
                        sign = "ZMW";
                        setkwhCost.setText("0.854");
                        break;
                    case "Zimbabwe (ZW)":
                        sign = "ZWL";
                        setkwhCost.setText("4.282");
                        break;
                    default:
                        sign = "$";
                        setkwhCost.setText("0.060");
                }
            }
        }
    }


    public static void hideSoftKeyboard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    public void back(View view) {
        Intent back=new Intent(applForAll.this,eCostForAll.class);
        startActivity(back);
        finish();
    }
}
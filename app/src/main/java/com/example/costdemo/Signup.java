package com.example.costdemo;

import androidx.appcompat.app.AppCompatActivity;

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

public class Signup extends AppCompatActivity {
    private String selectedNation,getName,selectedState,profileName,prNation,prState,prOccu;
    private String selectedOcc;
    private EditText editName;
    private Spinner selectNation,selectOcc;
    private Spinner selectState,profileNation;
    private ArrayAdapter nationAdapter,stateAdapter,occAdapter;
    private TextView showerror,statetv,occtv;
    private boolean check;
//    private static int check=0; //We can initialize check here because it will always change check is equal to zero
    public static String PREFS_NAME="MyPrefsFile";

    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        SharedPreferences shp=getSharedPreferences(Signup.PREFS_NAME,MODE_PRIVATE);
        check=shp.getBoolean("hasSignedUp",false);
        editName=(EditText) findViewById(R.id.etuserName);
        selectNation=findViewById(R.id.nationSpinnerSignUp);
        statetv=findViewById(R.id.selYState);
        occtv=findViewById(R.id.selYState2);
//        occtv.setVisibility(View.INVISIBLE);
//        selectOcc.setVisibility(View.INVISIBLE);
//        callingA=getCallingActivity().getClassName().toString();
        if(check) {
        Intent takeProfile=getIntent();
        profileName=takeProfile.getStringExtra("userName");
        prNation=takeProfile.getStringExtra("nationName");
            editName.setHint(null);
            editName.setText(profileName);
            if(prNation.equals("India (IN)")){
                prState=takeProfile.getStringExtra("stateName");
        }
            else{
                prOccu=takeProfile.getStringExtra("occupation");
            }
        }
        occtv=findViewById(R.id.selYState2);
        selectOcc=findViewById(R.id.stateSpinner2);
        occtv.setVisibility(View.INVISIBLE);
        selectOcc.setVisibility(View.INVISIBLE);
        occAdapter=ArrayAdapter.createFromResource(this,R.array.array_sel_conn,R.layout.spinnerresrource);
        occAdapter.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
        selectOcc.setAdapter(occAdapter);
        selectState=findViewById(R.id.stateSpinner);
        nationAdapter=ArrayAdapter.createFromResource(this,R.array.array_nations_name,R.layout.spinnerresrource);
        nationAdapter.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
        selectNation.setAdapter(nationAdapter);
        stateAdapter=ArrayAdapter.createFromResource(this,R.array.array_indian_states,R.layout.spinnerresrource);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
        selectState.setAdapter(stateAdapter);
        selectNation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedNation=selectNation.getSelectedItem().toString();
                hideSoftKeyboard(Signup.this,view);
                if(selectedNation.equals("India (IN)")){
                    selectState.setVisibility(View.VISIBLE);
                    statetv.setVisibility(View.VISIBLE);
                    occtv.setVisibility(View.INVISIBLE);
                    selectOcc.setVisibility(View.INVISIBLE);
                    selectState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectedState=selectState.getSelectedItem().toString();

                            //Switch case in case of if we select the nation then the options of districts
//                int parentID=parent.getId();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            Toast.makeText(getApplicationContext(),"Please select your State",Toast.LENGTH_LONG).show();
                        }});
                }
                else {
                    if (!selectedNation.equals("Select Your Country")) {
                        selectState.setVisibility(View.INVISIBLE);
                        statetv.setVisibility(View.INVISIBLE);
                        occtv.setVisibility(View.VISIBLE);
                        selectOcc.setVisibility(View.VISIBLE);
                        selectOcc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                selectedOcc = selectOcc.getSelectedItem().toString();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) { Toast.makeText(getApplicationContext(),"Please select your connection type",Toast.LENGTH_LONG).show();
                            }
                        });

                    }

                    //Switch case in case of if we select the nation then the options of districts
//                int parentID=parent.getId();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Please select your state",Toast.LENGTH_LONG).show();
            }
        });
        if (check) {
            int spinnerPosition = nationAdapter.getPosition(prNation);
            selectNation.setSelection(spinnerPosition);
            if(prNation.equals("India (IN)")){
                int spinnerpos=stateAdapter.getPosition(prState);
                selectState.setSelection(spinnerpos);
            }
            else{
                int spocc=occAdapter.getPosition(prOccu);
                selectOcc.setSelection(spocc);
                }
        }

//        showerror=(TextView)findViewById(R.id.showerror);
        signup=findViewById(R.id.btn_signup);
//        String compareName="Select Your Nation";


        signup.setOnClickListener(v -> {

            String stateName = selectState.getSelectedItem().toString();
            String ocp=selectOcc.getSelectedItem().toString();
            getName=editName.getText().toString();
            String nationName=selectNation.getSelectedItem().toString();
            if (nationName.equals("Select Your Country")||(getName.equals(""))) {
                if(nationName.equals("Select Your Country")&&(!getName.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Please select your country",Toast.LENGTH_LONG).show();
                    selectNation.requestFocus();
                    showerror.setError("Select your country");
                    editName.setError(null);
//                    selectState.setVisibility(View.INVISIBLE);
                }
                else{
                    if(getName.equals("")&&(!nationName.equals("Select Your Country"))) {
                        editName.setError("Please enter your  name");
                        editName.requestFocus();
                        showerror.setError(null);
                    }
                    else{
                        editName.setError("Please enter your name");
                        editName.requestFocus();
                        showerror.setError("Please select your country");
                        showerror.requestFocus();
                        selectNation.requestFocus();
                    }
                }
            }
            else {

                Intent inCase;
                SharedPreferences sharedPreferences = getSharedPreferences(Signup.PREFS_NAME, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user", getName);
                editor.putString("nation", nationName);
                if(nationName.equals("India (IN)")) {
                    editor.putString("selectedState", stateName);
                }
                else{
                    editor.putString("selectedOccupation",ocp);
                    }
                if(check) {
                   inCase = new Intent(Signup.this, Profile.class);
                }
                else {
                    inCase = new Intent(Signup.this, Home.class);
                }
                    editor.putBoolean("hasSignedUp",true);
                    editor.commit();
                    startActivity(inCase);
                    finish();
                }
            });

    }
    public static void hideSoftKeyboard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

}

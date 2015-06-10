package com.icare.nayeem.n_icare;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.icare.nayeem.n_icare.DBHandler.DBHandler;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    EditText etName,etPhone, etEmail, etDob,etPhoto,etAddress, etBloodGroup,etMajor,etPresentHealth,etSugarLabel, etBloodPressure,
            etStatus;

    String name, phone ,email, DOB , address,photo, bloodGroup,major, presentHealth, sugarLabel,bloodPressure,
            status;

    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {

        dbHandler= new DBHandler(this);

        etName=(EditText)findViewById(R.id.etName);
        etPhone=(EditText)findViewById(R.id.etPhone);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etDob=(EditText)findViewById(R.id.etDob);
        etPhoto=(EditText)findViewById(R.id.etPhoto);
        etAddress=(EditText)findViewById(R.id.etAddress);
        etBloodGroup=(EditText)findViewById(R.id.etBloodGroup);
        etMajor=(EditText)findViewById(R.id.etMajor);
        etPresentHealth=(EditText)findViewById(R.id.etPresentHealth);
        etSugarLabel=(EditText)findViewById(R.id.etSugarLabel);
        etBloodPressure=(EditText)findViewById(R.id.etBloodPressure);
        etStatus=(EditText)findViewById(R.id.etStatus);



        name=etName.getText().toString();
        phone=etPhone.getText().toString();
        email=etEmail.getText().toString();
        photo=etPhoto.getText().toString();
        DOB=etDob.getText().toString();
        address=etAddress.getText().toString();
        bloodGroup=etBloodGroup.getText().toString();
        major=etMajor.getText().toString();
        presentHealth=etPresentHealth.getText().toString();
        sugarLabel=etSugarLabel.getText().toString();
        bloodPressure=etBloodPressure.getText().toString();
        status=etStatus.getText().toString();

    }

    public void btnSave(View view){

        iCarePersonalProfile carePersonalProfile= new iCarePersonalProfile();
        carePersonalProfile.setName(name);
        carePersonalProfile.setPhone(phone);
        carePersonalProfile.setEmail(email);
        carePersonalProfile.setPhoto(photo);
        carePersonalProfile.setDob(DOB);
        carePersonalProfile.setAddress(address);
        carePersonalProfile.setBloodGroup(bloodGroup);
        carePersonalProfile.setMajor(major);
        carePersonalProfile.setPresentHealth(presentHealth);
        carePersonalProfile.setBloodPressure(bloodPressure);

        carePersonalProfile.setSugarLabel(sugarLabel);
        carePersonalProfile.setStatus(status);



        dbHandler.addiCarePersonalProfile(carePersonalProfile);
    }
    public void btnShow(View view){
        List<iCarePersonalProfile> carePersonalProfiles= dbHandler.getAllPersonalProfile();
        Toast.makeText(getApplicationContext(), String.valueOf(carePersonalProfiles), Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

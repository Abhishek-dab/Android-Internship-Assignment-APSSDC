package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    EditText et_roll,et_name,et_mobile, et_email,et_password;
    RadioButton r_male,r_female;
    String gender;

    Spinner sp_branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_roll = findViewById(R.id.roll);
        et_name= findViewById(R.id.name);
        et_mobile=findViewById(R.id.mobile);
        et_email = findViewById(R.id.email);
        et_password = findViewById(R.id.password);
        r_male = findViewById(R.id.male);
        r_female = findViewById(R.id.female);
        sp_branch = findViewById(R.id.branch);



        ArrayAdapter<CharSequence> branch_adapter = ArrayAdapter.createFromResource(this,R.array.branch,android.R.layout.simple_spinner_item);
        branch_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_branch.setAdapter(branch_adapter);

        sp_branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sp_branch.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void submit(View view) {

        String roll = et_roll.getText().toString();
        String name = et_name.getText().toString();
        String mobile = et_mobile.getText().toString();
        String mail = et_email.getText().toString();
        String password = et_password.getText().toString();
        String selectedBranch = sp_branch.getSelectedItem().toString();

        if(r_male.isChecked()){
            gender =r_male.getText().toString();
        }
        if(r_female.isChecked()){
            gender = r_female.getText().toString();
        }

        if(roll.isEmpty()){
            Toast.makeText(this, "Please Enter Roll No", Toast.LENGTH_SHORT).show();
        }else if(name.isEmpty()) {
            Toast.makeText(this, "Please Enter Name", Toast.LENGTH_SHORT).show();
        }else if (mobile.length()<10) {
            Toast.makeText(this, "Please Enter Phone Number of 10 Digits", Toast.LENGTH_SHORT).show();
        }else if(mail.isEmpty()){
            Toast.makeText(this, "Please Enter Mail ID", Toast.LENGTH_SHORT).show();
        }else if(password.length()<8) {
            Toast.makeText(this, "Password should be minimum of 8 characters", Toast.LENGTH_SHORT).show();
        }else if(gender==null) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("mydata1", roll);
            i.putExtra("mydata2", name);
            i.putExtra("mydata3", mobile);
            i.putExtra("mydata4", mail);
            i.putExtra("mydata5", password);
            i.putExtra("mydata6", gender);
            i.putExtra("mydata7", selectedBranch);
            startActivity(i);
        }
    }
}


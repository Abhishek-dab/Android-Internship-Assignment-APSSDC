package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    EditText etj;
    EditText etk;
    EditText etl;
    EditText etm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        etj = findViewById(R.id.usernamei);
        etk = findViewById(R.id.passwordi);
        etl = findViewById(R.id.mailid);
        etm = findViewById(R.id.numberi);
    }

    public void done(View view) {
        String dataj = etj.getText().toString();
        String datak = etk.getText().toString();
        String datal = etl.getText().toString();
        String datam = etm.getText().toString();
        if(dataj.isEmpty()) {
            Toast.makeText(this, "Please Enter Username", Toast.LENGTH_SHORT).show();
        }else if(datak.isEmpty()){
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
        }else if(datal.isEmpty()){
            Toast.makeText(this, "Please Enter Mail ID", Toast.LENGTH_SHORT).show();
        }else if(datam.isEmpty()){
            Toast.makeText(this, "Please Enter Phone Number", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(ThirdActivity.this, SecondActivity.class);
            i.putExtra("mydata", dataj);
            startActivity(i);
        }
    }
}
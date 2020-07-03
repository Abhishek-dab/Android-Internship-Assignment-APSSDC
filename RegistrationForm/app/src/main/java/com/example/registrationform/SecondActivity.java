package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String roll= getIntent().getStringExtra("mydata1");
        String name= getIntent().getStringExtra("mydata2");
        String mobile= getIntent().getStringExtra("mydata3");
        String mail= getIntent().getStringExtra("mydata4");
        String pass= getIntent().getStringExtra("mydata5");
        String gender= getIntent().getStringExtra("mydata6");
        String branch= getIntent().getStringExtra("mydata7");

        TextView tv = findViewById(R.id.welcome);
        TextView tv1 = findViewById(R.id.bye);
        TextView tv2 = findViewById(R.id.one);
        TextView tv3 = findViewById(R.id.two);
        TextView tv4 = findViewById(R.id.three);
        TextView tv5 = findViewById(R.id.four);
        TextView tv6 = findViewById(R.id.five);


        tv.setText("Roll No: "+roll);
        tv1.setText("Name: "+name);
        tv2.setText("Phone: "+mobile);
        tv3.setText("Email ID: "+mail);
        tv4.setText("Password: "+pass);
        tv5.setText("Gender: "+gender);
        tv6.setText("Branch: "+branch);
    }
}
package com.example.countingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    TextView tv;
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= findViewById(R.id.countInc);
        tv = findViewById(R.id.textcount);
        b2= findViewById(R.id.countDec);
        b3=findViewById(R.id.reset);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //action
                a=0;
                tv.setText(""+a);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //action
                a--;
                tv.setText(""+a);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //action
                a++;
                tv.setText(""+a);
            }
        });



        if(savedInstanceState!=null){
            String s = savedInstanceState.getString("abhishek");
            a = Integer.parseInt(s);
            tv.setText(""+a);

        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("abhishek", tv.getText().toString());
    }

    public void display(View view) {
        //action
        Toast.makeText(this, "Your Count is: "+a, Toast.LENGTH_SHORT).show();
    }
}
package com.example.shareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.username);
    }

    public void submit(View view) {
        String data = et.getText().toString();

        if(data.isEmpty()){
            Toast.makeText(this, "Please Something", Toast.LENGTH_SHORT).show();
        }else{

            Intent i = new Intent();
            i.setAction(Intent.ACTION_SEND);
            i.putExtra(Intent.EXTRA_TEXT,data);
            i.setType("text/plain");
            startActivity(i);
        }
    }
}
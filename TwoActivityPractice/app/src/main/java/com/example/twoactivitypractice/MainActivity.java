package com.example.twoactivitypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.username);
        String si= getIntent().getStringExtra("mydatai");
        TextView tvi = findViewById(R.id.text_message_reply);
        textView = findViewById(R.id.text_header_reply);
        tvi.setText(si);
        tvi.setVisibility(View.VISIBLE);
        if(si!=null){
            textView.setVisibility(View.VISIBLE);
        }


    }

    public void login(View view) {
        String data = et.getText().toString();
        if(data.isEmpty()){
            Toast.makeText(this, "Please Enter A Message", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("mydata", data);
            startActivity(i);
        }
    }
}
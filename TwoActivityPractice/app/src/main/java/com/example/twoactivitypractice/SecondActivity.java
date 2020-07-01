package com.example.twoactivitypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
EditText eti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        eti = findViewById(R.id.edit_Text_second);
        String s= getIntent().getStringExtra("mydata");
        TextView tv = findViewById(R.id.text_message);
        tv.setText(s);

    }

    public void returnReply(View view) {
        String datai = eti.getText().toString();
        if(datai.isEmpty()){
            Toast.makeText(this, "Please Enter A Reply", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Reply Sent", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            intent.putExtra("mydatai", datai);
            startActivity(intent);

        }
    }
}
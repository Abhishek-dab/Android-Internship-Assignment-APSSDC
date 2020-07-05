package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case  R.id.share:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case  R.id.dial:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.Gallery:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;


        }

        return super.onOptionsItemSelected(item);
    }

    public void sending(MenuItem item) {

        Intent i = new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_TEXT, "Hello There");
        i.setType("text/plain");
        startActivity(i);
    }

    public void calling(MenuItem item) {

        Uri uri = Uri.parse("tel:1234567890");
        Intent i = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);
    }

    public void galleryopen(MenuItem item) {


        Intent i =new Intent(Intent.ACTION_PICK);
        i.setType("image/+");
        startActivity(i);
    }
}
package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView listV;
List<String> list = new ArrayList<String>();
ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listV = (ListView) findViewById(R.id.list);


        list.add("Store One");
        list.add("Store Two");
        list.add("XYZ Shop");
        list.add("ABC Store");
        list.add("Store A");
        list.add("Store B");

         adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list);
         listV.setAdapter(adapter);
         registerForContextMenu(listV);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.coupons:
                Toast.makeText(this, "Coupons clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cashback:
                Toast.makeText(this, "Cashback clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.deals:
                Toast.makeText(this, "Deals clicked", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onContextItemSelected(item);
    }
}
package com.example.ticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Spinner dineoptions;
ListView listView;
List<String> list = new ArrayList<>();
ImageButton additem;
ArrayAdapter listadapter;

String[] options = {"Dine In","Take Out", "Food Delivery"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        additem = findViewById(R.id.additem1);
        listView = findViewById(R.id.listitem);
        listadapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(listadapter);

        additem.setOnClickListener(new View.OnClickListener() {//pareh parang kada onclick listener need ng adapter saka set adapter
            @Override
            public void onClick(View v) {
                list.add("tanginamo");
                listadapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
                listView.setAdapter(listadapter);
            }
        });

        dineoptions = findViewById(R.id.spnDineOptions);
        ArrayAdapter<String> adapterdine = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, options);
        adapterdine.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dineoptions.setAdapter(adapterdine);
             dineoptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                 @Override
                 public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                         String value=parent.getItemAtPosition(position).toString();
                         Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                     }


                 @Override
                 public void onNothingSelected(AdapterView<?> parent) {

                 }
             });
    }
}
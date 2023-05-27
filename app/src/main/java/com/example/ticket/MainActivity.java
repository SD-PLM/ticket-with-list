package com.example.ticket;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Spinner dineoptions;
LinearLayout layoutscroll;
AlertDialog dialog;

String[] options = {"Dine In","Take Out", "Food Delivery"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button additem = findViewById(R.id.btnadd);
        layoutscroll= findViewById(R.id.container);
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

             buildDialog();
             additem.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     dialog.show();
                 }
             });


    }


    private void buildDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog, null);
        EditText NameEdit = (EditText) view.findViewById(R.id.nameEdit);
        builder.setView(view);
        builder.setTitle("Enter item")
        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                addCard(NameEdit.getText().toString());
            }
        }) .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
                    }
                });
        dialog = builder.create();
        }

    public void addCard(String NameEdit) {
        View view = getLayoutInflater().inflate(R.layout.card, null);
        TextView nameView = view.findViewById(R.id.itemname);
        View view1 = getLayoutInflater().inflate(R.layout.card,null);
        ImageButton deleteitem = (ImageButton) view.findViewById(R.id.deleteitem);

        nameView.setText((String) NameEdit);
        view1.invalidate();

        deleteitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutscroll.removeView(view);
                Toast.makeText(MainActivity.this, "gumagana naman lods", Toast.LENGTH_SHORT).show();
            }
        });
        layoutscroll.addView(view);
    }

}
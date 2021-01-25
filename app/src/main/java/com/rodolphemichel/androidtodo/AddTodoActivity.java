package com.rodolphemichel.androidtodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddTodoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public String urgency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        Spinner spinner = findViewById(R.id.spinner);



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        urgency = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
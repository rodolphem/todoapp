package com.rodolphemichel.androidtodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddTodoActivity extends AppCompatActivity{

    private Button addBouton;
    private Button cancelBouton;
    private EditText toDo;
    public static final String KEY_TODO = "todo";
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        //ajout des vues aux variables
        toDo = findViewById(R.id.ChampTodoNom);
        Spinner spinner = findViewById(R.id.spinner);
        addBouton = findViewById(R.id.AddBtn);
        cancelBouton = findViewById(R.id.CancelBtn);


        List<String> itemSpinner = new ArrayList<String>();

        //affichage des urgences
        itemSpinner.add("Low Urgency / Peu urgent");
        itemSpinner.add("Medium Urgency /  Moyenement urgent");
        itemSpinner.add("High Urgency / Très urgent");

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, itemSpinner);

        spinnerArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

        //listener du bouton add
        addBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //recupère le todo et le urgency et les place dans un String
                String sTodo = toDo.getText().toString();
                String urgency = spinner.getSelectedItem().toString();

                Context context = getApplicationContext();

                //vérifie si au moins trois caractères sont présent
                if (sTodo.length() > 3) {
                    Intent resultIntent = getIntent();

                    Todo todo = new Todo(1, sTodo, urgency);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable(KEY_TODO, todo);
                    resultIntent.putExtras(bundle);
                    resultIntent.putExtra("requestCode", REQUEST_CODE);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "Veuillez saisir au moins 3 caractères", duration);
                    toast.show();
                }
            }
        });

        //listener du bouton cancel
        cancelBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("requestCode", REQUEST_CODE);
                setResult(RESULT_CANCELED, resultIntent);
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
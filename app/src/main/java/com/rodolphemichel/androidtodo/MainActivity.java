package com.rodolphemichel.androidtodo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView textTodo;
    public static final String KEY_TODO = "todo";
    private String affichTodo = "Votre Liste :";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTodo = findViewById(R.id.textView);

        if (savedInstanceState != null){
            affichTodo = savedInstanceState.getString(KEY_TODO);
        }

        if (textTodo == null){
            textTodo.setText(affichTodo);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.addToDo) {
            Intent intent = new Intent(MainActivity.this, AddTodoActivity.class);
            startActivityForResult(intent, 1);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_todo, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == 1) && (resultCode == RESULT_OK)) {
            Bundle bundle = data.getExtras();
            Todo task = (Todo) bundle.getSerializable(AddTodoActivity.KEY_TODO);

            //création de l'affichage
                affichTodo += " \n " + task.getToDo() + " // " + task.getUrgency();

                textTodo.setText(affichTodo);
        }
    }
}


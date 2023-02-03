package com.tejas.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class NewTasksPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tasks);

        EditText editText = findViewById(R.id.edtNewTask);
        AppCompatButton button = findViewById(R.id.btnSave);



        button.setOnClickListener(view -> {
            String inputTasks = editText.getText().toString();

            DatabaseHelper db = new DatabaseHelper(this);


            db.InsertTasks(inputTasks);

            Toast.makeText(this, "New Task Is Added..! ", Toast.LENGTH_SHORT).show();


            db.notifyAll();
            finish();


        });


    }


}
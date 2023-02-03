package com.tejas.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton button = findViewById(R.id.btnFloating);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DatabaseHelper db = new DatabaseHelper(this);           // Opening Of Database.

        List<Model> inputList = db.FetchTasks();

        RecyclerAdapter adapter = new RecyclerAdapter(this,inputList);


        recyclerView.setAdapter(adapter);

        Collections.reverse(inputList);             // Recently added tasks shown top of the list.





        button.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this, NewTasksPage.class);
            startActivity(intent);
        });




    }





}
package com.tejas.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.sql.DatabaseMetaData;

public class EditTasksPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tasks_page);

        EditText editText = findViewById(R.id.edtNewTask);
        AppCompatButton button = findViewById(R.id.btnSave);

        String task = getIntent().getStringExtra("text");

        editText.setText(task);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = getIntent().getIntExtra("id",0);
                String changeTask = editText.getText().toString();

                DatabaseHelper db = new DatabaseHelper(EditTasksPage.this);

                Model model = new Model();
                model.setTasks(changeTask);
                model.setId(id);

                db.UpdateTask(model.getId(),model.getTasks());

                db.notifyAll();

                finish();




            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delete_menus,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.icDelete){

            BottomSheetDialog sheetDialog = new BottomSheetDialog(this);

            View view = LayoutInflater.from(this).inflate(R.layout.delete_layout,
                    (LinearLayout)findViewById(R.id.delete_shit_structure));

            sheetDialog.setContentView(view);


            TextView yes = view.findViewById(R.id.delete_yes);
            TextView no = view.findViewById(R.id.delete_no);


            yes.setOnClickListener(view1 -> {

                    int wantId = getIntent().getIntExtra("id",0);

                    DatabaseHelper db = new DatabaseHelper(EditTasksPage.this);
                    Model model = new Model();
                    model.setId(wantId);

                    db.DeleteTask(model.getId());

                    db.notifyAll();
                    finish();

            });

            no.setOnClickListener(v -> {

                sheetDialog.dismiss();


            });

            sheetDialog.show();

        }




        return true;
    }
}
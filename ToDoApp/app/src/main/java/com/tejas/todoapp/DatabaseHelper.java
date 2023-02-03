package com.tejas.todoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ToDoTasks";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "Tasks";
    private static final String ID = "id";
    private static final String TASKS = "Task";


    public DatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table "+TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ TASKS +" TEXT "+")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }


    public void InsertTasks(String tasks){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TASKS,tasks);

        database.insert(TABLE_NAME,null,values);

        database.close();


    }


    public List<Model> FetchTasks(){

        SQLiteDatabase database = this.getReadableDatabase();

       Cursor cursor = database.rawQuery("select * from "+ TABLE_NAME,null);

       List<Model> list = new ArrayList<>();

       while (cursor.moveToNext()){

           Model item = new Model();
           item.setId(cursor.getInt(0));
           item.setTasks(cursor.getString(1));

           list.add(item);


       }

       return list;


    }

    public void UpdateTask(int id, String task){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TASKS,task);

        database.update(TABLE_NAME,values,ID + "=?",new String[]{String.valueOf(id)});



    }


    public void DeleteTask(int id){
        SQLiteDatabase database = this.getWritableDatabase();

        database.delete(TABLE_NAME,ID + "=?",new String[] {String.valueOf(id)});


    }





}

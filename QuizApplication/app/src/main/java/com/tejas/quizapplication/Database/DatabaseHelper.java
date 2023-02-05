package com.tejas.quizapplication.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Questions.class,exportSchema = false,version = 1)
public abstract class DatabaseHelper extends RoomDatabase {

    public static DatabaseHelper instance;


    public static synchronized DatabaseHelper getDB(Context context){

        if (instance==null){
            instance = Room.databaseBuilder(context, DatabaseHelper.class,"question_Database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    public abstract QuestionsDao questionDao();
}

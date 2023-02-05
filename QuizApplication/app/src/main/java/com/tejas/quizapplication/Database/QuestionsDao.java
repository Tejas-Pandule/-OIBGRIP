package com.tejas.quizapplication.Database;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface QuestionsDao {

    @Query("select * from question_table")
    List<Questions> getQuestions();

    @Insert
    void insertQuestions (Questions questions);



}

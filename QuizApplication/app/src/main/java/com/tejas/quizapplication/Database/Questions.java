package com.tejas.quizapplication.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "question_table")
public class Questions {

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "id")
    private int id;

    @ColumnInfo (name = "question")
    private String question;

    @ColumnInfo (name = "answer")
    private String answer;

    @ColumnInfo(name = "optionA")
    private String optionA;

    @ColumnInfo(name = "optionB")
    private String optionB;

    @ColumnInfo(name = "optionC")
    private String optionC;

    @ColumnInfo(name = "optionD")
    private String optionD;




    public Questions(String question, String answer, String optionA, String optionB, String optionC, String optionD) {
        this.question = question;
        this.answer = answer;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
    }

    public Questions() {

    }

    @Ignore
    public Questions(int id,String question, String answer, String optionA, String optionB, String optionC, String optionD) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }
}

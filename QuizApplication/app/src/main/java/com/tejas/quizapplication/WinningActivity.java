package com.tejas.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.tejas.quizapplication.databinding.ActivityWinningBinding;

public class WinningActivity extends AppCompatActivity {
ActivityWinningBinding binding;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityWinningBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        int Correct = getIntent().getIntExtra("Score",0);
        int Wrong = getIntent().getIntExtra("WrongScore",0);


        binding.ScoreBoard.setText(Correct+"/20");
        binding.circularProgressBar.setProgress((float) Correct);



        binding.btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(WinningActivity.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);    //For Pop out the activity from the activity stack.
            startActivity(intent);
        });
    }


}
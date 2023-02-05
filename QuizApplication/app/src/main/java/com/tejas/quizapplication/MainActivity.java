package com.tejas.quizapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;

import com.tejas.quizapplication.Database.DatabaseHelper;
import com.tejas.quizapplication.Database.Questions;
import com.tejas.quizapplication.databinding.ActivityMainBinding;


import java.util.Collections;
import java.util.List;



public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
private int CorrectCount = 0;
private int WrongCount = 0;
private String Answer = "";
private String OptionA = "";
private String OptionB ="";
private String OptionC ="";
private String OptionD ="";
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Database Questions:
        Questions Que1 =  new Questions("Who is the Father of our Nation?","Mahatma Gandhi","Dr. Rajendra Prasad","Dr. B. R. Ambedkar"," Jawaharlal Nehru","Mahatma Gandhi");
        Questions Que2 =   new Questions("1024 Kilobytes is equal to?"," 1 Megabyte (MB)"," 1 Megabyte (MB)"," 1 Megabyte (MB)"," 4Megabyte (MB)"," 3 Megabyte (MB)");
        Questions Que3 =   new Questions("Were you a bird, you ______________ in the sky.","would fly","shall fly","should fly","shall have flown","would fly");
        Questions Que4 =   new Questions("Choose the most appropriate word from the options given below to complete the following sentence: If we manage to ____________ our natural resources, we would leave a better planet for our children.","conserve","uphold","restrain","cherish","conserve");
        Questions Que5 =  new Questions("Brain of computer is?","CPU","RAM","KEYBOARD","SCRREN","CPU");
        Questions Que6 =  new Questions("India lies in which continent?","Asia","Asia","Russia","America","Africa");
        Questions Que7 =  new Questions(" How many Cricket world cups does India have?","2","4","2","6","5");
        Questions Que8 =  new Questions("Which is the longest river on the earth?","Nile","Ganga","Kaveri","Nile","Ghod");
        Questions Que9 =  new Questions("Which animal has hump on its back?","Camel","Horse","Bull","Camel","Goat");
        Questions Que10 =  new Questions(" Smallest state of India is?","Goa","Maharashtra","Goa","Panjab","Gujrat");
        Questions Que11 =  new Questions("What colour symbolises peace?","White","Orange","Green","Blue","White");
        Questions Que12 =  new Questions("Which organ purify our blood?","Kidney","Heart","Stomach","Brain","Kidney");
        Questions Que13 =  new Questions("Gateway of India is located at?","Mumbai","Delhi","Hydrabad","Kolkata","Mumbai");
        Questions Que14 =  new Questions("How many players are there in a cricket team?","11","14","16","11","10");
        Questions Que15 =  new Questions("LBW is related to which sports?","Cricket","Hockey","Football","Kabaddi","Cricket");
        Questions Que16 = new Questions("How many days are there in a Leap year?","366","365","367","366","368");
        Questions Que17 = new Questions(" Who is the founder of Microsoft?","Bill Gates","Jeff Bezos","MarkZukarbarg","Tejas Pandule","Bill Gates");
        Questions Que18 = new Questions("Children’s Day","14 Nov","25 Jan","25 Sept","14 Feb","14 Nov");
        Questions Que19 = new Questions("How many states does India have?","29","27","29","28","30");
        Questions Que20 = new Questions("Shirur Ghodnadi belongs to which district","Pune","Ahmednagar","Pune","Beed","Jalna");

        AddQuestions(Que1,Que2,Que3,Que4,Que5,Que6,Que7,Que8,Que9,Que10,Que11,Que12,Que13,Que14,Que15,Que16,Que17,Que18,Que19,Que20);
        LoadQuestions();


        Dialog dialog = new Dialog(MainActivity.this);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        dialog.setContentView(R.layout.timeout_layout);


                // for counting how many questions are solved.
        binding.crdNext.setOnClickListener(view -> {
            LoadQuestions();
            ResetColors();
            RightClickPermission();
            count++;

            if (count==20){
                Intent intent = new Intent(MainActivity.this,WinningActivity.class);
                intent.putExtra("Score",CorrectCount);
                intent.putExtra("WrongScore",WrongCount);
                startActivity(intent);
            }

        });

        ColorFunction();           // Changing background color ofCards According to right or wrong answer.



        binding.txtExit.setOnClickListener(view -> {
            finish();
        });

        binding.btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,SplashScreen.class);
            startActivity(intent);
        });




        // Countdown:
        long msTime = 300000;
        binding.progressBar.setMax((int)msTime);
        new CountDownTimer(msTime, 1000) {


            public void onTick(long msUntilFinished) {
                binding.cdText.setText("Remaining Sec: " + msUntilFinished / 1000);
                binding.progressBar.setProgress((int)msUntilFinished);


            }

            public void onFinish() {
                binding.cdText.setText("Done!");

                dialog.show();

                dialog.findViewById(R.id.btnTryAgain).setOnClickListener(view -> {
                    dialog.dismiss();
                    Intent intent = new Intent(MainActivity.this,SplashScreen.class);
                    startActivity(intent);

                });
            }
        }.start();








    }

    public void AddQuestions(Questions... question){        // Multiple Arguments/ Parameters.

        DatabaseHelper db = DatabaseHelper.getDB(MainActivity.this);

        for (Questions questionList:question) {

            db.questionDao().insertQuestions(questionList);
            
        }



    }      // Method for Creating Database Instance.

    public void LoadQuestions(){

        DatabaseHelper db = DatabaseHelper.getDB(MainActivity.this);


        List<Questions>questionsList = db.questionDao().getQuestions();
         Collections.shuffle(questionsList);



        for (int i=0; i<questionsList.size(); i++){

            String question = questionsList.get(i).getQuestion();
            Answer = questionsList.get(i).getAnswer();
            OptionA = questionsList.get(i).getOptionA();
            OptionB = questionsList.get(i).getOptionB();
            OptionC = questionsList.get(i).getOptionC();
            OptionD = questionsList.get(i).getOptionD();



            binding.txtQuestion.setText(question);
            binding.txtOptA.setText(OptionA);
            binding.txtOptB.setText(OptionB);
            binding.txtOptC.setText(OptionC);
            binding.txtOptD.setText(OptionD);



        }




    }            // Loading Questions on CardView from Database.

    public void ResetColors(){
        binding.crdOptA.setBackgroundColor(getResources().getColor(R.color.white));
        binding.crdOptB.setBackgroundColor(getResources().getColor(R.color.white));
        binding.crdOptC.setBackgroundColor(getResources().getColor(R.color.white));
        binding.crdOptD.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void WrongClickPermission(){
        binding.crdOptA.setClickable(false);
        binding.crdOptB.setClickable(false);
        binding.crdOptC.setClickable(false);
        binding.crdOptD.setClickable(false);
    }

    public void RightClickPermission(){
        binding.crdOptA.setClickable(true);
        binding.crdOptB.setClickable(true);
        binding.crdOptC.setClickable(true);
        binding.crdOptD.setClickable(true);

    }

    public void ColorFunction(){



        binding.crdOptA.setOnClickListener(view -> {

            if(OptionA.equals(Answer)){
                binding.crdOptA.setBackgroundColor(getResources().getColor(R.color.green));
                CorrectCount++;
            }else {
                binding.crdOptA.setBackgroundColor(getResources().getColor(R.color.red));
                WrongCount++;
                WrongClickPermission();
            }
        });

        binding.crdOptB.setOnClickListener(view -> {

            if(OptionB.equals(Answer)){
                binding.crdOptB.setBackgroundColor(getResources().getColor(R.color.green));
                CorrectCount++;
            }else {
                binding.crdOptB.setBackgroundColor(getResources().getColor(R.color.red));
                WrongCount++;
                WrongClickPermission();        // No Other click allowed.
            }
        });

        binding.crdOptC.setOnClickListener(view -> {

            if(OptionC.equals(Answer)){
                binding.crdOptC.setBackgroundColor(getResources().getColor(R.color.green));
                CorrectCount++;
            }else {
                binding.crdOptC.setBackgroundColor(getResources().getColor(R.color.red));
                WrongCount++;
                WrongClickPermission();
            }
        });

        binding.crdOptD.setOnClickListener(view -> {

            if(OptionD.equals(Answer)){
                binding.crdOptD.setBackgroundColor(getResources().getColor(R.color.green));
                CorrectCount++;
            }else {
                binding.crdOptD.setBackgroundColor(getResources().getColor(R.color.red));
                WrongCount++;
                WrongClickPermission();
            }
        });

    }




}
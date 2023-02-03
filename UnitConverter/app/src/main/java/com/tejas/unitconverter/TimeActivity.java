package com.tejas.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.tejas.unitconverter.R;
import com.tejas.unitconverter.databinding.ActivityTimeBinding;

public class TimeActivity extends AppCompatActivity {
ActivityTimeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityTimeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        // AutoSuggestion:
        String[] Unit = {"MIN","SEC","MSec","HOUR","DAY"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Unit);

        //Set the number of characters the user must type before the drop down list is shown
        binding.edtFrom.setThreshold(1);
        //Set the adapter
        binding.edtFrom.setAdapter(arrayAdapter);

        binding.edtTo.setThreshold(1);
        binding.edtTo.setAdapter(arrayAdapter);

        binding.btnCalculate.setOnClickListener(view -> {

            if (binding.edtTo.getText().toString().equals("") || binding.edtFrom.getText().toString().equals("")){
                Toast.makeText(this, "Please Fill All Required Fields..!", Toast.LENGTH_SHORT).show();
            }

            String flagFrom = binding.edtFrom.getText().toString();
            String flagTo = binding.edtTo.getText().toString();

            if (flagFrom.equals("MIN")&& flagTo.equals("SEC")){
                AnsMinuteToSecond();
            } else if (flagFrom.equals("MIN") && flagTo.equals("MSec")) {
                AnsMinuteToMilisecond();

            } else if (flagFrom.equals("MIN") && flagTo.equals("HOUR")) {
                AnsMinuteToHour();
                
            } else if (flagFrom.equals("MIN") && flagTo.equals("DAY")) {
                AnsMinuteToDay();

            } else if (flagFrom.equals("SEC") && flagTo.equals("MIN")) {
                 AnsSecondToMinute();

            } else if (flagFrom.equals("SEC") && flagTo.equals("MSec")) {
                  AnsSecondToMilisecond();
            } else if (flagFrom.equals("MSec") && flagTo.equals("SEC")) {
                  AnsMilisecondToSecond();
            } else if (flagFrom.equals("MSec") && flagTo.equals("MIN")) {
                AnsMilisecondToMinute();
            } else if (flagFrom.equals("HOUR") && flagTo.equals("DAY")) {
                AnsHourToDay();
            } else if (flagFrom.equals("DAY") && flagTo.equals("HOUR")) {
                AnsDayToHour();
            }


        });
    }

    private void AnsDayToHour() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number * 24;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "HOUR");
        }

    }

    private void AnsHourToDay() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number / 24;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "DAY");
        }
    }

    private void AnsMilisecondToMinute() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number / 60000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "MIN");
        }
    }

    private void AnsMilisecondToSecond() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number / 1000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "SEC");
        }
    }

    private void AnsSecondToMilisecond() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number * 1000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "MSec");
        }
    }

    private void AnsSecondToMinute() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number / 60;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "MIN");
        }
    }

    private void AnsMinuteToDay() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number / 1440;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "DAY");
        }
    }

    private void AnsMinuteToHour() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number / 60;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "HOUR");
        }

    }

    private void AnsMinuteToMilisecond() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number * 60000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "MSec");
        }
    }

    private void AnsMinuteToSecond() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number * 60;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "Sec");
        }
    }
}
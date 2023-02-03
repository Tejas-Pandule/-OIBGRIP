package com.tejas.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.tejas.unitconverter.databinding.ActivityLengthBinding;


public class LengthActivity extends AppCompatActivity {
ActivityLengthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityLengthBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        // AutoSuggestion:
        String[] Unit = {"M","KM","MM","CM"};
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


            if (flagFrom.equals("M") && flagTo.equals("CM")){
                AnsMeterToCentimeter();

            }else if (flagFrom.equals("CM") && flagTo.equals("M")){
                AnsCentimeterToMeter();

            }else if (flagFrom.equals("M")&& flagTo.equals("KM")){
                AnsMeterToKilometer();
                
            } else if (flagFrom.equals("M") && flagTo.equals("MM")) {
                AnsMeterToMilimeter();
                
            }else if (flagFrom.equals("CM") && flagTo.equals("MM")){
                AnsCentimeterToMilimeter();

            } else if (flagFrom.equals("CM") && flagTo.equals("KM")) {
                 AnsCentimeterToKilometer();
            }else if (flagFrom.equals("KM")&& flagTo.equals("M")){
                 AnsKilometerToMeter();

            } else if (flagFrom.equals("KM")&& flagTo.equals("CM")) {
                 AnsKilometerToCentimeter();

            }


        });












    }

    private void AnsKilometerToCentimeter() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number * 100000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "CM");
        }
    }

    private void AnsKilometerToMeter() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number * 1000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "M");
        }
    }

    private void AnsCentimeterToKilometer() {

        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number / 100000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "KM");
        }
    }

    private void AnsCentimeterToMilimeter() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number * 10;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "MM");
        }
    }

    private void AnsMeterToMilimeter() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number * 1000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "MM");
        }
    }

    private void AnsMeterToKilometer() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number / 1000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "KM");
        }
    }

    private void AnsMeterToCentimeter(){
        String no = binding.edtInputNo.getText().toString();

        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);
            float ans = number * 100;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "CM");

        }


    }

    private void AnsCentimeterToMeter(){
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number / 100;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "M");
        }

    }
}
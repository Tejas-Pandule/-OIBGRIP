package com.tejas.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.tejas.unitconverter.R;
import com.tejas.unitconverter.databinding.ActivityMassBinding;

public class MassActivity extends AppCompatActivity {
ActivityMassBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMassBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        // AutoSuggestion:
        String[] Unit = {"KG","G","TON","MG","Lb"};
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

            if (flagFrom.equals("KG") && flagTo.equals("G")){
                 AnsKilogramToGram();

            }else if (flagFrom.equals("KG") && flagTo.equals("TON")){
                 AnsKilogramToTonne();

            }else if (flagFrom.equals("KG") && flagTo.equals("MG")){
                 AnsKilogramToMiligram();

            }else if (flagFrom.equals("KG") && flagTo.equals("Lb")){
                 AnskilogramToPound();

            } else if (flagFrom.equals("G") && flagTo.equals("KG")) {
                 AnsGramToKilogram();

            } else if (flagFrom.equals("G")&& flagTo.equals("TON")) {
                 AnsGramToTonne();

            } else if (flagFrom.equals("G") && flagTo.equals("MG")) {
                 AnsGramToMiligram();

            }else if (flagFrom.equals("G") && flagTo.equals("Lb")) {
                  AnsGramToPound();

            }else if (flagFrom.equals("MG") && flagTo.equals("G")) {
                AnsMiligramToGram();

            }else if (flagFrom.equals("MG") && flagTo.equals("KG")) {
                AnsMiligramToKilogram();

            }else if (flagFrom.equals("MG") && flagTo.equals("TON")) {
                AnsMiligramToTonne();

            }else if (flagFrom.equals("MG") && flagTo.equals("Lb")) {
                AnsMiligramToPound();

            }
        });
    }

    private void AnsMiligramToPound() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            double ans = number *  2.205;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "Lb");
        }
    }

    private void AnsMiligramToTonne() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = (float) (number / 0.000000001);
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "Lb");
        }
    }

    private void AnsMiligramToKilogram() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            double ans = number / 0.000001;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "KG");
        }
    }

    private void AnsMiligramToGram() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number / 1000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "G");
        }
    }

    private void AnsGramToPound() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = (float) (number / 453.6);
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "Lb");
        }
    }

    private void AnsGramToMiligram() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number * 1000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "MG");
        }
    }

    private void AnsGramToTonne() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            double ans = number / 0.000001;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "TON");
        }
    }

    private void AnsGramToKilogram() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number / 1000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "KG");
        }
    }

    private void AnskilogramToPound() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            double ans = number *  2.205;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "Lb");
        }

    }

    private void AnsKilogramToMiligram() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            double ans = number * 0.000001;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "TON");
        }
    }

    private void AnsKilogramToTonne() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number / 1000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "TON");
        }

    }

    private void AnsKilogramToGram() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number * 1000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "G");
        }
    }
}
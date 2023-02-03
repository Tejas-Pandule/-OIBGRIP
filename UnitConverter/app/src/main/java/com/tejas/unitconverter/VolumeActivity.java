package com.tejas.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.tejas.unitconverter.R;
import com.tejas.unitconverter.databinding.ActivityVolumeBinding;

public class VolumeActivity extends AppCompatActivity {
ActivityVolumeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityVolumeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        // AutoSuggestion:
        String[] Unit = {"Liter","MiliLiter"};
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

            if (flagFrom.equals("Liter")&& flagTo.equals("MiliLiter")){
                AnsLiterToMiliLiter();
            } else if (flagFrom.equals("MiliLiter") && flagTo.equals("Liter")) {
                AnsMiliLeterToLiter();
            }
        });
    }

    private void AnsMiliLeterToLiter() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number / 1000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "Liter");
        }
    }

    private void AnsLiterToMiliLiter() {
        String no = binding.edtInputNo.getText().toString();
        if (no.equals("")){
            Toast.makeText(this, " Please enter the number..!", Toast.LENGTH_SHORT).show();
        }else {
            float number = Float.parseFloat(no);

            float ans = number * 1000;
            String finalAns = String.valueOf(ans);

            binding.txtOutput.setText(finalAns + "ML");
        }
    }
}
package com.tejas.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.tejas.unitconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


       binding.crdLength.setOnClickListener(view -> {
           Intent intent = new Intent(this,LengthActivity.class);
           startActivity(intent);
       });

        binding.crdMass.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MassActivity.class);
            startActivity(intent);

        });

        binding.crdTime.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TimeActivity.class);
            startActivity(intent);
        });

        binding.crdVolume.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, VolumeActivity.class);
            startActivity(intent);
        });

    }
}
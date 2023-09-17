package com.drivers.shamelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.drivers.shamelproject.databinding.ActivityMainBinding;
import com.drivers.shamelproject.SharedPreferences.SharedPreferences;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.shred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(), SharedPreferences.class);
                startActivity(intent);
            }
        });
        binding.database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(), DatabaseActivity.class);
                startActivity(intent);
            }
        });



    }
    //https://github.com/devabir93/Threads
}
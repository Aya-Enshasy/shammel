package com.drivers.shamelproject.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.drivers.shamelproject.databinding.ActivitySharedPreferanceBinding;

public class SharedPreferences extends AppCompatActivity {

    ActivitySharedPreferanceBinding binding;
    //////////
    public static final String PREF_NAME = "RegisterPreferences";
    public static android.content.SharedPreferences sp;
    public static android.content.SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySharedPreferanceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        editor = sp.edit();


        binding.saveInSharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.name.getText().toString();
                String age = binding.age.getText().toString();
                //put لحفظ جوا الشيرد
                editor.putString("name",name);//editor.putString("key",value)
                editor.putString("age",age);
                editor.apply();
                Toast.makeText(SharedPreferences.this, "add successfully", Toast.LENGTH_SHORT).show();
            }
        });

        binding.getFromSharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = sp.getString("name","");
                String age1 = sp.getString("age","");
                binding.nameFromShared.setText(name1);
                binding.ageFromShared.setText(age1);
                Toast.makeText(SharedPreferences.this, "get data successfully", Toast.LENGTH_SHORT).show();
            }
        });




    }
}
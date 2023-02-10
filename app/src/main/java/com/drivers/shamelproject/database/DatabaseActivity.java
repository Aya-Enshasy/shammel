package com.drivers.shamelproject.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.drivers.shamelproject.R;
import com.drivers.shamelproject.databinding.ActivityDatabaseBinding;
import com.drivers.shamelproject.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class DatabaseActivity extends AppCompatActivity {
    MyDatabase myDatabase;
    ActivityDatabaseBinding binding;
    ArrayList<Student> list;
    StudentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myDatabase = new MyDatabase(this);
        list = myDatabase.getAllStudents();

        binding.saveInDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.name.getText().toString();
                String age = binding.age.getText().toString();
                Student student = new Student(name,age);
                boolean res = myDatabase.insert(student);
                if (res){
                    Toast.makeText(DatabaseActivity.this, "add successfully", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(DatabaseActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });

        binding.getFromDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list = myDatabase.getAllStudents();

                LinearLayoutManager layoutManager=new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL,false);
                binding.recyclerview.setLayoutManager(layoutManager);
                adapter = new StudentsAdapter(getBaseContext(), list);
                binding.recyclerview.setAdapter(adapter);

            }
        });


        LinearLayoutManager layoutManager=new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        binding.recyclerview.setLayoutManager(layoutManager);
        adapter = new StudentsAdapter(this, list);
        binding.recyclerview.setAdapter(adapter);

    }
}
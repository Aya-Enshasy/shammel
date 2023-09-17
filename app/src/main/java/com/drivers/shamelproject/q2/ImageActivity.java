package com.drivers.shamelproject.q2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.drivers.shamelproject.databinding.ActivityImageBinding;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {
    ImageAdapter adapter;
    MyDatabase myDatabase;
    ActivityImageBinding binding;
    ArrayList<Photos> list;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = ActivityImageBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());

         myDatabase = new MyDatabase(this);
         list = myDatabase.getAllPhotos();


         LinearLayoutManager layoutManager=new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL,false);
         binding.recyclerview.setLayoutManager(layoutManager);
         adapter = new ImageAdapter(getBaseContext(), list);
         binding.recyclerview.setAdapter(adapter);


         //عدد عناصر المحفوظة
         long count =  myDatabase.getStudentCount();
         binding.count.setText(count+"");



     }

}
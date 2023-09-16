package com.drivers.shamelproject.recycel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.drivers.shamelproject.R;
import com.drivers.shamelproject.database.StudentsAdapter;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    NewsAdapter adapter;
    ArrayList<News> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        list.add(new News("title"));
        list.add(new News("aaaaaa"));
        list.add(new News("title"));

        adapter = new NewsAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
}
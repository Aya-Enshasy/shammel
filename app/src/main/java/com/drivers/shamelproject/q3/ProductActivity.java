package com.drivers.shamelproject.q3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.drivers.shamelproject.R;
import com.drivers.shamelproject.recycel.News;
import com.drivers.shamelproject.recycel.NewsAdapter;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    ProductAdapter adapter;
    ArrayList<Product> list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        list.add(new Product("name","10","2"));
        list.add(new Product("name","10","2"));
        list.add(new Product("name","10","2"));
        list.add(new Product("name","10","2"));
        list.add(new Product("name","10","2"));
        list.add(new Product("name","10","2"));
        list.add(new Product("name","10","2"));
        list.add(new Product("name","10","2"));
        list.add(new Product("name","10","2"));
        list.add(new Product("name","10","2"));


        adapter = new ProductAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
}
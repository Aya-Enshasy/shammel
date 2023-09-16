package com.drivers.shamelproject.apis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.drivers.shamelproject.R;
import com.drivers.shamelproject.apis.model.Post;
import com.drivers.shamelproject.database.DatabaseActivity;
import com.drivers.shamelproject.database.MyDatabase;
import com.drivers.shamelproject.database.Student;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApisActivity extends AppCompatActivity {
    public ApiInterface api;
    MyDatabase myDatabase;
    ArrayList<Post> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apis);

        myDatabase = new MyDatabase(this);
        list = myDatabase.getAllPosts();

        api = Creator.getRetrofitInstance();
        getPosts();
    }

    private void getPosts() {
        api.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()){

                    for (int i = 0; i < response.body().size(); i++) {
                        Log.e("title",response.body().get(i).getTitle());
                        //للتخزين في الداتا بيز
                        Post student = new Post(response.body().get(i).getId(),response.body().get(i).getTitle());
                        boolean res = myDatabase.insertPost(student);
                    }



                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

}
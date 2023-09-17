package com.drivers.shamelproject.q2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.drivers.shamelproject.R;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {
    public ApiInterface api;
    MyDatabase myDatabase;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        myDatabase = new MyDatabase(this);

        api = Creator.getRetrofitInstance();
        getPosts();
    }

    private void getPosts() {
        api.getPhotos().enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                if (response.isSuccessful()){

                    for (int i = 0; i < response.body().size(); i++) {
                        Log.e("title",response.body().get(i).getTitle());
                         Photos photos = new Photos(response.body().get(i).getAlbumId(),response.body().get(i).getTitle(),response.body().get(i).getUrl(),response.body().get(i).getThumbnailUrl());
                        boolean res = myDatabase.insert(photos);
                        if (res){
                            Toast.makeText(SplashActivity.this, "add successfully", Toast.LENGTH_SHORT).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent i = new Intent(SplashActivity.this, ImageActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                            }, 2000);
                        }else
                            Toast.makeText(SplashActivity.this, "error", Toast.LENGTH_SHORT).show();

                    }



                }
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {

            }
        });
    }

}
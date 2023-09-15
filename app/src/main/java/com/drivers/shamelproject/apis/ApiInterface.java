package com.drivers.shamelproject.apis;

import com.drivers.shamelproject.apis.model.Post;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Call<List<Post>> getPosts();
}

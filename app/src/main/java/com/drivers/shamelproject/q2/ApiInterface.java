package com.drivers.shamelproject.q2;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("photos")
    Call<List<Photos>> getPhotos();
}

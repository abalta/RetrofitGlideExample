package com.abdullahbalta.retrofitglideexample.interfaces;

import com.abdullahbalta.retrofitglideexample.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by asus on 6.09.2016.
 */
public interface RetroInterface {
    @GET("/json/glide.json")
    Call<Movie[]> getJsonValues();
}

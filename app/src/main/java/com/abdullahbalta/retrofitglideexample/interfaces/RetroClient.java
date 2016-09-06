package com.abdullahbalta.retrofitglideexample.interfaces;


import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by asus on 6.09.2016.
 */
public class RetroClient {
    public static final String BASE_URL = "http://api.androidhive.info";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

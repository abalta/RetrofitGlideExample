package com.abdullahbalta.retrofitglideexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.abdullahbalta.retrofitglideexample.adapter.MovieAdapter;
import com.abdullahbalta.retrofitglideexample.interfaces.RetroClient;
import com.abdullahbalta.retrofitglideexample.interfaces.RetroInterface;
import com.abdullahbalta.retrofitglideexample.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<Movie> moviesData = new ArrayList<>();
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        RetroInterface retroInterface = RetroClient.getClient().create(RetroInterface.class);
        Call<Movie[]> call = retroInterface.getJsonValues();
        call.enqueue(new Callback<Movie[]>() {
            @Override
            public void onResponse(Call<Movie[]> call, Response<Movie[]> response) {
                moviesData = Arrays.asList(response.body());
                movieAdapter = new MovieAdapter(moviesData, R.layout.movie_item, getApplicationContext());
                recyclerView.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Call<Movie[]> call, Throwable t) {
                Log.e(TAG, "HATA: " + t.toString());
            }
        });
    }
}

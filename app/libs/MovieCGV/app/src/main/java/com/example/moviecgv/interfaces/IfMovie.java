package com.example.moviecgv.interfaces;

import com.example.moviecgv.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IfMovie {
    //https://api.themoviedb.org/3/movie/popular?api_key=414ffc7cfe79b04554b68edfa48428d3&language=en-US&page=1
    @GET("3/movie/popular")
    Call<Example> getData(@Query("api_key") String api_key
            , @Query("language") String lang
            , @Query("page") int page);


}

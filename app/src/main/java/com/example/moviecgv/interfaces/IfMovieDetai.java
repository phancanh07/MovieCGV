package com.example.moviecgv.interfaces;

import com.example.moviecgv.model.detail.Detail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IfMovieDetai {
    // https://api.themoviedb.org/3/movie/399566/credits?api_key=414ffc7cfe79b04554b68edfa48428d3
    // https://api.themoviedb.org/3/movie/{id}?api_key=414ffc7cfe79b04554b68edfa48428d3

    //video
    //https://api.themoviedb.org/3/movie/399566/videos?api_key=414ffc7cfe79b04554b68edfa48428d3
    @GET("3/movie/{id}?api_key=414ffc7cfe79b04554b68edfa48428d3")
    Call<Detail> getDataDetai(@Path("id") String id);


}

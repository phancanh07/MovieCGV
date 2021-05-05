package com.example.moviecgv.interfaces;

import com.example.moviecgv.model.video.Video;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IfVideo {
    //https://api.themoviedb.org/3/movie/399566/videos?api_key=414ffc7cfe79b04554b68edfa48428d3
    @GET("3/movie/{id}/videos?api_key=414ffc7cfe79b04554b68edfa48428d3")
    Call<Video> getDataVideo(@Path("id") String id);
}

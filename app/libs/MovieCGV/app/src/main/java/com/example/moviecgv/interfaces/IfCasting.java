package com.example.moviecgv.interfaces;

import com.example.moviecgv.model.character.Characters;
import com.example.moviecgv.model.detail.Detail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IfCasting {
//https://api.themoviedb.org/3/movie/460465/credits?api_key=414ffc7cfe79b04554b68edfa48428d3
//    /https://api.themoviedb.org/3/movie/399566/credits?api_key=414ffc7cfe79b04554b68edfa48428d3
    @GET("3/movie/{id}/credits?api_key=414ffc7cfe79b04554b68edfa48428d3")
    Call<Characters> getDataCasting(@Path("id") String id);

}

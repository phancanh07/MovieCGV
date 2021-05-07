package com.example.moviecgv.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecgv.R;
import com.example.moviecgv.adapter.MovieAdapter;
import com.example.moviecgv.interfaces.IfMovie;
import com.example.moviecgv.model.Example;
import com.example.moviecgv.presenters.ApiRetrofit;
import com.example.moviecgv.ui.view.DetailActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieFragment extends Fragment implements View.OnClickListener {
    private RecyclerView recyclerView;
    int PAGE =1;
    LinearLayoutManager manager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        initView(view);
        getData();
        return view;
    }

    public void getData() {
        IfMovie ifMovie = ApiRetrofit.getClient().create(IfMovie.class);
        ifMovie.getData("414ffc7cfe79b04554b68edfa48428d3", "en-US", PAGE).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {
                    Example example = response.body();
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                    MovieAdapter movieAdapter = new MovieAdapter(getContext(), example.getResults(), MovieFragment.this::onClick);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(movieAdapter);


                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("err" + t.getMessage(), "ssss");
            }
        });
    }


    public void initView(View view) {
        recyclerView = view.findViewById(R.id.recylerView);
        manager = new LinearLayoutManager(getContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cardView:
                String position = String.valueOf(v.getTag());
                startActivity(new Intent(getContext(), DetailActivity.class).putExtra("key", position));
                break;
            default:
                break;
        }
    }
}
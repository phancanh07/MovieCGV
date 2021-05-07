package com.example.moviecgv.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecgv.R;
import com.example.moviecgv.adapter.CharacterAdapter;
import com.example.moviecgv.interfaces.IfCasting;
import com.example.moviecgv.interfaces.IfMovieDetai;
import com.example.moviecgv.interfaces.IfVideo;
import com.example.moviecgv.model.character.Characters;
import com.example.moviecgv.model.detail.Detail;
import com.example.moviecgv.model.video.Video;
import com.example.moviecgv.presenters.ApiRetrofit;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    List<Detail> list = new ArrayList<>();
    RecyclerView recyclerView, recyclerViewCast;
    private TextView txt_time, txt_date, txt_coutry, txt_genres_detail, txt_vote, txt_overview, txt_name;
    private ImageView img, img1;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        initView();
        getData(key);
        getCharacter(key);
        getVideo(key);
        button.setOnClickListener(this::onClick);

    }

    private void getCharacter(String key) {
        IfCasting ifCasting = ApiRetrofit.getClientDetaiCharacter().create(IfCasting.class);
        ifCasting.getDataCasting(key).enqueue(new Callback<Characters>() {
            @Override
            public void onResponse(Call<Characters> call, Response<Characters> response) {
                if (response.isSuccessful()) {
                    Characters characters = response.body();
                    CharacterAdapter characterAdapter = new CharacterAdapter(characters.getCast(), getApplicationContext());
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                    recyclerViewCast.setLayoutManager(layoutManager);
                    recyclerViewCast.setHasFixedSize(true);
                    recyclerViewCast.setAdapter(characterAdapter);

                }


            }

            @Override
            public void onFailure(Call<Characters> call, Throwable t) {

            }
        });
    }

    private void initView() {

        recyclerViewCast = findViewById(R.id.casting);
        txt_time = findViewById(R.id.txt_time);
        txt_date = findViewById(R.id.txt_date_detail);
        txt_coutry = findViewById(R.id.txt_country);
        txt_genres_detail = findViewById(R.id.txt_genres_detail);
        txt_vote = findViewById(R.id.txt_vote_detail);
        txt_overview = findViewById(R.id.txt_overview_detail);
        txt_name = findViewById(R.id.txt_nameMovie_detail);
        img = findViewById(R.id.img_detail);
        img1 = findViewById(R.id.img_detail1);
        button = findViewById(R.id.btn_trailer);

    }

    private void getData(String key) {
        IfMovieDetai ifMovieDetai = ApiRetrofit.getClientDetai().create(IfMovieDetai.class);
        ifMovieDetai.getDataDetai(key).enqueue(new Callback<Detail>() {
            @Override
            public void onResponse(Call<Detail> call, Response<Detail> response) {
                if (response.isSuccessful()) {
                    Detail detail = response.body();
                    txt_coutry.setText("Coutry :" + detail.getProductionCountries().get(0).getName());
                    txt_time.setText("Time:" + detail.getRuntime() + "Minute");
                    txt_date.setText("Date:" + detail.getReleaseDate());
                    txt_genres_detail.setText("Genres:" + detail.getGenres().get(0).getName());
                    txt_name.setText("Movie:" + detail.getOriginalTitle());
                    txt_overview.setText(detail.getOverview());
                    txt_vote.setText("Vote :" + detail.getVoteAverage().toString() + "/10");
                    Picasso.get().load("http://image.tmdb.org/t/p/original" + detail.getBackdropPath()).into(img);
                    Picasso.get().load("http://image.tmdb.org/t/p/w780" + detail.getPosterPath()).into(img1);


                }
            }

            @Override
            public void onFailure(Call<Detail> call, Throwable t) {
                Log.e("TAG", t.getMessage());
            }


        });


    }

    private void getVideo(String key) {
        IfVideo ifVideo = ApiRetrofit.getClientVideo().create(IfVideo.class);
        ifVideo.getDataVideo(key).enqueue(new Callback<Video>() {
            @Override
            public void onResponse(Call<Video> call, Response<Video> response) {
                if (response.isSuccessful()) {
                    Video video = response.body();
                    String url = video.getResults().get(0).getKey();
                    button.setTag(url);
                }
            }

            @Override
            public void onFailure(Call<Video> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            startActivity(new Intent(this, TrailerMovieActivity.class).putExtra("KEY_ID", String.valueOf(button.getTag())));
        }
    }

}
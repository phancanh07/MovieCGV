package com.example.moviecgv.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.moviecgv.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class TrailerMovieActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    public static final String KEY_YOUTOBE = "AIzaSyB8RYOL53PqN1pmsuilQNcVlxa41_kWOsA";
    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer_movie);
        youTubePlayerView = findViewById(R.id.youtobeView);
        youTubePlayerView.initialize(KEY_YOUTOBE, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer ytp, boolean b) {
        Intent intent = getIntent();
        String key = intent.getStringExtra("KEY_ID");
        if (!b) {
            ytp.cueVideo(key);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
        if (result.isUserRecoverableError()) {
            result.getErrorDialog(this, 1).show();
        } else {
            String error = String.format("Error initializing YouTube player", result.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }
}
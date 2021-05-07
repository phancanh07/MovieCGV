package com.example.moviecgv.ui.view;

import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviecgv.R;

public class TrailerActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4
        setContentView(R.layout.activity_trailer);

        videoView.setVideoPath("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4");
        videoView.start();
    }
}
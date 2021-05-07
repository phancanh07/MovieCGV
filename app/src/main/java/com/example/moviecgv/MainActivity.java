package com.example.moviecgv;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.moviecgv.adapter.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPageAdapter viewPageAdapter;
    ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tabLayout = findViewById(R.id.tabMode);
        pager = findViewById(R.id.viewpage);
        viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        pager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(pager);
        setupTabIcons();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_movies_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_movies_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_movies_24);
    }


}
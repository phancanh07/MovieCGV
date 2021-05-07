package com.example.moviecgv.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.moviecgv.ui.fragment.AboutFragment;
import com.example.moviecgv.ui.fragment.FavariteFragment;
import com.example.moviecgv.ui.fragment.MovieFragment;

public class ViewPage extends FragmentStatePagerAdapter {

    public ViewPage(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Movie";
                break;
            case 1:
                title = "Favarite";
                break;
            case 2:
                title = "About";
                break;

            default:
                title = "Movie";
        }

        return title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MovieFragment();
            case 1:
                return new FavariteFragment();
            case 2:
                return AboutFragment.newInstance("","");
            default:
                return new MovieFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}
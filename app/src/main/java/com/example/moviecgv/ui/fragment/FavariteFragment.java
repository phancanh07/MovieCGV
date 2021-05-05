package com.example.moviecgv.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecgv.R;
import com.example.moviecgv.adapter.FavariteAdapter;
import com.example.moviecgv.model.favorite.Favorite;
import com.example.moviecgv.roomdb.MovieDataBase;

import java.util.List;


public class FavariteFragment extends Fragment implements View.OnClickListener {
    private RecyclerView recyclerView;
    private List<Favorite> favoriteList;
    private FavariteAdapter movieAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favarite, container, false);
        recyclerView = view.findViewById(R.id.favarite);
        setData();
        return view;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getView() != null) {
            setData();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cardView1:
                break;
            default:
                break;
        }
    }

    private void setData() {
        favoriteList = MovieDataBase.getInstance(getContext()).movieDAO().getList();
        movieAdapter = new FavariteAdapter(favoriteList, getContext(), this::onClick);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        movieAdapter.setData(favoriteList);
        recyclerView.setHasFixedSize(true);
        movieAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(movieAdapter);


    }

}
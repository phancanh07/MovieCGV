package com.example.moviecgv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecgv.R;
import com.example.moviecgv.model.favorite.Favorite;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavariteAdapter extends RecyclerView.Adapter<FavariteAdapter.FavariteAdapterHoder> {
    private List<Favorite> favorites;
    Context context;
    View.OnClickListener onClickListener;



    public FavariteAdapter(List<Favorite> favorites, Context context, View.OnClickListener onClickListener) {
        this.favorites = favorites;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public FavariteAdapterHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_adapter, parent, false);
        return new FavariteAdapter.FavariteAdapterHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavariteAdapterHoder holder, int position) {
        final Favorite example = favorites.get(position);
        holder.movie_name.setText(example.getTitle());
        holder.txt_dateMovie.setText(example.getReleaseDate());
        holder.txt_overView.setText(example.getOverview());
        holder.txt_rating.setText(example.getVoteAverage());
        holder.txt_views.setText(example.getPopularity());
        Picasso.get().load("http://image.tmdb.org/t/p/w500" + example.getPosterPath()).into(holder.img);
        holder.cardView.setTag(example);

    }


    @Override
    public int getItemCount() {
        if (favorites != null) {
            return favorites.size();
        } else {
            return 0;
        }

    }


    public class FavariteAdapterHoder extends RecyclerView.ViewHolder {
        private ImageView img, like;
        private TextView txt_views, txt_overView, txt_dateMovie, txt_rating, movie_name;
        private CardView cardView;

        public FavariteAdapterHoder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img1);
            txt_views = itemView.findViewById(R.id.txt_views1);
            txt_overView = itemView.findViewById(R.id.txt_overview1);
            txt_dateMovie = itemView.findViewById(R.id.txt_date_movie1);
            txt_rating = itemView.findViewById(R.id.txt_rating1);
            movie_name = itemView.findViewById(R.id.txt_nameMovie1);
            cardView = itemView.findViewById(R.id.cardView1);
        }

    }
    public void setData(List<Favorite> favoriteList) {
        this.favorites = favoriteList;
        notifyDataSetChanged();
    }
}

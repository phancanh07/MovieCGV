package com.example.moviecgv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecgv.R;
import com.example.moviecgv.model.Result;
import com.example.moviecgv.model.favorite.Favorite;
import com.example.moviecgv.roomdb.MovieDataBase;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterHoder> {
    private Context context;
    private List<Result> exampleList;
    private View.OnClickListener onClickListener;

    private List<Favorite> favorites;


    public MovieAdapter(Context context, List<Result> exampleList, View.OnClickListener onClickListener) {
        this.context = context;
        this.exampleList = exampleList;
        this.onClickListener = onClickListener;
    }

    public MovieAdapter(Context context, List<Favorite> favorites) {
        this.context = context;
        this.favorites = favorites;
    }

    @NonNull
    @Override
    public MovieAdapterHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout_adapter, parent, false);
        return new MovieAdapterHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapterHoder holder, int position) {
        Favorite favorite = new Favorite();
        final Result example = exampleList.get(position);
        holder.movie_name.setText(example.getTitle());
        holder.txt_rating.setText("Vote :\t" + example.getVoteAverage() + "/10");
        holder.txt_overView.setText(example.getOverview());
        holder.txt_views.setText("Views :" + example.getPopularity());
        holder.txt_dateMovie.setText("Release Date:\t" + example.getReleaseDate());
        Picasso.get().load("http://image.tmdb.org/t/p/w500" + example.getPosterPath()).into(holder.img);

        if (MovieDataBase.getInstance(context).movieDAO().isCheckedMovieExit(example.getTitle())) {
            holder.like.setImageResource(R.drawable.heart);
        } else {
            holder.like.setImageResource(R.drawable.dis);
        }
        holder.cardView.setOnClickListener(onClickListener);
        holder.cardView.setTag(example.getId());
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favorite.setTitle(example.getTitle());
                favorite.setVoteAverage(example.getVoteAverage());
                favorite.setOverview(example.getOverview());
                favorite.setPopularity(example.getPopularity());
                favorite.setReleaseDate(example.getReleaseDate());
                favorite.setPosterPath(example.getPosterPath());
                if (checkFavorite(favorite)) {
                    holder.like.setImageResource(R.drawable.heart);
                    if (MovieDataBase.getInstance(context).movieDAO().checkMovie(example.getTitle()) == false) {
                        MovieDataBase.getInstance(context).movieDAO().insertMovie(favorite);

                    }
                } else {
                    holder.like.setImageResource(R.drawable.dis);
                    MovieDataBase.getInstance(context).movieDAO().delete(example.getTitle());
                    Toast.makeText(context, "delete", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    @Override
    public int getItemCount() {
        if (exampleList != null) {
            return exampleList.size();
        } else {
            return 0;
        }

    }

    public class MovieAdapterHoder extends RecyclerView.ViewHolder {
        private ImageView img, like;
        private TextView txt_views, txt_overView, txt_dateMovie, txt_rating, movie_name;
        private CardView cardView;

        public MovieAdapterHoder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txt_views = itemView.findViewById(R.id.txt_views);
            txt_overView = itemView.findViewById(R.id.txt_overview);
            txt_dateMovie = itemView.findViewById(R.id.txt_date_movie);
            txt_rating = itemView.findViewById(R.id.txt_rating);
            movie_name = itemView.findViewById(R.id.txt_nameMovie);
            cardView = itemView.findViewById(R.id.cardView);
            like = itemView.findViewById(R.id.like);
        }
    }

    private boolean checkFavorite(Favorite favorite) {
        favorites = MovieDataBase.getInstance(context).movieDAO().isCheckMovieExit(favorite.getTitle());
        return favorites != null && favorites.isEmpty();
    }

}

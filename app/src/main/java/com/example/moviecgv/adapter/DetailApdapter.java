package com.example.moviecgv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecgv.R;
import com.example.moviecgv.model.detail.Detail;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailApdapter extends RecyclerView.Adapter<DetailApdapter.DetailApdapterHoder> {
    private List<Detail> details;
    private Context context;

    public DetailApdapter(List<Detail> details, Context context) {
        this.details = details;
        this.context = context;
    }


    @NonNull
    @Override
    public DetailApdapterHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_apdapter, parent, false);
        return new DetailApdapterHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailApdapterHoder holder, int position) {
        final Detail detail = details.get(position);


    }

    @Override
    public int getItemCount() {
        if (details != null) {
            return details.size();
        } else {
            return 0;
        }

    }

    public class DetailApdapterHoder extends RecyclerView.ViewHolder {
        private TextView txt_time, txt_date, txt_coutry, txt_genres_detail, txt_vote, txt_overview, txt_name;
        private ImageView img, img1;
        private LinearLayout linearLayout;

        public DetailApdapterHoder(@NonNull View itemView) {
            super(itemView);
            txt_time = itemView.findViewById(R.id.txt_time);
            txt_date = itemView.findViewById(R.id.txt_date_detail);
            txt_coutry = itemView.findViewById(R.id.txt_country);
            txt_genres_detail = itemView.findViewById(R.id.txt_genres_detail);
            txt_vote = itemView.findViewById(R.id.txt_vote_detail);
            txt_overview = itemView.findViewById(R.id.txt_overview_detail);
            txt_name = itemView.findViewById(R.id.txt_nameMovie_detail);
            img = itemView.findViewById(R.id.img_detail);
            img1 = itemView.findViewById(R.id.img_detail1);
        }
    }
}

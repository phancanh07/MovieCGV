package com.example.moviecgv.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecgv.R;
import com.example.moviecgv.model.character.Cast;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterAdapterHoder> {
    private List<Cast> details;
    private Context context;

    public CharacterAdapter(List<Cast> details, Context context) {
        this.details = details;
        this.context = context;
    }

    @NonNull
    @Override
    public CharacterAdapterHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cast_item_apdapter, parent, false);
        return new CharacterAdapter.CharacterAdapterHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapterHoder holder, int position) {
        Cast character = details.get(position);
        Log.d("TAG", "TNV" + character.getOriginalName());
        holder.namecharacter.setText(character.getCharacter());
        holder.name.setText(character.getOriginalName());

        if (details.get(position).getProfilePath() != null) {
            Picasso.get().load("http://image.tmdb.org/t/p/w500" + character.getProfilePath()).into(holder.img);
        } else {
            Picasso.get().load("https://lh3.googleusercontent.com/proxy/t-UEhlXrp5lABcbKW1md_JlBYX0YTnFHIkalYAhEu8csVw77hBiQhDvia1EeVkIJ6q8H2gh5N5iIamTNufWG3ZgZ4BXMBnvi60VhqSdb05C9hNuw").into(holder.img);
        }

    }

    @Override
    public int getItemCount() {
        if (details != null) {
            return details.size();
        } else {
            return 0;
        }
    }

    public class CharacterAdapterHoder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, namecharacter;

        public CharacterAdapterHoder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_character);
            name = itemView.findViewById(R.id.name1);
            namecharacter = itemView.findViewById(R.id.nameCharacter1);
        }
    }
}

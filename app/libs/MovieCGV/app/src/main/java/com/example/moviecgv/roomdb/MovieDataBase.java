package com.example.moviecgv.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.moviecgv.model.Result;
import com.example.moviecgv.model.favorite.Favorite;

@Database(entities = {Favorite.class}, version = 1)
public abstract class MovieDataBase extends RoomDatabase {
    private static final String DATABASE_NAME = "movie.db";
    private static MovieDataBase instance;

    public static synchronized MovieDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MovieDataBase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract MovieDAO movieDAO();


}

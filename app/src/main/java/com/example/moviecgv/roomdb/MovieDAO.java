package com.example.moviecgv.roomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.moviecgv.model.favorite.Favorite;

import java.util.List;

@Dao
public interface MovieDAO {
    @Insert
    void insertMovie(Favorite favorite);

    @Delete
    void deleteMovie(Favorite favorite);

    @Query("DELETE FROM table_movie WHERE title=:title")
    void delete(String title);


    @Query("SELECT*FROM table_movie")
    List<Favorite> getList();

    @Query("select exists (select 1 from table_movie where title = :title)")
    public boolean isCheckedMovieExit(String title);

    @Query("select * from table_movie where title = :id")
    public List<Favorite> isCheckMovieExit(String id);

    @Query("SELECT *FROM table_movie  where title  =:title")
    public boolean checkMovie(String title);
}

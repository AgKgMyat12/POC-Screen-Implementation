package com.example.hp.poc_screenimplementation.data.vo;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.hp.poc_screenimplementation.data.persistence.PopularMovieContract;
import com.google.gson.annotations.SerializedName;

/**
 * Created by HP on 12/7/2017.
 */

public class PopularMovieVO {

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("id")
    private int id;

    @SerializedName("video")
    private boolean video;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("title")
    private String title;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("genre_ids")
    private int[] genreIDs;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("adult")
    private boolean adult;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String releaseDate;


    public int getVoteCount() {
        return voteCount;
    }

    public int getId() {
        return id;
    }

    public boolean isVideo() {
        return video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public int[] getGenreID() {
        return genreIDs;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public ContentValues parseToContentValues(){

        ContentValues contentValues = new ContentValues();
        contentValues.put(PopularMovieContract.PopularMovieEntry.COLUMN_VOTE_COUNT, voteCount);
        contentValues.put(PopularMovieContract.PopularMovieEntry.COLUMN_MOVIE_ID, id);
        contentValues.put(PopularMovieContract.PopularMovieEntry.COLUMN_VIDEO, video);
        contentValues.put(PopularMovieContract.PopularMovieEntry.COLUMN_VOTE_AVERAGE, voteAverage);
        contentValues.put(PopularMovieContract.PopularMovieEntry.COLUMN_TITLE, title);
        contentValues.put(PopularMovieContract.PopularMovieEntry.COLUMN_POPULARITY, popularity);
        contentValues.put(PopularMovieContract.PopularMovieEntry.COLUMN_POSTER_PATH, posterPath);
        contentValues.put(PopularMovieContract.PopularMovieEntry.COLUMN_ORIGINAL_LANGUAGE, originalLanguage);
        contentValues.put(PopularMovieContract.PopularMovieEntry.COLUMN_ORIGINAL_TITLE, originalTitle);
        contentValues.put(PopularMovieContract.PopularMovieEntry.COLUMN_BACK_DROP_PATH, backdropPath);
        contentValues.put(PopularMovieContract.PopularMovieEntry.COLUMN_ADULT, adult);
        contentValues.put(PopularMovieContract.PopularMovieEntry.COLUMN_OVERVIEW, overview);
        contentValues.put(PopularMovieContract.PopularMovieEntry.COLUMN_RELEASE_DATE, releaseDate);

        return contentValues;
    }

    public static PopularMovieVO parseFromCursor(Cursor cursor){
        PopularMovieVO popularMovie = new PopularMovieVO();
        popularMovie.voteCount = cursor.getInt(cursor.getColumnIndex(PopularMovieContract.PopularMovieEntry.COLUMN_VOTE_COUNT));
        popularMovie.id = cursor.getInt(cursor.getColumnIndex(PopularMovieContract.PopularMovieEntry.COLUMN_MOVIE_ID));
        //popularMovie.video = cursor.getInt(cursor.getColumnIndex(PopularMovieContract.PopularMovieEntry.COLUMN_VIDEO));
        popularMovie.voteAverage = cursor.getInt(cursor.getColumnIndex(PopularMovieContract.PopularMovieEntry.COLUMN_VOTE_AVERAGE));
        popularMovie.title = cursor.getString(cursor.getColumnIndex(PopularMovieContract.PopularMovieEntry.COLUMN_TITLE));
        popularMovie.popularity = cursor.getDouble(cursor.getColumnIndex(PopularMovieContract.PopularMovieEntry.COLUMN_POPULARITY));
        popularMovie.posterPath = cursor.getString(cursor.getColumnIndex(PopularMovieContract.PopularMovieEntry.COLUMN_POSTER_PATH));
        popularMovie.originalLanguage = cursor.getString(cursor.getColumnIndex(PopularMovieContract.PopularMovieEntry.COLUMN_ORIGINAL_LANGUAGE));
        popularMovie.originalTitle = cursor.getString(cursor.getColumnIndex(PopularMovieContract.PopularMovieEntry.COLUMN_ORIGINAL_TITLE));
        popularMovie.backdropPath = cursor.getString(cursor.getColumnIndex(PopularMovieContract.PopularMovieEntry.COLUMN_BACK_DROP_PATH));
        //popularMovie.adult = cursor.getInt(cursor.getColumnIndex(PopularMovieContract.PopularMovieEntry.COLUMN_ADULT));
        popularMovie.overview = cursor.getString(cursor.getColumnIndex(PopularMovieContract.PopularMovieEntry.COLUMN_OVERVIEW));
        popularMovie.releaseDate = cursor.getString(cursor.getColumnIndex(PopularMovieContract.PopularMovieEntry.COLUMN_RELEASE_DATE));

        return popularMovie;
    }
}

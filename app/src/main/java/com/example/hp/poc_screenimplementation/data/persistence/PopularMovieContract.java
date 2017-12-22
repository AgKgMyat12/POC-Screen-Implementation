package com.example.hp.poc_screenimplementation.data.persistence;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import com.example.hp.poc_screenimplementation.MovieListApp;

/**
 * Created by HP on 12/12/2017.
 */

public class PopularMovieContract {

    public static final String CONTENT_AUTHORITY = MovieListApp.class.getPackage().getName();
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_POPULAR_MOVIE = "popular_movie";
    public static final String PATH_GENRE = "genre";
    public static final String PATH_POPULAR_MOVIE_GENRE = "popular_movie_genre";

    public static class PopularMovieEntry implements BaseColumns{

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_POPULAR_MOVIE).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_POPULAR_MOVIE;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_POPULAR_MOVIE;

        public static final String TABLE_NAME = PATH_POPULAR_MOVIE;

        public static final String COLUMN_VOTE_COUNT = "vote_count";
        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String COLUMN_VIDEO = "movie_video";
        public static final String COLUMN_VOTE_AVERAGE = "vote_average";
        public static final String COLUMN_TITLE = "movie_title";
        public static final String COLUMN_POPULARITY = "popularity";
        public static final String COLUMN_POSTER_PATH = "poster_path";
        public static final String COLUMN_ORIGINAL_LANGUAGE = "org_language";
        public static final String COLUMN_ORIGINAL_TITLE = "org_title";
        public static final String COLUMN_BACK_DROP_PATH = "back_drop_path";
        public static final String COLUMN_ADULT = "adult";
        public static final String COLUMN_OVERVIEW = "overview";
        public static final String COLUMN_RELEASE_DATE = "release_date";

        public static Uri buildPopularMovieUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

        public static Uri buildPopularMovieUriWithTitle(String movieTitle){
            return CONTENT_URI.buildUpon().appendQueryParameter(COLUMN_TITLE, movieTitle).build();
        }

        public static String getTitleFromParam(Uri uri){
            return uri.getQueryParameter(COLUMN_TITLE);
        }
    }

    public static class GenreEntry implements BaseColumns{

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_GENRE).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GENRE;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GENRE;

        public static final String TABLE_NAME = PATH_GENRE;

        public static final String COLUMN_GENRE_ID = "genre_id";
        public static final String COLUMN_GENRE_NAME = "genre_name";

        public static Uri buildGenreUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }
    }

    public static class PopularMovieGenreEntry implements BaseColumns{

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_POPULAR_MOVIE_GENRE).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_POPULAR_MOVIE_GENRE;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_POPULAR_MOVIE_GENRE;

        public static final String TABLE_NAME = PATH_POPULAR_MOVIE_GENRE;

        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String COLUMN_GENRE_ID = "genre_id";

        public static Uri buildPopularMovieGenreUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

    }
}

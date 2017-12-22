package com.example.hp.poc_screenimplementation.data.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 12/14/2017.
 */

public class PopularMovieDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "popularmovie.db";

    public static final String SQL_CREATE_POPULAR_MOVIE_TABLE = "CREATE TABLE "+ PopularMovieContract.PopularMovieEntry.TABLE_NAME+ " ("+
            PopularMovieContract.PopularMovieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            PopularMovieContract.PopularMovieEntry.COLUMN_VOTE_COUNT + " INTEGER, "+
            PopularMovieContract.PopularMovieEntry.COLUMN_MOVIE_ID + " INTEGER, "+
            PopularMovieContract.PopularMovieEntry.COLUMN_VIDEO + " BOOLEAN, "+
            PopularMovieContract.PopularMovieEntry.COLUMN_VOTE_AVERAGE + " DOUBLE, "+
            PopularMovieContract.PopularMovieEntry.COLUMN_TITLE + " TEXT NOT NULL, "+
            PopularMovieContract.PopularMovieEntry.COLUMN_POPULARITY + " DOUBLE, "+
            PopularMovieContract.PopularMovieEntry.COLUMN_POSTER_PATH + " TEXT, "+
            PopularMovieContract.PopularMovieEntry.COLUMN_ORIGINAL_LANGUAGE + " TEXT, "+
            PopularMovieContract.PopularMovieEntry.COLUMN_ORIGINAL_TITLE + " TEXT, "+
            PopularMovieContract.PopularMovieEntry.COLUMN_BACK_DROP_PATH + " TEXT, "+
            PopularMovieContract.PopularMovieEntry.COLUMN_ADULT + " BOOLEAN, "+
            PopularMovieContract.PopularMovieEntry.COLUMN_OVERVIEW + " TEXT, "+
            PopularMovieContract.PopularMovieEntry.COLUMN_RELEASE_DATE + " TEXT, "+

            " UNIQUE (" + PopularMovieContract.PopularMovieEntry.COLUMN_MOVIE_ID + ") ON CONFLICT REPLACE" + " );";

    public static final String SQL_CREATE_GENRE_TABLE = "CREATE TABLE "+ PopularMovieContract.GenreEntry.TABLE_NAME + " ("+
            PopularMovieContract.GenreEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            PopularMovieContract.GenreEntry.COLUMN_GENRE_ID +  " INTEGER, "+
            PopularMovieContract.GenreEntry.COLUMN_GENRE_NAME + " TEXT, "+

            " UNIQUE (" + PopularMovieContract.GenreEntry.COLUMN_GENRE_ID + ") ON CONFLICT REPLACE" +

            " );";

    public static final String SQL_CREATE_POPULAR_MOVIE_GENRE_TABLE = "CREATE TABLE "+ PopularMovieContract.PopularMovieGenreEntry.TABLE_NAME + " ("+
            PopularMovieContract.PopularMovieGenreEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            PopularMovieContract.PopularMovieGenreEntry.COLUMN_MOVIE_ID + " INTEGER, "+
            PopularMovieContract.PopularMovieGenreEntry.COLUMN_GENRE_ID + " INTEGER, "+

            " UNIQUE (" + PopularMovieContract.PopularMovieGenreEntry.COLUMN_MOVIE_ID + ") ON CONFLICT REPLACE" +
            " UNIQUE (" + PopularMovieContract.PopularMovieGenreEntry.COLUMN_GENRE_ID + ") ON CONFLICT REPLACE" +

            " );";

    public PopularMovieDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_POPULAR_MOVIE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_GENRE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_POPULAR_MOVIE_GENRE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PopularMovieContract.PopularMovieGenreEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PopularMovieContract.GenreEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PopularMovieContract.PopularMovieEntry.TABLE_NAME);

        onCreate(sqLiteDatabase);
    }
}

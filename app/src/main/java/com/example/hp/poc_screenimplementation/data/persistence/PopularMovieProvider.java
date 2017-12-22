package com.example.hp.poc_screenimplementation.data.persistence;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by HP on 12/21/2017.
 */

public class PopularMovieProvider extends ContentProvider {

    public static final int POPULAR_MOVIE = 100;
    public static final int GENRE = 200;
    public static final int POPULAR_MOVIE_GENRE = 300;

    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private PopularMovieDBHelper popularMovieDBHelper;

    private static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(PopularMovieContract.CONTENT_AUTHORITY, PopularMovieContract.PATH_POPULAR_MOVIE, POPULAR_MOVIE);
        uriMatcher.addURI(PopularMovieContract.CONTENT_AUTHORITY, PopularMovieContract.PATH_GENRE, GENRE);
        uriMatcher.addURI(PopularMovieContract.CONTENT_AUTHORITY, PopularMovieContract.PATH_POPULAR_MOVIE_GENRE, POPULAR_MOVIE_GENRE);

        return uriMatcher;
    }

    private String getTableName(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case POPULAR_MOVIE:
                return PopularMovieContract.PopularMovieEntry.TABLE_NAME;
            case GENRE:
                return PopularMovieContract.GenreEntry.TABLE_NAME;
            case POPULAR_MOVIE_GENRE:
                return PopularMovieContract.PopularMovieGenreEntry.TABLE_NAME;

        }
        return null;
    }

    private Uri getContentUri(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case POPULAR_MOVIE:
                return PopularMovieContract.PopularMovieEntry.CONTENT_URI;
            case GENRE:
                return PopularMovieContract.GenreEntry.CONTENT_URI;
            case POPULAR_MOVIE_GENRE:
                return PopularMovieContract.PopularMovieGenreEntry.CONTENT_URI;
        }
        return null;
    }

    @Override
    public boolean onCreate() {
        popularMovieDBHelper = new PopularMovieDBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor queryCursor =  popularMovieDBHelper.getReadableDatabase().query(getTableName(uri),
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);

        if (getContext()!=null){
            queryCursor.setNotificationUri(getContext().getContentResolver(),uri);
        }
        return queryCursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case POPULAR_MOVIE:
                return PopularMovieContract.PopularMovieEntry.DIR_TYPE;
            case GENRE:
                return PopularMovieContract.GenreEntry.DIR_TYPE;
            case POPULAR_MOVIE_GENRE:
                return PopularMovieContract.PopularMovieGenreEntry.DIR_TYPE;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase db = popularMovieDBHelper.getWritableDatabase();
        String tableName = getTableName(uri);
        long _id = db.insert(tableName, null, contentValues);
        if (_id > 0) {
            Uri tableContentUri = getContentUri(uri);
            Uri insertedUri = ContentUris.withAppendedId(tableContentUri, _id);

            if (getContext() != null) {
                getContext().getContentResolver().notifyChange(uri, null);
            }
            return insertedUri;
        }

        return null;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        SQLiteDatabase db = popularMovieDBHelper.getWritableDatabase();
        String tableName = getTableName(uri);
        int insertedCount = 0;

        try {
            db.beginTransaction();
            for (ContentValues cv : values) {
                long _id = db.insert(tableName, null, cv);
                if (_id > 0) {
                    insertedCount++;
                }
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }

        if (getContext() != null) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return insertedCount;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = popularMovieDBHelper.getWritableDatabase();
        String tableName = getTableName(uri);
        int rowDeleted;

        rowDeleted = db.delete(tableName, selection, selectionArgs);
        if (rowDeleted > 0 && getContext() != null) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowDeleted;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = popularMovieDBHelper.getWritableDatabase();
        String tableName = getTableName(uri);
        int rowUpdated;

        rowUpdated = db.update(tableName, contentValues, selection, selectionArgs);
        if (rowUpdated > 0 && getContext() != null) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowUpdated;
    }
}

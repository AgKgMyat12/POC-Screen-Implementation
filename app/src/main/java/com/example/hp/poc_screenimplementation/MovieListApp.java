package com.example.hp.poc_screenimplementation;

import android.app.Application;

import com.example.hp.poc_screenimplementation.data.model.PopularMovieModel;

/**
 * Created by HP on 11/10/2017.
 */

public class MovieListApp extends Application {
    public static final String LOG_TAG = "MovieListApp";

    @Override
    public void onCreate() {
        super.onCreate();
        PopularMovieModel.getObjInstance().startPopularMovieLoaded();
    }
}

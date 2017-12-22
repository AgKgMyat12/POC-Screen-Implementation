package com.example.hp.poc_screenimplementation.data.model;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.hp.poc_screenimplementation.MovieListApp;
import com.example.hp.poc_screenimplementation.data.persistence.PopularMovieContract;
import com.example.hp.poc_screenimplementation.data.vo.PopularMovieVO;
import com.example.hp.poc_screenimplementation.events.PopularMoviesEvent;
import com.example.hp.poc_screenimplementation.network.PopularMovieDataAgentImpl;
import com.example.hp.poc_screenimplementation.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 12/7/2017.
 */

public class PopularMovieModel {

    public static PopularMovieModel objInstance;
    private int pageIndex = 1;
    private List<PopularMovieVO> mPopularMovies;

    public PopularMovieModel() {
        EventBus.getDefault().register(this);
        mPopularMovies = new ArrayList<>();
    }

    public static PopularMovieModel getObjInstance() {
        if (objInstance == null){
            objInstance = new PopularMovieModel();
        }
        return objInstance;
    }

    public void startPopularMovieLoaded(Context context){
        PopularMovieDataAgentImpl.getObjInstance().loadPopularMovie(AppConstants.ACCESS_TOKEN, pageIndex, context);
    }

    public void loadMoreMovies(Context context) {
        PopularMovieDataAgentImpl.getObjInstance().loadPopularMovie(AppConstants.ACCESS_TOKEN, pageIndex, context);
    }

    public List<PopularMovieVO> getPopularMovie() {
        return mPopularMovies;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsDataLoaded(PopularMoviesEvent.PopularMoviesLoaded event){
        mPopularMovies.addAll(event.getPopularMovie());
        pageIndex = event.getPageNo()+1;

        ContentValues[] popularMovieCVs = new ContentValues[event.getPopularMovie().size()];
        for (int index=0; index< popularMovieCVs.length; index++){
            popularMovieCVs[index] = event.getPopularMovie().get(index).parseToContentValues();
        }
        int insertedRow = event.getContext().getContentResolver().bulkInsert(PopularMovieContract.PopularMovieEntry.CONTENT_URI, popularMovieCVs);
        Log.d(MovieListApp.LOG_TAG, "Inserted Row : " + insertedRow);
    }

    public void forceRefreshNews(Context context) {
        mPopularMovies = new ArrayList<>();
        pageIndex = 1;
        startPopularMovieLoaded(context);
    }
}

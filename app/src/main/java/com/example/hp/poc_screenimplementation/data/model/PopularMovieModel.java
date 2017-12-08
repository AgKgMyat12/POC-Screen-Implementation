package com.example.hp.poc_screenimplementation.data.model;

import com.example.hp.poc_screenimplementation.data.vo.PopularMovieVO;
import com.example.hp.poc_screenimplementation.events.PopularMoviesEvent;
import com.example.hp.poc_screenimplementation.network.PopularMovieDataAgentImpl;
import com.example.hp.poc_screenimplementation.utils.AppConstants;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by HP on 12/7/2017.
 */

public class PopularMovieModel {

    public static PopularMovieModel objInstance;
    private int pageIndex = 1;
    private List<PopularMovieVO> mPopularMovies;

    public PopularMovieModel() {

    }

    public static PopularMovieModel getObjInstance() {
        if (objInstance == null){
            objInstance = new PopularMovieModel();
        }
        return objInstance;
    }

    public void startPopularMovieLoaded(){
        PopularMovieDataAgentImpl.getObjInstance().loadPopularMovie(AppConstants.ACCESS_TOKEN,pageIndex);
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onNewsDataLoaded(PopularMoviesEvent.PopularMoviesLoaded event){
//        mPopularMovies.addAll(event.getPopularMovie());
//        pageIndex = event.getPageNo()+1;
//    }
}

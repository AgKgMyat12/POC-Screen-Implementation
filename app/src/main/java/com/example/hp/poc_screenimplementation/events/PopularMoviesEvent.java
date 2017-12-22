package com.example.hp.poc_screenimplementation.events;

import android.content.Context;

import com.example.hp.poc_screenimplementation.data.vo.PopularMovieVO;

import java.util.List;

/**
 * Created by HP on 12/8/2017.
 */

public class PopularMoviesEvent {
    public static class PopularMoviesLoaded{
        private int pageNo;
        private List<PopularMovieVO> popularMovie;
        private Context context;

        public PopularMoviesLoaded(int pageNo, List<PopularMovieVO> popularMovie, Context context) {
            this.pageNo = pageNo;
            this.popularMovie = popularMovie;
            this.context = context;
        }

        public int getPageNo() {
            return pageNo;
        }

        public List<PopularMovieVO> getPopularMovie() {
            return popularMovie;
        }

        public Context getContext() {
            return context;
        }
    }

    public static class EmptyResponseEvent {
        private String emptyMsg;

        public EmptyResponseEvent(String emptyMsg) {
            this.emptyMsg = emptyMsg;
        }

        public String getEmptyMsg() {
            return emptyMsg;
        }
    }

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

}

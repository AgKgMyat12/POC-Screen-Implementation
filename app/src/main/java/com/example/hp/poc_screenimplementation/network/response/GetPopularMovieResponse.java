package com.example.hp.poc_screenimplementation.network.response;

import com.example.hp.poc_screenimplementation.data.vo.PopularMovieVO;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 12/7/2017.
 */

public class GetPopularMovieResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int page;

    @SerializedName("popular-movies")
    private List<PopularMovieVO> popularMovies;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPage() {
        return page;
    }

    public List<PopularMovieVO> getPopularMovies() {
        if (popularMovies == null){
            popularMovies = new ArrayList<>();
        }
        return popularMovies;
    }
}

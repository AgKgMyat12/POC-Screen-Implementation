package com.example.hp.poc_screenimplementation.network;

import com.example.hp.poc_screenimplementation.network.response.GetPopularMovieResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by HP on 12/8/2017.
 */

public interface PopularMovieAPI {

    @FormUrlEncoded
    @POST("v1/getPopularMovies.php")
    Call<GetPopularMovieResponse> loadPopularMovie(@Field("access_token") String accessToken,
                                            @Field("page") int page);
}

package com.example.hp.poc_screenimplementation.network;

import com.example.hp.poc_screenimplementation.events.PopularMoviesEvent;
import com.example.hp.poc_screenimplementation.network.response.GetPopularMovieResponse;
import com.example.hp.poc_screenimplementation.utils.AppConstants;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 12/8/2017.
 */

public class PopularMovieDataAgentImpl implements PopularMovieDataAgent {

    public static PopularMovieDataAgentImpl objInstance;
    private PopularMovieAPI theAPI;

    public PopularMovieDataAgentImpl() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        theAPI = retrofit.create(PopularMovieAPI.class);

    }

    public static PopularMovieDataAgentImpl getObjInstance() {
        if (objInstance == null){
            objInstance = new PopularMovieDataAgentImpl();
        }
        return  objInstance;
    }

    @Override
    public void loadPopularMovie(String accessToken, int page) {
        Call<GetPopularMovieResponse> loadPopularMovieCall = theAPI.loadPopularMovie(accessToken, page);
        loadPopularMovieCall.enqueue(new Callback<GetPopularMovieResponse>() {
            @Override
            public void onResponse(Call<GetPopularMovieResponse> call, Response<GetPopularMovieResponse> response) {
                GetPopularMovieResponse getPopularMovieResponse = response.body();
                if (getPopularMovieResponse != null && getPopularMovieResponse.getPopularMovies().size()>0){
                    PopularMoviesEvent.PopularMoviesLoaded popularMoviesLoaded = new PopularMoviesEvent.PopularMoviesLoaded(getPopularMovieResponse.getPage(),
                            getPopularMovieResponse.getPopularMovies());
                    EventBus.getDefault().post(popularMoviesLoaded);
                }
                else {
                    PopularMoviesEvent.EmptyResponseEvent emptyResponseEvent= new PopularMoviesEvent.EmptyResponseEvent("No data to show. Try again later!");
                    EventBus.getDefault().post(emptyResponseEvent);
                }
            }

            @Override
            public void onFailure(Call<GetPopularMovieResponse> call, Throwable t) {
                PopularMoviesEvent.ErrorInvokingAPIEvent errorInvokingAPIEvent = new PopularMoviesEvent.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorInvokingAPIEvent);
            }
        });
    }
}

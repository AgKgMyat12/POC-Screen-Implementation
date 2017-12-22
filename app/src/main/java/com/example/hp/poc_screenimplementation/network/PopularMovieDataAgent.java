package com.example.hp.poc_screenimplementation.network;

import android.content.Context;

/**
 * Created by HP on 12/8/2017.
 */

public interface PopularMovieDataAgent {
    void loadPopularMovie(String accessToken, int page, Context context);
}

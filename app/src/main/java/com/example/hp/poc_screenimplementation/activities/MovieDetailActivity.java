package com.example.hp.poc_screenimplementation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.hp.poc_screenimplementation.R;
import com.example.hp.poc_screenimplementation.adapters.TrailerMovieAdapter;
import com.example.hp.poc_screenimplementation.components.SmartRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HP on 12/15/2017.
 */

public class MovieDetailActivity extends AppCompatActivity {

    @BindView(R.id.srv_movie_trailers)
    SmartRecyclerView srvMovieTrailers;

    private TrailerMovieAdapter mTrailerMovieAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this,this);

        mTrailerMovieAdapter = new TrailerMovieAdapter(getApplicationContext());
        srvMovieTrailers.setAdapter(mTrailerMovieAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        srvMovieTrailers.setLayoutManager(linearLayoutManager);

    }
}

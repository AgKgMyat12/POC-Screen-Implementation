package com.example.hp.poc_screenimplementation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.poc_screenimplementation.R;
import com.example.hp.poc_screenimplementation.adapters.MovieAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HP on 11/10/2017.
 */

public class UpComingFragment extends Fragment {

    @BindView(R.id.rv_movie_list)
    RecyclerView rvMovieList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming,container,false);
        ButterKnife.bind(this,view);

        MovieAdapter movieAdapter = new MovieAdapter(getContext());
        rvMovieList.setAdapter(movieAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        rvMovieList.setLayoutManager(linearLayoutManager);
        return view;
    }
}

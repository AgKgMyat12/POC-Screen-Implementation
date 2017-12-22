package com.example.hp.poc_screenimplementation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.poc_screenimplementation.R;
import com.example.hp.poc_screenimplementation.viewholders.TrailerMovieViewHolder;

/**
 * Created by HP on 12/16/2017.
 */

public class TrailerMovieAdapter extends RecyclerView.Adapter<TrailerMovieViewHolder> {

    public LayoutInflater mLayoutInflator;

    public TrailerMovieAdapter(Context context){
        mLayoutInflator = LayoutInflater.from(context);
    }

    @Override
    public TrailerMovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View trailerItemView = mLayoutInflator.inflate(R.layout.view_item_movie_trailer,parent,false);
        return new TrailerMovieViewHolder(trailerItemView);
    }

    @Override
    public void onBindViewHolder(TrailerMovieViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}

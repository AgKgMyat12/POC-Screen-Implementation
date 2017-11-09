package com.example.hp.poc_screenimplementation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.poc_screenimplementation.R;
import com.example.hp.poc_screenimplementation.viewholders.MovieViewHolders;

/**
 * Created by HP on 11/10/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolders> {
    private LayoutInflater mLayoutInflator;

    public MovieAdapter(Context context){
        mLayoutInflator = LayoutInflater.from(context);
    }

    @Override
    public MovieViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View movieItemView = mLayoutInflator.inflate(R.layout.view_item_movie, parent, false);
        return new MovieViewHolders(movieItemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolders holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}

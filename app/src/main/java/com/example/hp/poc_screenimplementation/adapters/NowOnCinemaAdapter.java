package com.example.hp.poc_screenimplementation.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.poc_screenimplementation.R;
import com.example.hp.poc_screenimplementation.data.vo.PopularMovieVO;
import com.example.hp.poc_screenimplementation.viewholders.NowOnCinemaViewHolder;

/**
 * Created by HP on 11/10/2017.
 */

public class NowOnCinemaAdapter extends BaseRecyclerAdapter<NowOnCinemaViewHolder, PopularMovieVO> {

    public NowOnCinemaAdapter(Context context) {
        super(context);
    }

    @Override
    public NowOnCinemaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View movieItemView = mLayoutInflater.inflate(R.layout.view_item_movie, parent, false);
        return new NowOnCinemaViewHolder(movieItemView);
    }
}

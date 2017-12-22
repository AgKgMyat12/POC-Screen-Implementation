package com.example.hp.poc_screenimplementation.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hp.poc_screenimplementation.R;
import com.example.hp.poc_screenimplementation.data.vo.PopularMovieVO;
import com.example.hp.poc_screenimplementation.utils.AppConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HP on 11/10/2017.
 */

public class UpComingViewHolder extends BaseViewHolder<PopularMovieVO> {

    @BindView(R.id.tv_rating_point)
    TextView tvRatingPoint;

    @BindView(R.id.tv_movie_name)
    TextView tvMovieName;

    @BindView(R.id.iv_movie_poster)
    ImageView ivMoviePoster;


    public UpComingViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(PopularMovieVO data) {
        tvRatingPoint.setText(String.valueOf(data.getVoteAverage()));
        tvMovieName.setText(data.getOriginalTitle());

        if (data.getPosterPath() != null) {
            Glide
                    .with(ivMoviePoster)
                    .load(AppConstants.MOVIE_POSTER_URL+data.getPosterPath())
                    .into(ivMoviePoster);
        }
    }

    @Override
    public void onClick(View view) {

    }
}

package com.example.hp.poc_screenimplementation.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.hp.poc_screenimplementation.fragments.MostPopularFragment;
import com.example.hp.poc_screenimplementation.fragments.NowOnCinemaFragment;
import com.example.hp.poc_screenimplementation.fragments.UpComingFragment;

/**
 * Created by HP on 11/10/2017.
 */

public class TabLayoutPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    public TabLayoutPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                NowOnCinemaFragment nowOnCinemaFragment = new NowOnCinemaFragment();
                return nowOnCinemaFragment;
            case 1:
                UpComingFragment upComingFragment = new UpComingFragment();
                return  upComingFragment;
            case 2:
                MostPopularFragment mostPopularFragment = new MostPopularFragment();
                return mostPopularFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}

package com.example.myapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private Integer [] images = {R.drawable.onboarding_00, R.drawable.onboarding_01, R.drawable.onboarding_03, R.drawable.onboarding_05};

    public ScreenSlidePagerAdapter(FragmentManager supportFragmentManager ) {
        super(supportFragmentManager);
    }


    @Override
    public Fragment getItem(int position) {
        return new ScreenSlidePageFragment(position);
    }

    @Override
    public int getCount() {
        return images.length;
    }





}

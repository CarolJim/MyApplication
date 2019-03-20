package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ScreenSlidePagerActivity extends FragmentActivity {

    public static final int NUM_PAGES = 5;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    public TabLayout tabLayout;
    public TextView skeepIntro;
    private LinearLayout saltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        skeepIntro = findViewById(R.id.skeep_intro);
        saltar = findViewById(R.id.saltar);

        initViews();
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    public void initViews() {
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mPager, true);
        setAdapter();

        skeepIntro.setOnClickListener(this::onClick);
        SpannableString text = new SpannableString("Saltar Intro");
        text.setSpan(new UnderlineSpan(), 0, text.length(), 0);
        skeepIntro.setText(text);
        skeepIntro.setTextColor(Color.parseColor("#FFFFFF"));
    }

    public void showNext(boolean flag) {
        if (flag) {
            saltar.setVisibility(View.VISIBLE);
        } else {
            saltar.setVisibility(View.GONE);
        }
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.skeep_intro:
                Intent intent = new Intent(ScreenSlidePagerActivity.this, MainActivity.class);
                startActivity(intent);
                showNext(false);
                break;
        }
    }

    void setAdapter() {
        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

        mPager.setAdapter(pagerAdapter);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    skeepIntro.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    skeepIntro.setTextColor(Color.parseColor("#00A1E1"));
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        mPager.setCurrentItem(0);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mPager, true);

    }

}

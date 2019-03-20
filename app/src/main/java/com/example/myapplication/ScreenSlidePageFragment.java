package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

@SuppressLint("ValidFragment")
public class ScreenSlidePageFragment extends Fragment {

    View rootView;
    private ImageView imageView;
    private int index;

    public ScreenSlidePageFragment(int index) {
        this.index = index;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        imageView = rootView.findViewById(R.id.image_slide);
        initViews();

        return rootView;
    }

    public void initViews(){
        fill();
    }

    void fill(){
        switch (index){
            case 0:
                Picasso.get()
                        .load(R.drawable.onboarding_00)
                        .into(imageView);
                break;
            case 1:
                Picasso.get()
                        .load(R.drawable.onboarding_01)
                        .into(imageView);
                break;
            case 2:
                Picasso.get()
                        .load(R.drawable.onboarding_03)
                        .into(imageView);
                break;
            case 3:
                Picasso.get()
                        .load(R.drawable.onboarding_05)
                        .into(imageView);
                break;


        }
    }
}

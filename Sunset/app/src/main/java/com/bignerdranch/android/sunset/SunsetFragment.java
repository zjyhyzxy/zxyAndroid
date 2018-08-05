package com.bignerdranch.android.sunset;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;

/**
 * Created by 54063 on 2018/7/24.
 */

public class SunsetFragment extends Fragment {

    private View mSceneView;
    private View mSunView;
    private View mSkyView;
    private int mBlueSkyColor;
    private int mSunsetSkyColor;
    private int mNightSkyColor;
    private int mClickSum=0;
    private float mFirstYStart;
    private float mFirstYEnd;

    public static SunsetFragment newInstance(){
        return new SunsetFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_sunset , container , false);

        mSceneView = view;
        mSunView = view.findViewById(R.id.sun);
        mSkyView = view.findViewById(R.id.sky);


        Resources resources = getResources();
        mBlueSkyColor = resources.getColor(R.color.blue_sky);
        mSunsetSkyColor = resources.getColor(R.color.sunset_sky);
        mNightSkyColor = resources.getColor(R.color.night_sky);


        mSceneView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mClickSum++;
                if(mClickSum % 2 == 1){
                    startAnimation();
                }
                if(mClickSum % 2 == 0){
                    startAnimationAgain();
                }
            }
        });
        return view;


    }



    private void startAnimation(){

        float sunYStart = mSunView.getTop();
        float sunYEnd = mSkyView.getHeight();
        mFirstYStart = sunYStart;
        mFirstYEnd = sunYEnd;

        ObjectAnimator heightAnimator = ObjectAnimator.ofFloat(mSunView , "y" , sunYStart , sunYEnd)
                .setDuration(3000);
        heightAnimator.setInterpolator(new AccelerateInterpolator());

        ObjectAnimator sunsetSkyAnimator = ObjectAnimator.ofInt(mSkyView , "backgroundColor" , mBlueSkyColor , mSunsetSkyColor)
                .setDuration(3000);
        sunsetSkyAnimator.setEvaluator(new ArgbEvaluator());

       ObjectAnimator nightSkyAnimator = ObjectAnimator.ofInt(mSkyView , "backgroundColor" , mSunsetSkyColor , mNightSkyColor)
               .setDuration(1500);
       nightSkyAnimator.setEvaluator(new ArgbEvaluator());

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet
                .play(heightAnimator)
                .with(sunsetSkyAnimator)
                .before(nightSkyAnimator);
        animatorSet.start();
    }

    private void startAnimationAgain(){

        float sunYEnd = mFirstYEnd;
        float sunYStart = mFirstYStart;

        ObjectAnimator heightAnimator = ObjectAnimator.ofFloat(mSunView , "y" , sunYEnd , sunYStart)
                .setDuration(3000);
        heightAnimator.setInterpolator(new AccelerateInterpolator());

        ObjectAnimator sunsetSkyAnimator = ObjectAnimator.ofInt(mSkyView , "backgroundColor" , mSunsetSkyColor , mBlueSkyColor)
                .setDuration(3000);
        sunsetSkyAnimator.setEvaluator(new ArgbEvaluator());

        ObjectAnimator nightSkyAnimator = ObjectAnimator.ofInt(mSkyView , "backgroundColor" , mNightSkyColor , mSunsetSkyColor )
                .setDuration(1500);
        nightSkyAnimator.setEvaluator(new ArgbEvaluator());

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet
                .play(heightAnimator)
                .with(sunsetSkyAnimator)
                .after(nightSkyAnimator);
        animatorSet.start();
    }

}

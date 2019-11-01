package com.pcube.cocotab.Fragments;


import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;

import com.pcube.cocotab.Adapter.ImageData;
import com.pcube.cocotab.R;
import com.pcube.cocotab.databinding.FragmentAlexaBinding;

import java.util.List;
import java.util.Random;


public class AlexaFragment extends Fragment implements View.OnClickListener {

    FragmentAlexaBinding binding;
    List<ImageData> imageData;
    ViewGroup hiddenPanel;
    public AlexaFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_alexa, container, false);
        View view = binding.getRoot();

        return view;
    }

    public void slideUpView(){
        Animation bottomUp = AnimationUtils.loadAnimation(getActivity(),
                R.anim.bottom_up);

        hiddenPanel.startAnimation(bottomUp);
        hiddenPanel.setVisibility(View.VISIBLE);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_roulette:
                //rotateAnimation(binding.imageRoulette);
                break;
        }

    }

    public void rotateAnimation(View view) {
        int corner = 360 / 38; // corner for point
        int randPosition = corner * new Random().nextInt(38); // random point
        int MIN = 2; // min rotation
        int MAX = 6; // max rotation
        long TIME_IN_WHEEL = 1000;  // time in one rotation
        int randRotation = MIN + new Random().nextInt(MAX - MIN); // random rotation
        int truePosition = randRotation * 360 + randPosition;
        long totalTime = TIME_IN_WHEEL * randRotation + (TIME_IN_WHEEL / 360) * randPosition;

        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 0f, (float) truePosition);
        animator.setDuration(totalTime);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                //imageRoulette.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //imageRoulette.setEnabled(true);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();

    }

    public static void expand(final View v) {
        int matchParentMeasureSpec = View.MeasureSpec.makeMeasureSpec(((View) v.getParent()).getWidth(), View.MeasureSpec.EXACTLY);
        int wrapContentMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        v.measure(matchParentMeasureSpec, wrapContentMeasureSpec);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? ViewGroup.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density) * 4);
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };


        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density) * 4);
        v.startAnimation(a);
    }

}

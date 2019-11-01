package com.pcube.cocotab.Activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

import com.pcube.cocotab.R;
import com.pcube.cocotab.databinding.ActivityAlexaBinding;

import java.util.Random;

public class AlexaActivity extends AppCompatActivity {

    ActivityAlexaBinding binding;
    private boolean isVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_alexa);

            new CountDownTimer(2000, 500) {
                public void onTick(long millisUntilFinished) {
                    slideUpView();
                }

                public void onFinish() {
                  rotateAnimation(binding.imageRoulette);
                  rotateAnimation(binding.rlRotate);
                }
            }.start();


            binding.rl1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    binding.rl1.setBackgroundResource(R.drawable.rotate_toggle_drawable);
                    binding.rl2.setBackgroundResource(R.drawable.custom_circle_layout_with_stroke);
                    binding.rl3.setBackgroundResource(R.drawable.custom_circle_layout_with_stroke);
                }
            });

        binding.rl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.rl1.setBackgroundResource(R.drawable.custom_circle_layout_with_stroke);
                binding.rl2.setBackgroundResource(R.drawable.rotate_toggle_drawable);
                binding.rl3.setBackgroundResource(R.drawable.custom_circle_layout_with_stroke);
            }
        });

        binding.rl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.rl1.setBackgroundResource(R.drawable.custom_circle_layout_with_stroke);
                binding.rl2.setBackgroundResource(R.drawable.custom_circle_layout_with_stroke);
                binding.rl3.setBackgroundResource(R.drawable.rotate_toggle_drawable);
            }
        });

    }



    public void rotateAnimation(View view) {
        int corner = 360/38; // corner for point
        int randPosition = corner * new Random().nextInt(38); // random point
        int MIN = 2; // min rotation
        int MAX = 6; // max rotation
        long TIME_IN_WHEEL = 1000;  // time in one rotation
        int randRotation = MIN + new Random().nextInt(MAX-MIN); // random rotation
        int truePosition =  randRotation * 360 + randPosition;
        long totalTime = TIME_IN_WHEEL * randRotation + (TIME_IN_WHEEL/360) * randPosition;

        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",0f,(float)truePosition);
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

    public void slideUp(){
        binding.rlToggle.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(
                0,
                0,
                binding.imageRoulette.getHeight(),
                0);
        animate.setDuration(3000);
        animate.setFillAfter(true);
        binding.imageRoulette.startAnimation(animate);
    }


    public void slideDown(View view){
        TranslateAnimation animate = new TranslateAnimation(
                0,
                0,
                0,
                view.getHeight());
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }


    public void slideUpView(){
        Animation bottomUp = AnimationUtils.loadAnimation(this,
                R.anim.bottom_up);
        ViewGroup hiddenPanel = (ViewGroup)findViewById(R.id.rlToggle);
        hiddenPanel.startAnimation(bottomUp);
        hiddenPanel.setVisibility(View.VISIBLE);
    }


}

package com.example.project2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static int SPLASH_TIME_OUT = 2000;
    private ConstraintLayout constraintLayout;
    private ConstraintSet constraintSet1 = new ConstraintSet();
    private ConstraintSet constraintSet2 = new ConstraintSet();
    private boolean altLayout;
    Button button;
    private AnimationDrawable animationDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout=findViewById(R.id.layout);
        constraintSet1.clone(constraintLayout);
        constraintSet2.clone(this,R.layout.activity_intro);

        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);


            }
        });

        // init constraintLayout
        constraintLayout = (ConstraintLayout) findViewById(R.id.layout);

        // initializing animation drawable by getting background from constraint layout
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();

        // setting enter fade animation duration to 5 seconds
        animationDrawable.setEnterFadeDuration(5000);

        // setting exit fade animation duration to 2 seconds
        animationDrawable.setExitFadeDuration(2000);






//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent homeIntent = new Intent(MainActivity.this, IntroActivity.class);
//                startActivity(homeIntent);
//
//            }
//        },SPLASH_TIME_OUT);
    }

    public void click(View v){
        Log.d("click", "click: Clicked");
        TransitionManager.beginDelayedTransition(constraintLayout);

        if(!altLayout){
            constraintSet2.applyTo(constraintLayout);
            altLayout=true;

        }else{
            constraintSet1.applyTo(constraintLayout);
            altLayout=false;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            // start the animation
            animationDrawable.start();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning()) {
            // stop the animation
            animationDrawable.stop();
        }
    }



}

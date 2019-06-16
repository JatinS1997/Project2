package com.example.project2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IntroActivity extends Activity {


    Button button;
    private AnimationDrawable animationDrawable;
    private ConstraintLayout constraintLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(IntroActivity.this, HomeActivity.class);
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
    }


    public void doSomething(View v) {


            Toast toast = Toast.makeText(this, "Working", Toast.LENGTH_SHORT);
            toast.show();
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);


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
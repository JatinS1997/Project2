package com.example.project2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IntroActivity extends Activity {


    Button button;

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
    }


    public void doSomething(View v) {


            Toast toast = Toast.makeText(this, "Working", Toast.LENGTH_SHORT);
            toast.show();
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);


    }
}
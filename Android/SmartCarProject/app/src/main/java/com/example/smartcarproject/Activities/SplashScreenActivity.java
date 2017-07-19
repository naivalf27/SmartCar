package com.example.smartcarproject.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.smartcarproject.R;

/**
 * Created by Remi on 18/07/2017.
 */

public class SplashScreenActivity extends Activity {

    private static int TIMER = 3500;
    Intent i;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                    i = new Intent(SplashScreenActivity.this, DeviceListActivity.class);

                startActivity(i);
                overridePendingTransition(R.animator.slide_from_right, R.animator.slide_to_left);
                finish();
            }
        }, TIMER);
    }
}
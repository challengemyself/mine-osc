package com.example.lu.mine_osc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class AppStart extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this,R.layout.activity_app_start,null);
        setContentView(view);
        AlphaAnimation aa = new AlphaAnimation(0.5f,1.0f);
        aa.setDuration(800);
        view.startAnimation(aa);
        aa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                redirectTo();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void redirectTo() {
        Intent uploadLog = new Intent(AppStart.this,LogUploadService.class);
        startService(uploadLog);
        Intent intent = new Intent(AppStart.this,MainActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_app_start, menu);
        return true;
    }

}

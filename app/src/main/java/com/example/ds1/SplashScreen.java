package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.hammer);
        mp.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                finish();
                startActivity(intent);
            }
        },2000);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }
}

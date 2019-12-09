package com.example.ds1;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.widget.TextView;

public class GeraralFunction {

    /*public void CountDown(final Context context, final Class<?> cls,final TextView tv) {
        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                tv.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(context, cls);
                finish();
                startActivity(intent);
            }
        }.start();
    }*/

    @SuppressLint("WrongConstant")
    public void TextAnim(TextView tv,int value1,int value2){
        ObjectAnimator anim = ObjectAnimator.ofInt(tv, "textColor", value1, value2,
                value1);
        anim.setDuration(1500);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
    }

}

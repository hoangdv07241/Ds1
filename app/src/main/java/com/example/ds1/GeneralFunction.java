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

public class GeneralFunction {

    @SuppressLint("WrongConstant")
    public void TextAnim(TextView tv,int value1,int value2, long duration){
        ObjectAnimator anim = ObjectAnimator.ofInt(tv, "textColor", value1, value2,
                value1);
        anim.setDuration(duration);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
    }

}

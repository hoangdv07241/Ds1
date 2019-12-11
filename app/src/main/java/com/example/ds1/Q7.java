package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ds1.databinding.ActivityQ3Binding;

public class Q7 extends AppCompatActivity implements ViewDs1{

    ImageView ivQ7home;
    TextView tvQ7up, tvQ7left, tvQ7right, tvQ7down, tvQ7sc;
    PresenterDs1 presenterDs1;
    GeraralFunction gf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ3Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q7);
        TextBinding textBinding = new TextBinding("UP","LEFT","RIGHT","DOWN",null,null);
        binding.setTextBinding(textBinding);

        presenterDs1 = new PresenterDs1(this);
        gf = new GeraralFunction();
        ivQ7home = findViewById(R.id.ivQ7home);
        tvQ7sc = findViewById(R.id.tvQ7sc);
        tvQ7up = findViewById(R.id.tvQ7up);
        tvQ7left = findViewById(R.id.tvQ7left);
        tvQ7right = findViewById(R.id.tvQ7right);
        tvQ7down = findViewById(R.id.tvQ7down);

        gf.TextAnim(tvQ7up,Color.WHITE,Color.RED,500);
        gf.TextAnim(tvQ7down,Color.WHITE,Color.GREEN,500);

        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                tvQ7sc.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Q7.this, Lose.class);
                finish();
                startActivity(intent);
            }
        }.start();

        ivQ7home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDs1.ActivitiesNavigate();
            }
        });
        tvQ7up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDs1.Wrong();
            }
        });
        tvQ7left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDs1.Right();
            }
        });
        tvQ7right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDs1.Wrong();
            }
        });
        tvQ7down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDs1.Wrong();
            }
        });
    }

    @Override
    public void ActivitiesNavigate() {
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void Reset() {

    }

    @Override
    public void Help() {

    }

    @Override
    public void Right() {
        Intent intent = new Intent(this, Q4.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void Wrong() {
        Intent intent = new Intent(this, WrongWay.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void Other() {

    }
}

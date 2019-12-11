package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ds1.databinding.ActivityQ3Binding;

public class Q3 extends AppCompatActivity implements ViewDs1{

    ImageView ivQ3home;
    TextView tvQ3up,tvQ3left,tvQ3right,tvQ3down,tvQ3sc;
    PresenterDs1 presenterDs1;
    GeneralFunction gf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ3Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q3);
        TextBinding textBinding = new TextBinding("UP","LEFT","CHỌN","DOWN",null,null);
        binding.setTextBinding(textBinding);

        presenterDs1 = new PresenterDs1(this);
        gf = new GeneralFunction();
        ivQ3home = findViewById(R.id.ivQ3home);
        tvQ3sc = findViewById(R.id.tvQ3sc);
        tvQ3up = findViewById(R.id.tvQ3up);
        tvQ3left = findViewById(R.id.tvQ3left);
        tvQ3right = findViewById(R.id.tvQ3right);
        tvQ3down = findViewById(R.id.tvQ3down);

        gf.TextAnim(tvQ3up,Color.WHITE,Color.RED,500);

        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                tvQ3sc.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Q3.this, Lose.class);
                finish();
                startActivity(intent);
            }
        }.start();

        if(GeneralFunction.score == 4){
            tvQ3up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    countDownTimer.cancel();
                    presenterDs1.Help();
                }
            });
        }

        ivQ3home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDs1.ActivitiesNavigate();
            }
        });
        tvQ3up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDs1.Wrong();
            }
        });
        tvQ3left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDs1.Right();
            }
        });
        tvQ3right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tvQ3down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDs1.Other();
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
        Intent intent = new Intent(this, Winner.class);
        finish();
        startActivity(intent);
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
        Intent intent = new Intent(this, Q3d1.class);
        finish();
        startActivity(intent);
    }

}

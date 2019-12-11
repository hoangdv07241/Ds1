package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ds1.databinding.ActivityQ7d1Binding;

public class Q7d1 extends AppCompatActivity implements ViewDs1 {

    TextView tvQ7d1sc;
    ImageView ivQ7d1Reset, ivQ7d1Home, ivTaskq7d1;
    Button btnC1Q7d1, btnC2Q7d1, btnC3Q7d1, btnC4Q7d1;
    PresenterDs1 presenterDS1;
    GeneralFunction gf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ7d1Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q7d1);
        TextBinding textBinding = new TextBinding("Đây là hình gì ?", null, "tam giác",
                "vuông", "tam giác lệch", "hình thang");
        binding.setTextBinding(textBinding);

        presenterDS1 = new PresenterDs1(this);
        gf = new GeneralFunction();

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.ding);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.rewind);

        ivTaskq7d1 = findViewById(R.id.ivTaskq7d1);
        tvQ7d1sc = findViewById(R.id.tvQ7d1sc);
        ivQ7d1Reset = findViewById(R.id.ivQ7d1Reset);
        ivQ7d1Home = findViewById(R.id.ivQ7d1Home);
        btnC1Q7d1 = findViewById(R.id.btnC1Q7d1);
        btnC2Q7d1 = findViewById(R.id.btnC2Q7d1);
        btnC3Q7d1 = findViewById(R.id.btnC3Q7d1);
        btnC4Q7d1 = findViewById(R.id.btnC4Q7d1);

        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                tvQ7d1sc.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Q7d1.this, Lose.class);
                finish();
                startActivity(intent);
            }
        }.start();

        ivQ7d1Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                countDownTimer.cancel();
                presenterDS1.Reset();
            }
        });
        ivQ7d1Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.ActivitiesNavigate();
            }
        });
        ivTaskq7d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivTaskq7d1.setRotation(ivTaskq7d1.getRotation() + 90);
                btnC3Q7d1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mp.start();
                        countDownTimer.cancel();
                        presenterDS1.Other();
                    }
                });
            }
        });
        btnC1Q7d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                countDownTimer.cancel();
                presenterDS1.Right();
            }
        });
        btnC2Q7d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC3Q7d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC4Q7d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
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
        Intent intent = new Intent(this, Q1.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void Help() {

    }

    @Override
    public void Right() {
        Intent intent = new Intent(this, Q7d2.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void Wrong() {
        Intent intent = new Intent(this, Lose.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void Other() {
        Intent intent = new Intent(this, Mark1.class);
        finish();
        startActivity(intent);
    }
}

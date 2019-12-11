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

import com.example.ds1.databinding.ActivityQ3d1Binding;

public class Q3d1 extends AppCompatActivity implements ViewDs1 {

    TextView tvQ3d1sc, tvTaskq3d1;
    ImageView ivQ3d1Reset, ivQ3d1Home;
    Button btnC1Q3d1, btnC2Q3d1, btnC3Q3d1, btnC4Q3d1;
    PresenterDs1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ3d1Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q3d1);
        TextBinding textBinding = new TextBinding("Hai không hai bốn ?", null, "2024", "0044", "2044", "0024");
        binding.setTextBinding(textBinding);

        presenterDS1 = new PresenterDs1(this);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.ding);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.rewind);

        tvTaskq3d1 = findViewById(R.id.tvTaskq3d1);
        tvQ3d1sc = findViewById(R.id.tvQ3d1sc);
        ivQ3d1Reset = findViewById(R.id.ivQ3d1Reset);
        ivQ3d1Home = findViewById(R.id.ivQ3d1Home);
        btnC1Q3d1 = findViewById(R.id.btnC1Q3d1);
        btnC2Q3d1 = findViewById(R.id.btnC2Q3d1);
        btnC3Q3d1 = findViewById(R.id.btnC3Q3d1);
        btnC4Q3d1 = findViewById(R.id.btnC4Q3d1);

        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                tvQ3d1sc.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Q3d1.this, Lose.class);
                finish();
                startActivity(intent);
            }
        }.start();

        ivQ3d1Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                countDownTimer.cancel();
                presenterDS1.Reset();
            }
        });
        ivQ3d1Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.ActivitiesNavigate();
            }
        });
        tvTaskq3d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTaskq3d1.setText("0044");
                btnC2Q3d1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mp.start();
                        countDownTimer.cancel();
                        presenterDS1.Right();
                    }
                });
            }
        });
        btnC1Q3d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC2Q3d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC3Q3d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC4Q3d1.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(this, Mark1.class);
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

    }
}

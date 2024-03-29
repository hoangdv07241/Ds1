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

import com.example.ds1.databinding.ActivityQ1Binding;

public class Q1 extends AppCompatActivity implements ViewDs1 {

    TextView tvSc,tvQ1task;
    Button btnC1Q1, btnC2Q1, btnC3Q1, btnC4Q1;
    ImageView ivReset;
    PresenterDs1 presenterDS1;
    GeneralFunction gf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ1Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q1);
        TextBinding textBinding = new TextBinding("Chọn số thích hợp", "3", "2", "3", "5", "4");
        binding.setTextBinding(textBinding);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.ding);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.button_click);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.rewind);

        tvSc = findViewById(R.id.tvSc);
        tvQ1task = findViewById(R.id.tvQ1task);
        ivReset = findViewById(R.id.ivReset);
        btnC1Q1 = findViewById(R.id.btnC1Q1);
        btnC2Q1 = findViewById(R.id.btnC2Q1);
        btnC3Q1 = findViewById(R.id.btnC3Q1);
        btnC4Q1 = findViewById(R.id.btnC4Q1);
        presenterDS1 = new PresenterDs1(this);

        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                tvSc.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Q1.this, Lose.class);
                finish();
                startActivity(intent);
            }
        }.start();

        ivReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Reset();
            }
        });
        btnC1Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC2Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC3Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                mp.start();
                presenterDS1.Right();
            }
        });
        btnC4Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
    }

    @Override
    public void ActivitiesNavigate() {

    }

    @Override
    public void Reset() {
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void Help() {

    }

    @Override
    public void Right() {
        Intent intent = new Intent(this, Q2.class);
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

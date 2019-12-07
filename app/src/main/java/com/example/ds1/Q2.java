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

import com.example.ds1.databinding.ActivityQ2Binding;

public class Q2 extends AppCompatActivity implements ViewDs1 {

    TextView tvQ2sc;
    ImageView ivQ2Reset, ivQ2Home;
    Button btnC1Q2, btnC2Q2, btnC3Q2, btnC4Q2;
    PresenterDs1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q2);
        TextBinding textBinding = new TextBinding("Chọn ô chữ thích hợp", "1", "one", "1", "3", "một");
        binding.setTextBinding(textBinding);

        presenterDS1 = new PresenterDs1(this);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.ding);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.rewind);
        tvQ2sc = findViewById(R.id.tvQ2sc);
        ivQ2Reset = findViewById(R.id.ivQ2Reset);
        ivQ2Home = findViewById(R.id.ivQ2Home);
        btnC1Q2 = findViewById(R.id.btnC1Q2);
        btnC2Q2 = findViewById(R.id.btnC2Q2);
        btnC3Q2 = findViewById(R.id.btnC3Q2);
        btnC4Q2 = findViewById(R.id.btnC4Q2);

        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                tvQ2sc.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Q2.this, Lose.class);
                finish();
                startActivity(intent);
            }
        }.start();

        ivQ2Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                countDownTimer.cancel();
                presenterDS1.Reset();
            }
        });
        ivQ2Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterDS1.ActivitiesNavigate();
                countDownTimer.cancel();
            }
        });
        btnC1Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC2Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC3Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC4Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                mp.start();
                presenterDS1.Right();
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
        Intent intent = new Intent(this, Q3.class);
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

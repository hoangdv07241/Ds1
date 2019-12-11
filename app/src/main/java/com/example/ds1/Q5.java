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

import com.example.ds1.databinding.ActivityQ5Binding;

public class Q5 extends AppCompatActivity implements ViewDs1{

    TextView tvQ5sc;
    ImageView ivQ5Reset, ivQ5Home;
    Button btnC1Q5, btnC2Q5, btnC3Q5, btnC4Q5;
    PresenterDs1 presenterDS1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ5Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q5);
        TextBinding textBinding = new TextBinding("Chọn màu tương ứng với nghĩa", "XANH BIỂN", "xanh biển", "đỏ", "đen", "tím");
        binding.setTextBinding(textBinding);

        presenterDS1 = new PresenterDs1(this);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.ding);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.rewind);
        tvQ5sc = findViewById(R.id.tvQ5sc);
        ivQ5Reset = findViewById(R.id.ivQ5Reset);
        ivQ5Home = findViewById(R.id.ivQ5Home);
        btnC1Q5 = findViewById(R.id.btnC1Q5);
        btnC2Q5 = findViewById(R.id.btnC2Q5);
        btnC3Q5 = findViewById(R.id.btnC3Q5);
        btnC4Q5 = findViewById(R.id.btnC4Q5);

        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                tvQ5sc.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Q5.this, Lose.class);
                finish();
                startActivity(intent);
            }
        }.start();

        ivQ5Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                countDownTimer.cancel();
                presenterDS1.Reset();
            }
        });
        ivQ5Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.ActivitiesNavigate();
            }
        });
        btnC1Q5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC2Q5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC3Q5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                countDownTimer.cancel();
                presenterDS1.Right();
            }
        });
        btnC4Q5.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(this, Q6.class);
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

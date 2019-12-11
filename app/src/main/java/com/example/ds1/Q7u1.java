package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ds1.databinding.ActivityQ7u1Binding;

public class Q7u1 extends AppCompatActivity implements ViewDs1 {

    TextView tvQ7u1sc, tvTask;
    ImageView ivQ7u1Reset, ivQ7u1Home;
    Button btnC1Q7u1, btnC2Q7u1, btnC3Q7u1, btnC4Q7u1;
    PresenterDs1 presenterDS1;
    GeneralFunction gf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ7u1Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q7u1);
        TextBinding textBinding = new TextBinding("Chọn màu tương ứng với nghĩa", "Đen", "Đen", "xanh lá", "xanh biển", "trắng");
        binding.setTextBinding(textBinding);

        presenterDS1 = new PresenterDs1(this);
        gf = new GeneralFunction();
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.ding);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.rewind);
        tvTask = findViewById(R.id.tvTask);
        tvQ7u1sc = findViewById(R.id.tvQ5sc);
        ivQ7u1Reset = findViewById(R.id.ivQ5Reset);
        ivQ7u1Home = findViewById(R.id.ivQ5Home);
        btnC1Q7u1 = findViewById(R.id.btnC1Q5);
        btnC2Q7u1 = findViewById(R.id.btnC2Q5);
        btnC3Q7u1 = findViewById(R.id.btnC3Q5);
        btnC4Q7u1 = findViewById(R.id.btnC4Q5);

        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                tvQ7u1sc.setText(String.valueOf(l / 1000));
                if ((l / 1000) == 9 || (l / 1000) == 7 || (l / 1000) == 5 || (l / 1000) == 3 || (l / 1000) == 1) {
                    tvTask.setText("Trắng");
                }
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Q7u1.this, Lose.class);
                finish();
                startActivity(intent);
            }
        }.start();

        ivQ7u1Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                countDownTimer.cancel();
                presenterDS1.Reset();
            }
        });
        ivQ7u1Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.ActivitiesNavigate();
            }
        });
        btnC1Q7u1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC2Q7u1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC3Q7u1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC4Q7u1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
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
        Intent intent = new Intent(this, Q7u2.class);
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

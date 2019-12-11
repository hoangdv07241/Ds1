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

import com.example.ds1.databinding.ActivityQ6Binding;

public class Q6 extends AppCompatActivity implements ViewDs1{

    TextView tvQ6sc;
    ImageView ivQ6Reset, ivQ6Home;
    Button btnC1Q6, btnC2Q6, btnC3Q6, btnC4Q6;
    PresenterDs1 presenterDS1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ6Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q6);
        TextBinding textBinding = new TextBinding("Chọn màu tương ứng với nghĩa", "Tím", "xanh lá", "đỏ", "nâu", "tím");
        binding.setTextBinding(textBinding);

        presenterDS1 = new PresenterDs1(this);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.ding);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.rewind);
        tvQ6sc = findViewById(R.id.tvQ6sc);
        ivQ6Reset = findViewById(R.id.ivQ6Reset);
        ivQ6Home = findViewById(R.id.ivQ6Home);
        btnC1Q6 = findViewById(R.id.btnC1Q6);
        btnC2Q6 = findViewById(R.id.btnC2Q6);
        btnC3Q6 = findViewById(R.id.btnC3Q6);
        btnC4Q6 = findViewById(R.id.btnC4Q6);

        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                tvQ6sc.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Q6.this, Lose.class);
                finish();
                startActivity(intent);
            }
        }.start();

        ivQ6Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                countDownTimer.cancel();
                presenterDS1.Reset();
            }
        });
        ivQ6Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.ActivitiesNavigate();
            }
        });
        btnC1Q6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC2Q6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                countDownTimer.cancel();
                presenterDS1.Right();
            }
        });
        btnC3Q6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC4Q6.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(this, Q7.class);
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

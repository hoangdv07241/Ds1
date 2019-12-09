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

import com.example.ds1.databinding.ActivityQ4Binding;

public class Q4 extends AppCompatActivity implements ViewDs1{

    TextView tvQ4sc;
    ImageView ivQ4Reset, ivQ4Home;
    Button btnC1Q4, btnC2Q4, btnC3Q4, btnC4Q4;
    PresenterDs1 presenterDS1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ4Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q4);
        TextBinding textBinding = new TextBinding("Chọn ô chữ thích hợp", "1", "one", "1", "3", "một");
        binding.setTextBinding(textBinding);

        presenterDS1 = new PresenterDs1(this);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.ding);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.rewind);
        tvQ4sc = findViewById(R.id.tvQ4sc);
        ivQ4Reset = findViewById(R.id.ivQ4Reset);
        ivQ4Home = findViewById(R.id.ivQ4Home);
        btnC1Q4 = findViewById(R.id.btnC1Q4);
        btnC2Q4 = findViewById(R.id.btnC2Q4);
        btnC3Q4 = findViewById(R.id.btnC3Q4);
        btnC4Q4 = findViewById(R.id.btnC4Q4);

        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                tvQ4sc.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Q4.this, Lose.class);
                finish();
                startActivity(intent);
            }
        }.start();

        ivQ4Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                countDownTimer.cancel();
                presenterDS1.Reset();
            }
        });
        ivQ4Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.ActivitiesNavigate();
            }
        });
        btnC1Q4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC2Q4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC3Q4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC4Q4.setOnClickListener(new View.OnClickListener() {
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

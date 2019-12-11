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

import com.example.ds1.databinding.ActivityQ7u2Binding;

public class Q7u2 extends AppCompatActivity implements ViewDs1 {

    TextView tvQ7u2sc;
    ImageView ivQ7u2Reset, ivQ7u2Home, tvTask2;
    Button btnC1Q7u2, btnC2Q7u2, btnC3Q7u2, btnC4Q7u2;
    PresenterDs1 presenterDS1;
    GeneralFunction gf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ7u2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q7u2);
        TextBinding textBinding = new TextBinding("Đây là tượng gì ?", null, "Người suy nghĩ",
                "Người suy tư", "Người đang suy nghĩ", "Người đang suy tư");
        binding.setTextBinding(textBinding);

        presenterDS1 = new PresenterDs1(this);
        gf = new GeneralFunction();
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.ding);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.rewind);
        tvTask2 = findViewById(R.id.tvTask2);
        tvQ7u2sc = findViewById(R.id.tvQ7u2sc);
        ivQ7u2Reset = findViewById(R.id.ivQ7u2Reset);
        ivQ7u2Home = findViewById(R.id.ivQ7u2Home);
        btnC1Q7u2 = findViewById(R.id.btnC1Q7u2);
        btnC2Q7u2 = findViewById(R.id.btnC2Q7u2);
        btnC3Q7u2 = findViewById(R.id.btnC3Q7u2);
        btnC4Q7u2 = findViewById(R.id.btnC4Q7u2);

        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                tvQ7u2sc.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Q7u2.this, Lose.class);
                finish();
                startActivity(intent);
            }
        }.start();

        ivQ7u2Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                countDownTimer.cancel();
                presenterDS1.Reset();
            }
        });
        ivQ7u2Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.ActivitiesNavigate();
            }
        });
        btnC1Q7u2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC2Q7u2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                countDownTimer.cancel();
                presenterDS1.Right();
            }
        });
        btnC3Q7u2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC4Q7u2.setOnClickListener(new View.OnClickListener() {
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

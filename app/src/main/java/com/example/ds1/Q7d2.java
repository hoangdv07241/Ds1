package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ds1.databinding.ActivityQ7d2Binding;

public class Q7d2 extends AppCompatActivity implements ViewDs1 {

    TextView tvQ7d2sc;
    ImageView ivQ7d2Reset, ivQ7d2Home, tvTaskq7d2;
    Button btnC1Q7d2, btnC2Q7d2, btnC3Q7d2, btnC4Q7d2;
    PresenterDs1 presenterDS1;
    GeneralFunction gf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ7d2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q7d2);
        TextBinding textBinding = new TextBinding("Đây là hình gì ?", null, "Tròn",
                "chữ nhật", "tam giác", "vuông");
        binding.setTextBinding(textBinding);

        presenterDS1 = new PresenterDs1(this);
        gf = new GeneralFunction();

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.ding);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.rewind);

        tvTaskq7d2 = findViewById(R.id.tvTaskq7d2);
        tvQ7d2sc = findViewById(R.id.tvQ7d2sc);
        ivQ7d2Reset = findViewById(R.id.ivQ7d2Reset);
        ivQ7d2Home = findViewById(R.id.ivQ7d2Home);
        btnC1Q7d2 = findViewById(R.id.btnC1Q7d2);
        btnC2Q7d2 = findViewById(R.id.btnC2Q7d2);
        btnC3Q7d2 = findViewById(R.id.btnC3Q7d2);
        btnC4Q7d2 = findViewById(R.id.btnC4Q7d2);

        final CountDownTimer countDownTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                tvQ7d2sc.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Q7d2.this, Lose.class);
                finish();
                startActivity(intent);
            }
        }.start();

        //ObjectAnimator objectAnimator = ObjectAnimator.ofFloat()

        ivQ7d2Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                countDownTimer.cancel();
                presenterDS1.Reset();
            }
        });
        ivQ7d2Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.ActivitiesNavigate();
            }
        });
        btnC1Q7d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC2Q7d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC3Q7d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                presenterDS1.Wrong();
            }
        });
        btnC4Q7d2.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(this, Nopoint.class);
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

package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ds1.databinding.ActivityQ1Binding;

public class Q1 extends AppCompatActivity implements ViewDS1 {

    Button btnC1Q1, btnC2Q1, btnC3Q1, btnC4Q1;
    ImageView ivReset;
    PresenterDS1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ1Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q1);
        TextBinding textBinding = new TextBinding("Chọn số thích hợp", "3", "2", "3", "5", "4");
        binding.setTextBinding(textBinding);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.ding);
        final MediaPlayer mp2 = MediaPlayer.create(this,R.raw.button_click);
        final MediaPlayer mp3 = MediaPlayer.create(this,R.raw.rewind);
        ivReset = findViewById(R.id.ivReset);
        btnC1Q1 = findViewById(R.id.btnC1Q1);
        btnC2Q1 = findViewById(R.id.btnC2Q1);
        btnC3Q1 = findViewById(R.id.btnC3Q1);
        btnC4Q1 = findViewById(R.id.btnC4Q1);
        presenterDS1 = new PresenterDS1(this);

        ivReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3.start();
                presenterDS1.Reset();
            }
        });
        btnC1Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterDS1.Wrong();
            }
        });
        btnC2Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterDS1.Wrong();
            }
        });
        btnC3Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                presenterDS1.Right();
            }
        });
        btnC4Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
    public void Exit() {

    }
}

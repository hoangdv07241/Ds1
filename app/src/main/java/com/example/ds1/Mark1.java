package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ds1.databinding.ActivityMark1Binding;

public class Mark1 extends AppCompatActivity implements ViewDs1{

    public static int score = 0;
    Button btnMarkReturn;
    PresenterDs1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMark1Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_mark1);
        TextBinding textBinding = new TextBinding("Chúc mừng bạn được 1 điểm !!!", "+1", "CHẤP NHẬN", null, null, null);
        binding.setTextBinding(textBinding);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.cash);
        mp.start();

        presenterDS1 = new PresenterDs1(this);
        btnMarkReturn = findViewById(R.id.btnMarkReturn);

        btnMarkReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterDS1.ActivitiesNavigate();
                score++;
                if(score == 4){
                    score = score - 4;
                    presenterDS1.Right();
                }
            }
        });
    }

    @Override
    public void ActivitiesNavigate() {
        Intent intent = new Intent(this, Q1.class);
        startActivity(intent);
    }

    @Override
    public void Reset() {

    }

    @Override
    public void Help() {

    }

    @Override
    public void Right() {
        Intent intent = new Intent(this, Winner.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void Wrong() {

    }

    @Override
    public void Other() {

    }
}

package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ds1.databinding.ActivityWinnerBinding;

public class Winner extends AppCompatActivity implements ViewDs1{

    Button btnWinner;
    PresenterDs1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityWinnerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_winner);
        TextBinding textBinding = new TextBinding("Xin chúc mừng", "CHẤP NHẬN", null, null, null, null);
        binding.setTextBinding(textBinding);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.applause);
        mp.start();

        presenterDS1 = new PresenterDs1(this);
        btnWinner = findViewById(R.id.btnWinner);

        btnWinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterDS1.ActivitiesNavigate();
            }
        });
    }

    @Override
    public void ActivitiesNavigate() {
        Intent intent = new Intent(this, PlayerAccess.class);
        finish();
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

    }

    @Override
    public void Wrong() {

    }

    @Override
    public void Other() {

    }
}

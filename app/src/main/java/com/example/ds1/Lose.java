package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ds1.databinding.ActivityLoseBinding;

public class Lose extends AppCompatActivity implements ViewDs1 {

    Button btnLoseReturn;
    PresenterDs1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoseBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lose);
        TextBinding textBinding = new TextBinding("Bạn đã THUA", "Quay lại", null, null, null, null);
        binding.setTextBinding(textBinding);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.gameover);
        final MediaPlayer mp2 = MediaPlayer.create(this,R.raw.button_click);
        mp.start();
        presenterDS1 = new PresenterDs1(this);
        btnLoseReturn = findViewById(R.id.btnLoseReturn);
        btnLoseReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                presenterDS1.ActivitiesNavigate();
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
    public void Exit() {

    }
}

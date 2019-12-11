package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ds1.databinding.ActivityNopointBinding;

public class Nopoint extends AppCompatActivity implements ViewDs1{

    Button btnNopointReturn;
    PresenterDs1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNopointBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_nopoint);
        TextBinding textBinding = new TextBinding("Rất tiếc khồng có điểm ở đây", "CHẤP NHẬN", null, null, null, null);
        binding.setTextBinding(textBinding);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.wrongway);
        mp.start();

        presenterDS1 = new PresenterDs1(this);
        btnNopointReturn = findViewById(R.id.btnNopointReturn);

        btnNopointReturn.setOnClickListener(new View.OnClickListener() {
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

    }

    @Override
    public void Help() {

    }

    @Override
    public void Right() {

    }

    @Override
    public void Wrong() {
        Intent intent = new Intent(this, Q1.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void Other() {

    }
}

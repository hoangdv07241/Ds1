package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ds1.databinding.ActivityWrongWayBinding;

public class WrongWay extends AppCompatActivity implements ViewDs1{

    Button btnWrongReturn;
    PresenterDs1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityWrongWayBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_wrong_way);
        TextBinding textBinding = new TextBinding("Bạn đã sai đường", "CHẤP NHẬN", null, null, null, null);
        binding.setTextBinding(textBinding);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.wrongway);
        mp.start();

        presenterDS1 = new PresenterDs1(this);
        btnWrongReturn = findViewById(R.id.btnWrongReturn);

        btnWrongReturn.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(this, Lose.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void Other() {

    }
}

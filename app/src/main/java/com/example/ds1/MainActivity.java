package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ds1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ViewDs1 {

    public Button btnStart, btnHelp;
    ImageView ivLeaderboard;
    TextView tvTile1,tvTile2,tvTile3;
    PresenterDs1 presenterDS1;
    GeneralFunction gf1,gf2,gf3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        TextBinding textBinding = new TextBinding("RANDOM", "CHOICE", "GAME", "START", "HELP", null);

        binding.setTextBinding(textBinding);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button_click);
        presenterDS1 = new PresenterDs1(this);
        gf1 = new GeneralFunction();
        gf2 = new GeneralFunction();
        gf3 = new GeneralFunction();

        ivLeaderboard = findViewById(R.id.ivLeaderboard);
        tvTile1 = findViewById(R.id.tvTitle1);
        tvTile2 = findViewById(R.id.tvTitle2);
        tvTile3 = findViewById(R.id.tvTitle3);
        btnStart = findViewById(R.id.btnStart);
        btnHelp = findViewById(R.id.btnHelp);

        gf1.TextAnim(tvTile1, Color.WHITE,Color.RED,1500);
        gf2.TextAnim(tvTile2, Color.WHITE, Color.GREEN,1450);
        gf3.TextAnim(tvTile3, Color.WHITE, Color.BLUE,1400);

        ivLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                presenterDS1.ActivitiesNavigate();
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                presenterDS1.Help();
            }
        });

    }


    @Override
    public void ActivitiesNavigate() {
        Intent intent = new Intent(MainActivity.this, Q1.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void Reset() {

    }

    @Override
    public void Help() {
        Intent intent = new Intent(MainActivity.this, HelpScreen.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void Right() {

    }

    @Override
    public void Wrong() {

    }

    @Override
    public void Other() {
        System.exit(0);
    }
}

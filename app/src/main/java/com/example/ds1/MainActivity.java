package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ds1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  implements ViewDs1 {

    public Button btnStart,btnHelp,btnExit;
    PresenterDs1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        TextBinding textBinding = new TextBinding("RANDOM CHOICE GAME","START","HELP",null,null,null);

        binding.setTextBinding(textBinding);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.button_click);
        btnStart = findViewById(R.id.btnStart);
        btnHelp = findViewById(R.id.btnHelp);
        presenterDS1 = new PresenterDs1(this);

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
        Intent intent = new Intent(MainActivity.this,Q1.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void Reset() {

    }

    @Override
    public void Help() {
        Intent intent = new Intent(MainActivity.this,HelpScreen.class);
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

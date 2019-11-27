package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements ViewDS1{

    Button btnStart,btnHelp,btnExit;
    PresenterDS1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnHelp = findViewById(R.id.btnHelp);
        btnExit = findViewById(R.id.btnExit);
        presenterDS1 = new PresenterDS1(this);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterDS1.Help();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterDS1.Exit();
            }
        });
    }


    @Override
    public void ActivitiesNavigate() {

    }

    @Override
    public void Help() {
        Intent intent = new Intent(MainActivity.this,HelpScreen.class);
        startActivity(intent);
    }

    @Override
    public void Wrong() {

    }

    @Override
    public void Exit() {
        System.exit(0);
    }
}

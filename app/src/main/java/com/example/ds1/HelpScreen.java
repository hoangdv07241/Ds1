package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class HelpScreen extends AppCompatActivity implements ViewDS1{

    PresenterDS1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

        presenterDS1 = new PresenterDS1(this);
    }

    @Override
    public void ActivitiesNavigate() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void Help() {

    }

    @Override
    public void Wrong() {

    }

    @Override
    public void Exit() {

    }
}

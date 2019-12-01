package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ds1.databinding.ActivityLoseBinding;

public class Lose extends AppCompatActivity implements ViewDS1 {

    Button btnLoseReturn;
    PresenterDS1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoseBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lose);
        TextBinding textBinding = new TextBinding("Bạn đã THUA", "Quay lại", null, null, null, null);
        binding.setTextBinding(textBinding);

        presenterDS1 = new PresenterDS1(this);
        btnLoseReturn = findViewById(R.id.btnLoseReturn);
        btnLoseReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

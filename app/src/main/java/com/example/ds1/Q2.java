package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ds1.databinding.ActivityQ1Binding;

public class Q2 extends AppCompatActivity implements ViewDS1 {

    Button btnC1Q2, btnC2Q2, btnC3Q2, btnC4Q2;
    PresenterDS1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ1Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q2);
        TextBinding textBinding = new TextBinding("Chọn ô chữ thích hợp", "1", "one", "1", "3", "một");
        binding.setTextBinding(textBinding);

        presenterDS1 = new PresenterDS1(this);
        btnC1Q2 = findViewById(R.id.btnC1Q2);
        btnC2Q2 = findViewById(R.id.btnC2Q2);
        btnC3Q2 = findViewById(R.id.btnC3Q2);
        btnC4Q2 = findViewById(R.id.btnC4Q2);

        btnC1Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterDS1.Wrong();
            }
        });
        btnC2Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterDS1.Wrong();
            }
        });
        btnC3Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterDS1.Wrong();
            }
        });
        btnC4Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterDS1.Right();
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
    public void Exit() {

    }
}

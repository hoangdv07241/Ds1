package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.ds1.databinding.ActivityQ3Binding;

public class Q3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ3Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q3);
    }
}

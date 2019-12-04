package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.ds1.databinding.ActivityQ3Binding;

public class Q3 extends AppCompatActivity implements ViewDs1{

    PresenterDs1 presenterDs1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQ3Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_q3);
        TextBinding textBinding = new TextBinding("UP","LEFT","RIGHT","DOWN",null,null);
        binding.setTextBinding(textBinding);

        presenterDs1 = new PresenterDs1(this);
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

    }

    @Override
    public void Other() {

    }
}

package com.example.ds1;

public class PresenterDs1 {

    private ViewDs1 viewDS1;

    public PresenterDs1(ViewDs1 viewDS1) {
        this.viewDS1 = viewDS1;
    }

    void ActivitiesNavigate(){
        viewDS1.ActivitiesNavigate();
    }

    void Reset(){
        viewDS1.Reset();
    }

    void Help(){
        viewDS1.Help();
    }

    void Right(){
        viewDS1.Right();
    }

    void Wrong(){
        viewDS1.Wrong();
    }

    void Other(){
        viewDS1.Other();
    }
}

package com.example.ds1;

public class PresenterDS1 {

    private ViewDS1 viewDS1;

    public PresenterDS1(ViewDS1 viewDS1) {
        this.viewDS1 = viewDS1;
    }

    void ActivitiesNavigate(){
        viewDS1.ActivitiesNavigate();
    }

    void Help(){
        viewDS1.Help();
    }

    void Exit(){
        viewDS1.Exit();
    }
}

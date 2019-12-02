package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ds1.databinding.ActivityHelpScreenBinding;

public class HelpScreen extends AppCompatActivity implements ViewDs1 {

    Button btnReturn;
    PresenterDs1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHelpScreenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_help_screen);

        TextBinding textBinding = new TextBinding("Đọc kĩ câu hỏi và làm theo chỉ dẫn đến khi " +
                "bạn đạt đủ 4 điểm để màn hình hiển thị đúng dòng này WINNER", "ĐÃ HIỂU", null, null, null, null);

        binding.setTextBinding(textBinding);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.button_click);
        btnReturn = findViewById(R.id.btnReturn);
        presenterDS1 = new PresenterDs1(this);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
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

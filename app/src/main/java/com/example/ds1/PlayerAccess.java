package com.example.ds1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ds1.Dao.ScoreDAO;
import com.example.ds1.Model.Score;
import com.example.ds1.databinding.ActivityNopointBinding;
import com.example.ds1.databinding.ActivityPlayerAccessBinding;

public class PlayerAccess extends AppCompatActivity implements ViewDs1{

    EditText edtPlayer;
    Button btnGo;
    PresenterDs1 presenterDS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPlayerAccessBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_player_access);
        TextBinding textBinding = new TextBinding("Mời nhập tên.", "Bắt đầu", null, null, null, null);
        binding.setTextBinding(textBinding);

        presenterDS1 = new PresenterDs1(this);
        edtPlayer = findViewById(R.id.edtPlayer);
        btnGo = findViewById(R.id.btnGo);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterDS1.ActivitiesNavigate();
            }
        });
    }

    @Override
    public void ActivitiesNavigate() {
        Intent intent = new Intent(this, Q1.class);
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
    public void Other() {
        ScoreDAO scoreDAO = new ScoreDAO(PlayerAccess.this);

        String player = edtPlayer.getText().toString();

        Score score = new Score(player);

        boolean isInsert = scoreDAO.InsertPlayer(score);
        if(isInsert){
            Toast.makeText(PlayerAccess.this,"Tên người chơi đã được thêm vào bảng danh vọng.",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(PlayerAccess.this,"Add player fail",Toast.LENGTH_SHORT).show();
        }
    }
}

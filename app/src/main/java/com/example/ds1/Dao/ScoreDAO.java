package com.example.ds1.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.ds1.DatabaseHelper;
import com.example.ds1.Model.Score;

public class ScoreDAO {
    public static final String TABLE_NAME = "Score";
    private SQLiteDatabase db;
    private DatabaseHelper dbhelper;
    public static final String TAG = "ScoreDAO";
    public static final String SQL_SCORE = "CREATE TABLE Score " +
            "(PlayerCode CHAR(4) primary key NOT NULL, " +
            "Player NVARCHAR(50), " +
            ");";

    public ScoreDAO(Context context) {
        dbhelper = new DatabaseHelper(context);
        db = dbhelper.getWritableDatabase();
    }

    public boolean InsertPlayer(Score score){

        ContentValues values = new ContentValues();

        values.put("player",score.getPlayer());
        values.put("playercode",score.getPlayerCode());

        long result = db.insert(TABLE_NAME,null,values);

        try {
            if (result == -1){
                return false;
            }
        }catch (Exception ex){
            Log.e(TAG,ex.toString());
        }
        return true;
    }

    public int UpdateScore(Score score){
        ContentValues values = new ContentValues();

        values.put("player",score.getPlayer());

        return db.update(TABLE_NAME,values,"Player=?",new String[]{score.getPlayer()});
    }
}

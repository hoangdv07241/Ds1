package com.example.ds1.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ds1.DatabaseHelper;

public class ScoreDAO {
    public static final String TABLE_NAME = "Score";
    private SQLiteDatabase db;
    private DatabaseHelper dbhelper;
    public static final String TAG = "ScoreDAO";
    public static final String SQL_SCORE = "CREATE TABLE Score " +
            "(ScoreCode CHAR(4) primary key NOT NULL, " +
            "Rank INT, " +
            "Player NVARCHAR(50), " +
            "Score INT" +
            ");";

    public ScoreDAO(Context context) {
        dbhelper = new DatabaseHelper(context);
        db = dbhelper.getWritableDatabase();
    }
}

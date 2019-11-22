package com.example.ds1.Model;

public class Score {
    String ScoreCode,Player;
    int Rank,Score;

    public Score(String scoreCode, String player, int rank, int score) {
        ScoreCode = scoreCode;
        Player = player;
        Rank = rank;
        Score = score;
    }

    public Score(String player) {
        Player = player;
    }

    public String getPlayer() {
        return Player;
    }

    public void setPlayer(String player) {
        Player = player;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public String getScoreCode() {
        return ScoreCode;
    }

    public void setScoreCode(String scoreCode) {
        ScoreCode = scoreCode;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}

package com.example.ds1.Model;

public class Score {
    String PlayerCode,Player;

    public Score(String playerCode, String player) {
        PlayerCode = playerCode;
        Player = player;
    }

    public Score(String player) {
        Player = player;
    }

    public String getPlayerCode() {
        return PlayerCode;
    }

    public void setPlayerCode(String playerCode) {
        PlayerCode = playerCode;
    }

    public String getPlayer() {
        return Player;
    }

    public void setPlayer(String player) {
        Player = player;
    }

}

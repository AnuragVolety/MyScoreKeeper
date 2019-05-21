package com.example.android.myscorekeeper;

/**
 * Created by vanur on 21-12-2017.
 */

class Word {
    private String numberOfPlayers, gameType;
    public Word(String number, String game){
        numberOfPlayers= number;
        gameType = game;
    }
     public String getNumberOfPlayers(){ return numberOfPlayers;}
     public String getGameType(){return gameType;}
}

package com.company;

import java.util.*;

import static java.lang.System.exit;

/**
 * the class that represents the behaviour of each player
 * it implements the interface Runnable and overrides the method run() in order for our thread to be created and dealt with
 * there is an only problem with this.
 * It takes as winners all the players that get to the given max length.
 */

class Player implements Runnable {
    /**
     * @param name the name of the player
     * @param currentGame the current game that all of the players are in
     * @param ownedTokens a list of owned token that each player ca get their hands on
     * @param maxSize the maximum size that the arithmetic progression can get
     * @param points the corresponding points to each player game
     */

    private final String name;
    final Game currentGame;
    private final List<Token> ownedTokens = new ArrayList<Token>();
    private boolean go=false;
    private final int maxSize;
    private int points=0;
    private boolean gameOver;

    public Player(String name, Game currentGame, int maxSize, boolean gameOver) {
        this.name = name;
        this.currentGame = currentGame;
        this.maxSize = maxSize;
        this.gameOver = gameOver;
    }

    private void extract(int index){
        this.currentGame.extractToken(index);
    }

    @Override
    public void run() {
        synchronized (this) {
            while (go) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                System.out.println("Player: " + this.name);

                Thread.sleep(6000);
                if(!gameOver)
                    while (this.currentGame.getNumberOfTokensLeft() != 0) {
                        Token aux=this.currentGame.extractToken(0);
                        this.ownedTokens.add(aux);
                        if(this.verifyProgresion()>=this.maxSize){
                            System.out.println();
                            System.out.println(this.name + " a castigat!");
                            System.out.println();
                            points=verifyProgresion();
                            gameOver=true;
                            System.out.println(this);
                            exit(0);
                        }
                        //System.out.println(this.name + " extracted | tokens extracted->" + aux);
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            go = true; notifyAll();
        }


        points=verifyProgresion();
        System.out.println(this);

    }

    public int verifyProgresion(){
        int longestProgresion=1,ration=-1,blankElements=0;
        ownedTokens.sort(new CompareByValue());
        for(int i=1;i<ownedTokens.size();i++){
            if(this.ownedTokens.get(i-1).getValue()==-1) {
                blankElements++;
            }
            else {
                if (ration == -1) {
                    ration = ownedTokens.get(i - 1).getValue() + ownedTokens.get(i).getValue();
                    longestProgresion++;
                } else {
                    if (ownedTokens.get(i - 1).getValue() + ownedTokens.get(i).getValue() == ration) {
                        longestProgresion++;
                    } else {
                        longestProgresion = 1;
                        ration = -1;
                    }
                }
            }
        }
        longestProgresion+=blankElements;
        return longestProgresion;
    }



    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", Tokens=" + ownedTokens +
                ",points=" + points +
                '}';
    }
}

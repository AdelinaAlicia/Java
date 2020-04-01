package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * the class that deals with the progress of the game
 */
public class Game {
    /**
     * @param board a board type elemet
     * @param players a list of the game current players
     * @param limitOfPlayers the game current limit of accepted players
     *                       here are created the threads that deals with every player
     */
    private Board board;
    private List<Player> players = new ArrayList<Player>();
    private int limitOfPlayers;
    private boolean gameOver=false;

    Game(){ }

    Game(int limit, Board board, Player ... players){
        this.board=board;
        this.limitOfPlayers=limit;
        if(this.limitOfPlayers<players.length){
            Collections.addAll(this.players,players);
        }
    }

    synchronized public Token extractToken(int index){

        Token aux =this.board.getBoard().get(index);
        this.board.getBoard().remove(index);
        return aux;
    }


    public int getNumberOfTokensLeft(){
        return this.board.getNumberOfTokens();
    }

    public void startGame(){
        board= new Board(10, new Token(3),new Token(6),new Token(5),new Token(4),new Token(-1),new Token(-1),new Token(-1),new Token(-1));

        players.add(new Player("Adi", this, 3, gameOver));
        players.add(new Player("Tibi", this, 3, gameOver));
        players.add(new Player("Stefan", this, 3, gameOver));
        players.add(new Player("Andrei", this, 3, gameOver));

        //Runnable firstPlayer= players.get(0);
        Runnable secondPlayer= players.get(1);
        Runnable thirdPlayer= players.get(2);
        Runnable fourthPlayer= players.get(3);
        //list of all the players

        System.out.println("List of all players");

        Thread firstPlayer= new Thread(players.get(0));
        //threads created fr each player
        firstPlayer.start();
        new Thread(secondPlayer).start();
        new Thread(thirdPlayer).start();
        new Thread(fourthPlayer).start();

    }
}


package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * a class that contains the elements of the game
 */
public class Board {
    /**
     * @param board contains a list of tokens
     * @param limit the maximum value a token can get
     *              the elements that have -1 represent the blank elements
     */
    private List<Token> board= new ArrayList<Token>();
    private int limit;

    Board(int limitOfTokens, Token... token){
        for (Token tok:token) {
            if(tok.getValue()>limitOfTokens){
                System.out.println("Nu s-a putut adauga elementul");
            }
            else{
                this.board.add(tok);
            }
        }
        this.limit=limitOfTokens;
    }

    Board(){

    }

    public List<Token> getBoard() {
        return board;
    }


    public int getNumberOfTokens(){
        return this.board.size();
    }

    Board(int limitOfTokens){
        this.limit=limitOfTokens;
    }

    public void Add(Token ...token){
        if(this.board.size()+token.length<=limit){
            Collections.addAll(board,token);
        }
        else
            System.out.println("elements was't added, limit reached");
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + board +
                ", limit=" + limit +
                '}';
    }
}


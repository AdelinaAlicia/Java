package com.company;

/**
 * clasa Main, se ocupa doar de instantierea unui nou joc, si de pornirea acestuia
 */
public class Main {

    /**
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        // write your code here
        /**
         * @param oneGame the game, instance of Game class, represents a game
         */
        Game oneGame = new Game();
        oneGame.startGame();
        // oneGame.show(oneGame.getPlayers());
    }
}

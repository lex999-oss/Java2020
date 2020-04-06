package com.company;

import java.util.ArrayList;

public class Game {
    int noPlayers, tokenNo, range, k;
    ThreadGroup group;
    Board board;
    ArrayList<Player> players;
    boolean roundEnded;
    boolean existsWinner;
    public Game(int tokenNo, int range, int k, int noPlayers, int noRounds) {
        if (noPlayers < 0)
            throw new IllegalArgumentException("Number of players must be positive");
        if (k < 2)
            throw new IllegalArgumentException("A progression must have at least 3 elements!");
        this.noPlayers = noPlayers;
        this.tokenNo = tokenNo;
        this.range = range;
        this.k = k;
        for (int i = 0; i < noRounds; i++)
            startRound();
    }
    public void startRound() {
        Player.resetPlayerCount();
        this.board = new Board(tokenNo, range, k);
        this.players = new ArrayList<>();
        this.roundEnded = false;
        this.existsWinner = false;
        group = new ThreadGroup("playerGroup");
        for (int i = 0; i < noPlayers; i++)
            players.add(new RandomPlayer(board, this));
        System.out.println(board);
        Thread thread;
        for (Player currentPlayer : players) {
            thread = new Thread(group, currentPlayer, currentPlayer.getName());
            thread.start();
        }
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public abstract class Player implements Runnable {
    static int playerNo = 0;
    String name;
    int id;
    Board board;
    Game game;
    ArrayList<Token> tokensExtracted;
    boolean killPlayer = false;
    public Player(Board board, Game game) {
        tokensExtracted = new ArrayList<>();
        playerNo++;
        id = playerNo;
        name = String.format("Player %d", playerNo);
        this.board = board;
        this.game = game;
    }
    public static void resetPlayerCount() {
        Player.playerNo = 0;
    }
    public String getName() {
        return name;
    }
    public boolean isWinner()
    {
        int needed = board.winningProgressionSize;
        int n = tokensExtracted.size();
        if (needed > n)
            return false;
        int[] v = new int[n];
        for (int i = 0; i < n; i++)
            v[i] = tokensExtracted.get(i).getValue();
        Arrays.sort(v);
        int r, count, last;

        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++) {
                r = v[j] - v[i];
                last = v[j];
                count = 2;
                for (int k = j+1; k < n && count < needed; k++)
                    if (v[k] == last + r) {
                        last = v[k];
                        count++;
                    }
                if (count == needed)
                    return true;
            }
        return false;
    }
}

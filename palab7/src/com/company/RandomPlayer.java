package com.company;

import java.util.Random;

public class RandomPlayer extends Player{
    public RandomPlayer(Board board, Game game) {
        super(board, game);
    }
    @Override
    public void run() {
        Random random = new Random();
        if (game.existsWinner)
            return;
        if (board.tokens.isEmpty())
        {
            if (this.game.roundEnded)
                return;
            game.roundEnded = true;
            if (false == game.existsWinner)
                System.out.println("It's a tie !!!!");
        }
        int value = 0, size;
        while (!killPlayer) {
            if (board.tokens.isEmpty()) {
                killPlayer = true;
                break;
            }
            synchronized (board.tokens) {
                size = board.tokens.size();
                int index = Math.abs(random.nextInt()) % size;
                value = board.tokens.get(index).getValue();
                board.removeTokenAtIndex(index);
            }
            System.out.println(String.format("%s has taken the Token %d", this.name, value));
            tokensExtracted.add(new Token(value));
            if (this.isWinner()) {
                System.out.println(String.format("%s has won!!", this.name));
                game.existsWinner = true;
            }
        }
    }
}

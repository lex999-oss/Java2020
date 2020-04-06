package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    int tokenNo;
    int winningProgressionSize;
    final ArrayList<Token> tokens = new ArrayList<>();
    public Board(int tokenNo, int range, int winningProgressionSize) {
        this.tokenNo = tokenNo;
        this.winningProgressionSize = winningProgressionSize;
        buildTokenSet(tokenNo, range);
    }
    private void buildTokenSet(int tokenNo, int range) {
        Token currentToken;
        for (int i = 1; i < tokenNo; i++)
        {
            currentToken = new Token(range-tokenNo+i);
            tokens.add(currentToken);
            //fullRange.remove(currentIndex);
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Token currToken: tokens)
            output.append(currToken.getValue()).append(" ");
        return "Tokens on board are : " + output + ".";
    }

    public void removeTokenAtIndex(int index) {
        tokens.remove(index);
    }
}

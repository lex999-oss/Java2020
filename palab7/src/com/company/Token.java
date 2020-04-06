package com.company;

public class Token implements Comparable<Token> {
    private int value;
    public Token(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(Token o) {
        Integer a = this.value, b = o.value;
        return a.compareTo(b);
    }
}

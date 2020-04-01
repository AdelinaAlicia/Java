package com.company;

import java.util.Objects;

/**
 * class Token, represents a token, a value that each player can take such that they can form a arithmetic progression
 * of a given length, if they cannot form that, at the end, they will have points corresponding with the length of the
 * most large progression they could form
 */


public class Token {
    /**
     * @param value represent the actual value of a token
     *              it has the oveerrided methods so that it can be printed on the screen
     *              and compared with another object of its type
     */

    private int value;

    Token(int setValue){
        this.value= setValue;
    }

    public int getValue() {
        return value;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return getValue() == token.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return "Token{" +
                "value=" + value +
                '}';
    }
}


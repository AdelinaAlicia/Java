package com.company;

import com.company.Token;

/**
 * a class that implements the comparator interface in order for us to
 * sort a list of tokens later
 */

import java.util.Comparator;

public class CompareByValue implements Comparator<Token> {

    // Used for sorting in ascending order of
    // roll number
    public int compare(Token a, Token b) {
        return a.getValue() - b.getValue();
    }


}

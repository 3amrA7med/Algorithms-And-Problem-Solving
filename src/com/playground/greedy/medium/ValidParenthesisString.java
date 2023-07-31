package com.playground.greedy.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 678. Valid Parenthesis String
 */
public class ValidParenthesisString {

// BEATS 100% runtime and 99% memory
    public boolean checkValidString1(String s) {
       int leftMin = 0;
       int leftMax = 0;

       for(int i =0; i < s.length(); i++) {
           switch(s.charAt(i)) {
               case '(' -> {leftMin++; leftMax++;}
               case '*' -> {leftMin--; leftMax++;}
               case ')' -> {leftMin--; leftMax--;}
           }
           if(leftMax < 0) return false;
           if(leftMin < 0) leftMin = 0;
       }

        if(leftMin == 0) return true;
        return false;
    }


    // MEMORY LIMIT EXCEEDS
    public boolean checkValidString2(String s) {
        Deque<Character> sequenceStack = new ArrayDeque<>();

        for(int i =0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case '(', '*'-> sequenceStack.offerLast(s.charAt(i));
                case ')' -> {
                    if(sequenceStack.size() == 0) return false;
                    char c = sequenceStack.pollLast();
                    int numOfAstrics = 0;
                    while(c == '*' && sequenceStack.size() != 0) {
                        numOfAstrics++;
                        c = sequenceStack.pollLast();
                    }

                    while(numOfAstrics > 0)
                        sequenceStack.offerLast('*');
                }
            }
        }

        int k = 0;
        while(sequenceStack.size() != 0) {
            char c = sequenceStack.pollLast();
            if(c == '*') k++;
            else k--;

            if(k < 0) return false;
        }

        return true;
    }
}

package com.playground.stack.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. Valid Parentheses
 * Beats 98.87%, 1ms
 * Beats 69.82%, 40mb
 */
public class ValidParentheses {

    public void run() {
        System.out.println(isValid("()"));
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] charsArr = s.toCharArray();

        for(int i = 0; i < charsArr.length; i++) {
            switch(charsArr[i]) {
                case '(', '[', '{' -> stack.addLast(charsArr[i]);
                case ')' -> {if(stack.size()==0 || stack.removeLast() != '(') return false;}
                case '}' -> {if(stack.size()==0 || stack.removeLast() != '{') return false;}
                case ']' -> {if(stack.size()==0 || stack.removeLast() != '[') return false;}
            }
        }
        return stack.size() == 0;
    }
}

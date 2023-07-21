package com.playground.sliding_window.string.hard;

import java.util.Arrays;

/**
 * 76. Minimum Window Substring
 * Beats 80.25%, best 4ms
 * Memory 43.6 MB Beats 91.89%, best 42
 */
public class MinimumWindowSubstring {

    public void run() {
        String res = minWindow("abc", "bc");
        System.out.println(res);
    }

    final String NO_MATCH_STRING = "";
    final int CHARACTERS_COUNT = 26;

    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return NO_MATCH_STRING;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int[] sCount = new int[CHARACTERS_COUNT*2];
        int[] tCount = new int[CHARACTERS_COUNT*2];

        for(int i =0; i < tChars.length; i++) {
            tCount[getCharIndex(tChars[i])]++;
            sCount[getCharIndex(sChars[i])]++;
        }

        if(Arrays.equals(sCount, tCount))
            return s.substring(0, tChars.length);

        int startIndex = 0;
        int endIndex = sChars.length;
        int l = 0;
        for(int i = tChars.length; i < sChars.length; i++) {
            sCount[getCharIndex(sChars[i])]++;

            if(checkSubString(sCount, tCount)) {
                // Skip all left characters that does not contribute to the answer
                while(l < sChars.length && sCount[getCharIndex(sChars[l])] > tCount[getCharIndex(sChars[l])]) {
                    sCount[getCharIndex(sChars[l])]--;
                    l++;
                }
                // Record the values if it is better than previously recorded results.
                if(i - l < endIndex - startIndex) {
                    endIndex = i;
                    startIndex = l;
                }
            }
        }

        if(endIndex - startIndex == sChars.length) return NO_MATCH_STRING;
        return s.substring(startIndex, endIndex+1);
    }

    private int getCharIndex(char c) { // O(1)
        int index = c - 'A';
        if(index >=0 && index < CHARACTERS_COUNT) return index;
        index = 26 + c - 'a';
        return index;
    }

    private boolean checkSubString(int[] s, int[] t) { // O(n)
        for(int i = 0; i < t.length; i++) {
            if(t[i] == 0) continue;
            if(t[i] > s[i]) return false;
        }
        return true;
    }
}

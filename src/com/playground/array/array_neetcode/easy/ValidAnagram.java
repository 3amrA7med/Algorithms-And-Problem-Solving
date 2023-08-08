package com.playground.array.array_neetcode.easy;

import java.util.Arrays;

/**
 * 242. Valid Anagram
 */
public class ValidAnagram {

    private static final int CHARACTERS_COUNT = 26;

    /**
     * 3ms Beats 93.95%
     * 43.38mb Beats 65.28%
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int[] tCount = new int[CHARACTERS_COUNT];
        int[] sCount = new int[CHARACTERS_COUNT];

        for(int i = 0; i < tArr.length; i++) {
            tCount[tArr[i] - 'a']++;
            sCount[sArr[i] - 'a']++;
        }

        return Arrays.equals(tCount, sCount);
    }
}

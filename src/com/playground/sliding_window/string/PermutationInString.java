package com.playground.sliding_window.string;

import java.util.Arrays;

/**
 * 567. Permutation in String
 * ========================
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 * =====================================
 * Example 1:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 */
public class PermutationInString {

     public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(int i =0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1Freq, s2Freq))
            return true;

        int leftIndex = 0;

        for(int rightIndex = s1.length(); rightIndex < s2.length(); rightIndex++) {
            s2Freq[s2.charAt(rightIndex) - 'a']++;
            s2Freq[s2.charAt(leftIndex) - 'a']--;

            leftIndex++;
            if(Arrays.equals(s1Freq, s2Freq))
                return true;
        }

        return false;
    }

}

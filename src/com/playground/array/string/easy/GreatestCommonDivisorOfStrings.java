package com.playground.array.string.easy;

/**
 * 1071. Greatest Common Divisor of Strings
 * ============================
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * ===========================
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 */
public class GreatestCommonDivisorOfStrings {

    public void run() {
        System.out.println(this.gcdOfStrings("ABCABC", "ABC"));
    }

    /**
     * Runtime 1ms Beats 82.78%
     * Memory 40.72MB Beats 94.01%
     */
    public String gcdOfStrings(String str1, String str2) {
        for(int i = Math.min(str1.length(), str2.length()); i > 0; i--) {
            if(isDivisor(str1, str2, i)) return str1.substring(0, i);
        }

        return "";
    }

    public boolean isDivisor(String s1, String s2, int l) {
        // If the strings are not divisible by the length
        if(s1.length() % l != 0 || s2.length() % l != 0) return false;

        String t = s1.substring(0, l);

        int numberOfRepetitions1 = s1.length() / l;
        int numberOfRepetitions2 = s2.length() / l;

        return s1.equals(t.repeat(numberOfRepetitions1)) && s2.equals(t.repeat(numberOfRepetitions2));
    }
}

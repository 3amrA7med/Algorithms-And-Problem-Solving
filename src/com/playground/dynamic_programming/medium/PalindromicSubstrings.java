package com.playground.dynamic_programming.medium;

/**
 * 647. Palindromic Substrings
 */
public class PalindromicSubstrings {

    /**
     * 1ms Beats 99.81%
     * 40.48mb Beats 85.93%
     * @param s
     * @return
     */
    public int countSubstrings(String s) {

        int l,r;
        int palindromeCount = 0;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            l = i;
            r = i;
            while(l >= 0 && r < arr.length && arr[l] == arr[r]) {
                l--;
                r++;
                palindromeCount++;
            }

            l = i;
            r = i+1;
            while(l >= 0 && r < arr.length && arr[l] == arr[r]) {
                l--;
                r++;
                palindromeCount++;
            }
        }

        return palindromeCount;
    }
}

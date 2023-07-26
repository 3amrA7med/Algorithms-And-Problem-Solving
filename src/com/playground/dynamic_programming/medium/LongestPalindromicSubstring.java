package com.playground.dynamic_programming.medium;

/**
 * 5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {

    public void run(){
        String s = "babad";
        System.out.println(longestPalindrome1(s));
    }

    /**
     * Using array of char instead of string has reduced runtime by 50%
     * 11ms Beats 91.73%
     * 41.54mb Beats 60.23%
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int l, r;
        char[] arr = s.toCharArray();
        int maxL = 0;
        int maxR = 0;
        for(int i = 0; i < arr.length; i++) {
            // Odd palindromes
            l = i;
            r = i;
            while(l >= 0 && r < s.length() && arr[l] == arr[r]) {
                if((r-l+1) > (maxR-maxL+1)) {
                    maxL = l;
                    maxR = r;
                }
                l--;
                r++;
            }

            // Even palindromes
            l = i;
            r = i+1;
            while(l >= 0 && r < s.length() && arr[l] == arr[r]) {
                if((r-l+1) > (maxR-maxL+1)) {
                    maxL = l;
                    maxR = r;
                }
                l--;
                r++;
            }
        }

        return s.substring(maxL, maxR+1);
    }


    /**
     * 29ms Beats 49.56%
     * 41.31mb Beats 71.91%
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int l, r;
        int maxL = 0;
        int maxR = 0;
        for(int i = 0; i < s.length(); i++) {
            // Odd palindromes
            l = i;
            r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if((r-l+1) > (maxR-maxL+1)) {
                    maxL = l;
                    maxR = r;
                }
                l--;
                r++;
            }

            // Even palindromes
            l = i;
            r = i+1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if((r-l+1) > (maxR-maxL+1)) {
                    maxL = l;
                    maxR = r;
                }
                l--;
                r++;
            }
        }

        return s.substring(maxL, maxR+1);
    }


    /**
     * 248ms Beats 21.73%, best 6ms
     * 55.62mbBeats 5.06%, best 40
     */
    int maxSizePalindrome;
    boolean[][] isPalindromeDp;
    int maxPalindromeStart = 0;
    int maxPalindromeEnd = 0;
    public String longestPalindromeDp(String s) {
        if(s.length() == 1) return s;

        char[] chars = s.toCharArray();
        maxSizePalindrome = chars.length;
        isPalindromeDp = new boolean[chars.length][chars.length];

        longestPalindromeDp(chars, 0, chars.length-1);
        return s.substring(maxPalindromeStart, maxPalindromeEnd + 1);
    }

    public boolean longestPalindromeDp(char[] chars, int s, int e) {
        if(s >= e) return true;
        if(isPalindromeDp[s][e]) return isPalindromeDp[s][e];

        if(chars[s] != chars[e]) {
            longestPalindromeDp(chars, s + 1, e);
            longestPalindromeDp(chars, s, e - 1);
            return false;
        }
        isPalindromeDp[s][e] = longestPalindromeDp(chars, s + 1, e - 1);
        if(!isPalindromeDp[s][e]) {
            longestPalindromeDp(chars, s + 1, e);
            longestPalindromeDp(chars, s, e - 1);
            return false;
        }
        if(isPalindromeDp[s][e] && (e-s) > (maxPalindromeEnd - maxPalindromeStart)) { // If size is greater than previous max, then save it.
            maxPalindromeStart = s;
            maxPalindromeEnd = e;
        }

        return isPalindromeDp[s][e];
    }
}

package com.playground.dynamic_programming.medium;

import java.util.*;
/**
 * 139. Word Break
 */
public class WordBreak {

    public void run(){
        System.out.println(wordBreakBottomUp("aaaaaaa", new ArrayList<>(){{add("aaaa");add("aaa");add("sand");add("and");add("cat");}}));
    }


    /**
     * 4ms Beats 77.87%
     * 41.64mb Beats 75.78%
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreakBottomUp(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for(int i = s.length()-1; i >= 0; i--) {
            for(int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                if(word.length() + i <= s.length() && word.equals(s.substring(i, word.length() + i)))
                    dp[i] = dp[i + word.length()];
                if(dp[i]) break;
            }
        }

        return dp[0];
    }

    /**
     * 8ms Beats 51.74%, best 0ms
     * 41.58mb Beats 78.00%
     */
    int dp[];
    int minLength, maxLength;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length()];
        char[] input = new char[s.length()];
        // Get min and max length of words in dictionary.
        minLength = Integer.MAX_VALUE;
        maxLength = Integer.MIN_VALUE;
        for(int i = 0; i < wordDict.size(); i++){
            minLength = Math.min(wordDict.get(i).length(), minLength);
            maxLength = Math.max(wordDict.get(i).length(), maxLength);
        }
        return wordBreakTopDown(s, 0, minLength - 1, wordDict, minLength, maxLength) == 1;
    }

    public int wordBreakTopDown(String input, int s, int e, List<String> wordDict, int min, int max) {
        if(s == input.length()) return 1;
        if(e >= input.length()) return -1;
        if(dp[s] != 0) return dp[s];

        int res = -1;
        if(wordDict.contains(input.substring(s, e+1))) // Word dict found
            res = wordBreakTopDown(input, e + 1, e + min, wordDict, min, max);
        if(res != 1) {
            for(int i =1; e + i - s <= max && e + i < input.length(); i++) {
                if(wordDict.contains(input.substring(s, e+i+1))) {
                    res = wordBreakTopDown(input, s, e + i, wordDict, min, max);
                    if(res == 1) break;
                }
            }
        }
        dp[s] = res;
        return dp[s];
    }
}

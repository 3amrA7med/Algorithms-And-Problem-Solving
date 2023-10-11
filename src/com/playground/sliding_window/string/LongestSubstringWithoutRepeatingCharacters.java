package com.playground.sliding_window.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * ================================
 * Given a string s, find the length of the longest substring without repeating characters.
 * ===============================
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public void run() {
        System.out.println(this.lengthOfLongestSubstring3("abcabcbb"));
    }

    /**
     * Runtime 7 ms Beats 42.45%
     * Memory 43.4 MB Beats 75.91%
     */
    public int lengthOfLongestSubstring3(String s) {
        char[] sArr = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLength = 0;

        for(char c: sArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(map.get(c) > 1) {
                map.put(sArr[start], map.get(sArr[start]) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        return maxLength;
    }

    /**
     * Leetcode solution 2ms
     */
    public int lengthOfLongestSubstring4    (String s)
    {
        int maxLen = 0;

        // [1] longest substring is the one with the largest
        //    difference between positions of repeated characters;
        //    thus, we should create a storage for such positions
        int[] pos = new int[128];

        // [2] while iterating through the string (i.e., moving
        //    the end of the sliding window), we should also
        //    update the start of the window
        int start = 0, end = 0;

        for (char ch : s.toCharArray())
        {
            // [3] get the position for the start of sliding window
            //    with no other occurences of 'ch' in it
            start  = Math.max(start, pos[ch]);

            // [4] update maximum length
            maxLen = Math.max(maxLen, end-start+1);

            // [5] set the position to be used in [3] on next iterations
            pos[ch] = end + 1;

            end++;
        }

        return maxLen;
    }


    /**
     * 1 is better in memory but time is similar.
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        if(s.length() < 2) return 1;

        int maxLength = 0;
        int startOfSubStringIndex = 0;
        int endOfSubStringIndex = 0;
        char currentCharacter;
        Map<Character, Integer> languageMap = new HashMap<>();

        while(endOfSubStringIndex < s.length()) {
            currentCharacter = s.charAt(endOfSubStringIndex);
            Integer value = languageMap.get(currentCharacter);

            if(value != null && value > 0) {
                while (startOfSubStringIndex < endOfSubStringIndex && s.charAt(startOfSubStringIndex) != currentCharacter) {
                    languageMap.put(s.charAt(startOfSubStringIndex), 0);
                    startOfSubStringIndex++;
                }
                languageMap.put(s.charAt(startOfSubStringIndex), 0);
                startOfSubStringIndex++;
            }
            else {
                int result = endOfSubStringIndex - startOfSubStringIndex + 1;
                maxLength = Math.max(result, maxLength);
            }

            endOfSubStringIndex++;
            languageMap.put(currentCharacter, 1);
        }


        return maxLength;
    }


    public int lengthOfLongestSubstring2(String s) {
        if(s.isEmpty()) return 0;
        if(s.length() < 2) return 1;

        int maxLength = 0;
        int startOfSubStringIndex = 0, endOfSubStringIndex = 0;
        Map<Character, Integer> languageMap = new HashMap<>();

        while(endOfSubStringIndex < s.length()) {
            char currentCharacter = s.charAt(endOfSubStringIndex);
            Integer value = languageMap.get(currentCharacter);

            while (value != null && value > 0) {
                languageMap.put(s.charAt(startOfSubStringIndex), 0);
                startOfSubStringIndex++;
                value = languageMap.get(currentCharacter);
            }

            maxLength = Math.max(endOfSubStringIndex - startOfSubStringIndex + 1, maxLength);
            endOfSubStringIndex++;
            languageMap.put(currentCharacter, 1);
        }

        return maxLength;
    }
}

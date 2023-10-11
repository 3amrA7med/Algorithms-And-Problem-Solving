package com.playground.sliding_window.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 424. Longest Repeating Character Replacement
 * =============================
 * You are given a string s and an integer k. You can choose any character of the string
 * and change it to any other uppercase English character. You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * =============
 * Example 1:
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achive this answer too.
 */
public class LongestRepeatingCharacterReplacement {

    public void run() {
        String s= "AABABBA";
        int result = characterReplacement(s, 1);
        System.out.print(s + " " + result);
    }

    /**
     * Needs optimizations to enhance time/memory performance
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        if(s.isEmpty()) return 0;
        if(s.length() == 1) return 1;

        int maxLength = 0;
        int startIndexOFSubString = 0;
        Map<Character, Integer> languageMap = new HashMap<>();
        int maxFrequency = 0;

        for(int endIndexOFSubString = 0; endIndexOFSubString < s.length(); endIndexOFSubString++) {
            char currentCharacter = s.charAt(endIndexOFSubString);
            // Update freq of the current character.
            languageMap.put(currentCharacter, languageMap.getOrDefault(currentCharacter, 0) + 1);
            maxFrequency = Math.max(maxFrequency, languageMap.getOrDefault(currentCharacter, 0));

            while((endIndexOFSubString - startIndexOFSubString +1) - maxFrequency > k) {
                int Freq = languageMap.getOrDefault(s.charAt(startIndexOFSubString), 0);
                if(Freq == 0) languageMap.remove(s.charAt(startIndexOFSubString));
                else languageMap.put(s.charAt(startIndexOFSubString), Freq - 1);
                startIndexOFSubString ++;
            }

            maxLength = Math.max(endIndexOFSubString - startIndexOFSubString + 1, maxLength);
        }

        return maxLength;
    }
}

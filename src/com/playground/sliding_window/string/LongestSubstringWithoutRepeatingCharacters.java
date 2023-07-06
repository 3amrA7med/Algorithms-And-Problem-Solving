package com.exercise.sliding_window.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 1 is better in memory but time is similar.
     * @param s
     * @return
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

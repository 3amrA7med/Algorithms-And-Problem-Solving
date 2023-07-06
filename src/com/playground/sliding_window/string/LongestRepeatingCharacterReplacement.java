package com.playground.sliding_window.string;

import java.util.HashMap;
import java.util.Map;

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

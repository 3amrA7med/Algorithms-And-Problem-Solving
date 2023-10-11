package com.playground.array.array_neetcode.easy;

import java.util.*;

public class WordPattern {

    public void run() {
        System.out.println(this.wordPattern("abba", "dog cat cat fish"));
    }

    /**
     * Runtime 1ms Beats 79.95%
     * Memory 40.75MB Beats 13.88%
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        char[] patternChars = pattern.toCharArray();

        if(patternChars.length != words.length) return false;

        Map<Character, String> map = new HashMap<>();

        for(int i = 0; i < patternChars.length; i++) {
            if(!map.containsKey(patternChars[i])) map.put(patternChars[i], words[i]);
            else if(!map.get(patternChars[i]).equals(words[i])) return false;
        }

        Set<String> set = new HashSet<>();
        for(char key: map.keySet()) {
            if(set.contains(map.get(key))) return false;
            set.add(map.get(key));
        }

        return true;
    }
}

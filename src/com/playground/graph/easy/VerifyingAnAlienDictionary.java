package com.playground.graph.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 953. Verifying an Alien Dictionary
 * Easy
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if
 * and only if the given words are sorted lexicographically in this alien language.
 * =============================
 * Example 1:
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 */
public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        char[] orderArr = order.toCharArray();

        for(int i = 0; i < orderArr.length; i++) map.put(orderArr[i], i);

        for(int i = 0; i < words.length - 1; i++) {
            char[] word1 = words[i].toCharArray();
            char[] word2 = words[i+1].toCharArray();
            for(int j = 0; j < word1.length; j++) {
                if(j >= word2.length || map.get(word1[j]) > map.get(word2[j])) return false;
                if(map.get(word1[j]) < map.get(word2[j])) break;
            }
        }

        return true;
    }
}

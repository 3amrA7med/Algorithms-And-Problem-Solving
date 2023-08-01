package com.playground.array_101.array_neetcode.medium;

import java.util.*;

/**
 * 49. Group Anagrams
 * New idea to construct a key of arrays but as a string in a hashmap.
 */
public class GroupAnagrams {

    public void run() {

        System.out.println(groupAnagrams1(new String[] {"bdddddddddd","bbbbbbbbbbc"}));
    }

    /**
     * 6ms Beats 98.66%
     * 46.55mb Beats 95.79%
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            char[] wordChars = strs[i].toCharArray();
            Arrays.sort(wordChars);
            String sortedWord = new String(wordChars);

            map.computeIfAbsent(sortedWord, k -> new ArrayList<>());
            map.get(sortedWord).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    private static final Integer CHARACTERS_COUNT = 26;
    /**
     * 16ms Beats 30.99%, best 2ms~8ms
     * 47.35mb Beats 29.18%, best 46
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            char[] str = strs[i].toCharArray();
            int[] freqArray = new int[CHARACTERS_COUNT];
            // Calculate count of characters.
            for(int j = 0; j < str.length; j++)
                freqArray[str[j] - 'a']++;

            // Build key
            StringBuilder keyBuilder = new StringBuilder();
            for(int j = 0; j < CHARACTERS_COUNT; j++)
                keyBuilder.append('-').append(freqArray[j]);
            String key = keyBuilder.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    //===========================================

    /**
     * The worst solution.
     * 798ms Beats 5.00%
     * 47.06mb Beats 58.34%
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int[][] freqArrays = new int[strs.length][CHARACTERS_COUNT];

        for(int i = 0; i < strs.length; i++) {
            char[] str = strs[i].toCharArray();
            int[] freqArray = new int[CHARACTERS_COUNT];
            for(int j = 0; j < str.length; j++)
                freqArray[str[j] - 'a']++;

            int index = findAnagram(freqArrays, freqArray);
            if(index == -1 || index >= result.size()) {
                freqArrays[result.size()] = freqArray;
                List<String> newAnagramGroup = new ArrayList<>();
                newAnagramGroup.add(strs[i]);
                result.add(newAnagramGroup);
            }
            else
                result.get(index).add(strs[i]);
        }
        return result;
    }

    private int findAnagram(int[][] freqArrays, int[] freqArray) {
        for(int i = 0; i < freqArrays.length; i++)
            if(Arrays.equals(freqArrays[i], freqArray)) return i;

        // Not found.
        return -1;
    }
}

package com.playground.sliding_window.string;

import java.util.*;

/**
 * 438. Find All Anagrams in a String
 */
public class FindAllAnagramsInAString {
    /**
     * Best runtime and memory performance.
     * @param s main string
     * @param p anagram string
     * @return list of indices
     */
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) return Collections.emptyList();

        List<Integer> resultIndices = new ArrayList<>();

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for(int i=0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if(Arrays.equals(sCount, pCount))
            resultIndices.add(0);

        int leftIndex = 0;

        for(int rightIndex = p.length(); rightIndex < s.length(); rightIndex++) {
            sCount[s.charAt(rightIndex) - 'a']++;
            sCount[s.charAt(leftIndex) - 'a']--;

            leftIndex++;
            if(Arrays.equals(sCount, pCount)){
                resultIndices.add(leftIndex);
            }
        }
        return resultIndices;
    }


    // Right answer not optimal compared to the previous
    public List<Integer> findAnagrams2(String s, String p) {

        if(p.length() > s.length()) return Collections.emptyList();
        // Prepare flag map of the p string
        Map<Character, Integer> anagramMapFreqCount = new HashMap<>();
        Map<Character, Integer> inputMapFreqCount = new HashMap<>();
        List<Integer> resultIndices = new ArrayList<>();

        for(int i = 0; i< p.length(); i++) {
            anagramMapFreqCount.put(p.charAt(i), anagramMapFreqCount.getOrDefault(p.charAt(i), 0)+1);
            inputMapFreqCount.put(s.charAt(i), inputMapFreqCount.getOrDefault(s.charAt(i), 0)+1);
        }

        if(inputMapFreqCount.equals(anagramMapFreqCount))
            resultIndices.add(0);

        int leftIndex = 0;

        for(int rightIndex = p.length(); rightIndex < s.length(); rightIndex++) {
            inputMapFreqCount.put(s.charAt(rightIndex), inputMapFreqCount.getOrDefault(s.charAt(rightIndex), 0)+1);
            inputMapFreqCount.put(s.charAt(leftIndex), inputMapFreqCount.getOrDefault(s.charAt(leftIndex), 0)-1);

            if(inputMapFreqCount.get(s.charAt(leftIndex)) == 0)
                inputMapFreqCount.remove(s.charAt(leftIndex));

            leftIndex++;
            if(inputMapFreqCount.equals(anagramMapFreqCount))
                resultIndices.add(leftIndex);
        }

        return resultIndices;
    }




    // Wrong answer because it assumes that the anagrams contain unique characters
    public List<Integer> findAnagrams3(String s, String p) {
        // Prepare flag map of the p string
        Map<Character, Integer> anagramMapFreqCount = new HashMap<>();
        Map<Character, Integer> inputMapFreqCount = new HashMap<>();
        for(int i = 0; i< p.length(); i++) {
            anagramMapFreqCount.put(p.charAt(i), anagramMapFreqCount.getOrDefault(p.charAt(i), 0)+1);
            inputMapFreqCount.put(p.charAt(i), 0);
        }

        List<Integer> resultIndices = new ArrayList<>();

        int leftIndex = 0;
        int anagramSize = 0;
        for(int rightIndex = 0; rightIndex < s.length(); rightIndex++) {

            Integer value = anagramMapFreqCount.get(s.charAt(rightIndex));

            // 3 possible outcomes, 1 or 0 or null
            if(value == null) {
                leftIndex = rightIndex + 1;
                initializeMapWithZeros(inputMapFreqCount, p);
                anagramSize = 0;
            }
            else if(value.equals(inputMapFreqCount.get(s.charAt(rightIndex)))) {
                while(inputMapFreqCount.get(s.charAt(rightIndex)).equals(anagramMapFreqCount.get(s.charAt(rightIndex))) && s.charAt(rightIndex) != s.charAt(leftIndex)) {
                    inputMapFreqCount.put(s.charAt(leftIndex), inputMapFreqCount.get(s.charAt(leftIndex)) - 1);
                    leftIndex++;
                    anagramSize--;
                }
                leftIndex++;
            }
            else{
                inputMapFreqCount.put(s.charAt(rightIndex), inputMapFreqCount.get(s.charAt(rightIndex)) + 1);
                anagramSize++;

                if(anagramSize == p.length()) {
                    resultIndices.add(leftIndex);
                    inputMapFreqCount.put(s.charAt(leftIndex), inputMapFreqCount.get(s.charAt(leftIndex)) - 1);
                    leftIndex++;
                    anagramSize--;
                }
            }

        }

        return resultIndices;
    }

    private void initializeMapWithZeros(Map<Character, Integer> flagMap, String p) {
        for(int i = 0; i< p.length(); i++)
            flagMap.put(p.charAt(i), 0);
    }

}

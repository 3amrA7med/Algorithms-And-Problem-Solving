package com.playground.greedy.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 763. Partition Labels
 * =========================================
 * You are given a string s. We want to partition the string into as many parts as possible so that each
 * letter appears in at most one part.
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 * Return a list of integers representing the size of these parts.
 * ===========================================================
 * Example 1:
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 * Input: s = "eccbbbbdec"
 * Output: [10]
 * =================================
 * Constraints:
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 *
 * d c c c c b a a b e
 * 0 4 4 4 4 8 7 7 8 9
 */
public class PartitionLabels {
    public void run() {
        System.out.println(partitionLabels1("dccccbaabe"));
    }

    /**
     * Runtime 4 ms Beats 91.10%
     * Memory 41.3 MB Beats 44.74%
     */
    public List<Integer> partitionLabels1(String s) {
        List<Integer> result = new ArrayList<>();
        Integer[] endValMap = new Integer[26];
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++) endValMap[chars[i] - 'a'] = i;


        int currStartIndex = 0;
        int currEndIndex = endValMap[chars[0]-'a'];
        for(int i = 1; i < chars.length; i++) {
            if(i > currEndIndex) {
                result.add((currEndIndex - currStartIndex) + 1);
                currStartIndex = i;
            }
            currEndIndex = Math.max(currEndIndex, endValMap[chars[i] - 'a']);
        }

        result.add((currEndIndex - currStartIndex) + 1);
        return result;
    }

    /**
     * 9ms Beats 45.71%
     * 42.06mb Beats 10.19%
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> endValMap = new HashMap<>();
        Map<Character, Integer> startValMap = new HashMap<>();
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            if(endValMap.get(chars[i]) == null) startValMap.put(chars[i], i);
            endValMap.put(chars[i], i);
        }

        int currStartIndex = startValMap.get(chars[0]);
        int currEndIndex = endValMap.get(chars[0]);
        startValMap.remove(chars[0]);
        endValMap.remove(chars[0]);
        for(int i = 0; i < chars.length; i++) {

            if(startValMap.get(chars[i]) == null || currEndIndex > endValMap.get(chars[i])) continue;
            if(currEndIndex < startValMap.get(chars[i])) {
                result.add((currEndIndex - currStartIndex) + 1);
                currStartIndex = startValMap.get(chars[i]);
            }

            currEndIndex = endValMap.get(chars[i]);

            startValMap.remove(chars[i]);
            endValMap.remove(chars[i]);
        }

        result.add((currEndIndex - currStartIndex) + 1);
        return result;
    }
}

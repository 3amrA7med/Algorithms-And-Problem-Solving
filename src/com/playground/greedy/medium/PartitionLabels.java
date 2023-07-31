package com.playground.greedy.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public void run() {
        System.out.println(partitionLabels("dccccbaabe"));
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

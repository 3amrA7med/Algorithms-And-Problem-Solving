package com.playground.sliding_window.string.medium;

import java.util.*;

/**
 * 187. Repeated DNA Sequences
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {

        if(s.length() < 10) return Collections.emptyList();

        Set<String> strings = new HashSet<>();
        Set<String> repeatedStrings = new HashSet<>();

        for(int i =0; i < s.length() - 9; i++) {
            String currentDnaSeq = s.substring(i, i+10);

            if(strings.contains(currentDnaSeq))
                repeatedStrings.add(currentDnaSeq);
            else
                strings.add(currentDnaSeq);
        }

        return new ArrayList<>(repeatedStrings);
    }
}

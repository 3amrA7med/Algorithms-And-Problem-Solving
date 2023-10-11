package com.playground.heap.medium;

import java.util.PriorityQueue;

/**
 * 767. Reorganize String
 * ================================
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 * Return any possible rearrangement of s or return "" if not possible.
 * ==================================
 * Example 1:
 * Input: s = "aab"
 * Output: "aba"
 * Example 2:
 * Input: s = "aaab"
 * Output: ""
 * ==========================================
 * Constraints:
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */
public class ReorganizeString {

    public void run() {
        System.out.println(reorganizeString("baaba"));
    }

    static class Element {
        char character;
        int count;

        Element(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }

    /**
     * 2ms Beats 77.79%
     * 40.48mb Beats 93.08%
     */
    public String reorganizeString(String s) {
        PriorityQueue<Element> pQueue = new PriorityQueue<>((a,b) -> Integer.compare(b.count, a.count));
        int[] freq = new int[26];
        char[] arr = s.toCharArray();
        char[] newArr = new char[arr.length];

        for (char c : arr) freq[c - 'a']++;

        for(int i = 0; i < 26; i++) if(freq[i] != 0) pQueue.offer(new Element((char)(i + 'a'), freq[i]));

        int totalCharactersCount = arr.length;
        Element prev = null;
        int index = 0;

        while(!pQueue.isEmpty() ) {
            Element currChar = pQueue.poll();
            if(totalCharactersCount - currChar.count < currChar.count - 1) return "";
            totalCharactersCount--;
            newArr[index++] = currChar.character;
            if(prev != null) {
                pQueue.offer(prev);
                prev = null;
            }
            currChar.count--;
            if(currChar.count > 0) prev = currChar;
        }

        return new String(newArr);
    }
}

package com.playground.heap.medium;

import java.util.PriorityQueue;

/**
 * 767. Reorganize String
 */
public class ReorganizeString {

    public void run() {
        System.out.println(reorganizeString("baaba"));
    }

    class Element {
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

        for(int i = 0; i < arr.length; i++) freq[arr[i] - 'a']++;

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

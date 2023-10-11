package com.playground.trees.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 211. Design Add and Search Words Data Structure
 *
 *  Your WordDictionary object will be instantiated and called as such:
 *  WordDictionary obj = new WordDictionary();
 *  obj.addWord(word);
 *  boolean param_2 = obj.search(word);
 *
 *
 * Beats 29.47% 342ms, best 200ms
 * Beats 46.02% 100 mb, best ~ 90mb
 */
public class DesignAddAndSearchWordsDataStructure {
    static class WordDictionary {

        static class Node {
            Map<Character, Node> map;
            boolean isWord;

            public Node() {
                map = new HashMap<>();
                isWord = false;
            }
        }

        Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            char[] chars = word.toCharArray();
            Node iterator = root;

            for(int i = 0; i < chars.length; i++) {
                if(iterator.map.get(chars[i]) == null)
                    iterator.map.put(chars[i], new Node());
                iterator = iterator.map.get(chars[i]);
            }
            iterator.isWord = true;
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            Node iterator = root;

            for(int i = 0; i < chars.length; i++) {
                if(chars[i] == '.') {
                    boolean resultFoundFlag;
                    for(Map.Entry<Character, Node> it: iterator.map.entrySet()) {
                        resultFoundFlag = searchHelper(chars, i+1, it.getValue(), 1);
                        if(resultFoundFlag) return true;
                    }
                    return false;
                }
                if(iterator.map.get(chars[i]) == null)
                    return false;
                iterator = iterator.map.get(chars[i]);
            }
            return iterator.isWord;
        }

        public boolean searchHelper(char[] chars, int i, Node iterator, int numOfDots) {
            if(numOfDots > 2) return false;
            for(; i < chars.length; i++) {
                if(chars[i] == '.') {
                    boolean resultFoundFlag;
                    for(Map.Entry<Character, Node> it: iterator.map.entrySet()) {
                        resultFoundFlag = searchHelper(chars, i+1, it.getValue(), numOfDots + 1);
                        if(resultFoundFlag) return true;
                    }
                    return false;
                }
                if(iterator.map.get(chars[i]) == null)
                    return false;
                iterator = iterator.map.get(chars[i]);
            }
             return iterator.isWord;
        }
    }
}

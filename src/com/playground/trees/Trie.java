package com.playground.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree)
 *
 * Beats 21.53% => 51ms and best is 3x ms
 * Memory: beats 10% 55.5mb best 50mb.
 */
public class Trie {

    class Node {
        Map<Character, Node> map;
        boolean isWord;

        public Node() {
            map = new HashMap<>();
            isWord = false;
        }
    }

    Node root;
    public Trie() {
        root = new Node();
    }


    public void insert(String word) {
        char[] characters = word.toCharArray();

        Node curr = root;
        for (char character : characters) {
            if (curr.map.get(character) == null) // Doesn't exist, add a map for it
                curr.map.put(character, new Node());

            curr = curr.map.get(character);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        char[] characters = word.toCharArray();

        Node curr = root;
        for (char character : characters) {
            if (curr.map.get(character) == null) // Doesn't exist
                return false;
            curr = curr.map.get(character);
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        char[] characters = prefix.toCharArray();

        Node curr = root;
        for (char character : characters) {
            if (curr.map.get(character) == null) // Doesn't exist
                return false;
            curr = curr.map.get(character);
        }

        return true;
    }
}

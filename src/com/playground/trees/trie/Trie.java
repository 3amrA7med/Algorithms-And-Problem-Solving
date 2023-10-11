package com.playground.trees.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree)
 * ==================================
 * Runtime 33 ms Beats 86.3%
 * Memory 54.5 MB Beats 81.59%
 */
class Trie2 {

    class Node {
        Node[] children;
        boolean isWord;
        static final int NUM_OF_CHARS = 26;

        public Node() {
            children = new Node[NUM_OF_CHARS];
            isWord = false;
        }
    }

    Node root;
    public Trie2() {
        root = new Node();
    }


    public void insert(String word) {
        char[] characters = word.toCharArray();

        Node curr = root;
        for(int i = 0; i < characters.length; i++) {
            if(curr.children[characters[i] - 'a'] == null) // Doesn't exist, add a map for it
                curr.children[characters[i] - 'a'] = new Node();

            curr = curr.children[characters[i] - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        char[] characters = word.toCharArray();

        Node curr = root;
        for(int i = 0; i < characters.length; i++) {
            if(curr.children[characters[i] - 'a'] == null) // Doesn't exist
                return false;
            curr = curr.children[characters[i] - 'a'];
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        char[] characters = prefix.toCharArray();

        Node curr = root;
        for(int i = 0; i < characters.length; i++) {
            if(curr.children[characters[i] - 'a'] == null) // Doesn't exist
                return false;
            curr = curr.children[characters[i] - 'a'];
        }

        return true;
    }
}

 /**
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



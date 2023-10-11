package com.playground.trees.trie;

import java.util.*;

/**
 * 212. Word Search II
 * ======================
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells
 * are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * =======================
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 *        words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 */
public class WordSearchII {

    public void run() {
        System.out.println(this.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
        new String[]{"oath","pea","eat","rain"}));
    }

    /**
     * Runtime 803ms Beats 20.38%
     * Memory 47.43MB Beats 6.49%
     * needs optimization, use array instead of hashmap.
     */
    static class Trie {
        static class Node {
            public Map<Character, Node> map;
            public boolean isWord;

            Node() {
                this.map = new HashMap<>();
                this.isWord = false;
            }
        }

        public Node root;

        Trie() {
            this.root = new Node();
        }

        public void addWord(String word) {
            char[] wordArr = word.toCharArray();
            Node curr = root;
            for (char c : wordArr) {
                if (curr.map.get(c) == null) curr.map.put(c, new Node());
                curr = curr.map.get(c);
            }
            curr.isWord = true;
        }
    }

    List<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        result = new ArrayList<>();
        Trie prefixTree = new Trie();
        for(String word: words) prefixTree.addWord(word);

        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                dfs(board, prefixTree.root, "", r, c);
            }
        }

        return result;
    }

    public void dfs(char[][] board, Trie.Node node, String word, int r, int c) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || node.map.get(board[r][c]) == null) return;

        char temp = board[r][c];
        word+=board[r][c];
        Trie.Node newChild = node.map.get(board[r][c]);
        if(newChild.isWord) result.add(word);
        board[r][c] = '#';
        dfs(board, newChild, word, r + 1, c);
        dfs(board, newChild, word, r - 1, c);
        dfs(board, newChild, word, r, c + 1);
        dfs(board, newChild, word, r, c - 1);
        board[r][c] = temp;
    }
}

package com.playground.trees.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1268. Search Suggestions System
 * Can be solved using trie, but this solution is easier.
 */
public class SearchSuggestionsSystem {
    List<List<String>> result;

    /**
     * 13ms Beats 90.95%
     * 46.57mb Beats 71.23%
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        result = new ArrayList<>();
        char[] sWord = searchWord.toCharArray();
        int l = 0;
        int r = products.length - 1;

        for(int i = 0; i < sWord.length; i++) {
            while(l <= products.length - 1 && notSamePrefix(products[l], sWord, i)) l++;
            while(r >= 0 && notSamePrefix(products[r], sWord, i)) r--;
            addToAnswer(products, l , r);
        }

        return result;
    }

    private boolean notSamePrefix(String word, char[] prefix, int index) {
        char[] wordArr = word.toCharArray();
        if(wordArr.length - 1 < index) return true;
        for(int i = 0; i <= index; i++)
            if(wordArr[i] != prefix[i]) return true;
        return false;
    }

    private void addToAnswer(String[] products, int start, int end) {
        if(end < start) {
            result.add(new ArrayList<>());
            return;
        }
        if((end - start) >= 3) end = start + 2;
        List<String> suggestions = new ArrayList<>();
        for(int i = start; i <= end; i++) suggestions.add(products[i]);
        result.add(suggestions);
    }
}

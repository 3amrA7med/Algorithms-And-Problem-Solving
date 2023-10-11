package com.playground.backtrack.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning    [IMPORTANT]
 * ============================
 * Given a string s, partition s such that every  substring of the partition is a palindrome
 * Return all possible palindrome partitioning of s.
 * ===========================
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 * ============================
 */
public class PalindromePartitioning {

    public void run() {
        System.out.println(partition("aab"));
    }

    List<List<String>> result;

    /**
     * 6ms Beats 99.18%
     * 55.68mb Beats 25.89%, best 53
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        partitionRec(s.toCharArray(), s, 0, 0, new ArrayList<>());
        return result;
    }

    public void partitionRec(char[] sArr, String s, int l, int r, List<String> partition) {
        if(r >= sArr.length) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for(int i = 0; i < sArr.length - r; i++) {
            if(checkNotPalindrome(sArr, l, r+i)) continue;
            partition.add(s.substring(l, r+i+1));
            partitionRec(sArr, s, r+i+1,r+i+1, partition);
            partition.remove(partition.size() - 1);
        }
    }

    private boolean checkNotPalindrome(char[] sArr, int l, int r) {
        while(l<r && sArr[l]==sArr[r]) {
            l++;
            r--;
        }
        return l<r;
    }
}

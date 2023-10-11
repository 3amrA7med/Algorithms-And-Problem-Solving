package com.playground.backtrack.medium;

import java.util.*;

/**
 * 1980. Find Unique Binary String
 * ===============================
 * Given an array of strings nums containing n unique binary strings each of length n, return a binary string of
 * length n that does not appear in nums. If there are multiple answers, you may return any of them.
 * ========================================
 * Example 1:
 * Input: nums = ["01","10"]
 * Output: "11"
 * Explanation: "11" does not appear in nums. "00" would also be correct.
 * Example 2:
 * Input: nums = ["00","01"]
 * Output: "11"
 * Explanation: "11" does not appear in nums. "10" would also be correct.
 * Example 3:
 * Input: nums = ["111","011","001"]
 * Output: "101"
 * Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 * ========================================
 * Constraints:
 * n == nums.length
 * 1 <= n <= 16
 * nums[i].length == n
 * nums[i] is either '0' or '1'.
 * All the strings of nums are unique.
 * ========================================
 * this problem can be solved with backtracing but cutting the recursion upon finding the answer.
 */
public class FindUniqueBinaryString {

    /**
     * Runtime 0 ms Beats 100%
     * Memory 40.6 MB Beats 46.74%
     */
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < nums.length; i++) res.append((nums[i].charAt(i) == '0')? '1': '0');
        return res.toString();
    }

    // =================================================
    public String findDifferentBinaryString2(String[] nums) {

        // we would use the hashset to store the base 10 representation of the binary strings
        Set<Integer> set = new HashSet<>();

        // res will store the result
        String res = "";

        // iterate through the list of binary strings, convert them to decimal and store in the hashset
        for(String i : nums)set.add(Integer.parseInt(i,2));

        // as the range is from 1 to 16 in the question, so we check for any one number that is missing in the hashset from 1 to 16
        for(int i = 0 ;i <= 16; i++){
            if(!set.contains(i)){
                // when we find the missing number, we store its binary form in res and break out of the loop
                res = Integer.toBinaryString(i);
                break;
            }
        }

        // we convert res to the required length for the binary representation as per the binary strings in the list  "nums"
        StringBuilder temp = new StringBuilder(res);
        while(temp.length() < nums[0].length())temp.insert(0,0);
        res = temp.toString();

        // return the result
        return res;
    }
}

package com.playground.trees.medium;

import com.playground.trees.model.TreeNode;

/**
 * 1372. Longest ZigZag Path in a Binary Tree
 * LeetCode 75
 */
public class LongestZigZagPathInABinaryTree {

    int longestZigZag = 0;

    /**
     * 4ms Beats 99.04%
     * 54.91mb Beats 75.19%
     */
    public int longestZigZag(TreeNode root) {
        longestZigZagRec(root.left, false, 1);
        longestZigZagRec(root.right, true, 1);

        return longestZigZag;
    }

    public void longestZigZagRec(TreeNode root, boolean isRight, int zigZag) {
        if(root == null) return;
        longestZigZag = Math.max(zigZag, longestZigZag);

        if(isRight) {
            longestZigZagRec(root.left, false, zigZag + 1);
            longestZigZagRec(root.right, true, 1);
        }
        else {
            longestZigZagRec(root.right, true, zigZag + 1);
            longestZigZagRec(root.left, false, 1);
        }
    }

    /* Time Limit Exceeds.
    int longestZigZag = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;

        int res = Math.max(longestZigZagRec(root.left, false), longestZigZagRec(root.right, true));
        longestZigZag = Math.max(res, longestZigZag);
        longestZigZag(root.left);
        longestZigZag(root.right);

        return longestZigZag;
    }

    public int longestZigZagRec(TreeNode root, boolean isRight) {
        if(root == null) return 0;

        if(isRight) return 1 + longestZigZagRec(root.left, false);
        else        return 1 + longestZigZagRec(root.right, true);
    }
     */
}

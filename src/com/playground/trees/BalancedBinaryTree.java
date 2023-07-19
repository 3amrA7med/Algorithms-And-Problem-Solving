package com.playground.trees;

import com.playground.trees.model.TreeNode;

/**
 * 110. Balanced Binary Tree
 */
public class BalancedBinaryTree {
    // 93 % 1ms bad memory but not too far from best.

    public boolean isBalanced(TreeNode root) {

        return checkDifference(root) != -1;
    }

    public int checkDifference(TreeNode root) {
        if(root == null) return 0;

        int l = checkDifference(root.left);
        int r = checkDifference(root.right);
        if(l == -1 || r == -1) return -1;
        if(Math.abs(l-r) > 1) return -1;

        return Math.max(l,r) +1;
    }
}

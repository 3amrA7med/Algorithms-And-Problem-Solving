package com.playground.trees.hard;

import com.playground.trees.model.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum
 */
public class BinaryTreeMaximumPathSum {

    // Beats 91.17% runtime, memory Beats 82.07%
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumRec(root);
        return res;
    }

    public int maxPathSumRec(TreeNode root) {
        if(root == null) return 0;

        int leftPath = maxPathSumRec(root.left);
        int rightPath = maxPathSumRec(root.right);

        if(leftPath != 0) res = Math.max(res, leftPath);
        if(rightPath != 0) res = Math.max(res, rightPath);

        res = Math.max(res, root.val);
        res = Math.max(res, leftPath + rightPath + root.val);
        res = Math.max(res, leftPath + root.val);
        res = Math.max(res, rightPath + root.val);

        return Math.max(root.val, Math.max(leftPath + root.val, rightPath + root.val));
    }
}

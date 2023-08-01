package com.playground.trees.medium;

import com.playground.trees.model.TreeNode;

/**
 * 437. Path Sum III
 * LeetCode 75
 */
public class PathSum3 {

    int count = 0;

    /**
     * 17ms Beats 52.79%
     * 42.74mb Beats 97.73%
     * There exists another solution using hashmap
     */
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        pathSumRec(root, 0, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;
    }

    public void pathSumRec(TreeNode root, long pathSum, int targetSum) {
        if(root == null) return;
        pathSum+=root.val;
        if(pathSum == targetSum) count++;

        pathSumRec(root.left, pathSum, targetSum);
        pathSumRec(root.right, pathSum, targetSum);
    }
}

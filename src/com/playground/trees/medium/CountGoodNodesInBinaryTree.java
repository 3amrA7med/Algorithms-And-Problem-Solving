package com.playground.trees.medium;

import com.playground.trees.model.TreeNode;

/**
 * 1448. Count Good Nodes in Binary Tree
 */
public class CountGoodNodesInBinaryTree {

    // 100% runtime 98% memory
    public int goodNodes(TreeNode root) {
        return goodNodesDfs(root, Integer.MIN_VALUE);
    }

    public int goodNodesDfs(TreeNode root, int maxValInPath) {
        if(root == null) return 0;

        int valToAdd = 0;
        if(root.val >= maxValInPath) {
            maxValInPath = root.val;
            valToAdd = 1;
        }

        return valToAdd + goodNodesDfs(root.left, maxValInPath) + goodNodesDfs(root.right, maxValInPath);
    }
}

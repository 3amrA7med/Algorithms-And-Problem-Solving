package com.playground.trees;

import com.playground.trees.model.TreeNode;

/**
 * 543. Diameter of Binary Tree
 */
public class DiameterOfBinaryTree {
    // 100% runtime
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    public int dfs(TreeNode root) {
        if(root == null) return -1;

        int l = dfs(root.left);
        int r = dfs(root.right);

        maxDiameter = Math.max(maxDiameter, l+r+2);
        return Math.max(l, r) + 1;
    }
}

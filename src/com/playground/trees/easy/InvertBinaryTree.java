package com.playground.trees.easy;

import com.playground.trees.model.TreeNode;

/**
 * 226. Invert Binary Tree
 */
public class InvertBinaryTree {

    // 100% runtime, 80% memory

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}

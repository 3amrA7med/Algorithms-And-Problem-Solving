package com.playground.trees.medium;

import com.playground.trees.model.TreeNode;

/**
 * 98. Validate Binary Search Tree
 */
public class ValidateBinarySearchTree {

    // 100% runtime, 96% memory
    public boolean isValidBST(TreeNode root) {
        return isValidBSTRec(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTRec(TreeNode root, long minVal, long maxVal) {
        if(root == null) return true;

        if(root.val <= minVal || root.val >= maxVal) return false;

        return isValidBSTRec(root.left, minVal, root.val) && isValidBSTRec(root.right, root.val, maxVal);
    }
}

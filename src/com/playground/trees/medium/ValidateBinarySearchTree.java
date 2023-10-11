package com.playground.trees.medium;

import com.playground.trees.model.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * ==========================================
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * =============================================
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * ========================================
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
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

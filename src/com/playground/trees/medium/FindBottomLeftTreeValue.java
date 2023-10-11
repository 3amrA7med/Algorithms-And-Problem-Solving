package com.playground.trees.medium;

import com.playground.trees.model.TreeNode;

/**
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 * ==============================
 * Example 1:
 * Input: root = [2,1,3]
 * Output: 1
 * Example 2:
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
 * =================================
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */
public class FindBottomLeftTreeValue {

    /**
     * Runtime 0 ms Beats 100%
     * Memory 43.4 MB Beats 89.10%
     */
    int lastLevel = 0;
    int leftMostVal;
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValueRec(root, 1);
        return leftMostVal;
    }

    public void findBottomLeftValueRec(TreeNode root, int level) {
        if(root == null) return;

        if(level > lastLevel) {leftMostVal = root.val; lastLevel = level;}
        findBottomLeftValueRec(root.left, level + 1);
        findBottomLeftValueRec(root.right, level + 1);
    }
}

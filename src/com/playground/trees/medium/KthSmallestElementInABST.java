package com.playground.trees.medium;

import com.playground.trees.model.TreeNode;

/**
 * 230. Kth Smallest Element in a BST
 */
public class KthSmallestElementInABST {

    int res;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestRec(root, k);
        return res;
    }

    public int kthSmallestRec(TreeNode root, int k) {
        if(root == null) return k;

        k = kthSmallestRec(root.left, k);
        k-=1;
        if(k == 0) {
            res = root.val;
            return -1;
        }
        k = kthSmallestRec(root.right, k);
        return k;
    }
}

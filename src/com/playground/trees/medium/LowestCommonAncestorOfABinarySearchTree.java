package com.playground.trees.medium;

import com.playground.trees.model.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */
public class LowestCommonAncestorOfABinarySearchTree {

    // 97% runtime, 70% memory
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,p,q);
        else if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left,p,q);
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if(p.val < root.val && q.val < root.val) root = root.left;
            else if(p.val > root.val && q.val > root.val) root = root.left;
            else return root;
        }
    }
}

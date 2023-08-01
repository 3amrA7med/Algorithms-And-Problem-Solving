package com.playground.trees.medium;

import com.playground.trees.model.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * LeetCode 75
 */
public class LowestCommonAncestorOfABinaryTree {

    TreeNode lcaNode = null;

    /**
     * First parent 0 -> 2 -> 5 -> 9    lca(9,11) = 2
     *              0 -> 2 -> 6 -> 11
     * 6ms Beats 99.04%
     * 44.91mb Beats 9.27%
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorTraversal(root, p, q);
        return lcaNode;
    }

    public boolean[] lowestCommonAncestorTraversal(TreeNode root, TreeNode p, TreeNode q) {
        boolean[] nodesFound = new boolean[2];
        if(root == null || lcaNode != null) return nodesFound;

        boolean[] nodesFoundLeft = lowestCommonAncestorTraversal(root.left, p, q);
        boolean[] nodesFoundRight = lowestCommonAncestorTraversal(root.right, p, q);

        nodesFound[0] = nodesFoundLeft[0] || nodesFoundRight[0] || root == p;
        nodesFound[1] = nodesFoundLeft[1] || nodesFoundRight[1] || root == q;

        if(nodesFound[0] && nodesFound[1])
            if(lcaNode == null) lcaNode = root;

        return nodesFound;
    }
}

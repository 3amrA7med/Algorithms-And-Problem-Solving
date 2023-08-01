package com.playground.trees.easy;

import com.playground.trees.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 * LeetCode 75
 */
public class LeafSimilarTrees {

    /**
     * -ms Beats 100.00%
     * 40.32mb Beats 64.92%
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Leafs = new ArrayList<>();
        List<Integer> root2Leafs = new ArrayList<>();
        leafSimilarPreOrderTraversal(root1, root1Leafs);
        leafSimilarPreOrderTraversal(root2, root2Leafs);

        return root1Leafs.equals(root2Leafs);
    }

    public void leafSimilarPreOrderTraversal(TreeNode root, List<Integer> leafs) {
        if (root == null) return;
        leafSimilarPreOrderTraversal(root.left, leafs);
        if (root.left == null && root.right == null) leafs.add(root.val);
        leafSimilarPreOrderTraversal(root.right, leafs);

    }
}

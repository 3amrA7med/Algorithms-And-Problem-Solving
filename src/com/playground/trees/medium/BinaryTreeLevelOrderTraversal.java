package com.playground.trees.medium;

import com.playground.trees.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {

    // 99% runtime, 40% memory
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderRec(root, result, 0);
        return result;
    }

    public void levelOrderRec(TreeNode root, List<List<Integer>> result, int level) {
        if(root == null) return;

        if(result.size() > level)
            result.get(level).add(root.val);
        else
            result.add(new ArrayList<>(){{add(root.val);}});

        levelOrderRec(root.left, result, level + 1);
        levelOrderRec(root.right, result, level + 1);
    }
}

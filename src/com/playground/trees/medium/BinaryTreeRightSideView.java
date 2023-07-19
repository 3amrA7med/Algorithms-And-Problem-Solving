package com.playground.trees.medium;

import com.playground.trees.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 * DFS solution also these exists a BFS solution
 */
public class BinaryTreeRightSideView {
    List<Integer> result = new ArrayList<>();

    // 100% runtime, 45%memory
    public List<Integer> rightSideView(TreeNode root) {
        rightSideViewRec(root, 0);
        return result;
    }

    public void rightSideViewRec(TreeNode root, int level) {
        if(root == null) return;
        if(result.size() > level)
            result.set(level, root.val);
        else
            result.add(root.val);
        rightSideViewRec(root.left, level+1);
        rightSideViewRec(root.right, level+1);
    }
}

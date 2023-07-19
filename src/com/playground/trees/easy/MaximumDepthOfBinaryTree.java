package com.playground.trees.easy;

import com.playground.trees.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 104. Maximum Depth of Binary Tree
 */
public class MaximumDepthOfBinaryTree {

    //100% runtime 0 ms, 70% memory 42.5

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        //return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1); // 11% memory
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1; // 70% memory
    }


    // 11% runtime 1ms but 96% memory 42.2
    public int maxDepthBfs(TreeNode root) {
        if(root == null) return 0;

        Deque<TreeNode> queue = new ArrayDeque<>();
        int level = 0;

        queue.addFirst(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i =0; i < size; i++) {
                TreeNode temp = queue.removeFirst();
                if(temp.left != null) queue.addLast(temp.left);
                if(temp.right != null) queue.addLast(temp.right);
            }
            level++;
        }
        return level;
    }


    public class StackNode {
        TreeNode node;
        int depth;

        StackNode(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }

    // worst soln, 5% runtime 2ms 5% memory 43.5
    public int maxDepthDfs(TreeNode root) {
        if(root == null) return 0;

        Deque<StackNode> stack = new ArrayDeque<>();
        int maxLevel = 0;

        stack.addFirst(new StackNode(root, 1));
        while(!stack.isEmpty()) {
            StackNode temp = stack.removeFirst();
            if(temp.depth > maxLevel) maxLevel = temp.depth;
            if(temp.node.left != null) stack.addFirst(new StackNode(temp.node.left, temp.depth + 1));
            if(temp.node.right != null) stack.addFirst(new StackNode(temp.node.right, temp.depth + 1));

        }
        return maxLevel;
    }
}

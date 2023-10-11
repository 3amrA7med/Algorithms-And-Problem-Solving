package com.playground.trees.medium.bfs;

import com.playground.trees.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161. Maximum Level Sum of a Binary Tree
 * =========================================
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 * =========================================
 * Example 1:
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 * Example 2:
 * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * Output: 2
 * ====================================
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 */
public class MaximumLevelSumOfABinaryTree {

    /**
     * Runtime 8 ms Beats 88.4%
     * Memory 46 MB Beats 74.36%
     */
    public int maxLevelSum2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        int currLevel = 1;
        int maxLevel = 1;
        int maxSum = Integer.MIN_VALUE;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            if(levelSum > maxSum) {
                maxLevel = currLevel;
                maxSum = levelSum;
            }

            currLevel++;
        }

        return maxLevel;
    }

    /**
     * Runtime 8 ms Beats 88.4%
     * Memory 46 MB Beats 63.1%
     */
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();

        int currLevel = 1;
        int maxLevel = 1;
        int maxSum = Integer.MIN_VALUE;
        queue.addLast(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                levelSum += node.val;
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
            }

            if(levelSum > maxSum) {
                maxLevel = currLevel;
                maxSum = levelSum;
            }

            currLevel++;
        }

        return maxLevel;
    }
}

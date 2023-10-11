package com.playground.trees.medium;

import com.playground.trees.hard.SerializeAndDeserializeBinaryTree;
import com.playground.trees.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 958. Check Completeness of a Binary Tree
 * ===================================
 * Given the root of a binary tree, determine if it is a complete binary tree.
 * In a complete binary tree, every level, except possibly the last is completely filled,
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes
 * inclusive at the last level h.
 * =============================================
 * Example 1:
 * Input: root = [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 * Example 2:
 * Input: root = [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 * ===================================
 * Constraints:
 * The number of nodes in the tree is in the range [1, 100].
 * 1 <= Node.val <= 1000
 */
public class CheckCompletenessOfABinaryTree {

    public void run() {
        SerializeAndDeserializeBinaryTree.Codec deser = new SerializeAndDeserializeBinaryTree.Codec();
        TreeNode root = deser.deserialize("1,2,3,4,5,6");
        System.out.println(this.isCompleteTree(root));
    }

    /**
     * Runtime 1 ms Beats 90.17%
     * Memory 41.3 MB Beats 19.49%
     */
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        TreeNode nullNode = new TreeNode(-1);
        TreeNode prevNode = new TreeNode(2); // fake value
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(prevNode.val == -1 && curr.val != -1) return false;
                prevNode = curr;
                if(curr.val != -1) {
                    queue.add((curr.left == null) ? nullNode : curr.left);
                    queue.add((curr.right == null) ? nullNode : curr.right);
                }
            }
        }

        return true;
    }
    //============ Wrong thinking
    int lastLevel = 0;
    public boolean isCompleteTreeXX(TreeNode root) {
        return nodesCount(root, 1) != -1;
    }

    public int nodesCount(TreeNode root, int level) {
        if(root == null) {
            lastLevel = Math.max(lastLevel, level - 1);
            return 0;
        }

        int left = nodesCount(root.left, level + 1);
        int right = nodesCount(root.right, level + 1);

        if(left == -1 || right == -1 || right > left || (left-right) > Math.pow(2,(lastLevel - level - 1))) return -1;
        return left+right+1;
    }
}

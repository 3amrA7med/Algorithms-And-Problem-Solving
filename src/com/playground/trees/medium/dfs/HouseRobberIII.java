package com.playground.trees.medium.dfs;

import com.playground.trees.model.TreeNode;

/**
 * 337. House Robber III
 * ===================================================
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all
 * houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses
 * were broken into on the same night. Given the root of the binary tree, return the maximum amount of money the
 * thief can rob without alerting the police.
 * ================================================================
 * Example 1:
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * ====================================================================
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 104
 */
public class HouseRobberIII {

    /**
     * Runtime 0 ms Beats 100%
     * Memory 44 MB Beats 33.39%
     */
    public int rob(TreeNode root) {
        int[] res = robDfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robDfs(TreeNode root) {
        if(root == null) return new int[]{0,0};

        int[] leftVals = robDfs(root.left);
        int[] rightVals = robDfs(root.right);

        // Memory 43.2 MB Beats 97.38%
        // return new int[]{root.val + leftVals[1] + rightVals[1], Math.max(Math.max(leftVals[0] + rightVals[0], leftVals[1] + rightVals[1]), Math.max(leftVals[0] + rightVals[1], leftVals[1] + rightVals[0]))};
        return new int[]{root.val + leftVals[1] + rightVals[1], Math.max(leftVals[0], leftVals[1]) + Math.max(rightVals[0], rightVals[1])};
    }
}


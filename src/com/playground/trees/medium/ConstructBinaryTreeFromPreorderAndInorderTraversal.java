package com.playground.trees.medium;

import com.playground.trees.model.TreeNode;

import java.util.Arrays;

/**
 * Good problem
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * ===================================
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and
 * inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * ===============================
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * ====================================
 * Constraints:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * Runtime 3 ms Beats 44.59%
     * Memory 42.8 MB Beats 95.17%
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTreeRec(preorder, inorder, 0, preorder.length - 1, 0, inorder.length);
    }

    public TreeNode buildTreeRec(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        int preLength = preEnd-preStart;
        int inLength = inEnd-inStart;
        if(preLength < 0 || inLength < 0) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        if(preLength == 0 && inLength == 0) return root;

        int index =  getIndex(inorder, root.val, inStart, inEnd);
        int displacement = (index-inStart);
        root.left = buildTreeRec(preorder, inorder, preStart+1, preStart + displacement, inStart, inStart + displacement);
        root.right = buildTreeRec(preorder, inorder, preStart + displacement + 1, preEnd, inStart + displacement + 1, inEnd);
        return root;
    }

    private int getIndex(int[] arr, int val, int startIndex, int endIndex) {
        for(int i = startIndex; i <= endIndex; i++)
            if(arr[i] == val) return i;

        return -1;
    }

    // 5% runtime and bad memory also, O(N^2)
    // Runtime 13 ms Beats 5.6%
    // Memory 80.4 MB Beats 5.70%
    // the optimal in this case would be using hashmap instead of the array to get the index in O(1)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1 && inorder.length == 1) return root;

        int index =  getIndex(inorder, root.val);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }

    private int getIndex(int[] arr, int val) {
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == val) return i;

        return -1;
    }
}

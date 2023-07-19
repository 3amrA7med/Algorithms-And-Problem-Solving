package com.playground.trees.medium;

import com.playground.trees.model.TreeNode;

import java.util.Arrays;

/**
 * Good problem
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    // 5% runtime and bad memory also, O(N^2)
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

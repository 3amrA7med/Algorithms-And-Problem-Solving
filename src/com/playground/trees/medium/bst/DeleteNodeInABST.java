package com.playground.trees.medium.bst;

import com.playground.trees.hard.SerializeAndDeserializeBinaryTree;
import com.playground.trees.model.TreeNode;

/**
 * 450. Delete Node in a BST
 * ===========================
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove. If the node is found, delete the node.
 * ==============================
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 */
public class DeleteNodeInABST {

    public void run() {
        SerializeAndDeserializeBinaryTree.Codec ser = new SerializeAndDeserializeBinaryTree.Codec();
        SerializeAndDeserializeBinaryTree.Codec deser = new SerializeAndDeserializeBinaryTree.Codec();
        TreeNode root = deser.deserialize("5,3,6,2,4,n,7");
        System.out.println(this.deleteNode(root, 3));
    }

    /**
     * Runtime 0ms Beats 100.00%
     * Memory 44.98MB Beats 75.29%
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val > key)      root.left = deleteNode(root.left, key);
        else if(root.val < key) root.right = deleteNode(root.right, key);
        else if(key == root.val) { // delete node // when removing if memory consumption inc.
            if(root.right == null) return root.left;
            else if(root.left == null) return root.right;

            // Has 2 subtrees.
            TreeNode succParent = root;
            TreeNode succ = root.right;
            while(succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            if(root == succParent) succParent.right = succ.right;
            else succParent.left = succ.right;
            root.val = succ.val;
        }

        return root;
    }
}

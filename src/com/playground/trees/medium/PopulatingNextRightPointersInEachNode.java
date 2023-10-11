package com.playground.trees.medium;

/**
 * 116. Populating Next Right Pointers in Each Node
 * ================================================
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * The binary tree has the following definition:
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * =======================================
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * Example 2:
 * Input: root = []
 * Output: []
 * =======================================
 * Constraints:
 * The number of nodes in the tree is in the range [0, 212 - 1].
 * -1000 <= Node.val <= 1000
 * ====================================
 * Follow-up:
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 */
public class PopulatingNextRightPointersInEachNode {

    /**
     * Runtime 0ms Beats 100.00%
     * Memory 43.86MB Beats 8.52%
     */
    public Node connect(Node root) {
        connectRec(root, null);
        return root;
    }

    public void connectRec(Node root, Node next) {
        if(root == null) return;

        root.next = next;
        connectRec(root.left, root.right);
        if(root.next == null) connectRec(root.right, null);
        else connectRec(root.right, root.next.left);
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}

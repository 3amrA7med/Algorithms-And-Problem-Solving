package com.playground.trees.hard;

import com.playground.trees.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * 297. Serialize and Deserialize Binary Tree
 * Beats 54.10% 18ms, best 6ms
 * Memory Beats 80.05% 44.5mb, best 43
 */
public class SerializeAndDeserializeBinaryTree {
    public static class Codec {
        final static Integer NULL_VALUE = -1001;

        // Encodes a tree to a single string.
        // BFS encoding
        public String serialize(TreeNode root) {
            if(root == null) return "";
            Deque<TreeNode> queue = new ArrayDeque<>();
            StringBuilder encodedString = new StringBuilder();

            queue.addLast(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i ++) {
                    TreeNode node = queue.removeFirst();
                    if(node.val == NULL_VALUE) encodedString.append('n');
                    else {
                        encodedString.append(node.val);
                        queue.addLast(Objects.requireNonNullElseGet(node.left, () -> new TreeNode(NULL_VALUE)));
                        queue.addLast(Objects.requireNonNullElseGet(node.right, () -> new TreeNode(NULL_VALUE)));
                    }
                    encodedString.append(',');
                }
            }

            return encodedString.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.length() == 0) return null;

            String[] arr = data.split(",", 0);
            Deque<TreeNode> queue = new ArrayDeque<>();

            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            queue.addLast(root);

            int arrIndex = 1;
            while(arrIndex < arr.length - 1) {
                TreeNode node = queue.removeFirst();
                String left = arr[arrIndex++];
                String right = arr[arrIndex++];

                if(!left.equals("n")) {
                    node.left = new TreeNode(Integer.parseInt(left));
                    queue.addLast(node.left);
                }
                if(!right.equals("n"))  {
                    node.right = new TreeNode(Integer.parseInt(right));
                    queue.addLast(node.right);
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}

/*
/**
 * This implementation is right except for extreme edge cases, -1000 <= node.val <= 1000
 * fails with [-1000, null, -1000]

class SerializeAndDeserializeBinaryTree2 {
    public static class Codec {
        final static Integer NULL_VALUE = -1001;

        // Encodes a tree to a single string.
        // BFS encoding
        public String serialize(TreeNode root) {
            if(root == null) return "";
            Deque<TreeNode> queue = new ArrayDeque<>();
            StringBuilder encodedString = new StringBuilder();

            queue.addLast(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i ++) {
                    TreeNode node = queue.removeFirst();
                    if(node.val == NULL_VALUE) encodedString.append('n');
                    else {
                        encodedString.append((char) (node.val + '0'));
                        queue.addLast(Objects.requireNonNullElseGet(node.left, () -> new TreeNode(NULL_VALUE)));
                        queue.addLast(Objects.requireNonNullElseGet(node.right, () -> new TreeNode(NULL_VALUE)));
                    }
                }
            }

            return encodedString.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            char[] chars = data.toCharArray();
            if(chars.length == 0) return null;
            Deque<TreeNode> queue = new ArrayDeque<>();

            TreeNode root = new TreeNode(chars[0] - '0');
            queue.addLast(root);

            int charIndex = 1;
            while(charIndex < chars.length) {
                TreeNode node = queue.removeFirst();
                char left = chars[charIndex++];
                char right = chars[charIndex++];

                if(left != 'n') {
                    node.left = new TreeNode(left - '0');
                    queue.addLast(node.left);
                }
                if(right != 'n')  {
                    node.right = new TreeNode(right - '0');
                    queue.addLast(node.right);
                }
            }

            return root;
        }
    }
    // Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

}
 */


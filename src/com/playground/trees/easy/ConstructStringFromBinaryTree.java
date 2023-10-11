package com.playground.trees.easy;

import com.playground.trees.model.TreeNode;

/**
 * 606. Construct String from Binary Tree
 * Difference between Strings and StringBuilders.
 * =============================
 * Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with
 * the preorder traversal way, and return it. Omit all the empty parenthesis pairs that do not affect the
 * one-to-one mapping relationship between the string and the original binary tree.
 * =============================
 * Example 1:
 * Input: root = [1,2,3,4]
 * Output: "1(2(4))(3)"
 * Explanation: Originally, it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)"
 * Example 2:
 * Input: root = [1,2,3,null,4]
 * Output: "1(2()(4))(3)"
 * Explanation: Almost the same as the first example, except we cannot omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 * ================================
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -1000 <= Node.val <= 1000
 */
public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        return tree2strRec(root).toString();
    }

    /**
     * Runtime 5 ms Beats 62.59%
     * Memory 44 MB Beats 61.11%
     */
    public StringBuilder tree2strRec(TreeNode root) {
        if(root == null) return new StringBuilder();

        StringBuilder s = new StringBuilder(Integer.toString(root.val));

        String left = tree2strRec(root.left).toString();
        String right = tree2strRec(root.right).toString();

        if(left.equals("") && right.equals("")) return s;
        else if(left.equals("")) s.append("()").append("(").append(right).append(")");
        else if(right.equals("")) s.append("(").append(left).append(")");
        else s.append("(").append(left).append(")").append("(").append(right).append(")");

        return s;
    }

    /**
     * Runtime 14 ms Beats 32.44%
     * Memory 44.9 MB Beats 7.11%
     */
    public String tree2str2(TreeNode root) {
        if(root == null) return "";

        String s = Integer.toString(root.val);

        String left = tree2str2(root.left);
        String right = tree2str2(root.right);

        if(left == "" && right == "") return s;
        else if(left == "") s+="()"+ "("+right+")";
        else if(right == "") s+="(" + left + ")";
        else s+="(" + left + ")" +  "("+right+")";

        return s;
    }
}

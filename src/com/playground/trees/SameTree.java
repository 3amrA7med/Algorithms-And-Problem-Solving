package com.playground.trees;

import com.playground.trees.model.TreeNode;

public class SameTree {

    // 100% runtime, bad memory but not too far from best ~=1.4mb
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

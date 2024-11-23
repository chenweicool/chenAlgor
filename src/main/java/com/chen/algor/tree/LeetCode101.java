package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSameTree(root.left, root.right);
    }

    private boolean isSameTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        // 因为是对称的e
        return isSameTree(left.left, right.right) && isSameTree(left.right, right.left);
    }

    public static void main(String[] args) {

    }
}

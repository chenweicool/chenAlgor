package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

import java.util.concurrent.TransferQueue;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * 使用递归来解决这个问题
 */
public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
             return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int i = new LeetCode104().maxDepth(root);
        System.out.println(i);
    }
}

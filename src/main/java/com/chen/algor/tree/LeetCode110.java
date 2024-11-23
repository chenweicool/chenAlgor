package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

/**
 * 给定一个二叉树，判断它是否是
 * 平衡二叉树
 * 什么是平衡二叉树，左右子树高度相差不超过1
 * */
public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    //后序遍历检查高度
    private int checkHeight(TreeNode root) {
        if (root == null) {
             return 0;
        }
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
             return -1;
        }


        // 检查当前节点是不是满足
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // 返回当前树的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        LeetCode110 solution = new LeetCode110();
        // 构建测试树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        // 检查平衡性
        boolean result = solution.isBalanced(root);
        System.out.println("Is the tree balanced? " + result);
    }
}

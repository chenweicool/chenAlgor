package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

/**
 *
 代码
 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
 平衡二叉搜索树。
 */
public class LeetCode108 {

    public TreeNode builderTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return builderTreeHelper(nums, 0, nums.length - 1);
    }

    private TreeNode builderTreeHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode rootNode = new TreeNode(nums[mid]);

        rootNode.left = builderTreeHelper(nums, left, mid - 1);
        rootNode.right = builderTreeHelper(nums, mid + 1, right);
        return rootNode;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -1, 2, 3, 5};
        TreeNode treeNode = new LeetCode108().builderTree(nums);
        middleSortPrintTree(treeNode);
    }

    private static void middleSortPrintTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        middleSortPrintTree(treeNode.left);
        middleSortPrintTree(treeNode.right);
    }


}


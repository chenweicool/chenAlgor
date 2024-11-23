package com.chen.algor.dp;

import com.chen.algor.common.TreeNode;
import sun.nio.cs.ext.MacHebrew;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 题目分析：
 * 1 就是找一个节点中二叉树中最大的节点
 */
public class LeetCode124 {

    // 使用dfs来解决这个问题，每次递归更新两个值，一个是：
    // 1  单侧路径的和，就是当前节点和左或者右的值，
    // 2 更新全路径的和，就是当前作为中间的节点值

    private int maxSum ;
    public int maxPathSum(TreeNode root) {
         maxSum = Integer.MIN_VALUE;  // 初始化最小的值
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        // 递归的结束条件
        if (root == null) {
            return 0;
        }
        // 递归计算左右子树单侧路径的和
        int rightValue = Math.max(dfs(root.left), 0);
        int leftValue = Math.max(dfs(root.right), 0);

        // 计算最全路径的和
        int currentSum = root.val + rightValue + leftValue;
        maxSum = Math.max(maxSum, currentSum);

        // 返回单边的值,用于父节点的计算
        return root.val + Math.max(rightValue, leftValue);
    }

    public static void main(String[] args) {
        // 示例测试
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("最大路径和: " + new LeetCode124().maxPathSum(root)); // 输出 42
    }

}

package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 */
public class LeetCode129 {

    /**
     * 使用树的dfs进行优先搜索
     * @return
     */
    public int sumNumbers(TreeNode root) {
       return dfs(root, 0);
    }

    private int dfs(TreeNode root, int currentSum) {
        if (root == null) {
             return 0;
        }
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return currentSum;
        }
        return dfs(root.left, currentSum) + dfs(root.right, currentSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        System.out.println(new LeetCode129().sumNumbers(root));
    }
}

package com.chen.algor.tree.dfs;

import com.chen.algor.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class LeetCode113 {

    /**
     * 使用dfs来解决
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, result, currentPath);
        return result;
    }


    private void dfs(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> currentPath) {
        if (root == null) {
             return;
        }

        // 加入根节点
        currentPath.add(root.val);

        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(currentPath));
        }else{
            dfs(root.left, targetSum - root.val, result, currentPath);
            dfs(root.right, targetSum - root.val, result, currentPath);
        }

        // 溢出当前节点
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        // 示例测试
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        LeetCode113 solution = new LeetCode113();
        int targetSum = 22;
        List<List<Integer>> paths = solution.pathSum(root, targetSum);

        System.out.println(paths); // 输出 [[5, 4, 11, 2], [5, 8, 4, 5]]
    }
}

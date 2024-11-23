package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;
import com.sun.deploy.net.proxy.BrowserProxyInfo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * // 深度优先来处理
 */


public class LeetCode112 {

    /**
     * 使用递归来解决
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
             return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        int remainValue = targetSum - root.val;
        return hasPathSum(root.left, remainValue) || hasPathSum(root.right, remainValue);
    }

    // 第二种方法解决，队列解决，声明两个队列，
    public boolean hasPathSumV2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        queue.offer(root);
        sumQueue.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            int sumValue = sumQueue.poll();

            // 检查是否为叶子节点并且是不是和目标值相等
            if (currentNode.left == null && currentNode.right == null && sumValue == targetSum) {
                 return true;
            }
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
                sumQueue.offer(sumValue + currentNode.left.val);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
                sumQueue.offer(sumValue + currentNode.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

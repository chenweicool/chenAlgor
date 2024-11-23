package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class LeetCode111 {

    /**
     * 方法简单，耗时比较长
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
             return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     *使用迭代来完成.
     * 层序遍历完成
     * @param root
     * @return
     */
    public int mindDepthV2(TreeNode root) {
        if (root == null) {
             return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode currentNode = queue.poll();
            for (int i = 0; i < size; i++) {

                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.right= new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        System.out.println(new LeetCode111().mindDepthV2(root));
    }
}

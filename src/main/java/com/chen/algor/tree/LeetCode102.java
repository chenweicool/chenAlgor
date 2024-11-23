package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LeetCode102 {

    /**
     * 使用广度优先
     * 队列实现
     * @param root
     * @return
     */
    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // 边界条件
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 遍历队列
        while (!queue.isEmpty()) {
             // 元素个数
            int levelSize = queue.size();
            List<Integer> subTreeValues = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                  // 当前元素出队，并将自己左右子树加入队列
                TreeNode currentNode = queue.poll();
                subTreeValues.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
              }
            result.add(subTreeValues);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LeetCode102 solution = new LeetCode102();
        List<List<Integer>> result = solution.levelOrder(root);

        System.out.println(result);
    }
}

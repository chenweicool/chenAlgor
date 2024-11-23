package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 */
public class LeetCode103 {

    //使用队列，使用一个标识
    public List<List<Integer>> zigzaLevelLevelOrder(TreeNode root) {
        // 边界条件
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 声明一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        // 遍历二叉树
        while (!queue.isEmpty()) {
            List<Integer> subTressValues = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                subTressValues.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            if (!leftToRight) {
                Collections.reverse(subTressValues);
            }
            result.add(subTressValues);
            // 每层结束之后换方向
            leftToRight = !leftToRight;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists = new LeetCode103().zigzaLevelLevelOrder(root);
        System.out.println(lists);

        System.out.println(5 % 2);
    }
}

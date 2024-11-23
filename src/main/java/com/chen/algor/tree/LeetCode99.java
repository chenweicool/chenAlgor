package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

import java.util.Stack;

/**
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树 。
 */
public class LeetCode99 {
    // 解题思路，通过对树进行中序遍历，然后找到两个错误，然后交换两个位置
    TreeNode firstNode = null;
    TreeNode secondNode = null;

    TreeNode preNode = null;

    public void recoverTree(TreeNode root) {

        // 对树进行中序遍历，并且寻找错误数据，
        inOrderTraversal(root);

        // 交换两个值
        if (firstNode != null && secondNode != null) {
            int temp = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val = temp;
        }
    }

    private void inOrderTraversal(TreeNode root) {
         if(root ==null){
             return;
         }

        inOrderTraversal(root.left);

        if (preNode != null && preNode.val > root.val) {
            if (firstNode == null) {
                firstNode = preNode;
            }
            // 第二个值肯定是个小的值，它应该在前面
            secondNode = root;
        }

        // 更新前一个节点为当前节点
        preNode = root;

        // 遍历右子树
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        new LeetCode99().recoverTree(root);

        // 中序遍历
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }
}

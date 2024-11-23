package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 要求:
 * 你可以使用原地算法（O(1) 额外空间）展开这棵树吗
 * 遍历二叉树的每个节点。
 * 如果当前节点的左子树不为空：
 * 找到左子树的最右节点（即左子树的中序遍历最后一个节点）。
 * 将当前节点的右子树接到该最右节点的右子指针上。
 * 将当前节点的左子树变为右子树，左子指针置为 null。
 * 移动到下一个节点（右子树）继续处理。
 */
public class LeetCode114 {

    public void flatten(TreeNode root) {

        TreeNode currentNode = root;
        while (currentNode != null) {

            // 如果左子树不为空，那就继续遍历，找到最右界定啊
            if (currentNode.left != null) {
                // 找到左子树的最右节点
                  TreeNode rightMost = currentNode.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                rightMost.right = currentNode.right;

                // 将左子树替换为右子树
                currentNode.right = currentNode.left;
                // 将原有的左子树置为空
                currentNode.left = null;
            }

            // 移动下一个节点右子树
            currentNode = currentNode.right;
        }
    }

    public static void main(String[] args) {
        // 示例测试
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        LeetCode114 solution = new LeetCode114();
        solution.flatten(root);

        // 打印结果
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.right;
        }
        System.out.println("null");
    }
}

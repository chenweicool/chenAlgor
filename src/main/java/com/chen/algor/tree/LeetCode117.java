package com.chen.algor.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 */
public class LeetCode117 {

    /**
     * 因为是不规则二叉树，所以使用层序遍历来完成
     * 遍历每一层，如果不是最后节点，就把这个节点赋值给他的上一个节点，作为next
     */
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        // 声明一个队列
        Queue<Node> queue = new LinkedList<>();
        // 先把根节点加入到其中
        queue.add(root);

        // 遍历队列
        while (!queue.isEmpty()) {
             // 获取每一层的数量
            int levelSize = queue.size();

            // 对每一层进行遍历
            for (int i = 0; i < levelSize; i++) {
                // 将当前节点出队列
                Node currentNode = queue.poll();
                if (i < levelSize - 1) {
                    currentNode.next = queue.peek();
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return root;
    }

    /**
     *这个方法不是很理解
     */
    public Node connectV2(Node root) {
        if (root == null) {
            return null;
        }

        Node current = root; // 当前层的起始节点

        while (current != null) {
            Node dummy = new Node(0); // 虚拟头节点
            Node tail = dummy; // 用于构建下一层的链表

            // 遍历当前层
            while (current != null) {
                if (current.left != null) {
                    tail.next = current.left;
                    tail = tail.next;
                }
                if (current.right != null) {
                    tail.next = current.right;
                    tail = tail.next;
                }
                current = current.next;
            }

            // 移动到下一层
            current = dummy.next;
        }

        return root;
    }
    public static void main(String[] args) {
        // 构建二叉树
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        LeetCode117 solution = new LeetCode117();
        solution.connect(root);

        // 验证 next 指针
        System.out.println(root.next); // 输出 null
        System.out.println(root.left.next.val); // 输出 3
        System.out.println(root.left.left.next.val); // 输出 5
        System.out.println(root.left.right.next.val); // 输出 7
        System.out.println(root.right.next); // 输出 null
    }
}


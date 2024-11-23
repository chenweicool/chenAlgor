package com.chen.algor.tree;

public class LeetCode116 {

    /**
     * 使用迭代方法解决
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
         Node levelStart = root;
        while (levelStart.left != null) {
            Node current = levelStart;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            // 移动下一层
            levelStart = levelStart.left;
        }
        return root;
    }

    // 使用递归来解决
    public Node connectV2(Node root) {
        if (root == null || root.left == null || root.right == null) {
            return root;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connectV2(root.left);
        connectV2(root.right);
        return root;
    }

    public static void main(String[] args) {
        // 构建完美二叉树
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        LeetCode116 solution = new LeetCode116();
        solution.connect(root);

        // 验证 next 指针
        System.out.println(root.left.next.val); // 输出 3
        System.out.println(root.left.left.next.val); // 输出 5
        System.out.println(root.left.right.next.val); // 输出 6
        System.out.println(root.right.right.next); // 输出 null
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

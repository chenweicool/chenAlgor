package com.chen.algor.tree;

import com.chen.algor.common.ListNode;
import com.chen.algor.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为
 * 平衡
 *  二叉搜索树。
 */
public class LeetCode109 {

    // 解题思路，找到链路中间节点，然后递归构造二叉树
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        return buildTree(head, null);
   }

    private TreeNode buildTree(ListNode start, ListNode end) {
        if (start == end) {
             return null;
        }

        // 找到链表中间节点
        ListNode middle = findMiddleNode(start,end);
        // 构造根节点
        TreeNode root = new TreeNode(middle.val);

        //递归构造
        root.left = buildTree(start, middle);
        root.right = buildTree(middle.next, end);

        return root;
    }

    private ListNode findMiddleNode(ListNode start, ListNode end) {
        // 声明快慢指针
        ListNode slow = start,fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new
                ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));

        LeetCode109 solution = new LeetCode109();
        TreeNode root = solution.sortedListToBST(head);

        // 打印二叉树
        middleSortPrintTree(root);
    }

    private static void middleSortPrintTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        middleSortPrintTree(treeNode.left);
        middleSortPrintTree(treeNode.right);
    }
}

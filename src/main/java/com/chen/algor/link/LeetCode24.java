package com.chen.algor.link;

import com.chen.algor.common.ListNode;

/**
 * 链表的两两节点交换
 * 题目描述:
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class LeetCode24 {
    /**
     * 第一种方法使用迭代方法来解决
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode pre = dump;
        while (pre.next != null && pre.next.next!= null) {
            ListNode firstNode = pre.next;
            ListNode secondNode = pre.next.next;

            // 进行交换
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            pre.next = secondNode;

            //移动指针
           pre = firstNode;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode listNode = new LeetCode24().swapPairs(node1);
        while (listNode != null ) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

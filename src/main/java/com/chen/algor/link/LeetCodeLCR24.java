package com.chen.algor.link;

import com.chen.algor.common.ListNode;

/**
 * 反转链表
 * 24道题
 */
public class LeetCodeLCR24 {

    public ListNode reverseListNode(ListNode head) {
        ListNode prev = null; // 前驱节点
        ListNode current = head; // 当前节点

        while (current != null) {
            ListNode next = current.next; // 暂存下一个节点
            current.next = prev; // 反转当前节点的指向
            prev = current; // 移动 prev 到当前节点
            current = next; // 移动 current 到下一个节点
        }

        return prev; // prev 成为新链表的头节点
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode listNode = new LeetCodeLCR24().reverseListNode(l1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

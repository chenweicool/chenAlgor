package com.chen.algor.link;

import com.chen.algor.common.ListNode;

/**
 * 反转链表
 * 24道题
 */
public class LeetCodeLCR24 {

    public ListNode reverseListNode(ListNode head) {
          ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
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

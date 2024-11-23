package com.chen.algor.link;

import com.chen.algor.common.ListNode;

/**
 * leetCode 的第二道题
 * 这个题是链表，
 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 请你将两个数相加，并以相同形式返回一个表示和的链表。
 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead  = new ListNode(0);  // 声明一个虚拟节点
        ListNode currentNode = dummyHead;

        // 可以理解为进位，
        int carry = 0;

        // 遍历两条链表
        while (l1 != null || l2 != null || carry > 0) {

            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;

            currentNode.next = new ListNode(sum % 10);
            // 对carry进行计算
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);

        ListNode l2 = new ListNode(3);

        ListNode listNode = new LeetCode2().addTwoNumbers(l1, l2);
        System.out.println(listNode.val);
    }
}

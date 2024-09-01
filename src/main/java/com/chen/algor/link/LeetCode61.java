package com.chen.algor.link;

import com.chen.algor.common.ListNode;
import javafx.scene.control.Alert;

/**
 * 链表反转
 *给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class LeetCode61 {

    /**
     * 解题思路
     * 1 判断边界条件，如果链表长度为空，或者只有一个元素，直接返回本身
     * 2 遍历链表，找到尾节点，并计算链表长度
     * 3  k% length 计算旋转的长度
     * 4  找到新的尾节点，length -k
     * 5  将尾节点进行链接，
     *
     * 可以画图，把链表想成一个环，这样就很好理解了
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // 遍历链表，计算链表长度
        ListNode oldTail = head;
        int length = 1;
        // 计算长度
        while (oldTail.next != null) {
              oldTail = oldTail.next;
              length++;
        }

        // 计算旋转次数
        k = k%length;
        if (k == 0) {
            return head;
        }

        // 找到最新的尾节点
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        // 新的头节点
        ListNode newHead = newTail.next;

        // 断开链表,重新链接,
        newTail.next = null;
        // 大概理解了，原来的链表
        oldTail.next = head;
        // 返回新的节点
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        ListNode result = rotateRight(head, k);

        // 打印旋转后的链表
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

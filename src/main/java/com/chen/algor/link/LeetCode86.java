package com.chen.algor.link;

import com.chen.algor.common.ListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class LeetCode86 {

    // 使用双指针来解决中这个问题
    public ListNode partition(ListNode head, int x) {
        // 声明两个节点分别来指向大节点和小节点  为什么声明两个是因为，一个用来指向，一个用来执行操作原本对象的
        ListNode lessHead = new ListNode(0);
        ListNode grateHead = new ListNode(0);
        ListNode less = lessHead;
        ListNode grate = grateHead;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            }else{
                grate.next = head;
                grate = grate.next;
            }
            head = head.next;
        }
        grate.next = null;
        less.next = grateHead.next;

        return lessHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode partition = new LeetCode86().partition(head, 3);
        while (partition != null) {
            System.out.println(partition.val);
            partition = partition.next;
        }
    }
}

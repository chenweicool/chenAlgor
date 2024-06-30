package com.chen.algor.link;

import com.chen.algor.common.ListNode;
/**
 * 合并两个有序链表
 */
public class LeetCode21 {

    /**
     * 解题思路
     * 1  遍历两个两个链表
     * 2  比较大小，然后处理
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListNode(ListNode l1, ListNode l2) {
        // 声明一个头节点来处理，虚拟节点来处理
        ListNode dump = new ListNode(0);
        ListNode current = dump;

        // 遍历两个链表
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                  current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        // 如果遍历结束，l1或者和l2还不为空，直接补充到current后面
        current.next = l1 == null ? l2 : l1;

        // 返回合并后的头节点
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = new LeetCode21().mergeTwoListNode(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

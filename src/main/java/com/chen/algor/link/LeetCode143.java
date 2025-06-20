package com.chen.algor.link;

import com.chen.algor.common.ListNode;

/**
 * 题目描述
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 */
public class LeetCode143 {

    /**
     * 分析题目要求：
     * 相当于把后面的节点插入到前面的节点，
     * 不能单纯的更改值，需要进行实际的节点交换
     * 实现思路，
     * 1 找到链表中点
     * 2 链表后半段进行反转
     * 3 交叉合并两个链表
     * @param head
     */
    public void reorderList(ListNode head) {
          if (head == null || head.next == null) return;

          // 1 找到链表的中点
          ListNode slow = head;
          ListNode fast = head;
          while (fast != null && fast.next != null) {
               slow = slow.next;
               fast = fast.next.next;
          }

          // 2 反转后半段链表
         ListNode reverseNode = reverseNode(slow.next);
         slow.next = null;

         // 合并两个链表
        ListNode firstHalf = head;
        mergerListNode(firstHalf, reverseNode);
    }

    private void mergerListNode(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            l1.next = l2;
            if (l1Next != null) {
                l2.next = l1Next;
            }
            l1 = l1Next;
            l2 = l2Next;
        }
    }


    /**
     * 链表反转的核心思想确实是通过逐个节点地改变其 next 指针的方向，逐步让每个节点指向它的前一个节点，
     * 最终实现链表的整体反转。
     */
    private ListNode reverseNode(ListNode head) {
       ListNode prev = null;
       while (head != null) {
           ListNode nextNode = head.next;
           head.next = prev;
           prev = head;
           head = nextNode;
       }
        return prev;
    }

    public static void main(String[] args) {
        LeetCode143 rl = new LeetCode143();

        // 创建链表: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("原链表:");
        rl.printList(head);

        rl.reorderList(head);

        System.out.println("重新排列后的链表:");
        rl.printList(head);
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}

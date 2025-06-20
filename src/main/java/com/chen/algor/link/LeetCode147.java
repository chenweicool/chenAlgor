package com.chen.algor.link;

import com.chen.algor.common.ListNode;

/**
 * 对链表进行插入排序
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 */
public class LeetCode147 {

    private ListNode insertSortList(ListNode head) {
          //如果链表为空，就返回
        if(head == null || head.next == null){
            return  head;
        }

        // 声明一个虚拟节点存储排序后的节点
        ListNode sortedHead = new ListNode(0);
        ListNode current = head;

        // 对current进行遍历
        while(current != null){

            ListNode prev = sortedHead;
            ListNode next = current.next;

            // 进行排序
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            // 进行赋值
            current.next = prev.next;
            prev.next = current;

            current = next;
        }
        return sortedHead.next;
    }

    public static void main(String[] args) {
        // 创建链表 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        LeetCode147 solution = new LeetCode147();
        ListNode sortedHead = solution.insertSortList(head);

        // 输出排序后的链表
        while (sortedHead != null) {
            System.out.print(sortedHead.val + " ");
            sortedHead = sortedHead.next;
        }
    }
}

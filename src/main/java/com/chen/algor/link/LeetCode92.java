package com.chen.algor.link;

import com.chen.algor.common.ListNode;

import java.util.List;

/**
 给你单链表的头指针 head 和两个整数 left 和 right ，
 其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 解题思路：是找到反转前的一个节点： 然后处理反装链表，然后进行链接
 */
public class LeetCode92 {

    /**
     *解题步骤，
     * 1 声明一个虚拟节点
     * 2 找到left-1个节点这样pre.next就是需要反装的前驱节点
     * 3 反装指定区间
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 处理边界情况
        if (head == null || left == right) {
            return head;
        }

        // 声明一个头节点
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode pre = dump;

        // 找到left-1个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 找到左节点
        ListNode currNode = pre.next;

        // 遍历指定区间的节点
        for (int i = 0; i < right - left; i++) {
            ListNode temp = currNode.next;
            currNode.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        // 构建链表: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 创建 Solution 对象
        LeetCode92 solution = new LeetCode92();

        // 调用 reverseBetween 方法
        ListNode result = solution.reverseBetween(head, 2, 4);

        // 打印结果
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}

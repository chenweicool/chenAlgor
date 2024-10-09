package com.chen.algor.link;

import com.chen.algor.common.ListNode;

import java.nio.IntBuffer;

/**
 *  删除重复元素，返回只出现一次链表数据
 */
public class LeetCode83 {


    /**
     * 遍历的方式，来解决这个问题
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
          ListNode currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;  // 删除重复节点
            }
            currentNode = currentNode.next; // 移动到下一个节点
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(1);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = new LeetCode83().deleteDuplicates(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

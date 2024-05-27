package com.chen.algor.link;

import com.chen.algor.common.ListNode;

/**
 * leetCode 的第二道题
 * 这个题是链表，
 * 主要考察链表的使用，
 * 每道题需要达到标准是就是融会贯通，
 */
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null,tail = null;

        int carry = 0;

        // 遍历两条链表
        while(l1 != null || l2 !=null){
            int n1 = l1 != null ? l1.val:0;
            int n2 = l2 != null ? l2.val: 0;
            int sum = n1+n2+carry;

            if(head == null){
                head = tail = new ListNode(sum % 10);
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            // 对carry进行计算
            carry = sum /10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        // 边界，为了考虑最后两位数相加进位的问题
        if(carry > 0){
            tail.next = new ListNode(carry);
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);

        ListNode l2 = new ListNode(3);

        ListNode listNode = new LeetCode2().addTwoNumbers(l1, l2);
        System.out.println(listNode.val);

    }
}

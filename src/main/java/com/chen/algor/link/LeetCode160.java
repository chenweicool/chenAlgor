package com.chen.algor.link;

import com.chen.algor.common.ListNode;

/**
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class LeetCode160 {

    /**
     *使用链表双指针方法，来解决
     * 使用双指针，就是链表的长度差以及指针的遍历路径，核心是让他们走相同步数
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode pA = headA;
       ListNode pb = headB;

       // 两个指针遍历两个链表
        while (pA != pb) {
             pA = (pA == null) ? headB : pA.next;
             pb = (pb == null) ? headA : pb.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        // 创建链表 A
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);

        // 创建链表 B
        ListNode headB = new ListNode(4);
        headB.next = new ListNode(5);

        // 创建交点部分
        ListNode intersection = new ListNode(6);
        headA.next.next.next = intersection;  // 链表 A 连接交点
        headB.next.next = intersection;       // 链表 B 连接交点

        intersection.next = new ListNode(7);  // 交点后的链表
        intersection.next.next = new ListNode(8);

        // 调用方法获取交点
        LeetCode160 solution = new LeetCode160();
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);

        // 输出交点的值
        if (intersectionNode != null) {
            System.out.println("The intersection node value is: " + intersectionNode.val);
        } else {
            System.out.println("There is no intersection.");
        }
    }

}

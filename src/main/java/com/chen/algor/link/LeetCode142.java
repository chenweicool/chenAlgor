package com.chen.algor.link;

import com.chen.algor.common.ListNode;

/**
 * 和141题目类似
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos
 * 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，
 * 则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 */
public class LeetCode142 {

    // 需要返回链表本身，所以还是需要使用快慢指针
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
             if(slow == fast){
                 // 使用数学公式推导而来的
                 ListNode entry = head;
                 while(entry != slow){
                       entry = entry.next;
                       slow = slow.next;
                 }
                 return entry;
             }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        head.next = head1;
        head1.next = head;
        System.out.println(new LeetCode142().detectCycle(head).val);
    }
}

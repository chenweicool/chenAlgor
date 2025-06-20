package com.chen.algor.link;

import com.chen.algor.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，
 * 则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */
public class LeetCode141 {

    // 这个方法为什们耗时这么久，因为你用了list集合，这个耗时比较久，是个线性结构，可用HashSet代替
    public boolean hasCycle(ListNode head) {
          if(head == null || head.next == null){
              return false;
          }

        List<ListNode> nodeList = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            if (nodeList.contains(cur)) {
                return true;
            }
            nodeList.add(cur);
            cur = cur.next;
        }
        return false;
    }

    //使用快慢指针
    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
               slow = slow.next;
               fast = fast.next.next;
               if(slow == fast){
                   return true;
               }
        }
        return false;
    }

    public static void main(String[] args) {
         ListNode head = new ListNode(1);
         ListNode head1 = new ListNode(2);
         ListNode head2 = new ListNode(3);
         ListNode head3 = new ListNode(4);
         head.next = head1;
         head1.next = head2;
         head2.next = head3;
         head3.next = head1;
        System.out.println(new LeetCode141().hasCycle(head));
    }
}

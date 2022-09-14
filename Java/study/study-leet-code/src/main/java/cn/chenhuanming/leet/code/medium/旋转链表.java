package cn.chenhuanming.leet.code.medium;

import cn.chenhuanming.leet.code.common.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置
 */
public class 旋转链表 {
    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            curr = curr.next;
            fast = fast.next;
        }
        fast.next = head;
        fast = curr.next;
        curr.next = null;
        return fast;
    }
}

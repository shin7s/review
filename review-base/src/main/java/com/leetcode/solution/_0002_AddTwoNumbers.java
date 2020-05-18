package com.leetcode.solution;

import com.alg.ListNode;

public class _0002_AddTwoNumbers {

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        //s记录和，a记录进位，b记录余数
        int s = 0, a = 0, b = 0;
        ListNode head = l1, p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            s = p1.val + p2.val + a;
            a = s / 10;
            p1.val = s % 10;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null && a > 0) {
            s = p1.val + a;
            a = s / 10;
            p1.val = s % 10;
            p1 = p1.next;
        }
        //while (p2 != null) {
        //    s = p2.val + a;
        //    a = s / 10;
        //    t.next = new ListNode(s % 10);
        //    t = t.next;
        //    p2 = p2.next;
        //}
        //if (a > 0) {
        //    t.next = new ListNode(a);
        //}
        return head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s = 0, a = 0;
        ListNode head = new ListNode(0), t = head, p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            s = p1.val + p2.val + a;
            a = s / 10;
            t.next = new ListNode(s % 10);
            t = t.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            s = p1.val + a;
            a = s / 10;
            t.next = new ListNode(s % 10);
            t = t.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            s = p2.val + a;
            a = s / 10;
            t.next = new ListNode(s % 10);
            t = t.next;
            p2 = p2.next;
        }
        if (a > 0) {
            t.next = new ListNode(a);
        }
        return head.next;
    }
}

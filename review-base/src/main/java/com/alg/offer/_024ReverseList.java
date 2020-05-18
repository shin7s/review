package com.alg.offer;

import com.alg.ListNode;

public class _024ReverseList {
    public static void main(String[] args) {
        reverseList(ListNode.build(-1, 1, 2, 3, 4)).print();
        reverseList(ListNode.build(-1, 1)).print();
        reverseList(ListNode.build(-1, 1, 2)).print();
        reverseList(new ListNode(1)).print();
    }
    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode curr = head, temp = head.next, next = null;

        while (temp != null) {
            curr.next = next;
            next = curr;

            curr = temp;
            temp = temp.next;
        }

        curr.next = next;

        return curr;
    }
}

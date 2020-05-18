package com.alg.offer;

import com.alg.ListNode;

import static com.alg.ListNode.build;

public class _023MeetingNode {
    public static void main(String[] args) {

        //ListNode head = new ListNode(1);
        //ListNode tail = head;
        //ListNode node3 = null;
        //for (int i = 2; i <= 6; i++) {
        //    ListNode temp = new ListNode(i);
        //    if (i == 3) {
        //        node3 = temp;
        //    }
        //    tail.add(temp);
        //    tail = tail.next;
        //}
        //tail.next = node3;
        //
        //ListNode pt = head;
        //for (int i = 0; i < 7; i++) {
        //    System.out.println(pt.val);
        //    pt = pt.next;
        //}
        ListNode head = build(3, 1, 2, 3, 4, 5, 6);
        cal(head);

        cal(build(1, 1));
        cal(build(1, 1, 2));
        cal(build(1, 1, 2, 3));
        cal(build(2, 1, 2, 3));
        cal(build(2, 1, 2, 3, 4));

    }

    private static void cal(ListNode head) {
        ListNode inCircleNode = meetingNode(head);
        System.out.println(inCircleNode.val);

        if (inCircleNode != null) {
            ListNode entryOfLoop = findEntryOfLoop(head, inCircleNode);
            System.out.println("entry:" + entryOfLoop.val);
        }
    }


    //通过环中的节点去找入口
    public static ListNode findEntryOfLoop(ListNode head, ListNode nodeOfLoop) {

        ListNode step1 = nodeOfLoop;
        int count = 0;
        do {
            ++count;
            step1 = step1.next;
        } while (step1 != nodeOfLoop);
        System.out.println("count:" +count);

        ListNode step2 = step1 = head;

        while (count > 0) {
            step2 = step2.next;
            --count;
        }

        while (step1 != step2) {
            step1 = step1.next;
            step2 = step2.next;
        }

        return step1;
    }

    //判断环是否存在
    public static ListNode meetingNode(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode ptStep1, ptStep2;
        ptStep1 = ptStep2 = head;

        while (ptStep1 != null && ptStep2 != null) {

            //走一步
            ptStep1 = ptStep1.next;

            //走两步
            ptStep2 = ptStep2.next;
            if (ptStep2.next != null) {
                ptStep2 = ptStep2.next;
            } else {
                //走到终点
                return null;
            }

            if (ptStep1 == ptStep2) {
                return ptStep1;
            }
        }
        return null;
    }
}

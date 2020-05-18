package com.alg;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode add(ListNode node) {
        next = node;
        return node;
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    public ListNode append(int i) {
        return add(new ListNode(i));
    }

    public static ListNode[] build(int[] vals) {
        ListNode build = buildList(-1, vals);



        List<ListNode> arrayList = new ArrayList<>();
        while (build != null) {
            arrayList.add(build);
            build = build.next;
        }
        return arrayList.toArray(new ListNode[arrayList.size()]);
    }

    public static ListNode buildList(int loop, int... vals) {
        ListNode head = null, tail = null, entry = null;
        for (int i = 0; i < vals.length; i++) {
            if (head == null) {
                tail = head = new ListNode(vals[i]);
            } else {
                tail = tail.append(vals[i]);
            }
            if ((vals[i]) == loop) {
                entry = tail;
            }
        }

        tail.next = entry;

        return head;
    }

    public static ListNode build(int loop, int... vals) {
        ListNode head = null, tail = null, entry = null;
        for (int i = 0; i < vals.length; i++) {
            if (head == null) {
                tail = head = new ListNode(i + 1);
            } else {
                tail = tail.append(i + 1);
            }
            if ((i + 1) == loop) {
                entry = tail;
            }
        }

        tail.next = entry;

        return head;
    }
    public void print() {
        ListNode head = this;
        while (head != null) {
            System.out.print(head.val);
            System.out.print("\t");
            head = head.next;
        }
        System.out.println();
    }
}

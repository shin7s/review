package com.alg.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用两个队列实现栈
 */
public class _009StackImplByQueue<T> {

    public static void main(String[] args) {

        _009StackImplByQueue<String> stack = new _009StackImplByQueue<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push("d");
        System.out.println(stack.pop());

    }

    public T pop() {
        Queue emQueue = curr == q1 ? q2 : q1;
        while (curr.size() > 1) {
            emQueue.add(curr.remove());
        }
        T remove = curr.remove();
        curr = emQueue;
        return remove;
    }
    public boolean push(T v) {
        return curr.offer(v);
    }

    private Queue<T> q1 = new LinkedList<>();
    private Queue<T> q2 = new LinkedList<>();
    private Queue<T> curr = q1;
}

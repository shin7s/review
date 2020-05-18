package com.alg.offer;

import java.util.Stack;

public class _031IsPopOrder {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        System.out.println(isPopOrder(data, new int[] {4, 5, 3, 2, 1}));
        System.out.println(isPopOrder(data, new int[] {4, 3, 5, 1, 2}));
    }

    public static boolean isPopOrder(int[] seq1, int[] seq2) {

        if (seq1 == null || seq2 == null || seq1.length == 0 || seq2.length == 0 || seq1.length != seq2.length)
            return false;

        int i1 = 0, i2 = 0;
        Stack<Integer> stack = new Stack<Integer>();

        while (i2 < seq1.length) {

            int number = seq2[i2];
            while (stack.isEmpty() || stack.peek() != number) {
                if (i1 >= seq1.length)
                    break;
                stack.push(seq1[i1]);
                ++i1;
            }

            if (stack.peek() != number) {
                break;
            }

            stack.pop();
            i2++;

            ////压栈
            //while (i1 < seq1.length) {
            //    int val = seq1[i1];
            //    ++i1;
            //    stack.push(val);
            //    if (val == number) {
            //        break;
            //    }
            //}
            //
            ////判断number是否栈顶元素
            //while (!stack.empty() && i2 < seq2.length && stack.peek() == seq2[i2]) {
            //    stack.pop();
            //    number = seq2[i2];
            //    i2++;
            //}
        }
        return i1 == i2;
    }
}

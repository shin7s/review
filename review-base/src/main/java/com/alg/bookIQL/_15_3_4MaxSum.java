package com.alg.bookIQL;

import java.util.Arrays;

/**
 * 求最大的a[x]
 */
public class _15_3_4MaxSum {
    public static void main(String[] args) {
        System.out.println(maxSumX(new int[] {1, 2, 3, 3, 4, 3, 2, 8, 12, 15, 5, 6, 46,76,100}));
    }

    public static int maxSumX(int[] a) {
        if (a == null || a.length == 0)
            return -1;
        Arrays.sort(a);
        int i = a.length - 1, j = 0;
        for (;i >= 1; i--) {
            if (findSum(a, i, 0, i - 1)) {
                return a[i];
            }
        }
        return -1;
    }

    private static boolean findSum(int[] a, int x, int head, int tail) {
        if (head == tail)
            return false;

        while (head < tail) {
            int sum = a[head] + a[tail];
            if (sum == a[x]) {
                return true;
            } else if (a[head] + a[tail] < a[x]) {
                head++;
            } else {
                tail--;
            }
        }
        return false;
    }
}

package com.alg;

public class BinarySearch {
    public static void main(String[] args) {

        System.out.println(0x80000000);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(sqrt(1000));
        System.out.println(sqrt(999999999));
    }

    public static long sqrt(long x) {
        long s = 0, e = x;
        while (s <= e) {
            long mid = (s + e) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        if (s * s > x) return s -1;
        else return s;
    }
}

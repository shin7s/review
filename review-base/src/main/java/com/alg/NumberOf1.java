package com.alg;

public class NumberOf1 {
    public static void main(String[] args) {
        //System.out.println(numberOf1(1));
        //System.out.println(numberOf1(2));
        //System.out.println(numberOf1(3));
        System.out.println(numberOf1(0));
        System.out.println(numberOf1(Integer.MAX_VALUE));
        System.out.println(numberOf1(Integer.MIN_VALUE));
        //1000 0000 0000 0000 0000 0000 0000 0000
        System.out.println(numberOf1(Integer.MIN_VALUE - 1));
        System.out.println(numberOf1(-1));
    }

    public static int numberOf1(int n) {
        int qty = 0;
        while (n != 0) {
            ++qty;
            n = n & (n - 1);
        }
        return qty;
    }
}

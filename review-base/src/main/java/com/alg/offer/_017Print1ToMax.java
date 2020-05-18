package com.alg.offer;

public class _017Print1ToMax {
    public static void main(String[] args) {

        //print1ToMax(1);
        //print1ToMax(2);
        //print1ToMax(3);
        print1ToMax(5);

    }

    public static void print1ToMax(int n) {
        if (n <= 0) return;

        char[] number = new char[n];

        for (int i = 0; i < 10; i++) {
            number[0] = (char)(i + '0');
            print1ToMaxRecursive(number, 0);
        }
    }

    private static void print1ToMaxRecursive(char[] number, int index) {

        if (index == number.length - 1) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char)(i + '0');
            print1ToMaxRecursive(number, index + 1);
        }

    }

    private static void printNumber(char[] number) {
        StringBuilder b = new StringBuilder();
        boolean begin = false;
        for (int i = 0; i < number.length; i++) {
            if (number[i] != '0') {
                begin = true;
            }
            if (begin) {
                b.append(number[i]);
            }
        }
        System.out.println(b.toString());
    }
}

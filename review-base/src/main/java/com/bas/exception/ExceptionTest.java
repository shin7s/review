package com.bas.exception;

public class ExceptionTest {

    public static void main(String[] args) {
        System.out.println(getNum());
    }

    public static int getNum() {
        try {
            double a = 1 / 0;
        } catch (Exception e) {
            //return 2;
            throw e;
        } finally {
            return 3;
        }
    }
}

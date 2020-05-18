package com.bas.string;

import java.util.Random;

public class AddForTest {
    public static void main(String[] args) {
        String s = "";
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            s = s + rand.nextInt(1000) + " ";
        }
        System.out.println(s);
    }
}

package com.bas.string;

import java.util.Random;

public class AddForTest2 {
    public static void main(String[] args) {
        String s = "";
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            //s = s + rand.nextInt(1000) + " ";
            sb.append(rand.nextInt(100) + " ");
        }
        s = sb.toString();
        System.out.println(s);
    }
}

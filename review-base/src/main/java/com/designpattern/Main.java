package com.designpattern;

import com.designpattern.decorator.LowerCaseInputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public void aaa() {
        class B {

        }

        char[] a[] = new char[10][];


        char s = 1;
        switch (s) {
            case 'a':

            default:
        }

        System.out.println(new B());
    }

    public static void main(String[] args) {
        try{
            if (true) {
                return;
            }
        } finally {
            System.out.println("finally");
        }

        class A {
            public int i = 3;
        }
        Object o = (Object) new A();
        A a = (A)o;
        System.out.println(a.i);

        String sb = "xbcde";
        System.out.println(sb.charAt(4));
        System.out.println("hello" instanceof Object);
        System.out.println("hello" instanceof String);

        //readTest();
        //readTest1();
        //readTest2();
        System.out.println(010);

        int i = 5;
        int j = 5;
        System.out.println(i++ * 3);
        System.out.println(++i * 3);
        String type = "Normal";
        //i > 5 ? type = "VIP" : type = "Normal";
        System.out.println(type);
        short s1 = 1;
        short s2 = 1;
        //s1 = s1 + 1;
        s2 += (Short.MAX_VALUE + 1);

        int visitTime = 0;
        int bonus = 0;
        do {
            bonus++;
        } while (visitTime++ < 10);
        System.out.println(bonus);

        List<String> aList = new ArrayList<>();
        List<String> bList = new ArrayList<>();

        String substring = "abdc".substring(0, 1);

        first1:
        for (String s : aList) {

            for (String s3 : bList) {
                break first1;
            }

        }

        first:
        for (int k = 0; k < 10; k++) {

            second:
            for (int l = 0; l < 20; l++) {
                if (l == 10) {
                    break first;
                } else if (l == 11) {
                    continue second;
                }
            }

        }



    }

    public static void copy(String src, String dest) throws IOException {
        //static int i = 0;
        try (InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest)) {

            byte[] buf = new byte[1024 * 4];
            int n = 0;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }

    public static void readTest() {
        int c = 0;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
            while ((c = in.read()) >= 0) {
                System.out.print((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readTest1() {

        byte[] b = new byte[1024];

        try {
            InputStream in = new BufferedInputStream(new FileInputStream("test.txt"));
            //
            int read = in.read(b, 10, 10);
            if (read >= 0) {
                for (int i = 0; i < b.length; i++) {
                    if (b[i] >= 0) {
                        System.out.print((char)b[i]);
                    } else {
                        System.out.println(' ');
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readTest2() {

        byte[] b = new byte[32];
        byte $a;
        //byte #a;
        try {
            InputStream in = new BufferedInputStream(new FileInputStream("test.txt"));
            //
            int read = in.read(b, 0, 32);
            while (read >= 0) {
                System.out.print(new String(b, 0, read));

                b = new byte[32];
                read = in.read(b, 0, 32);
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



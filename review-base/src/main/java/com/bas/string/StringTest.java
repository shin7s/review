package com.bas.string;

import java.util.Random;

public class StringTest {
    public static void main(String[] args) {
        String s1, s2;
        String temp = "hh";
        s1 = "a" + temp;
        s2 = "ahh";
        System.out.println(s1 == s2);
        System.out.println(s1 == s2.intern());
        System.out.println(s1.intern() == s2);
        System.out.println(s1.intern() == s2.intern());
        System.out.println(s1 == s1.intern());
        System.out.println(s2 == s2.intern());

        s1 = new StringBuilder("why").append("true").toString();
        System.out.println(s1 == s1.intern());

        //只有马上调用intern()，常量池生成了bhh,然后存了S1的地址
        s1 = "b" + temp;
        System.out.println(s1 == s1.intern());

        s1 = "Pro";
        s2 = new String("Pro");
        System.out.println(s2 == s2.intern());

        //s3是指向堆对象
        String s3 = new String("Pro2");
        System.out.println(s3 == s3.intern());

        String s4 = "b" + temp;
        System.out.println(s4 == s4.intern());

        //
        //s1 = new String("1");
        //s1.intern();
        //s2 = "1";
        //System.out.println(s1 == s2);

        //s3();



        //s4();

        //s5();
        s6();
    }

    private static void s3() {
        String s3 = new String("1") + new String("1");    // 此时生成了四个对象 常量池中的"1" + 2个堆中的"1" + s3指向的堆中的对象（注此时常量池不会生成"11"）
        s3.intern();    // jdk1.7之后，常量池不仅仅可以存储对象，还可以存储对象的引用，会直接将s3的地址存储在常量池
        String s4 = "11";    // jdk1.7之后，常量池中的地址其实就是s3的地址
        System.out.println(s3 == s4); // jdk1.7之前false， jdk1.7之后true
    }

    private static int MAX = 10000000;
    private static void s4() {
        String[] arr = new String[MAX];
        Integer[] DB_DATA = new Integer[10];
        Random random = new Random(10 * 10000);
        for (int i = 0; i < DB_DATA.length; i++) {
            DB_DATA[i] = random.nextInt();
        }
        long t = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {
            //arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length]));                // --- 每次都要new一个对象
            // arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length])).intern();    //其实虽然这么多字符串，但是类型最多为10个，大部分重复的字符串,大大减少内存
            // arr[i] = String.valueOf(DB_DATA[i % DB_DATA.length]).intern();    //其实虽然这么多字符串，但是类型最多为10个，大部分重复的字符串,大大减少内存
             arr[i] = String.valueOf(DB_DATA[i % DB_DATA.length]);    //其实虽然这么多字符串，但是类型最多为10个，大部分重复的字符串,大大减少内存
        }
        System.out.println((System.currentTimeMillis() - t) + "ms");
        System.gc();
    }

    public static void s5() {
        String a = "ab";
        String b = "a" + "b";
        System.out.println(a == b);
    }

    public static void s6() {
        String str1 = new StringBuilder("测试").append("01").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("测试").toString();
        System.out.println(str2.intern() == str2);
    }
}

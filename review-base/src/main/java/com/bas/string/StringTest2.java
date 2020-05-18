package com.bas.string;

public class StringTest2 {
    public static void main(String[] args) {
        String temp = "hh";
        String s2 = new String("Pro");
        System.out.println(s2 == s2.intern());

        //s3是指向堆对象
        //String s3 = new String("Pro2");
        //System.out.println(s3 == s3.intern());

        String s4 = "b" + temp;
        System.out.println(s4 == s4.intern());

        String s5 = "n" + "4";
        System.out.println(s5 == s5.intern());

        String s6 = new String("Abc");
        String s7 = "Abc";
        String s8 = new String("Abc");
        s8.intern();
        String s9 = new String("Abc");
        System.out.println(s6 == s7);
        System.out.println(s6.intern() == s7);
        System.out.println(s6.intern() == s8);
        System.out.println(s6 == s8);
        System.out.println(s9 == s8);

        String s10 = new StringBuilder("bcd").append("asd").toString();
        //使bcdasd驻留到常量池
        s10.intern();
        String s11 = "bcdasd";
        System.out.println(s10 == s11);

        String s12 = new StringBuilder("aaa").toString();
        System.out.println(s12.intern() == s12);
        //s12.intern();
        String s13 = "aaa";
        System.out.println(s12 == s13);


        String str5 = new StringBuilder("str")
                .append("03")
                .toString();
        str5.intern();
        String str6 = "str03";
        System.out.println(str5 == str6);

        String str7 = new StringBuilder("str")
                .toString();
        String str8 = "str";
        System.out.println(str7.intern() == str8);
    }
}

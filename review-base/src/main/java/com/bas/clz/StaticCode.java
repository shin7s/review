package com.bas.clz;

public class StaticCode {
    public StaticCode() {
        System.out.print("默认构造方法！--");
    }

    //非静态代码块
    {
        System.out.print("非静态代码块！--");
    }

    //静态代码块
    static {
        System.out.print("静态代码块！--");
    }

    private static void test() {
        System.out.print("静态方法中的内容! --");
        {
            System.out.print("静态方法中的代码块！--");
        }

    }

    public static void main(String[] args) {
        StaticCode test = new StaticCode();
        StaticCode.test();//静态代码块！--静态方法中的内容! --静态方法中的代码块！--
    }
}

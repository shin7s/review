package com.bas;

import java.util.Date;

public class B extends Date{

    static {
        System.out.println("静态代码块");
    }
    B() {
        System.out.println("构造函数");
    }
    {
        System.out.println("构造代码块");
    }
    public void B(){
        System.out.println("fuck");
    };
    public static void main(String[] args) {
        B b = new B();
        b.B();
        b.test();

        Test test = b.new Test();
        test.test();

        //new BufferedReader(new InputStreamReader())
        ((B)null).hello();
        ((B)null).test();
    }

    public static void hello() {
        System.out.println("空指针打印静态函数");
    }

    private void test() {
        System.out.println(super.getClass().getName());
    }


    class Test extends Date {
        private void test() {
            System.out.println(super.getClass().getName());
        }
    }
}

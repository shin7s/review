package com.thread.sync;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest {

    public static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);

    public static void main(String[] args) throws InterruptedException {

        int a = 1, b = 2, c = 3;

        c = b = a = 9;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        (new Thread(() -> {
            try {
                queue.put("a");
                Thread.sleep(1000);
                System.out.println("a");
                for (int i = 0; i < 3; i++) {
                    queue.put("b");
                    System.out.println("b");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        })).start();

        (new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(3000);
                    System.out.println("aa:" + queue.size());
                    System.out.println("aa:" + queue.remove("b"));
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        })).start();


    }

}

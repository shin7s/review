package com.thread.semaphore.multipc;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者
 */
public class ServicePC {

    //公共资源
    Semaphore semaphoreP = new Semaphore(4); //厨子数量
    Semaphore semaphoreC = new Semaphore(4); //顾客数量
    Object[] container = new Object[4]; //盘子数量（消费者同时就餐数量）

    //消费者就餐需要占用盘子
    static Random next = new Random();
    Lock lock = new ReentrantLock();
    Condition cookCondition = lock.newCondition();
    Condition eatCondition = lock.newCondition();

    public boolean isEmpty() {
        boolean flag = true;
        for (int i = 0; i < container.length; i++) {
            if (container[i] != null) {
                return false;
            }
        }
        return flag;
    }

    public boolean isFull() {
        boolean flag = true;
        for (int i = 0; i < container.length; i++) {
            if (container[i] == null) {
                return false;
            }
        }
        return flag;
    }

    //生产
    public void cook() {

        try {
            semaphoreP.acquire();

            lock.lock();

            while (isFull()) {
                System.out.println("厨师" + Thread.currentThread() + "在等待");
                cookCondition.await();
            }

            for (int i = 0; i < container.length; i++) {
                if (container[i] == null) {
                    container[i] = new Object();

                    int ms = 100 + next.nextInt(500);
                    Thread.sleep(ms);
                    System.out.println(Thread.currentThread() + " cook [" + i + "],use [" + ms + "]");
                    break;
                }
            }

            eatCondition.signalAll();
            lock.unlock();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreP.release();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void eat() {


        try {
            semaphoreC.acquire();
            lock.lock();

            while (isEmpty()) {
                System.out.println("顾客" + Thread.currentThread() + "在等待");
                eatCondition.await();
            }

            for (int i = 0; i < container.length; i++) {
                if (container[i] != null) {
                    container[i] = null;
                    int ms = 100 + next.nextInt(500);
                    Thread.sleep(ms);
                    System.out.println(Thread.currentThread() + " eat [" + i + "],use [" + ms + "]");
                    break;
                }
            }

            cookCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //lock.unlock();
            semaphoreC.release();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServicePC pc = new ServicePC();

        int size = 50;

        Thread[] eats = new Thread[size];
        Thread[] cook = new Thread[size];
        //消费者线程
        for (int i = 0; i < 50; i++) {
            eats[i] = new Thread(() -> pc.eat());
            cook[i] = new Thread(() -> pc.cook());
        }

        for (int i = 0; i < 50; i++) {
            eats[i].start();
            cook[i].start();
        }

    }

}

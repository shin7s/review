package com.thread;

public class SubMainThreadTest {
    public static void main(String[] args) {
        final Business business = new Business();

        new Thread(() -> {
            //先执行完3遍子方法
            for (int i = 0; i < 3; i++) {
                business.subMethod();
            }
            business.setSubFlag(false);
        }).start();

        for (int i = 0; i < 3; i++) {
            //再执行3遍主方法
            business.mainMethod();
        }
    }
}

class Business {

    private boolean subFlag = true;

    public boolean isSubFlag() {
        return subFlag;
    }

    public void setSubFlag(boolean subFlag) {
        this.subFlag = subFlag;
    }

    public synchronized void subMethod() {

        while (!subFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + " Sub " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        subFlag = false;
        notify();
    }

    public synchronized void mainMethod() {
        while (subFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread() + " Main " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        subFlag = true;
        notify();
    }
}

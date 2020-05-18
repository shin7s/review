package com.thread.semaphore.pool;

import java.util.Random;

class PoolService implements Runnable {

    ListPool listPool;

    public PoolService(ListPool pool) {
        listPool = pool;
    }
    @Override
    public void run() {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            String resource = listPool.getResource();
            builder.append(Thread.currentThread()).append(" get resources [").append(resource).append("],use [");
            int ms = 1000 + next.nextInt(2000);
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listPool.putResources(resource);
            builder.append(ms).append("]");
            listPool.count.getAndIncrement();
            builder.append(",count [" + listPool.count.get() + "]").append(",avg [").append(String.format("%.2f", listPool.getAvgPerSecond())).append("]");
            System.out.println(builder.toString());
            builder.setLength(0);
        }
    }

    static Random next = new Random();
    public static void main(String[] args) {
        ListPool pool = new ListPool();

        for (int i = 0; i < 50; i++) {
            new Thread(new PoolService(pool)).start();
        }
    }
}

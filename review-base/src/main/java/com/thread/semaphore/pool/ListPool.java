package com.thread.semaphore.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程池
 */
public class ListPool {

    private long start = System.currentTimeMillis();
    private int POOL_MAX_SIZE = 20; //资源最大数量
    private Semaphore semaphore = new Semaphore(20); //允许并发访问的线程最大数量
    private ReentrantLock lock = new ReentrantLock(); //同步控制获取资源和释放资源
    private Condition condition = lock.newCondition(); //获取资源和释放资源操作通知
    List<String> resources = new ArrayList<>(); //列表

    //统计每秒钟处理了多少事务
    AtomicInteger ms = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);

    public ListPool() {
        //初始化线程资源
        for (int i = 0; i < POOL_MAX_SIZE; i++) {
            resources.add("Res" + (i + 1));
        }
    }

    public AtomicInteger getMs() {
        return ms;
    }

    public AtomicInteger getCount() {
        return count;
    }

    /**
     * 获取资源
     *
     * @return
     */
    public String getResource() {
        try {
            semaphore.acquire();
            lock.lock();
            while (resources.size() == 0) {
                condition.await();
            }
            //返回资源
            return resources.remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            //注意在线程归还资源前一直占用了连接数
            //semaphore.release();
        }
        return null;
    }

    public void putResources(String res) {
        try {
            //semaphore.acquire();
            lock.lock();
            resources.add(res);
            condition.signalAll();
        } finally {
            lock.unlock();
            semaphore.release();
        }
    }

    //统计每秒钟能处理了多少事务
    public double getAvgPerSecond() {
        long end = System.currentTimeMillis();
        return ((double)count.get()) / ((end - start)/ 1000);
    }

}

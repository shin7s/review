package com.battcn.singleton.demo2;

/**
 * Double Check 双重检查（懒汉）加 volatile 线程安全
 *
 * @author Levin
 * @create 2017/10/25 0025
 */
public class LazyLoadBalancer {

    private volatile static LazyLoadBalancer loadBalancer;

    private LazyLoadBalancer() {
    }


    public static LazyLoadBalancer getInstance() {
        if (loadBalancer == null) {
            synchronized (LazyLoadBalancer.class) {
                if (loadBalancer == null) {
                    loadBalancer = new LazyLoadBalancer();
                }
            }
        }
        return loadBalancer;
    }

    public static void main(String[] args) {
        LazyLoadBalancer balancer1 = LazyLoadBalancer.getInstance();
        LazyLoadBalancer balancer2 = LazyLoadBalancer.getInstance();
        System.out.println(balancer1.hashCode());
        System.out.println(balancer2.hashCode());
    }
}

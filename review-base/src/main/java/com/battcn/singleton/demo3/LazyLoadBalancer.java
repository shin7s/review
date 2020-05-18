package com.battcn.singleton.demo3;

/**
 * Demand Holder （懒汉）线程安全
 *
 * @author Levin
 * @create 2017/10/25 0025
 */
public class LazyLoadBalancer {

    private LazyLoadBalancer() {}

    private static class LoadBalancerHolder {
        /**
         * 在JVM中 final 对象只会被实例化一次,无法修改
         */
        private final static LazyLoadBalancer INSTANCE = new LazyLoadBalancer();
    }

    public static LazyLoadBalancer getInstance() {
        return LoadBalancerHolder.INSTANCE;
    }

    public static void main(String[] args) {
        LazyLoadBalancer balancer1 = LazyLoadBalancer.getInstance();
        LazyLoadBalancer balancer2 = LazyLoadBalancer.getInstance();
        //判断服务器负载均衡器是否相同
        if (balancer1 == balancer2) {
            System.out.println("服务器负载均衡器具有唯一性！");
        }
        System.out.println(balancer1.hashCode());
        System.out.println(balancer2.hashCode());
    }


}

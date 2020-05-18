package com.battcn.singleton.demo4;

/**
 * 利用枚举特性（懒汉）线程安全
 * @author Levin
 * @create 2017/10/25 0025
 */

public class LazyLoadBalancer {

    enum Lazy {
        /**
         * 枚举
         */
        INSTANCE;
        private LazyLoadBalancer loadBalancer;

        /**
         * 枚举的特性,在JVM中只会被实例化一次
         */
        Lazy() {
            loadBalancer = new LazyLoadBalancer();
        }

        public LazyLoadBalancer getInstance() {
            return loadBalancer;
        }
    }

    public static void main(String[] args) {
        LazyLoadBalancer balancer1 = Lazy.INSTANCE.getInstance();
        LazyLoadBalancer balancer2 = Lazy.INSTANCE.getInstance();
        if (balancer1 == balancer2) {
            System.out.println("服务器负载均衡器具有唯一性！");
        }
        System.out.println(balancer1.hashCode());
        System.out.println(balancer2.hashCode());
    }

}

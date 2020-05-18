package com.battcn.singleton.demo5;

/**
 * 饿汉单例（天生线程安全）
 * 类加载时会实例化 当前类 所以使用的时候可以直接调用
 *
 * @author Levin
 * @create 2017/10/25 0025
 */
public class EagerLoadBalancer {
    private final static EagerLoadBalancer INSTANCE = new EagerLoadBalancer();

    private EagerLoadBalancer() {
    }

    public static EagerLoadBalancer getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        EagerLoadBalancer balancer1 = EagerLoadBalancer.getInstance();
        EagerLoadBalancer balancer2 = EagerLoadBalancer.getInstance();
        if (balancer1 == balancer2) {
            System.out.println("服务器负载均衡器具有唯一性！");
        }
        System.out.println(balancer1.hashCode());
        System.out.println(balancer2.hashCode());
    }
}

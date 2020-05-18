package com.battcn.singleton.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 单一检查（懒汉）非线程安全
 *
 * @author Levin
 * @create 2017/10/25 0025
 */
public class LazyLoadBalancer {

    private static LazyLoadBalancer loadBalancer;
    private List<String> servers = null;

    private LazyLoadBalancer() {
        servers = new ArrayList<>();
    }

    public void addServer(String server) {
        servers.add(server);
    }

    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(servers.size());
        return servers.get(i);
    }

    public  synchronized static LazyLoadBalancer getInstance() {
        // 第一步：假设T1,T2两个线程同时进来且满足 loadBalancer == null
        if (loadBalancer == null) {
            // 第二步：那么 loadBalancer 即会被实例化2次
            loadBalancer = new LazyLoadBalancer();
        }
        return loadBalancer;
    }

    public static void main(String[] args) {
        LazyLoadBalancer balancer1 = LazyLoadBalancer.getInstance();
        LazyLoadBalancer balancer2 = LazyLoadBalancer.getInstance();
        System.out.println("hashCode："+balancer1.hashCode());
        System.out.println("hashCode："+balancer2.hashCode());
        balancer1.addServer("Server 1");
        balancer2.addServer("Server 2");
        IntStream.range(0, 5).forEach(i -> System.out.println("转发至：" + balancer1.getServer()));
    }
}

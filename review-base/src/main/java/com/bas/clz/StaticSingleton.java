package com.bas.clz;

public class StaticSingleton {
    //声明为 private 避免调用默认构造方法创建对象
    private StaticSingleton() {
    }

    // 声明为 private 表明静态内部该类只能在该 Singleton 类中被访问
    private static class SingletonHolder {
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }

    public static StaticSingleton getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }

}

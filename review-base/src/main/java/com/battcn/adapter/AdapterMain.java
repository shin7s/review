package com.battcn.adapter;

/**
 * 小米4数据线
 * 已存在的、但不符合我们既有的标准接口的类
 */
class M4DataLine {
    public void connection() {
        System.out.println("使用小米4数据线连接...");
    }
}

/**
 * 标准 m5 接口，客户端使用的接口，与业务相关
 */
interface Target {
    void connection();
}

/**
 * 具体目标类，只提供 小米5 功能
 */
class M5DataLine implements Target {
    @Override
    public void connection() {
        System.out.println("使用小米5数据线连接...");
    }
}

/**
 * 适配器类，继承了被适配类，同时实现标准接口
 */
class M5DataLineAdapter extends M4DataLine implements Target {


    @Override
    public void connection() {
        System.out.println("插入 type-c 转接头");
        super.connection();
    }
}

/**
 * @author Levin
 * @create 2017/11/3 0003
 */
public class AdapterMain {

    public static void main(String[] args) {
        Target target = new M5DataLine();
        target.connection();

        // 使用特殊功能类，即适配类
        Target adapter = new M5DataLineAdapter();
        adapter.connection();
    }
}

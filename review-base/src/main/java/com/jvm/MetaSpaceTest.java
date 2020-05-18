package com.jvm;

import java.util.HashMap;

public class MetaSpaceTest {
    public static void main(String[] args) {
        int i = 0;
        try {
            for (i = 0; i < 10000; i++) {
                //CglibBean bean = new CglibBean("com.jvm.perm" + i, new HashMap<>());

            }
        } catch (Exception e) {
            System.out.println("total create count:" + i);
        }
    }
}

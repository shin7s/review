package com.lamda;

import java.util.ArrayList;
import java.util.List;

public class LamdaTest {
    public static void main(String[] args) {
        Object[] o = new Long[1];
        o[0] = "as";

        //List<Object> a = new ArrayList<Long>();
        //a.add("asd");

        int a = 2;
        int b = (a++) << (++a) + (++a);

        if (a + b == 1) {

        }
        System.out.println(b);
        //int i = 0;
        //i = i++;
        //System.out.println(i);
    }
}

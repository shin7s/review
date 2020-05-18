package com.alg.offer;

public class _046Translate {
    public static void main(String[] args) {
        System.out.println(translate("12258".toCharArray()));
        System.out.println(translate("25".toCharArray()));
        System.out.println(translate("26".toCharArray()));
        System.out.println(translate("111".toCharArray()));
        System.out.println(translate("1111".toCharArray()));
        System.out.println(translate("11111".toCharArray()));
        System.out.println(translate("111111".toCharArray()));
        System.out.println(translate("1".toCharArray()));
        System.out.println(translate("3025".toCharArray()));


        System.out.println(translate("325".toCharArray()));
    }

    public static int translate(char[] strs) {

        //记录
        int count1 = 1, count2 = 1, temp = 0;

        for (int i = strs.length - 1; i > 0; i--) {

            int c1 = strs[i] - '0';
            int c2 = strs[i - 1] - '0';
            temp = c2 * 10 + c1;

            if (temp >= 10 && temp <= 25) {
                temp = count2 + count1;
            } else {
                //注意边界条件
                if (i == strs.length - 1) {
                    temp = count1;
                } else {
                    temp = count2;
                }
            }
            count1 = count2;
            count2 = temp;
        }
        return count2;
    }
}

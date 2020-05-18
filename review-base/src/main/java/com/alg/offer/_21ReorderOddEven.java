package com.alg.offer;

import java.util.Arrays;

public class _21ReorderOddEven {
    public static void main(String[] args) {
        int[] data = new int[] { 1, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9, 9, 9, 9, 10};
        reorderOddEven(data);
        System.out.println(Arrays.toString(data));
        System.out.println(0x1);
    }

    public static void reorderOddEven(int[] data) {

        if (data == null && data.length <= 1)
            return;

        int odd = -1, index = 0, temp;
        for (; index < data.length; index++) {

            //if (data[index] % 2 == 1) {
            if ((data[index] & 1) != 0) {
                //寻找到一个奇数
                odd++;

                //交换奇偶位置
                if (odd != index) {
                    temp = data[index];
                    data[index] = data[odd];
                    data[odd] = temp;
                }
            }
        }
    }
}

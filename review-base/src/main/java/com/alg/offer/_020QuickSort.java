package com.alg.offer;

import java.util.Arrays;

public class _020QuickSort {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            int[] values = new int[]{1, 9, 10, 3, 8, 7, 6, 2, 4};
            quickSort(values);
            System.out.println(i + ":" + Arrays.toString(values));
        }
        //partition(values, 0, 8);

        //int[] s = new int[8];
        //for (int i = 0; i < 100000; i++) {
        //    s[random(0, 7)]++;
        //}
        //System.out.println(Arrays.toString(s));
    }

    public static void quickSort(int[] data) {
        quickSortRecursive(data, 0, data.length - 1);
    }


    public static void quickSortRecursive(int[] data, int s, int e) {
        if (data == null || data.length <= 1) {
            return;
        }

        //int index = partition(data, s, e);
        int index = partition2(data, s, e);
        //int index = partitionMid(data, s, e);
        if (index > s) {
            quickSortRecursive(data, s, index - 1);
        }
        if (index < e) {
            quickSortRecursive(data, index + 1, e);
        }

    }

    //取中位数
    public static int partitionMid(int[] data, int si, int ei) {

        if (data == null || data.length <= 0 || si < 0 || ei >= data.length) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int mid = (si + ei) / 2;
        int rand = mid;
        if (data[si] >= data[mid] && data[si] <= data[ei] || data[si] >= data[ei] && data[si] <= data[mid]) {
            rand = si;
        }
        if (data[ei] >= data[mid] && data[ei] <= data[si] || data[ei] >= data[si] && data[ei] <= data[mid]) {
            rand = ei;
        }
        System.out.println("mid:" + rand);

        swap(data, rand, ei);
        int i = si, j = ei - 1;
        while (i < j) {
            //i 右移
            while (data[i] < data[ei]) ++i;
            while (data[j] > data[ei]) --j;
            //注意不要忘记判断i和j的交叉
            if (i < j) {
                swap(data, i, j);
            }
        }
        swap(data, i, ei);
        return i;
    }

    public static int partition2(int[] data, int si, int ei) {
        if (data == null || data.length <= 0 || si < 0 || ei >= data.length) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int index = random(si, ei);
        System.out.println(index);
        //交换到末尾
        swap(data, index, ei);

        int small = si - 1;
        for (index = si; index < ei; index++) {
            if (data[index] < data[ei]) {
                small++;
                if (small != index) {
                    swap(data, small, index);
                }
            }
        }
        small++;
        swap(data, small, ei);
        return small;
    }

    public static int partition(int[] data, int si, int ei) {

        if (data == null || data.length <= 0 || si < 0 || ei >= data.length) {
            throw new IllegalArgumentException("Invalid Input");
        }

        //得到位置
        int rand = random(si, ei);
        //System.out.println("rand: " + rand);

        //交换最后一个数字
        swap(data, rand, ei);
        int i = si, j = ei - 1;
        while (i < j) {
            //System.out.println("rand,si,ei,i,j:" + rand + "," + si + "," + ei + "," + i + "," + j);
            //System.out.println("---" + Arrays.toString(data));
            //i 右移
            while (i < ei && data[i] < data[ei]) ++i;
            while (i < j && data[j] >= data[ei]) --j;
            //注意不要忘记判断i和j的交叉
            if (i < j) {
                swap(data, i, j);
            }
        }
        if (data[i] > data[ei]) {
            swap(data, i, ei);
        }
        return i;
    }

    //产生随机数
    public static int random(int start, int end) {
        return start + (int)(Math.random() *  100 % (end - start + 1));
    }
    public static void swap(int[] data, int source, int target) {
        int temp = data[target];
        data[target] = data[source];
        data[source] = temp;
    }
}

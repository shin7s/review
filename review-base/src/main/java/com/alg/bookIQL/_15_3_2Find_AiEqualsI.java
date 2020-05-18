package com.alg.bookIQL;

import java.util.Arrays;

/**
 * a[i + 1]>=a[i]
 * 快速输出a[i]=i的数
 */
public class _15_3_2Find_AiEqualsI {
    public static void main(String[] args) {
        int[] a = { 1, 2, 2, 3, 4, 5, 5, 6, 7};
        //System.out.println(findMaxIndex(a));
        //System.out.println(findMaxIndex(new int[]{5, 6, 7, 8, 9}));
        //System.out.println(findMaxIndex(new int[]{1, 1, 2, 3}));
        //System.out.println(findMaxIndex(new int[]{1}));
        //System.out.println(findMaxIndex(new int[]{1, 1, 1, 1, 1}));

        System.out.println(Arrays.toString(findAiEqualsI(a)));
        System.out.println(Arrays.toString(findAiEqualsI(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(findAiEqualsI(new int[]{1, 1, 2, 3})));
        System.out.println(Arrays.toString(findAiEqualsI(new int[]{1})));
        System.out.println(Arrays.toString(findAiEqualsI(new int[]{1, 1, 1, 1, 1})));
    }

    public static int[] findAiEqualsI(int[] data) {

        if (data == null || data.length == 0) {
            return null;
        }

        int[] result = null;

        int maxIndex = findMaxIndex(data);
        int minIndex = findMinIndex(data);
        if (maxIndex == -1 || minIndex == -1) {
            return null;
        } else {
            result = Arrays.copyOfRange(data, minIndex, maxIndex + 1);
        }

        return result;
    }

    public static int findMaxIndex(int[] data) {
        int low = 0, high = data.length - 1, mid, max = low;

        while (low <= high) {
            mid = (low + high) / 2;
            if (data[mid] == mid) {
                if (mid == data.length - 1) {
                    //不能再往上找
                    return mid;
                }
                //往上找
                low = mid + 1;
                max = mid;
            } else if (data[mid] < mid) {
                //往下找
                high = mid - 1;
            } else if (data[mid] > mid) {
                low = mid + 1;
            }
        }

        if (low >= data.length) {
            return -1;
        }
        return max;
    }

    public static int findMinIndex(int[] data) {
        int low = 0, high = data.length - 1, mid, max = low;

        while (low <= high) {
            mid = (low + high) / 2;
            if (data[mid] == mid) {
                if (mid == 0) {
                    //不能再往下找
                    return mid;
                }
                //往下找
                high = high - 1;
                max = mid;
            } else if (data[mid] < mid) {
                //往下找
                high = mid - 1;
            } else if (data[mid] > mid) {
                low = mid + 1;
            }
        }

        if (high <= -1) {
            return -1;
        }
        return max;
    }

}

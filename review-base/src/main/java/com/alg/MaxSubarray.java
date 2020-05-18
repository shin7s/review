package com.alg;

import java.util.Arrays;
import java.util.List;

public class MaxSubarray {

    static class Sum {
        public Sum(int sum, int start, int end) {
            this.sum = sum;
            this.start = start;
            this.end = end;
        }

        int sum;
        int start;
        int end;
    }

    public static void main(String[] args) {
        int[] array = new int[] {-2, 2,-3, 4,-1, 2, 1,-5, 3};
        int[] array1 = new int[] {-2, 2};
        int[] array2 = new int[] {-2};
        int[] array3 = new int[] {2};
        int[] array4 = new int[] {-1, -2, -3, -100, -1, -50};

        //Sum divide = divide(array, 0, array.length - 1);
        //System.out.println(divide.sum);

        //System.out.println(divide2(array, 0, array.length - 1));
        //System.out.println(divide2(array1, 0, array1.length - 1));
        //System.out.println(divide2(array2, 0, array2.length - 1));
        //System.out.println(divide2(array3, 0, array3.length - 1));
        //System.out.println(divide2(array4, 0, array4.length - 1));

        System.out.println(dp(array));
        System.out.println(dp(array1));
        System.out.println(dp(array2));
        System.out.println(dp(array3));
        System.out.println(dp(array4));

        Integer[] arrayMin = {1, -1, -2, 1, -4};
        System.out.println(dpMin(Arrays.asList(arrayMin)));

    }

    public static int dpMin(List<Integer> nums) {
        int length = nums.size();
        int thisSum = nums.get(0);
        int minSum = nums.get(0);

        for (int i = 1; i < length; i++) {
            //
            thisSum = Math.min(thisSum + nums.get(i), nums.get(i));
            minSum = Math.min(thisSum, minSum);
        }
        return minSum;
    }

    public static int dp(int[] nums) {
        int length = nums.length;
        int thisSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < length; i++) {
            //
            thisSum = Math.max(thisSum + nums[i], nums[i]);
            maxSum = Math.max(thisSum, maxSum);
        }
        return maxSum;
    }

    public static int divide2(int[] nums, int start, int end) {

        if (start == end) {
            return nums[start];
        }

        int sumLeft, sumRight, sumMiddle = 0;
        int middle = (start + end) / 2;
        sumLeft = divide2(nums, start, middle);
        sumRight = divide2(nums, middle + 1, end);

        //
        int sumMiddleLeft = 0, maxMiddleLeft = Integer.MIN_VALUE;
        int sumMiddleRight = 0, maxMiddleRight = Integer.MIN_VALUE;
        for (int i = middle; i >= start; i--) {
            sumMiddleLeft += nums[i];
            maxMiddleLeft = Math.max(sumMiddleLeft, maxMiddleLeft);
        }
        for (int i = middle + 1; i <= end; i++) {
            sumMiddleRight += nums[i];
            maxMiddleRight = Math.max(sumMiddleRight, maxMiddleRight);
        }
        sumMiddle = maxMiddleLeft + maxMiddleRight;

        return Math.max(Math.max(sumLeft, sumRight), sumMiddle);
    }

    public static Sum divide(int[] array, int start, int end) {

        if (start == end) {
            return new Sum(array[start], start, end);
        }

        Sum left, right, middle;
        int mLeftSum = 0, mRightSum = 0;

        int mid = (start + end) / 2;
        int leftTemp = 0, rightTemp = 0;
        int startTemp = 0, endTemp = 0;

        left = divide(array, start, mid);
        right = divide(array, mid + 1, end);

        //
        for (int i = mid; i >= start; i--) {
            leftTemp = leftTemp + array[i];
            if (leftTemp > mLeftSum) {
                mLeftSum = leftTemp;
                startTemp = i;
            }
        }
        for (int i = mid + 1; i <= end; i++) {
            rightTemp = rightTemp + array[i];
            if (rightTemp > mRightSum) {
                mRightSum = rightTemp;
                endTemp = i;
            }
        }

        middle = new Sum(mLeftSum + mRightSum, startTemp, endTemp);

        return left.sum >= right.sum ? (left.sum >= middle.sum ? left : middle) : (right.sum >= middle.sum ? right : middle);
    }
}

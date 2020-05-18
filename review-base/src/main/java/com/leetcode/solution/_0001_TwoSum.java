package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class _0001_TwoSum {
    /**
     * 数组无序，一次hash
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        if (nums != null && nums.length > 0) {
            Map<Integer, Integer> hash = new HashMap<>();
            Integer next;
            for (int i = 0; i < nums.length; i++) {
                next = target - nums[i];
                if (hash.containsKey(next) && hash.get(next) != i) {
                    return new int[]{hash.get(next), i};
                }
                hash.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 167. 两数之和 II - 输入有序数组
     * 有序数组
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        if (numbers != null && numbers.length > 0) {
            int i = 0, j = numbers.length - 1, sum;
            while (i < j) {
                sum = numbers[i] + numbers[j];
                if (sum == target) {
                    return new int[]{i + 1, j + 1};
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

package com.leetcode.solution;

public class _0560_K_Sum {

    /**
     * 
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        if (nums != null && nums.length > 0) {
            int[] sums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = nums[i] + sums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j <= nums.length; j++) {
                    if (sums[j] - sums[i] == k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 算法效率为n2，不满意
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        if (nums != null && nums.length > 0) {
            int[] sums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = nums[i] + sums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j <= nums.length; j++) {
                    if (sums[j] - sums[i] == k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

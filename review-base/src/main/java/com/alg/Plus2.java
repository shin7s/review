package com.alg;

import java.util.*;

public class Plus2 {
    public static void main(String[] args) {
        //int[] nums = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
        //System.out.println(maxSubArray(nums));
        //int[] nums2 = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
        //System.out.println(maxSubArray(nums2));

        //System.out.println(productExcludeItself(Arrays.asList(1, 2, 3)));
        //System.out.println(productExcludeItself(Arrays.asList(2, 4, 6)));
        //System.out.println(productExcludeItself(Arrays.asList(0)));

        //String ss = "the sky is blue.";
        //reverseWords(ss);

        System.out.println(Arrays.toString(twoSum(new int[] {3, 3}, 6)));


        mergeSortedArray(new int[] {1, 2, 3, -1, -1}, 3, new int[] {4, 5}, 2);

        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 0));
        System.out.println(searchInsert(new int[] {}, 9));

    }

    public static int searchInsert(int[] A, int target) {
        // write your code here
        int low = 0, high = A.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (target < A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n -1, aidx = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[aidx] = A[i];
                i--;
            } else {
                A[aidx] = B[j];
                j--;
            }
            aidx--;
        }
        while (i >= 0) {
            A[aidx] = A[i];
            i--;
            aidx--;
        }
        while (j >= 0) {
            A[aidx] = B[j];
            j--;
            aidx--;
        }
        System.out.println(Arrays.toString(A));
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int cur = numbers[i];
            int find = target - cur;
            if (map.containsKey(find) ) {
                return new int[] {map.get(find), i};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static String reverseWords(String s) {
        // write your code here

        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {

            }
            //builder.append()
        }
        return "";
    }

    public static List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        List<Long> longList = new ArrayList<>(nums.size());
        if (nums.size() == 1) {
            longList.add(1L);
            return longList;
        }

        long[] prefixs = new long[nums.size()];
        long[] suffixs = new long[nums.size()];
        prefixs[0] = nums.get(0);
        suffixs[nums.size() - 1] = nums.get(nums.size() - 1);

        for (int i = 1; i < nums.size(); i++) {
            prefixs[i] = prefixs[i - 1] * nums.get(i);
        }
        for (int i = nums.size() - 2; i >= 0; i--) {
            suffixs[i] = suffixs[i + 1] * nums.get(i);
        }

        for (int i = 0; i < nums.size(); i++) {
            if (i == 0) {
                longList.add(suffixs[i + 1]);
            } else if (i == nums.size() - 1) {
                longList.add(prefixs[i - 1]);
            } else {
                longList.add(prefixs[i - 1] * suffixs[i + 1]);
            }
        }

        return longList;
    }

    public static int maxOccur(List<Integer> nums) {
        int count = 1, main = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == main) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                main = nums.get(i);
            }
        }
        return main;
    }

    public static int maxSubArray(int[] nums) {
        // write your code here
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }
        return max;
    }

    public static int minSubArray(int[] nums) {
        // write your code here
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }
        return max;
    }
}

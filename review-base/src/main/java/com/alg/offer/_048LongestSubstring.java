package com.alg.offer;

import java.util.Arrays;

public class _048LongestSubstring {
    public static void main(String[] args) {
        System.out.println(longestSubstring("arabcacfr".toCharArray()));
    }

    public static int longestSubstring(char[] strs) {

        if (strs == null || strs.length == 0) return 0;

        int max = 0;
        int[] maxs = new int[strs.length];

        int i = 0;
        for (; i < maxs.length; i++) {
            maxs[i] = -1;
        }

        for (i = 0; i < strs.length; ++i) {

            if (i == 0) {
                maxs[i] = 1;
            } else {
                //检查前N位是否重复
                int j = 0;
                for (; j <= maxs[i - 1] - 1; j++) {
                    if (strs[i - 1 - j] == strs[i]) {
                        break;
                    }
                }
                if (j <= maxs[i - 1]) {
                    maxs[i] = j + 1;
                } else {
                    maxs[i] = maxs[i - 1] + 1;
                }
                max = Math.max(maxs[i], max);
            }
        }

        System.out.println(Arrays.toString(maxs));

        return max;
    }
}

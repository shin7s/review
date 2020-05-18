package com.alg;

import java.util.Arrays;

public class DP {
    public static void main(String[] args) {

        int[] ints = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
        //int[] ints = {2, 4, -7, 5, 2, -1, 2, -4, 3};
        //int[] ints = {-2, 2, 4, -7, 5, 2, -1, 2, -4, 3};
        //System.out.println(MaxSubSequence3(ints));
        System.out.println(db(ints));

        int[] min = {-2, 2,-3, 4,-1, 2, 1,-5, 3};

        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };
        System.out.println(minPathSum(grid));

        int[][] grid2 = {
                {1, 99, 99, 99, 99},
                {1, 99, 1, 1, 1},
                {1, 99, 1, 99, 1},
                {1, 1, 1, 99, 1},
        };
        System.out.println(minPathSum(grid2));
        minPathSum3(grid2);

        System.out.println(climbStairs(3));
        System.out.println(climbStairs(10));
    }

    public static int climbStairs(int n) {
        // write your code here
        if (n <= 2) return n;
        int a = 1, b = 2, temp = a + b;
        //int[] steps = new int[n + 1];
        //steps[1] = 1;
        //steps[2] = 2;
        for (int i = 3; i <= n; i++) {
            //steps[i] = steps[i - 1] + steps[i - 2];
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }


    public static int minPathSum3(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }

        int m = A.length, n = A[0].length;
        int[][] f = new int[m][n];
        int[][] pi = new int[m][n];
        int i, j;
        for (i = 0; i < m; ++i) {
            for (j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    f[0][0] = A[0][0];
                    continue;
                }

                f[i][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j] + A[i][j]);
                    if (f[i][j] == f[i - 1][j] + A[i][j]) {
                        pi[i][j] = 0;
                    }
                }

                if (j > 0) {
                    f[i][j] = Math.min(f[i][j], f[i][j - 1] + A[i][j]);
                    if (f[i][j] == f[i][j - 1] + A[i][j]) {
                        pi[i][j] = 1;
                    }
                }
            }
        }

        // reverse order
        // m-1,n-1
        int[][] path = new int[m + n - 1][2];
        int p;
        i = m - 1;
        j = n - 1;
        for (p = m + n - 2; p >= 0; --p) {
            path[p][0] = i;
            path[p][1] = j;
            if (p == 0) break;
            if (pi[i][j] == 0) {
                --i;
            } else {
                --j;
            }
        }

        for (p = 0; p < m + n - 1; ++p) {
            System.out.println("(" + path[p][0] + ", " + path[p][1] + "):" + A[path[p][0]][path[p][1]]);
        }

        return f[m - 1][n - 1];
    }

    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static int db(int[] nums) {
        int length = nums.length;
        int thisSum = 0;
        int maxSum = 0;
        for (int i = 1; i < length; i++) {
            //
            thisSum = Math.max(thisSum + nums[i], nums[i]);
            maxSum = Math.max(thisSum, maxSum);
        }
        return maxSum;
    }


    public static int MaxSubSequence3(int[] array) {

        int length = array.length;
        int[] MaxSum = new int[length];
        MaxSum[0] = array[0];
        for (int i = 1; i < length; i++) {
            MaxSum[i] = Math.max(MaxSum[i - 1] + array[i], array[i]);
        }
        System.out.println(Arrays.toString(MaxSum));
        //找到MaxSum中的最大值
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < MaxSum.length; i++) {
            if (MaxSum[i] > maxSum) {
                maxSum = MaxSum[i];
            }
        }

        return maxSum;
    }
}

package com.alg.offer;

public class _047MaxGiftsValue {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5},
        };
        System.out.println(maxValueWithArray(matrix));

    }

    public static int maxValueWithArray(int[][] gifts) {
        if (gifts == null || gifts.length <= 0 || gifts[0].length <= 0)
            return 0;

        int rows = gifts.length;
        int cols = gifts[0].length;

        int[] max = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = max[j];
                }
                if (j > 0) {
                    left = max[j - 1];
                }
                max[j] = Math.max(up, left) + gifts[i][j];
            }
        }
        return max[cols - 1];
    }

    public static int maxValue(int[][] gifts) {

        if (gifts == null || gifts.length <= 0 || gifts[0].length <= 0)
            return 0;

        int rows = gifts.length;
        int cols = gifts[0].length;

        int[][] max = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (i > 0 && j > 0) {
                    max[i][j] = Math.max(max[i - 1][j], max[i][j - 1]);
                } else if (i > 0) {
                    max[i][j] = max[i - 1][j];
                } else if (j > 0) {
                    max[i][j] = max[i][j - 1];
                }
                max[i][j] += gifts[i][j];
            }
        }
        return max[rows - 1][cols - 1];
    }
}

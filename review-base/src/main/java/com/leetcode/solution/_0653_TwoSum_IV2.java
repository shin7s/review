package com.leetcode.solution;

import com.alg.TreeNode;

import java.util.Arrays;

/**
 * 653. 两数之和 IV - 输入 BST
 * 二叉搜索树
 * 中序遍历得到有序数组
 * 然后双指针法
 */
public class _0653_TwoSum_IV2 {
    public int[] values = new int[100];
    public int index = 0;

    public boolean findTarget(TreeNode root, int k) {
        inorder2(root);
        return twoSum2(values, index, k);
    }

    public void output() {
        System.out.println(index + ":" +
                Arrays.toString(Arrays.copyOfRange(values, 0, index)));
    }

    public void inorder2(TreeNode root) {
        if (root == null) return;
        inorder2(root.left);
        grow();
        values[index++] = root.val;
        inorder2(root.right);
    }

    void grow() {
        if (index >= values.length) {
            int[] newValues = new int[values.length * 2 + 1];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }
    }

    public boolean twoSum2(int[] numbers, int end, int target) {
        if (numbers != null && end > 0) {
            int i = 0, j = end - 1, sum;
            while (i < j) {
                sum = numbers[i] + numbers[j];
                if (sum == target) {
                    return true;
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return false;
    }

}

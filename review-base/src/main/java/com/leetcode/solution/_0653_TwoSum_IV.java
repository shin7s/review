package com.leetcode.solution;

import com.alg.ListNode;
import com.alg.TreeNode;

import java.util.Arrays;

/**
 * 653. 两数之和 IV - 输入 BST
 * 二叉搜索树
 * 中序遍历得到有序数组
 * 然后双指针法
 */
public class _0653_TwoSum_IV {
    public boolean findTarget(TreeNode root, int k) {
        int[] inorder = inorder(root);
        System.out.println(Arrays.toString(inorder));
        return twoSum2(inorder, k);
    }
    /**
     * 中序遍历
     * @param root
     * @return
     */
    public int[] inorder(TreeNode root) {

        if (root == null) return null;
        int[] leftArray = inorder(root.left);
        int[] rightArray = inorder(root.right);
        int length = (leftArray == null ? 0 : leftArray.length)
                + (rightArray == null ? 0 : rightArray.length) + 1;

        int[] array = new int[length];
        int start = 0;
        if (leftArray != null) {
            System.arraycopy(leftArray, 0, array, start, leftArray.length);
            start = leftArray.length;
        }
        array[start++] = root.val;
        if (rightArray != null) {
            System.arraycopy(rightArray, 0, array, start, rightArray.length);
        }
        return array;
    }

    /**
     * 有序数组
     *
     * @param numbers
     * @param target
     * @return
     */
    public boolean twoSum2(int[] numbers, int target) {
        if (numbers != null && numbers.length > 0) {
            int i = 0, j = numbers.length - 1, sum;
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

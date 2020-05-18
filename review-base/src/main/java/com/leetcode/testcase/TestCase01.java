package com.leetcode.testcase;

import com.alg.ListNode;
import com.alg.TreeNode;
import com.leetcode.solution._0001_TwoSum;
import com.leetcode.solution._0560_K_Sum;
import com.leetcode.solution._0653_TwoSum_IV;
import com.leetcode.solution._0653_TwoSum_IV2;
import org.junit.Test;

import java.util.Arrays;

import static com.alg.Tree.buildBST_inorder;

public class TestCase01 {
    @Test
    public void test_0001_TwoSum() {
        _0001_TwoSum demo = new _0001_TwoSum();
        System.out.println(Arrays.toString(demo.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(demo.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(demo.twoSum(new int[]{3}, 6)));
    }

    @Test
    public void test_0653_TwoSum_IV() {

        TreeNode case1 = buildBST_inorder(ListNode.build(new int[]{5, 3, 2, 4, 6, 7}));

        _0653_TwoSum_IV demo = new _0653_TwoSum_IV();
        System.out.println(demo.findTarget(case1, 9));
        System.out.println(demo.findTarget(case1, 28));
        //System.out.println(demo.findTarget(case1, 28));
    }

    @Test
    public void test_0653_TwoSum_IV2() {
        TreeNode case1 = buildBST_inorder(ListNode.build(new int[]{5, 3, 2, 4, 6, 7}));
        _0653_TwoSum_IV2 demo = new _0653_TwoSum_IV2();
        demo.inorder2(case1);
        demo.output();

        System.out.println(demo.findTarget(case1, 9));
        System.out.println(demo.findTarget(case1, 28));
    }

    @Test
    public void test_0560_K_Sum() {
        _0560_K_Sum demo = new _0560_K_Sum();
        System.out.println(demo.subarraySum(new int[] {1,1,1}, 2));
    }
}
